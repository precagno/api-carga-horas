package com.educativa.cargahoras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educativa.cargahoras.model.Colegio;

@Repository
public interface ColegioRepository extends JpaRepository<Colegio, Integer>{
}
