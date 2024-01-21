package com.desafio.primeiro.repository;

import com.desafio.primeiro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findUsuarioByNome(String nome);
    Optional<Usuario> findUsuarioById(UUID id);

}
