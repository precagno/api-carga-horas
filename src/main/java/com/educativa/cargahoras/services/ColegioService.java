package com.educativa.cargahoras.services;

import com.educativa.cargahoras.entities.Colegio;

import java.util.List;

public interface ColegioService {
    public List<Colegio> getAllColegios();
    public Colegio getColegioById(int id);
    public Colegio createColegio(Colegio colegio);
    public int updateColegio(int id,Colegio colegio);
    public int deleteColegioById(int id);
    public void deleteAllColegios();
    public Long getCantColegios();
}
