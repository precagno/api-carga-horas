package com.educativa.cargahoras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educativa.cargahoras.entities.Asignatura;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura,Integer>{
    public Asignatura findByNombreAsignatura(String nombre);
}