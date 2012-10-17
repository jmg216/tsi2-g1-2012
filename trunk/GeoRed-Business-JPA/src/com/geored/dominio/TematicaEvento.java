package com.geored.dominio;

import java.io.Serializable;

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
@Table(name="tematica_evento")
public class TematicaEvento implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3194319439298569315L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@JoinColumn(name="TEMATICA_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Tematica tematica;
	
	@JoinColumn(name="EVENTO_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	
	private Evento evento;

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

	public Evento getEvento()
	{
		return evento;
	}

	public void setEvento(Evento evento)
	{
		this.evento = evento;
	}
}