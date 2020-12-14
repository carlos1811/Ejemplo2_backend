package com.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.apirest.models.entity.Dispositivo;
import com.springboot.backend.apirest.models.services.IDispositivoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class DispositivoRestController {

	@Autowired
	private IDispositivoService dispositivoService;

	@GetMapping("/dispositivo")
	public List<Dispositivo> index() {
		
 		List<Dispositivo> dispo = dispositivoService.findAll();
		
		dispo.stream().forEach(System.out::println);
		
		return dispo;
	}

	@GetMapping("/dispositivo/{id}")
	public Dispositivo show(@PathVariable Long id) {
		return this.dispositivoService.findById(id);
	}

	@PostMapping("/dispositivo")
	@ResponseStatus(HttpStatus.CREATED)
	public Dispositivo create(@RequestBody Dispositivo dispositivo) {
		this.dispositivoService.save(dispositivo);
		return dispositivo;
	}

	@PutMapping("/dispositivo/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Dispositivo update(@RequestBody Dispositivo dispositivo, @PathVariable Long id) {
		Dispositivo currentDispositivo = this.dispositivoService.findById(id);
		currentDispositivo.setDispositivo(dispositivo.getDispositivo());
		currentDispositivo.setActivado(dispositivo.getActivado());
		
		this.dispositivoService.save(currentDispositivo);
		return currentDispositivo;
	}

	@DeleteMapping("/dispositivo/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Dispositivo currentDispositivo = this.dispositivoService.findById(id);
		this.dispositivoService.delete(currentDispositivo);
	}
}
