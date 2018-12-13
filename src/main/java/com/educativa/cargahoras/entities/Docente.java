package com.educativa.cargahoras.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="docentes")
@JsonIgnoreProperties(value={"createdAt"},allowGetters=true)
public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDocente;
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@NotNull
	private int edad;
	@NotBlank
	private String direccion;
	@NotBlank
	private String nacionalidad;
	@NotNull
	private int antiguedad;
	@NotNull
	private Double puntaje;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Asignatura> asignaturas;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Hora> horas;
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Timestamp createdAt;

	public int getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public Double getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(Double puntaje) {
		this.puntaje = puntaje;
	}
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	public List<Hora> getHoras() {
		return horas;
	}
	public void setHoras(List<Hora> horas) {
		this.horas = horas;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
}