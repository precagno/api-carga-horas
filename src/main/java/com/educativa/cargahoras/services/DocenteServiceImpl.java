package com.educativa.cargahoras.services;

import com.educativa.cargahoras.entities.Docente;
import com.educativa.cargahoras.exceptions.ResourceNotFoundException;
import com.educativa.cargahoras.repositories.DocenteRepository;
import com.educativa.cargahoras.validations.ValidateEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class DocenteServiceImpl implements DocenteService{
    @Autowired
    private DocenteRepository repository;

    @Autowired
    private ValidateEntityService validEnt;

    @Override
    public List<Docente> getAllDocentes() {
        return this.repository.findAll();
    }

    @Override
    public Docente getDocenteById(int id) {
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Docente", "id_docente", id));
    }

    @Override
    public Docente createDocente(@Valid Docente docente){
        return this.repository.save(docente);
    }

    @Override
    public int updateDocenteById(int id,@Valid Docente docente) {
        Docente aux = this.getDocenteById(id);

        String nombre = docente.getNombre();
        String apellido = docente.getApellido();
        int edad = docente.getEdad();
        String direccion = docente.getDireccion();
        String nacionalidad = docente.getNacionalidad();
        int antiguedad = docente.getAntiguedad();
        Double puntaje = docente.getPuntaje();

        if(!this.validEnt.isEmpty(nombre)){
            aux.setNombre(nombre);
        }
        if(!this.validEnt.isEmpty(apellido)){
            aux.setApellido(apellido);
        }
        if(!this.validEnt.isNull(edad)){
            aux.setEdad(edad);
        }
        if(!this.validEnt.isEmpty(direccion)){
            aux.setDireccion(direccion);
        }
        if(!this.validEnt.isEmpty(nacionalidad)){
            aux.setNacionalidad(nacionalidad);
        }
        if(!this.validEnt.isNull(antiguedad)){
            aux.setAntiguedad(antiguedad);
        }
        if(!this.validEnt.isNull(puntaje)){
            aux.setPuntaje(puntaje);
        }

        this.repository.save(aux);
        return id;
    }

    @Override
    public int deleteDocenteById(int id) {
        Docente docente = this.getDocenteById(id);
        this.repository.delete(docente);
        return id;
    }
}