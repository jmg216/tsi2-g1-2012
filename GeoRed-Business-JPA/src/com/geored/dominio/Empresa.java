package com.geored.dominio;

import java.io.Serializable;
import java.sql.Timestamp;
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
@Table(name="empresa")
public class Empresa implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6416162494503125506L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="URL_IMAGEN")
	private String urlImagen;
	
	@Column(name="FECHA_CREACION", nullable=false)
	private Timestamp fechaCreacion;

	@JoinColumn(name="ADMINISTRADOR_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Administrador administrador;
	
	@OneToMany(mappedBy="empresa", fetch=FetchType.LAZY)
	private List<Local> listaLocales;
	
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

	public String getUrlImagen()
	{
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen)
	{
		this.urlImagen = urlImagen;
	}

	public Timestamp getFechaCreacion()
	{
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion)
	{
		this.fechaCreacion = fechaCreacion;
	}

	public List<Local> getListaLocales()
	{
		return listaLocales;
	}

	public void setListaLocales(List<Local> listaLocales)
	{
		this.listaLocales = listaLocales;
	}
}