package com.educativa.cargahoras.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educativa.cargahoras.exception.ResourceNotFoundException;
import com.educativa.cargahoras.model.Hora;
import com.educativa.cargahoras.repository.HoraRepository;

@RestController
@RequestMapping("/api")
public class HoraController {
	
	@Autowired
	private HoraRepository horaRepository;
	
	@GetMapping("/horas")
	public List<Hora> getHoras(){
		return this.horaRepository.findAll();
	}
	
	@PostMapping("/horas")
	public Hora createHora(@Valid @RequestBody Hora hora){
		return this.horaRepository.save(hora);
	}
	
	@GetMapping("/horas/{id}")
	public Hora getHoraById(@PathVariable(value="id") Integer id){
		return this.horaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hora","ID_hora",id));
	}
	
	@PutMapping("/horas/{id}")
	public Hora updateHora(@PathVariable(value="id") Integer id,@Valid @RequestBody Hora hora){
		Hora hora_edited=this.horaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hora", "ID_hora",id));
		hora_edited.setColegio(hora.getColegio());
		hora_edited.setCurso(hora.getCurso());
		hora_edited.setDescripcion(hora.getDescripcion());
		
		return this.horaRepository.save(hora_edited);
	}
	
	@DeleteMapping("/horas/{id}")
	public ResponseEntity<?> deleteHora(@PathVariable(value="id") Integer id){
		String response=String.format("La hora con id: %s fue borrada correctamente.",id);
		Hora horaDeleted=this.horaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hora", "ID_hora", id));
		
		this.horaRepository.delete(horaDeleted);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
}
