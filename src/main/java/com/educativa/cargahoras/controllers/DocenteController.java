package com.educativa.cargahoras.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educativa.cargahoras.entities.Docente;
import com.educativa.cargahoras.services.DocenteService;

@RestController
@RequestMapping("/api")
public class DocenteController {
	@Autowired
	private DocenteService docenteService;

	//Traer a todos los docentes
	@GetMapping("/v1/docentes")
	public List<Docente> getDocentes(){
		return this.docenteService.getAllDocentes();
	}
	
	//Crear un docente
	@PostMapping("/v1/docente")
	public ResponseEntity<String> createDocente(@RequestBody Docente docente){
		Docente docSaved = this.docenteService.createDocente(docente);
		String response=String.format("Fue creado el docente con el id %d",docSaved.getIdDocente());
		return ResponseEntity.ok(response);
	}
	
	//Traer un docente por id
	@GetMapping("/v1/docente/{id}")
	public Docente getDocenteById(@PathVariable(value="id")Integer id){
		return this.docenteService.getDocenteById(id);
	}
	
	//Actualizar un docente por id
	@PatchMapping("/v1/docente/{id}")
	public ResponseEntity<String> updateDocente(@PathVariable(value="id")Integer id ,@RequestBody Docente docente){
		this.docenteService.updateDocenteById(id,docente);
		String response=String.format("Fue actualizado el docente con el id %d",id);
		return ResponseEntity.ok(response);
	}
	
	//Borrar el registro de un docente por id
	@DeleteMapping("/v1/docente/{id}")
	public ResponseEntity<String> deleteDocente(@PathVariable(value="id") Integer id){
		this.docenteService.deleteDocenteById(id);
		String response=String.format("Fue borrado de la base de datos el docente con el id %d",id);
		return ResponseEntity.ok(response);
	}
}
