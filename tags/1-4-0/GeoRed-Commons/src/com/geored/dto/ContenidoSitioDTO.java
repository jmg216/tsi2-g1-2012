package com.geored.dto;

public class ContenidoSitioDTO
{
	private Long id;

	private String comentario;
	
	private String urlImagen;
	
	private Long idUsuario;
	
	private String nombreUsuario;
	
	private Long idSitio;
	
	private String nombreSitio;
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getIdUsuario()
	{
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario)
	{
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario()
	{
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario)
	{
		this.nombreUsuario = nombreUsuario;
	}

	public Long getIdSitio()
	{
		return idSitio;
	}

	public void setIdSitio(Long idSitio)
	{
		this.idSitio = idSitio;
	}

	public String getNombreSitio()
	{
		return nombreSitio;
	}

	public void setNombreSitio(String nombreSitio)
	{
		this.nombreSitio = nombreSitio;
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