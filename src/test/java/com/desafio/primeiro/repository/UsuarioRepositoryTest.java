package com.desafio.primeiro.repository;

import com.desafio.primeiro.model.Usuario;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
class UsuarioRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Deve retornar 'usuário retornado com sucesso'. ")
    void findUsuarioByNomeCase1() {
            Usuario usuario = new Usuario();
            usuario.setNome("Teste 1");
            usuario.setEmail("teste@teste.com.br");

            Usuario usuarioCriado= usuarioRepository.save(usuario);
            Optional<Usuario> usuarioEncontrado = usuarioRepository.findUsuarioByNome(usuario.getNome());

            assertThat(usuarioEncontrado.isPresent());


    }
    @Test
    @DisplayName("Não deve retornar Usuário.")
    void findUsuarioByNomeCase2() {
        Usuario novoUsuario;
        Optional<Usuario> usuario = usuarioRepository.findUsuarioByNome("Inexistente");
        assertThat(usuario.isEmpty());
    }
    private Usuario criarUsuario(Usuario usuario){
        Usuario novoUsuario = new Usuario();
        entityManager.persist(novoUsuario);
        return novoUsuario;
    }
}