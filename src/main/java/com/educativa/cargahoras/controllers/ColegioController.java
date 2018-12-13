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
import com.educativa.cargahoras.entities.Colegio;
import com.educativa.cargahoras.repositories.ColegioRepository;

@RestController
@RequestMapping("/api")
public class ColegioController {
	@Autowired
	ColegioRepository colegiorepository; 
	
	//Get all colegios
	@GetMapping("/colegios")
	public List<Colegio> getColegios(){
		return this.colegiorepository.findAll();
	}
	
	//Create a new colegio
	@PostMapping("/colegios")
	public Colegio createAsignatura(@Valid @RequestBody Colegio colegio){
		return this.colegiorepository.save(colegio);
	}
	
	//Get single colegio by id
	@GetMapping("/colegios/{id}")
	public Colegio getColegioById(@PathVariable(name="id")Integer id){
		return this.colegiorepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Colegio", "ID_colegio", id));
	}
	
	//Update colegio
	@PutMapping("/colegios/{id}")
	public Colegio updateColegio(@PathVariable(value="id") Integer id,@Valid @RequestBody Colegio colegio){
		Colegio colegio_edited=this.colegiorepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Colegio", "ID_colegio",id));
		colegio_edited.setNombre_colegio(colegio.getNombre_colegio());
		colegio_edited.setDireccion(colegio.getDireccion());
		
		return this.colegiorepository.save(colegio_edited);
	}
	
	//Delete colegio
	@DeleteMapping("/colegios/{id}")
	public ResponseEntity<?> deleteAsignatura(@PathVariable(value="id") Integer id){
		Colegio deletedColegio=this.colegiorepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Colegio", "ID_colegio", id));		
		String response=String.format("El colegio con id: %s fue borrado correctamente.",id);
		
		this.colegiorepository.delete(deletedColegio);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
}
