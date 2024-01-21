package com.desafio.primeiro.service;

import com.desafio.primeiro.model.Usuario;
import com.desafio.primeiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {


    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }


}
