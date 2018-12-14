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

import com.educativa.cargahoras.exceptions.ResourceNotFoundException;
import com.educativa.cargahoras.entities.Asignatura;
import com.educativa.cargahoras.repositories.AsignaturaRepository;

@RestController
@RequestMapping("/api")
public class AsignaturaController {
	/*@Autowired
	AsignaturaRepository asignaturarepository; 
	
	//Get all asignaturas
	@GetMapping("/asignaturas")
	public List<Asignatura> getAsignaturas(){
		return this.asignaturarepository.findAll();
	}
	
	//Create a new asignatura
	@PostMapping("/asignaturas")
	public ResponseEntity<?> createAsignatura(@Valid @RequestBody Asignatura asignatura){
		if(asignatura.getNombre_asignatura()==""){
			return ResponseEntity.badRequest().build();
		}
		@Valid Asignatura save = this.asignaturarepository.save(asignatura);
		String response=String.format("Asignatura creada correctamente con id %i",save.getID_asignatura());

		return ResponseEntity.ok(response);
	}
	
	//Get single asignatura by id
	@GetMapping("/asignaturas/{id}")
	public ResponseEntity<?> getAsignaturaById(@PathVariable(name="id")Integer id){
		Asignatura asignatura = this.asignaturarepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Asignatura", "ID_asignatura", id));
		String response=String.format("Asignatura actualizada correctamente con id %i",asignatura.getID_asignatura());

		return ResponseEntity.ok(response);
	}
	
	//Update asignatura
	@PutMapping("/asignaturas/{id}")
	public Asignatura updateAsignatura(@PathVariable(value="id") Integer id,@Valid @RequestBody Asignatura asignatura){
		Asignatura asignatura_edited=this.asignaturarepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Asignatura", "ID_asignatura",id));
		asignatura_edited.setNombre_asignatura(asignatura.getNombre_asignatura());
		
		return this.asignaturarepository.save(asignatura_edited);
	}
	//Delete asignatura
	@DeleteMapping("/asignaturas/{id}")
	public ResponseEntity<?> deleteAsignatura(@PathVariable(value="id") Integer id){
		Asignatura deletedAsignatura=this.asignaturarepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Asignatura", "ID_asignatura", id));		
		String nombre_asignatura=deletedAsignatura.getNombre_asignatura();
		String response=String.format("La asignatura con id: %s (%s) fue borrada correctamente.",id,nombre_asignatura);
		
		this.asignaturarepository.delete(deletedAsignatura);

		return ResponseEntity.ok(response);
	}*/
}