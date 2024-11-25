package com.bmt.PROAULA.Service;

import com.bmt.PROAULA.Model.Usuario;
import com.bmt.PROAULA.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario iniciarSesion(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getPassword().equals(password)){
            return usuario;
        }
        return null;
    }
}
