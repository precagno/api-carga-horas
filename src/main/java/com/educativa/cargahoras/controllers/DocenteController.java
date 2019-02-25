package com.educativa.cargahoras.controllers;

import java.util.List;


import com.educativa.cargahoras.services.DocenteService;
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

import com.educativa.cargahoras.entities.Docente;

@RestController
@RequestMapping("/api")
public class DocenteController {
	@Autowired
	private DocenteService docenteService;

	//Get all docentes
	@GetMapping("/docentes")
	public List<Docente> getDocentes(){
		return this.docenteService.getAllDocentes();
	}
	
	//Create a new docente
	@PostMapping("/docentes")
	public ResponseEntity<?> createDocente(@RequestBody Docente docente){
		Docente docSaved = this.docenteService.createDocente(docente);

		String response=String.format("Fue creado el docente con el id %d",docSaved.getIdDocente());
		return ResponseEntity.ok(response);
	}
	
	//Get single docente by id
	@GetMapping("/docentes/{id}")
	public Docente getDocenteById(@PathVariable(value="id")Integer id){
		return this.docenteService.getDocenteById(id);
	}
	
	//Update a docente
	@PutMapping("/docentes/{id}")
	public ResponseEntity<?> updateDocente(@PathVariable(value="id")Integer id ,@RequestBody Docente docente){
		this.docenteService.updateDocenteById(id,docente);

		String response=String.format("Fue actualizado el docente con el id %d",id);
		return ResponseEntity.ok(response);
	}
	
	//Delete a docente
	@DeleteMapping("/docentes/{id}")
	public ResponseEntity<?> deleteDocente(@PathVariable(value="id") Integer id){
		this.docenteService.deleteDocenteById(id);

		String response=String.format("Fue borrado de la base de datos el docente con el id %d",id);
		return ResponseEntity.ok(response);
	}
}
