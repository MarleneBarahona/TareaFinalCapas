package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Usuario;

public interface UsuarioService {
		
	public List<Usuario> findAll() throws DataAccessException;

	public Usuario findOne(Integer codigo) throws DataAccessException;
	
	//public Usuario findUser(String name, String pass) throws DataAccessException;
}
