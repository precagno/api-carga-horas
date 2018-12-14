package com.educativa.cargahoras.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date fechaCreacion;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "docentes_asignaturas",
			joinColumns = @JoinColumn(name = "docente_id",referencedColumnName = "idDocente"),
			inverseJoinColumns = @JoinColumn(name = "asignatura_id",referencedColumnName = "idAsignatura"))
	private List<Asignatura> asignaturas;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Hora> horas;


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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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
				", asignaturas=" + asignaturas +
				", horas=" + horas +
				", fechaCreacion=" + fechaCreacion +
				'}';
	}
}