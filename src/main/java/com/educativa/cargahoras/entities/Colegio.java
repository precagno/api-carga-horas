package com.educativa.cargahoras.entities;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="colegios")
@JsonIgnoreProperties({"createdAt"})
public class Colegio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idColegio;
	@NotBlank
	private String nombreColegio;
	@Embedded
	private Direccion direccion;
	@Column(nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	public Integer getIdColegio() {
		return idColegio;
	}

	public void setIdColegio(Integer idColegio) {
		this.idColegio = idColegio;
	}

	public String getNombreColegio() {
		return nombreColegio;
	}

	public void setNombreColegio(String nombreColegio) {
		this.nombreColegio = nombreColegio;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}