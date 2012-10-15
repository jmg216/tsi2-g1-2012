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
@Table(name="empresa")
public class Empresa implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6416162494503125506L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;
	
	@Column(name="DESCRIPCION", nullable=false)
	private String descripcion;
	
	@Column(name="LOGO_URL", nullable=false)
	private String logoUrl;
	
	@Column(name="FECHA_CREACION", nullable=false)
	private Timestamp fechaCreacion;

	@JoinColumn(name="ADMINISTRADOR_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Administrador administrador;
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public Administrador getAdministrador()
	{
		return administrador;
	}

	public void setAdministrador(Administrador administrador)
	{
		this.administrador = administrador;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public String getLogoUrl()
	{
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl)
	{
		this.logoUrl = logoUrl;
	}

	public Timestamp getFechaCreacion()
	{
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion)
	{
		this.fechaCreacion = fechaCreacion;
	}
}