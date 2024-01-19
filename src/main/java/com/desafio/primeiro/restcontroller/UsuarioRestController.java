package com.desafio.primeiro.restcontroller;

import com.desafio.primeiro.model.Usuario;
import com.desafio.primeiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioRestController {

    @Autowired
    UsuarioRepository usuarioRepository;
    @RequestMapping(path = "/usuario/findAll")
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    @PostMapping(path = "/usuario/save")
    public Usuario save(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
