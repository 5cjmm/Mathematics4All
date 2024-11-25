package com.bmt.PROAULA.Controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bmt.PROAULA.Model.Usuario;
import com.bmt.PROAULA.Repository.UsuarioRepository;
import com.bmt.PROAULA.Service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping({"", "/"})
    public String home() {
        return "Home";
    }

    @GetMapping("/Discalculia")
    public String discalculia() {
        return "Discalculia";
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "Registro";
    }

    @PostMapping({"/registrar"})
    public String registrarUsuario(@ModelAttribute Usuario usuario, Model model) {
        usuario.setFechaCreacion(LocalDateTime.now());
        this.usuarioService.registrarUsuario(usuario);
        return "redirect:/usuarios/login";
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "Login";
    }

    @PostMapping("/login")
    public String procesarFormularioLogin(@RequestParam("email") String email,
                                          @RequestParam("password") String password,
                                          HttpSession session, Model model) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null && usuario.getPassword().equals(password)) {
            session.setAttribute("usuario", usuario);
            return "redirect:/usuarios/inicio";
        }

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("errorMessage", "Credenciales incorrectas. Por favor, inténtalo de nuevo."); // Cambié "error" a "errorMessage"
        return "login";
    }

    @GetMapping("/inicio")
    public String showInicio(Model model, HttpSession session) {
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario != null) {
        model.addAttribute("usuario", usuario);
    } else {
        return "redirect:/login";
    }
    return "Inicio";
}

}