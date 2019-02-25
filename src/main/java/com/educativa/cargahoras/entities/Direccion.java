package com.educativa.cargahoras.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
public class Direccion {
    @NotBlank
    @JsonProperty("nombre")
    private String nombre;
    @NotNull
    @JsonProperty("numero")
    private int numero;
    @NotBlank
    @JsonProperty("codigo_postal")
    private String codigoPostal;
    @NotBlank
    @JsonProperty("ciudad")
    private String ciudad;
    @NotBlank
    @JsonProperty("provincia")
    private String provincia;
    @NotBlank
    @JsonProperty("pais")
    private String pais;
}