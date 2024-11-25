package com.bmt.PROAULA.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class  HomeController {

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("title", "Home");
        return "Home";
    }

    @GetMapping("/discalculia")
    public String discalculia(Model model) {
        model.addAttribute("title", "Discalculia");
        return "Discalculia";
    }

    @GetMapping("/inicio")
    public String inicio(Model model) {
        model.addAttribute("title", "Inicio");
        return "Inicio";
    }

    @GetMapping("/juegos/calculo-mental")
    public String calculoMental(Model model) {
        model.addAttribute("title", "Cálculo Mental");
        return "Juegos345/CalculoMental";
    }

    @GetMapping("/juegos/encontrar")
    public String encontrar(Model model) {
        model.addAttribute("title", "Encontrar");
        return "Juegos345/Encontrar";
    }

    @GetMapping("/juegos/mayor-menor")
    public String mayorMenor(Model model) {
        model.addAttribute("title", "Mayor o Menor");
        return "Juegos345/MayorMenor";
    }

    @GetMapping("/juegos/rompecabezas")
    public String rompecabezas(Model model) {
        model.addAttribute("title", "Rompecabezas");
        return "Juegos345/Rompecabezas";
    }

    @GetMapping("/juegos/sumas-imagen")
    public String sumasImagen(Model model) {
        model.addAttribute("title", "Sumas con Imagen");
        return "Juegos345/SumasImagen";
    }

    @GetMapping("/videos/video1")
    public String video1(Model model) {
        model.addAttribute("title", "Video 1");
        return "Videos/Video1";
    }

    @GetMapping("/videos/video2")
    public String video2(Model model) {
        model.addAttribute("title", "Video 2");
        return "Videos/Video2";
    }

    @GetMapping("/videos/video3")
    public String video3(Model model) {
        model.addAttribute("title", "Video 3");
        return "Videos/Video3";
    }

    @GetMapping("/videos/video4")
    public String video4(Model model) {
        model.addAttribute("title", "Video 4");
        return "Videos/Video4";
    }

    @GetMapping("/videos/video5")
    public String video5(Model model) {
        model.addAttribute("title", "Video 5");
        return "Videos/Video5";
    }

    @GetMapping("/videos/video6")
    public String video6(Model model) {
        model.addAttribute("title", "Video 6");
        return "Videos/Video6";
    }

    @GetMapping("/videos/video7")
    public String video7(Model model) {
        model.addAttribute("title", "Video 7");
        return "Videos/Video7";
    }
}
