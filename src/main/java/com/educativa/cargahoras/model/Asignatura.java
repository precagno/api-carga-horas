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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="asignaturas")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updatedAt"},allowGetters=true)
public class Asignatura {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer ID_asignatura;
	
	@NotBlank
	private String nombre_asignatura;
	
	@Column(nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public Integer getID_asignatura() {
		return this.ID_asignatura;
	}

	public void setID_asignatura(Integer iD_asignatura) {
		ID_asignatura = iD_asignatura;
	}

	public String getNombre_asignatura() {
		return this.nombre_asignatura;
	}

	public void setNombre_asignatura(String nombre_asignatura) {
		this.nombre_asignatura = nombre_asignatura;
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
