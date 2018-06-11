package com.educativa.cargahoras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educativa.cargahoras.model.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente,Integer>{
}