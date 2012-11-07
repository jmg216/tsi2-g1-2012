package com.geored.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tematica")
public class Tematica implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7258502485558244016L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;

	@Column(name="DESCRIPCION", nullable=false)
	private String descripcion;
	
	@ManyToMany(mappedBy="listaTematicas")
	private List<Usuario> listaUsuario;
	
	@ManyToMany(mappedBy="listaTematicas")
	private List<Evento> listaEventos;
	
	@ManyToMany(mappedBy="listaTematicas")
	private List<Oferta> listaOfertas;
	
	@ManyToMany(mappedBy="listaTematicas")
	private List<Sitio> listaSitios;
	
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

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public List<Usuario> getListaUsuario()
	{
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario)
	{
		this.listaUsuario = listaUsuario;
	}

	public List<Evento> getListaEventos()
	{
		return listaEventos;
	}

	public void setListaEventos(List<Evento> listaEventos)
	{
		this.listaEventos = listaEventos;
	}

	public List<Oferta> getListaOfertas()
	{
		return listaOfertas;
	}

	public void setListaOfertas(List<Oferta> listaOfertas)
	{
		this.listaOfertas = listaOfertas;
	}

	public List<Sitio> getListaSitios()
	{
		return listaSitios;
	}

	public void setListaSitios(List<Sitio> listaSitios)
	{
		this.listaSitios = listaSitios;
	}
}