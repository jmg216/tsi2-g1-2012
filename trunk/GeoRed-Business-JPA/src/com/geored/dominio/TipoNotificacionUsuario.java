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
@Table(name="tipo_notificacion_usuario")
public class TipoNotificacionUsuario implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 679535350637627971L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false)
	private Long id;
	
	@JoinColumn(name="TIPO_NOTIFICACION_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private TipoNotificacion tipoNotificacion;
	
	@JoinColumn(name="USUARIO_FK", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public TipoNotificacion getTipoNotificacion()
	{
		return tipoNotificacion;
	}

	public void setTipoNotificacion(TipoNotificacion tipoNotificacion)
	{
		this.tipoNotificacion = tipoNotificacion;
	}

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
}