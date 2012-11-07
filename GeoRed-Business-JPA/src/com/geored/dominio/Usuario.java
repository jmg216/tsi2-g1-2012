package com.geored.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@Column(name="IMAGEN", nullable=false)
	private String imagen;
	
	@OneToMany(mappedBy ="usuario")
	private List<TematicaUsuario> tematicas;
	
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
	
	public List<TematicaUsuario> getTematicas()
	{
		return tematicas;
	}

	public void setTematica(List<TematicaUsuario> tematicas)
	{
		this.tematicas = tematicas;
	}
	
	public String getImagen()
	{
		return imagen;
	}

	public void setImagen(String imagen)
	{
		this.imagen = imagen;
	}
}