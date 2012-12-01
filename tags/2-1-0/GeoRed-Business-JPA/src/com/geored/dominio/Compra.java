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
@Table(name="compra")
public class Compra implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3780476528962467498L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;
	
	@JoinColumn(name="USUARIO_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)		
	private Usuario usuario;
	
	@JoinColumn(name="OFERTA_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Oferta oferta;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Timestamp getFechaCreacion()
	{
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion)
	{
		this.fechaCreacion = fechaCreacion;
	}

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}

	public Oferta getOferta()
	{
		return oferta;
	}

	public void setOferta(Oferta oferta)
	{
		this.oferta = oferta;
	}
}