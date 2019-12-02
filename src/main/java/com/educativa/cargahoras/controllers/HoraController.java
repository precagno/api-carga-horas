package com.educativa.cargahoras.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educativa.cargahoras.entities.Hora;
import com.educativa.cargahoras.exceptions.NotImplementedException;
import com.educativa.cargahoras.services.HoraService;

@RestController
@RequestMapping("/api")
public class HoraController {
	@Autowired
	private HoraService horaService;
	
	@GetMapping("/horas")
	public List<Hora> getHoras(){
		return this.horaService.getHoras();
	}

	@GetMapping("/horas/{id}")
	public Hora getHoraById(@PathVariable(value="id") Integer id){
		return this.horaService.getHoraById(id);
	}
	
	@PostMapping("/horas")
	public ResponseEntity<Hora> createHora(@Valid @RequestBody Hora hora){
		Hora horaCreada = this.horaService.createHora(hora);
		String response=String.format("La hora con id: %s fue creada correctamente.",horaCreada.getID_hora());

		return ResponseEntity.ok(hora);
	}

	@PutMapping("/horas/{id}")
	public ResponseEntity<?> updateHora(@PathVariable(value="id") Integer id, @Valid @RequestBody Hora hora){
		throw new NotImplementedException("updateHora");
	}
	
	@DeleteMapping("/horas/{id}")
	public ResponseEntity<String> deleteHora(@PathVariable(value="id") Integer id){
		String response=String.format("La hora con id: %s fue borrada correctamente.",id);

		this.horaService.deleteHoraById(id);
		return ResponseEntity.ok(response);
	}
}
