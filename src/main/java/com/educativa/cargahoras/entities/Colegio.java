package com.educativa.cargahoras.entities;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="colegios")
@JsonIgnoreProperties({"createdAt"})
public class Colegio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer idColegio;
	@NotBlank
	@JsonProperty("nombre_colegio")
	private String nombreColegio;
	@Embedded
	@JsonProperty("direccion")
	private Direccion direccion;
	@Column(nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date fechaCreacion;

	////GETTERS
	public Integer getIdColegio() {
		return idColegio;
	}
	public void setIdColegio(Integer idColegio) {
		this.idColegio = idColegio;
	}
	public String getNombreColegio() {
		return nombreColegio;
	}

	////SETTERS
	public void setNombreColegio(String nombreColegio) {
		this.nombreColegio = nombreColegio;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Colegio{" +
				"idColegio=" + idColegio +
				", nombreColegio='" + nombreColegio + '\'' +
				", direccion=" + direccion +
				", fechaCreacion=" + fechaCreacion +
				'}';
	}
}