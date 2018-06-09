package com.educativa.cargahoras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educativa.cargahoras.model.Asignatura;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura,Integer>{
}