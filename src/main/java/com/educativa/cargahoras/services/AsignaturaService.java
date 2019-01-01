package com.educativa.cargahoras.services;

import com.educativa.cargahoras.entities.Asignatura;

import java.util.List;

public interface AsignaturaService{
    public Asignatura getAsignaturaById(int id);
    public Asignatura getAsignaturaBynombreAsignatura(String nombre);
    public List<Asignatura> getAsignaturas();
    public Asignatura createAsignatura(Asignatura asignatura);
    public int updateAsignatura(int id,Asignatura asignatura);
    public void deleteAsignaturas();
    public int deleteAsignaturaById(int id);
    public Long cantAsignaturas();
}