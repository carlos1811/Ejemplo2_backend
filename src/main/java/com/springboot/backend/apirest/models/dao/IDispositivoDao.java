package com.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.apirest.models.entity.Dispositivo;

public interface IDispositivoDao extends CrudRepository<Dispositivo, Long>{

}
