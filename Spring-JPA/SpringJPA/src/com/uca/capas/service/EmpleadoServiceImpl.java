package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Empleado;
import com.uca.capas.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	EmpleadoRepository eRepo;
	
	@Override
	public List<Empleado> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return eRepo.findAll();
	}

	@Override
	public Empleado findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return eRepo.findById(codigo).get();
	}

	@Override
	public Empleado save(Empleado e) throws DataAccessException {
		// TODO Auto-generated method stub
		return eRepo.save(e);
	}

}
