package com.cooper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooper.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public List<Usuario> findAll();
	public List<Usuario> findByNickAndPassword(String nick, String password);
}
