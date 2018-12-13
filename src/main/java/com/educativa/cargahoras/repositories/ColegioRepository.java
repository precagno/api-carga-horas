package com.educativa.cargahoras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educativa.cargahoras.entities.Colegio;

@Repository
public interface ColegioRepository extends JpaRepository<Colegio, Integer>{
}
