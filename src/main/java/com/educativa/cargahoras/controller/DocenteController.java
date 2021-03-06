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
import com.educativa.cargahoras.model.Docente;
import com.educativa.cargahoras.repository.DocenteRepository;

@RestController
@RequestMapping("/api")
public class DocenteController {
	@Autowired
	private DocenteRepository docenteRepository;
	
	//Get all docentes
	@GetMapping("/docentes")
	public List<Docente> getDocentes(){
		return this.docenteRepository.findAll();
	}
	
	//Create a new docente
	@PostMapping("/docentes")
	public Docente createDocente(@Valid @RequestBody Docente docente){
		return this.docenteRepository.save(docente);
	}
	
	//Get single docente by id
	@GetMapping("/docentes/{id}")
	public Docente getDocenteById(@PathVariable(value="id")Integer id){
		return this.docenteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Docente", "ID_docente", id));
	}
	
	//Update a docente
	@PutMapping("/docentes/{id}")
	public Docente updateDocente(@PathVariable(value="id")Integer id ,@Valid @RequestBody Docente docente){
		Docente docenteEdited=this.docenteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Docente", "ID_docente", id));
		docenteEdited.setNombre_completo(docente.getNombre_completo());
		docenteEdited.setEdad(docente.getEdad());
		docenteEdited.setDireccion(docente.getDireccion());
		docenteEdited.setNacionalidad(docente.getNacionalidad());
		docenteEdited.setAsignatura(docente.getAsignatura());
		docenteEdited.setAntiguedad(docente.getAntiguedad());
		docenteEdited.setPuntaje(docente.getPuntaje());
		
		return this.docenteRepository.save(docenteEdited);
	}
	
	//Delete a docente
	@DeleteMapping("/docentes/{id}")
	public ResponseEntity<?> deleteDocente(@PathVariable(value="id") Integer id){
		Docente docenteDeleted=this.docenteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Docente", "ID_docente", id));
		String nombre_completo=docenteDeleted.getNombre_completo();
		String response=String.format("El docente con id: %s (%s) fue eliminado del sistema",id,nombre_completo);
		
		this.docenteRepository.delete(docenteDeleted);
		return new ResponseEntity<String>(response,HttpStatus.OK); 
	}
}
