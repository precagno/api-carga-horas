package com.educativa.cargahoras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educativa.cargahoras.model.Hora;

@Repository
public interface HoraRepository extends JpaRepository<Hora, Integer>{
}
