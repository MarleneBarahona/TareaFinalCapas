package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Sucursal;

public interface SucursalService {

	public List<Sucursal> findAll() throws DataAccessException;

	public Sucursal findOne(Integer codigo) throws DataAccessException;

	public Sucursal save(Sucursal s)  throws DataAccessException;
	
	public void delete(Integer id);
}
