package com.desafio.primeiro.service;

import com.desafio.primeiro.model.Usuario;
import jdk.jfr.Description;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TransferenciaServiceTest {



    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private TransferenciaService transferenciaService;

    
    
    @BeforeEach
    void Setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Description("Deve mostrar Sucesso, quando houver ucesso na transferencia.")
    void transferirCase1() {



        Usuario origem = new Usuario();
        origem.setNome("Teste 1");

        Usuario destino = new Usuario();
        destino.setNome("Teste 2");

        when(usuarioService.usuarioRepository.findById(origem.getId())).thenReturn(Optional.of(origem));
        when(usuarioService.usuarioRepository.findById(destino.getId())).thenReturn(Optional.of(destino));



       // transferenciaService.transferir();
    }
    @Test
    @Description("Deve mostrar Erro, quando houver erro na transferencia.")
    void transferirCase2() {
    }
}