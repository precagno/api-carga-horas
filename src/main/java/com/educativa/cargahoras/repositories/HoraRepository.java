package com.educativa.cargahoras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educativa.cargahoras.entities.Hora;

@Repository
public interface HoraRepository extends JpaRepository<Hora, Integer>{
}
