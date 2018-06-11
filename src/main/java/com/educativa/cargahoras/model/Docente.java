package com.educativa.cargahoras.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="docentes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updatedAt"},allowGetters=true)
public class Docente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer ID_docente;
	@NotBlank
	private String nombre_completo;
	@NotNull
	private Integer edad; 
	@NotBlank
	private String direccion;
	@NotBlank
	private String nacionalidad;
	@NotNull
	Integer asignatura;
	@NotNull
	private Integer antiguedad;
	@NotNull
	private Double puntaje;
	@Column(nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	public Integer getID_docente() {
		return this.ID_docente;
	}
	public void setID_docente(Integer iD_docente) {
		ID_docente = iD_docente;
	}
	public String getNombre_completo() {
		return this.nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public Integer getEdad() {
		return this.edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getDireccion() {
		return this.direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNacionalidad() {
		return this.nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Integer getAsignatura() {
		return this.asignatura;
	}
	public void setAsignatura(Integer asignatura) {
		this.asignatura = asignatura;
	}
	public Integer getAntiguedad() {
		return this.antiguedad;
	}
	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}
	public Double getPuntaje() {
		return this.puntaje;
	}
	public void setPuntaje(Double puntaje) {
		this.puntaje = puntaje;
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