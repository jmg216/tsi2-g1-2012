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
	
	@Column(name="GCMREGID")
	private String gcmRegId;	
	
	@Column(name="URL_IMAGEN")
	private String urlImagen;
	
	@Column(name="UBICACION_ACTUAL")
	private String ubicacionActual;
	
	@Column(name="CONECTADO")
	private Boolean conectado;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="usuario_tematica",
	joinColumns =
	{
	    @JoinColumn(name = "USUARIO_FK")
	},
	inverseJoinColumns =
	{
	    @JoinColumn(name = "TEMATICA_FK")
	})
	private List<Tematica> listaTematicas;
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getUbicacionActual() 
	{
		return ubicacionActual;
	}

	public void setUbicacionActual(String ubicacionActual) 
	{
		this.ubicacionActual = ubicacionActual;
	}

	public Boolean getConectado() 
	{
		return conectado;
	}

	public void setConectado(Boolean conectado) 
	{
		this.conectado = conectado;
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

	public String getGcmRegId() 
	{
		return gcmRegId;
	}

	public void setGcmRegId(String gcmRegId) 
	{
		this.gcmRegId = gcmRegId;
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
}