package com.educativa.cargahoras.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="colegios")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"createdAt","updatedAt"})
public class Colegio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ID_colegio;
	@NotBlank
	private String nombre_colegio;
	@NotBlank
	private String direccion;
	@Column(nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	public Integer getID_colegio() {
		return this.ID_colegio;
	}
	public void setID_colegio(Integer iD_colegio) {
		ID_colegio = iD_colegio;
	}
	public String getNombre_colegio() {
		return this.nombre_colegio;
	}
	public void setNombre_colegio(String nombre_colegio) {
		this.nombre_colegio = nombre_colegio;
	}
	public String getDireccion() {
		return this.direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getCreatedAt() {
		return this.createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return this.updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}