package com.educativa.cargahoras.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
public class Direccion {
    @NotBlank
    private String nombre;
    @NotNull
    private int numero;
    @NotBlank
    private String codigoPostal;
    @NotBlank
    private String ciudad;
    @NotBlank
    private String provincia;
    @NotBlank
    private String pais;
}