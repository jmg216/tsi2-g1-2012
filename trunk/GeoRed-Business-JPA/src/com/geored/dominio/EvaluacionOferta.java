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
@Table(name="evaluacion_oferta")
public class EvaluacionOferta implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7701969749727877202L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@JoinColumn(name="USUARIO_FK", nullable=false)
	private Usuario usuario;
	
	@JoinColumn(name="OFERTA_FK", nullable=false)
	private Oferta oferta;

	@Column(name="EVALUACION", nullable=false)
	private String evaluacion;
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
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

	public String getEvaluacion()
	{
		return evaluacion;
	}

	public void setEvaluacion(String evaluacion)
	{
		this.evaluacion = evaluacion;
	}
}