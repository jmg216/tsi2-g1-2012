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
@Table(name="contenido_sitio")
public class ContenidoSitio implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7262405870466293412L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Long id;

	@Column(name="COMENTARIO")
	private String comentario;
	
	@Column(name="URL_IMAGEN")
	private String urlImagen;
	
	@JoinColumn(name="USUARIO_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;
	
	@JoinColumn(name="SITIO_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Sitio sitio;
	
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

	public Sitio getSitio()
	{
		return sitio;
	}

	public void setSitio(Sitio sitio)
	{
		this.sitio = sitio;
	}

	public String getComentario()
	{
		return comentario;
	}

	public void setComentario(String comentario)
	{
		this.comentario = comentario;
	}

	public String getUrlImagen()
	{
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen)
	{
		this.urlImagen = urlImagen;
	}
	
	
}