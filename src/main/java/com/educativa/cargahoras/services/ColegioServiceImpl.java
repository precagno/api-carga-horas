package com.educativa.cargahoras.services;

import com.educativa.cargahoras.entities.Colegio;
import com.educativa.cargahoras.exceptions.ResourceNotFoundException;
import com.educativa.cargahoras.repositories.ColegioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class ColegioServiceImpl implements ColegioService{
    @Autowired
    private ColegioRepository repository;

    @Override
    public List<Colegio> getAllColegios() {
        return this.repository.findAll();
    }

    @Override
    public Colegio getColegioById(int id) {
        return this.repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Colegio","id_colegio",id));
    }

    @Override
    public Colegio createColegio(Colegio colegio) {
        return this.repository.save(colegio);
    }

    @Override
    public int updateColegio(int id, Colegio colegio) {
        throw new NotImplementedException();
    }

    @Override
    public int deleteColegioById(int id) {
        Colegio colegioById = this.getColegioById(id);
        this.repository.delete(colegioById);
        return id;
    }

    @Override
    public void deleteAllColegios() {
        this.repository.deleteAll();
    }

    @Override
    public Long getCantColegios() {
        return this.repository.count();
    }
}