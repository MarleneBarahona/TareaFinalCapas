package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository uRepo;

	@Override
	public List<Usuario> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return uRepo.findAll();
	}

	@Override
	public Usuario findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return uRepo.getOne(codigo);
	}

	/*@Override
	public Usuario findUser(String name, String pass) throws DataAccessException {
		// TODO Auto-generated method stub
		return uRepo.findByUserNameAndPass(name, pass);
	}*/


}