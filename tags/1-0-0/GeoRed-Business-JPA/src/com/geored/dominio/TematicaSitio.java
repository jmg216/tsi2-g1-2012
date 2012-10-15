package com.geored.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tematica_sitio")
public class TematicaSitio implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -802694227417026322L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@JoinColumn(name="TEMATICA_FK", nullable=false)
	private Tematica tematica;
	
	@JoinColumn(name="SITIO_FK", nullable=false)
	private Sitio sitio;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Tematica getTematica()
	{
		return tematica;
	}

	public void setTematica(Tematica tematica)
	{
		this.tematica = tematica;
	}

	public Sitio getSitio()
	{
		return sitio;
	}

	public void setSitio(Sitio sitio)
	{
		this.sitio = sitio;
	}
}