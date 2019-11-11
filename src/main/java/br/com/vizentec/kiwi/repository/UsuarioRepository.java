package br.com.vizentec.kiwi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vizentec.kiwi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
	
	Optional<Usuario> findByEmail(String email);

}
