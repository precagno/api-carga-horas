package com.educativa.cargahoras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educativa.cargahoras.entities.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente,Integer>{
}