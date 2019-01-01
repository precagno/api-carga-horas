package com.educativa.cargahoras.controllers;

import java.util.List;

import javax.validation.Valid;

import com.educativa.cargahoras.services.AsignaturaServiceImpl;
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

import com.educativa.cargahoras.entities.Asignatura;

@RestController
@RequestMapping("/api")
public class AsignaturaController {
	@Autowired
	private AsignaturaServiceImpl asignaturaService;
	
	//Get all asignaturas
	@GetMapping("/asignaturas")
	public List<Asignatura> getAsignaturas(){
		return this.asignaturaService.getAsignaturas();
	}
	
	//Create a new asignatura
	@PostMapping("/asignaturas")
	public ResponseEntity<?> createAsignatura(@Valid @RequestBody Asignatura asignatura){
		Asignatura asignaturaSaved=this.asignaturaService.createAsignatura(asignatura);
        String response=String.format("Asignatura creada correctamente con id %d",asignaturaSaved.getIdAsignatura());
        return ResponseEntity.ok(response);
    }
	
	//Get single asignatura by id
	@GetMapping("/asignaturas/{id}")
	public Asignatura getAsignaturaById(@PathVariable(name="id")Integer id){
		return this.asignaturaService.getAsignaturaById(id);
	}
	
	//Update asignatura
	@PutMapping("/asignaturas/{id}")
	public int updateAsignatura(@PathVariable(value="id") Integer id,@Valid @RequestBody Asignatura asignatura){
        int idAsignatura = this.asignaturaService.updateAsignatura(id, asignatura);
        String response=String.format("Asignatura actualizada correctamente con id %d",idAsignatura);

        return idAsignatura;
    }
	//Delete asignatura
	@DeleteMapping("/asignaturas/{id}")
	public ResponseEntity<?> deleteAsignatura(@PathVariable(value="id") Integer id){
        int idAsignaturaDeleted = this.asignaturaService.deleteAsignaturaById(id);

        String response=String.format("La asignatura con id: %d fue borrada correctamente.",idAsignaturaDeleted);

		return ResponseEntity.ok(response);
	}
}