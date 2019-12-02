package com.educativa.cargahoras.services;

import java.util.List;

import com.educativa.cargahoras.entities.Docente;

public interface DocenteService {
    public List<Docente> getAllDocentes();
    public Docente getDocenteById(int id);
    public Docente getDocenteByName(String name);
    public Docente createDocente(Docente docente);
    public int updateDocenteById(int id,Docente docente);
    public int deleteDocenteById(int id);
    public void deleteAllDocentes();
    public Long cantDocentes();
}
