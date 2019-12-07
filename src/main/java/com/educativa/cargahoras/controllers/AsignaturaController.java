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

import com.educativa.cargahoras.entities.Asignatura;
import com.educativa.cargahoras.services.AsignaturaService;

@RestController
@RequestMapping("/api")
public class AsignaturaController {
	@Autowired
	private AsignaturaService asignaturaService;
	
	//Trae todas las asignaturas
	@GetMapping("/v1/asignaturas")
	public List<Asignatura> getAsignaturas(){
		return this.asignaturaService.getAsignaturas();
	}
	//Traer una asignatura por id
	@GetMapping("/v1/asignatura/{id}")
	public Asignatura getAsignaturaById(@PathVariable(name="id")Integer id){
		return this.asignaturaService.getAsignaturaById(id);
	}
	//Crear una nueva asignatura
	@PostMapping("/v1/asignatura")
	public ResponseEntity<String> createAsignatura(@Valid @RequestBody Asignatura asignatura){
		Asignatura asignaturaSaved=this.asignaturaService.createAsignatura(asignatura);
        String response=String.format("Asignatura creada correctamente con id %d",asignaturaSaved.getIdAsignatura());
        return ResponseEntity.ok(response);
    }
	//Actualiza una asignatura por id
	@PutMapping("/v1/asignatura/{id}")
	public ResponseEntity<String> updateAsignatura(@PathVariable(value="id") Integer id,@Valid @RequestBody Asignatura asignatura){
        int idAsignatura = this.asignaturaService.updateAsignatura(id, asignatura);
        String response=String.format("Asignatura actualizada correctamente con id %d",idAsignatura);
        return ResponseEntity.ok(response);
    }
	//Borrar una asignatura por id
	@DeleteMapping("/v1/asignatura/{id}")
	public ResponseEntity<String> deleteAsignatura(@PathVariable(value="id") Integer id){
        int idAsignaturaDeleted = this.asignaturaService.deleteAsignaturaById(id);
        String response=String.format("La asignatura con id: %d fue borrada correctamente.",idAsignaturaDeleted);
		return ResponseEntity.ok(response);
	}
}