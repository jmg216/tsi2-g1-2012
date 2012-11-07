package com.geored.dominio;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="oferta")
public class Oferta implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4539384334155342226L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;
	
	@Column(name="DESCRIPCION", nullable=false)
	private String descripcion;
	
	@Column(name="COSTO", nullable=false)
	private Double costo;
	
	@Column(name="LOGO_URL")
	private String logoUrl;
	
	@Column(name="FECHA_INICIO", nullable=false)
	private Timestamp fechaInicio;
	
	@Column(name="FECHA_FIN", nullable=false)
	private Timestamp fechaFin;
	
	@JoinColumn(name="LOCAL_FK", nullable=false)
	@ManyToOne(fetch=FetchType.EAGER)
	private Local local;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="oferta_tematica",
	joinColumns =
	{
	    @JoinColumn(name = "TEMATICA_FK")
	},
	inverseJoinColumns =
	{
	    @JoinColumn(name = "OFERTA_FK")
	})
	private List<Tematica> listaTematicas;

	@ManyToMany(mappedBy="listaCompras")
	private List<Usuario> listaCompradores;
	
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

	public Local getLocal()
	{
		return local;
	}

	public void setLocal(Local local)
	{
		this.local = local;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public Double getCosto()
	{
		return costo;
	}

	public void setCosto(Double costo)
	{
		this.costo = costo;
	}

	public String getLogoUrl()
	{
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl)
	{
		this.logoUrl = logoUrl;
	}

	public Timestamp getFechaInicio()
	{
		return fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio)
	{
		this.fechaInicio = fechaInicio;
	}

	public Timestamp getFechaFin()
	{
		return fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin)
	{
		this.fechaFin = fechaFin;
	}

	public List<Tematica> getListaTematicas()
	{
		return listaTematicas;
	}

	public void setListaTematicas(List<Tematica> listaTematicas)
	{
		this.listaTematicas = listaTematicas;
	}

	public List<Usuario> getListaCompradores()
	{
		return listaCompradores;
	}

	public void setListaCompradores(List<Usuario> listaCompradores)
	{
		this.listaCompradores = listaCompradores;
	}
	
	
}