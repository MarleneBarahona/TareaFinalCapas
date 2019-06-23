package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Sucursal;
import com.uca.capas.repositories.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService{

	@Autowired
	SucursalRepository sRepo;
	
	@Override
	public List<Sucursal> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return sRepo.findAll();
	}

	@Override
	public Sucursal findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return sRepo.findById(codigo).get();
	}

	@Override
	public Sucursal save(Sucursal s) throws DataAccessException {
		// TODO Auto-generated method stub
		return sRepo.save(s);
	}

}
