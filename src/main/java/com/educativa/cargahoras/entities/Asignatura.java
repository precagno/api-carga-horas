package com.educativa.cargahoras.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="asignaturas")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"fechaCreacion"},allowGetters=true)
public class Asignatura {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer idAsignatura;
	@NotBlank
	private String nombreAsignatura;
	@Column(nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date fechaCreacion;
	@ManyToMany(mappedBy = "asignaturas")
	private List<Docente> docentes;

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    @Override
	public String toString() {
		return "Asignatura{" +
				"idAsignatura=" + idAsignatura +
				", nombreAsignatura='" + nombreAsignatura + '\'' +
				", fechaCreacion=" + fechaCreacion +
				'}';
	}
}
