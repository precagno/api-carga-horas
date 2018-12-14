package com.educativa.cargahoras.controllers;

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

import com.educativa.cargahoras.exceptions.ResourceNotFoundException;
import com.educativa.cargahoras.entities.Docente;
import com.educativa.cargahoras.repositories.DocenteRepository;

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
	public ResponseEntity<?> createDocente(@RequestBody @Valid Docente docente){
        Docente docenteAux = docente;
        this.docenteRepository.save(docenteAux);
        String format=String.format("Docente creado correctamente con id %d",docenteAux.getIdDocente());
	    return ResponseEntity.ok(format);
	}
	
	//Get single docente by id
	@GetMapping("/docentes/{id}")
	public Docente getDocenteById(@PathVariable(value="id")Integer id){
		return this.docenteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Docente","id_docente",id));
	}
	
	//Update a docente
	@PutMapping("/docentes/{id}")
	public Docente updateDocente(@PathVariable(value="id")Integer id ,@Valid @RequestBody Docente docente){
		Docente docenteEdited=this.docenteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Docente", "ID_docente", id));
		docenteEdited.setNombre(docente.getNombre());
		docenteEdited.setEdad(docente.getEdad());
		docenteEdited.setDireccion(docente.getDireccion());
		docenteEdited.setNacionalidad(docente.getNacionalidad());

		docenteEdited.setAntiguedad(docente.getAntiguedad());
		docenteEdited.setPuntaje(docente.getPuntaje());
		
		return this.docenteRepository.save(docenteEdited);
	}
	
	//Delete a docente
	@DeleteMapping("/docentes/{id}")
	public ResponseEntity<?> deleteDocente(@PathVariable(value="id") Integer id){
		Docente docenteDeleted=this.docenteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Docente", "ID_docente", id));
		String nombre_completo=docenteDeleted.getNombre();
		String response=String.format("El docente con id: %s (%s) fue eliminado del sistema",id,nombre_completo);
		
		this.docenteRepository.delete(docenteDeleted);
		return new ResponseEntity<String>(response,HttpStatus.OK); 
	}
}
