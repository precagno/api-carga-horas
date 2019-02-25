package com.educativa.cargahoras.services;

import com.educativa.cargahoras.entities.Hora;

import java.util.List;

public interface HoraService {
    public Hora getHoraById(int id);
    public List<Hora> getHoras();
    public Hora createHora(Hora hora);
    public int updateHora(int id, Hora asignatura);
    public int deleteHoraById(int id);
    public void deleteHoras();
    public Long cantHoras();
}