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
@Table(name = "notificacion")
public class Notificacion implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8408536548407729536L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;

	@Column(name = "LEIDA", nullable = false)
	private boolean leida;

	@Column(name = "ID_OBJETO", nullable = false)
	private String idObjeto;

	@JoinColumn(name = "USUARIO_DESTINO_FK", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuarioDestino;

	@JoinColumn(name = "TIPO_NOTIFICACION_FK", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private TipoNotificacion tipoNotificacion;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public boolean isLeida()
	{
		return leida;
	}

	public void setLeida(boolean leida)
	{
		this.leida = leida;
	}

	public String getIdObjeto()
	{
		return idObjeto;
	}

	public void setIdObjeto(String idObjeto)
	{
		this.idObjeto = idObjeto;
	}

	public Usuario getUsuarioDestino()
	{
		return usuarioDestino;
	}

	public void setUsuarioDestino(Usuario usuarioDestino)
	{
		this.usuarioDestino = usuarioDestino;
	}

	public TipoNotificacion getTipoNotificacion()
	{
		return tipoNotificacion;
	}

	public void setTipoNotificacion(TipoNotificacion tipoNotificacion)
	{
		this.tipoNotificacion = tipoNotificacion;
	}
}