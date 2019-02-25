package com.educativa.cargahoras.services;

import com.educativa.cargahoras.entities.Hora;
import com.educativa.cargahoras.exceptions.ResourceNotFoundException;
import com.educativa.cargahoras.repositories.HoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class HoraServiceImpl implements HoraService{
    @Autowired
    private HoraRepository repository;

    @Override
    public Hora getHoraById(int id) {
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hora", "id_hora", id));
    }
    @Override
    public List<Hora> getHoras() {
        return this.repository.findAll();
    }
    @Override
    public Hora createHora(@Valid Hora hora) {
        return this.repository.save(hora);
    }
    @Override
    public int updateHora(int id, Hora hora) {
        return id;
    }
    @Override
    public int deleteHoraById(int id) {
        Hora horaById = this.getHoraById(id);
        this.repository.delete(horaById);
        return id;
    }
    @Override
    public void deleteHoras() {
        this.repository.deleteAll();
    }
    @Override
    public Long cantHoras() {
        return this.repository.count();
    }
}