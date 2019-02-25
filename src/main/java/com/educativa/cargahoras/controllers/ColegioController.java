package com.educativa.cargahoras.controllers;

import java.util.List;

import javax.validation.Valid;

import com.educativa.cargahoras.services.ColegioService;
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

import com.educativa.cargahoras.entities.Colegio;

@RestController
@RequestMapping("/api")
public class ColegioController {
	@Autowired
	private ColegioService colegioService;
	
	//Get all colegios
	@GetMapping("/colegios")
	public List<Colegio> getColegios(){
		return this.colegioService.getAllColegios();
	}

	//Get single colegio by id
	@GetMapping("/colegios/{id}")
	public Colegio getColegioById(@PathVariable(name="id")Integer id){
		return this.colegioService.getColegioById(id);
	}
	
	//Create a new colegio
	@PostMapping("/colegios")
	public ResponseEntity<?> createAsignatura(@Valid @RequestBody Colegio colegio){
		Colegio colegioSaved=this.colegioService.createColegio(colegio);
		String response=String.format("Fue creado el colegio con el id %d",colegioSaved.getIdColegio());
		return ResponseEntity.ok(response);
	}

	//Update colegio
	@PutMapping("/colegios/{id}")
	public ResponseEntity<?> updateColegio(@PathVariable(value="id") Integer id,@Valid @RequestBody Colegio colegio){
		this.colegioService.updateColegio(id,colegio);
		String response=String.format("Fue actualizado el colegio con el id %d",id);

		return ResponseEntity.ok(response);
	}
	
	//Delete colegio
	@DeleteMapping("/colegios/{id}")
	public ResponseEntity<?> deleteAsignatura(@PathVariable(value="id") Integer id){
		this.colegioService.deleteColegioById(id);

		String response=String.format("Fue borrado de la base de datos el colegio con el id %d",id);
		return ResponseEntity.ok(response);
	}
}
