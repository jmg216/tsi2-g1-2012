package com.geored.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="amistad")
public class Amistad implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6136851369023849489L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@JoinColumn(name="USUARIO_A_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuarioA;

	@JoinColumn(name="USUARIO_B_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuarioB;
	
	@OneToMany(mappedBy="amistad", fetch=FetchType.LAZY)
	private List<MensajeAmistad> listaMensajes = new ArrayList<MensajeAmistad>();

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Usuario getUsuarioA()
	{
		return usuarioA;
	}

	public void setUsuarioA(Usuario usuarioA)
	{
		this.usuarioA = usuarioA;
	}

	public Usuario getUsuarioB()
	{
		return usuarioB;
	}

	public void setUsuarioB(Usuario usuarioB)
	{
		this.usuarioB = usuarioB;
	}

	public List<MensajeAmistad> getListaMensajes()
	{
		return listaMensajes;
	}

	public void setListaMensajes(List<MensajeAmistad> listaMensajes)
	{
		this.listaMensajes = listaMensajes;
	}
}