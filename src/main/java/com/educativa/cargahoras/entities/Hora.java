package com.educativa.cargahoras.entities;

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
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="horas")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updatedAt"},allowGetters=true)
public class Hora {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer ID_hora;
	@NotNull
	@JsonProperty("colegio")
	private int colegio;
	@NotBlank
	@JsonProperty("descripcion")
	private String descripcion;
	@NotBlank
	@JsonProperty("curso")
	private String curso;
	@Column(nullable=false,updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@JsonProperty("fecha_creacion")
	private Date fecha_creacion;
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@JsonProperty("fecha_edicion")
	private Date updatedAt;
	
	////GETTERS
	public Integer getID_hora() {
		return ID_hora;
	}
	public int getColegio() {
		return colegio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getCurso() {
		return curso;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}

	////SETTERS
	public void setID_hora(Integer ID_hora) {
		this.ID_hora = ID_hora;
	}
	public void setColegio(int colegio) {
		this.colegio = colegio;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Hora{" +
				"ID_hora=" + ID_hora +
				", colegio=" + colegio +
				", descripcion='" + descripcion + '\'' +
				", curso='" + curso + '\'' +
				", fecha_creacion=" + fecha_creacion +
				", updatedAt=" + updatedAt +
				'}';
	}
}