package com.springboot.backend.apirest.models.services;

import java.util.List;

import com.springboot.backend.apirest.models.entity.Dispositivo;



public interface IDispositivoService {
	
	public List<Dispositivo> findAll();
	
	public void save(Dispositivo dispositivo);
	
	public Dispositivo findById(Long id);
	
	public void delete(Dispositivo dispositivo);

}
