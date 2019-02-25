package com.educativa.cargahoras.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="docentes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"fechaCreacion"},allowGetters=true)
public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private int idDocente;
	@NotBlank
	@JsonProperty("nombre")
	private String nombre;
	@NotBlank
	@JsonProperty("apellido")
	private String apellido;
	@NotNull
	@JsonProperty("edad")
	private int edad;
	@NotBlank
	@JsonProperty("direccion")
	private String direccion;
	@NotBlank
	@JsonProperty("nacionalidad")
	private String nacionalidad;
	@NotNull
	@JsonProperty("antiguedad")
	private int antiguedad;
	@NotNull
	@JsonProperty("puntaje")
	private Double puntaje;
	@Temporal(TemporalType.DATE)
	@CreatedDate
	@JsonProperty("fecha_creacion")
	private Date fechaCreacion;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "docentes_asignaturas",
			joinColumns = @JoinColumn(name = "docente_id",referencedColumnName = "idDocente"),
			inverseJoinColumns = @JoinColumn(name = "asignatura_id",referencedColumnName = "idAsignatura"))
	@JsonProperty("asignaturas")
	private List<Asignatura> asignaturas;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonProperty("horas")
	private List<Hora> horas;

	////GETTERS
	public int getIdDocente() {
		return idDocente;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getEdad() {
		return edad;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public Double getPuntaje() {
		return puntaje;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public List<Hora> getHoras() {
		return horas;
	}
	////SETTERS
	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public void setPuntaje(Double puntaje) {
		this.puntaje = puntaje;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	public void setHoras(List<Hora> horas) {
		this.horas = horas;
	}

	@Override
	public String toString() {
		return "Docente{" +
				"idDocente=" + idDocente +
				", nombre='" + nombre + '\'' +
				", apellido='" + apellido + '\'' +
				", edad=" + edad +
				", direccion='" + direccion + '\'' +
				", nacionalidad='" + nacionalidad + '\'' +
				", antiguedad=" + antiguedad +
				", puntaje=" + puntaje +
				", fechaCreacion=" + fechaCreacion +
				", asignaturas=" + asignaturas +
				", horas=" + horas +
				'}';
	}
}