package com.educativa.cargahoras.services;

import com.educativa.cargahoras.entities.Asignatura;
import com.educativa.cargahoras.exceptions.ResourceNotFoundException;
import com.educativa.cargahoras.repositories.AsignaturaRepository;
import com.educativa.cargahoras.validations.ValidateEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{
    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private ValidateEntityServiceImpl validateEntityService;

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
    public int updateAsignatura(int id, Asignatura asignatura) {
        Asignatura asignaturaById = this.getAsignaturaById(id);

        asignaturaById.setNombreAsignatura(asignatura.getNombreAsignatura());

        return id;
    }

    @Override
    public void deleteAsignaturas() {
        this.asignaturaRepository.deleteAll();
    }

    @Override
    public int deleteAsignaturaById(int id) {
        this.asignaturaRepository.deleteById(id);

        return id;
    }

    @Override
    public Long cantAsignaturas() {
        return this.asignaturaRepository.count();
    }
}