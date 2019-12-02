package com.educativa.cargahoras.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "docentes")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value={"fechaCreacion"},allowGetters=true)
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
	private Calendar fechaCreacion;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "docentes_asignaturas", joinColumns = @JoinColumn(name = "docente_id", referencedColumnName = "idDocente"), inverseJoinColumns = @JoinColumn(name = "asignatura_id", referencedColumnName = "idAsignatura"))
	@JsonProperty("asignaturas")
	private List<Asignatura> asignaturas;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonProperty("horas")
	private List<Hora> horas;

	public Docente() {}

	public Docente(@NotBlank String nombre, @NotBlank String apellido, @NotNull int edad, @NotBlank String direccion,
			@NotBlank String nacionalidad, @NotNull int antiguedad, @NotNull Double puntaje) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.direccion = direccion;
		this.nacionalidad = nacionalidad;
		this.antiguedad = antiguedad;
		this.puntaje = puntaje;
	}

	//// GETTERS
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

	@JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy")
	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public List<Hora> getHoras() {
		return horas;
	}

	//// SETTERS
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

	public void setFechaCreacion(Calendar fechaCreacion) {
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
		return "Docente [idDocente=" + idDocente + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", direccion=" + direccion + ", nacionalidad=" + nacionalidad + ", antiguedad=" + antiguedad
				+ ", puntaje=" + puntaje + ", fechaCreacion=" + fechaCreacion + ", asignaturas=" + asignaturas
				+ ", horas=" + horas + "]";
	}

}