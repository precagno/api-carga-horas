package com.educativa.cargahoras.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Direccion {
    private String nombre;
    private int numero;
    private String codigoPostal;
    private String ciudad;
    private String provincia;
    private String pais;
}
