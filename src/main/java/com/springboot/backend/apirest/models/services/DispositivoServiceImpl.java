package com.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.apirest.models.dao.IDispositivoDao;
import com.springboot.backend.apirest.models.entity.Dispositivo;

@Service
public class DispositivoServiceImpl implements IDispositivoService{

	@Autowired
	private IDispositivoDao dispositivoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Dispositivo> findAll() {
		return (List<Dispositivo>) dispositivoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Dispositivo dispositivo) {
		dispositivoDao.save(dispositivo);
	}

	@Override
	@Transactional(readOnly = true)
	public Dispositivo findById(Long id) {
		return dispositivoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Dispositivo dispositivo) {
		dispositivoDao.delete(dispositivo);
		
	}

}
