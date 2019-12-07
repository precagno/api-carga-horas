package com.educativa.cargahoras.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="asignaturas")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value={"fechaCreacion"},allowGetters=true)
public class Asignatura {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonProperty("id")
	private Integer idAsignatura;
	@NotBlank
    @JsonProperty("nombre_asignatura")
	private String nombreAsignatura;
	@Column(nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
    @JsonProperty("fecha_creacion")
    private Date fechaCreacion;
    @JsonProperty("docentes")
	@ManyToMany(mappedBy = "asignaturas")
	private List<Docente> docentes;
    
    public Asignatura() {}
    
    public Asignatura(@NotBlank String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

    ////GETTERS
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public List<Docente> getDocentes() {
		return docentes;
	}
	
	public Integer getIdAsignatura() {
		return idAsignatura;
	}

	@JsonFormat(shape = Shape.STRING,pattern = "dd/MM/yyyy")
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	////SETTERS
	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}   
}
