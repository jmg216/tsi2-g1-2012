package com.geored.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8244156161741559631L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@Column(name="PASS", nullable=false)
	private String pass;

	@Column(name="NOMBRE", nullable=false)
	private String nombre;
	
	@Column(name="URL_IMAGEN", nullable=false)
	private String urlImagen;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="usuario_tematica",
	joinColumns =
	{
	    @JoinColumn(name = "TEMATICA_FK")
	},
	inverseJoinColumns =
	{
	    @JoinColumn(name = "USUARIO_FK")
	})
	private List<Tematica> listaTematicas;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="usuario_oferta",
	joinColumns =
	{
	    @JoinColumn(name = "OFERTA_FK")
	},
	inverseJoinColumns =
	{
	    @JoinColumn(name = "USUARIO_FK")
	})
	private List<Oferta> listaCompras;
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getUrlImagen()
	{
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen)
	{
		this.urlImagen = urlImagen;
	}

	public List<Tematica> getListaTematicas()
	{
		return listaTematicas;
	}

	public void setListaTematicas(List<Tematica> listaTematicas)
	{
		this.listaTematicas = listaTematicas;
	}

	public List<Oferta> getListaCompras()
	{
		return listaCompras;
	}

	public void setListaCompras(List<Oferta> listaCompras)
	{
		this.listaCompras = listaCompras;
	}
}