package com.educativa.cargahoras.services;

import com.educativa.cargahoras.entities.Docente;

import java.util.List;

public interface DocenteService {
    public List<Docente> getAllDocentes();
    public Docente getDocenteById(int id);
    public Docente createDocente(Docente docente);
    public int updateDocenteById(int id,Docente docente);
    public int deleteDocenteById(int id);
}
