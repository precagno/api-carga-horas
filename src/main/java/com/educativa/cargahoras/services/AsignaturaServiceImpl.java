package com.educativa.cargahoras.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educativa.cargahoras.entities.Asignatura;
import com.educativa.cargahoras.exceptions.ResourceNotFoundException;
import com.educativa.cargahoras.repositories.AsignaturaRepository;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{
    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    public List<Asignatura> getAsignaturas() {
        return this.asignaturaRepository.findAll();
    }
    @Override
    public Asignatura getAsignaturaById(int id) {
        return this.asignaturaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Asignatura","id_asignatura",id));
    }
    @Override
    public Asignatura getAsignaturaBynombreAsignatura(String nombre){
        return this.asignaturaRepository.findByNombreAsignatura(nombre);
    }
    @Override
    public Asignatura createAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }
    @Override
    public int updateAsignatura(int id, @Valid Asignatura asignatura) {
        Asignatura asignaturaById = this.getAsignaturaById(id);
        asignaturaById.setNombreAsignatura(asignatura.getNombreAsignatura());
        this.asignaturaRepository.save(asignaturaById);
        return id;
    }
    @Override
    public int deleteAsignaturaById(int id) {
        Asignatura asignaturaById = this.getAsignaturaById(id);
        this.asignaturaRepository.delete(asignaturaById);
        return id;
    }
    @Override
    public void deleteAsignaturas() {
        this.asignaturaRepository.deleteAll();
    }
    @Override
    public Long cantAsignaturas() {
        return this.asignaturaRepository.count();
    }
}