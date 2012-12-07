package com.geored.dominio;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mensaje_amistad")
public class MensajeAmistad implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6501502269319220200L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="MENSAJE")
	private String mensaje;
	
	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;
	
	@JoinColumn(name="AMISTAD_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Amistad amistad;
	
	@JoinColumn(name="REMITENTE_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario remitente;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getMensaje()
	{
		return mensaje;
	}

	public void setMensaje(String mensaje)
	{
		this.mensaje = mensaje;
	}

	public Timestamp getFechaCreacion()
	{
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion)
	{
		this.fechaCreacion = fechaCreacion;
	}

	public Amistad getAmistad()
	{
		return amistad;
	}

	public void setAmistad(Amistad amistad)
	{
		this.amistad = amistad;
	}

	public Usuario getRemitente()
	{
		return remitente;
	}

	public void setRemitente(Usuario remitente)
	{
		this.remitente = remitente;
	}
}