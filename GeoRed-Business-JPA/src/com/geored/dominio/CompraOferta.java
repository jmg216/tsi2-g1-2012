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
@Table(name="compra_oferta")
public class CompraOferta implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3087531603052890310L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@JoinColumn(name="USUARIO_FK", nullable=false)
	private Usuario usuario;
	
	@JoinColumn(name="OFERTA_FK", nullable=false)
	private Oferta oferta;

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
}
