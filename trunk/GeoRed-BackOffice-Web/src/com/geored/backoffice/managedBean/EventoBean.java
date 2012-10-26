package com.geored.backoffice.managedBean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="eventoBean")
@SessionScoped
public class EventoBean implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private Date fechaFin;
	private Date fechaInicio;
	private Long id;
	private Long idAdministrador;
	private String nombre;
	private String nombreAdministrador;
	private String ubicacionGeografica;
	private String imagen;
	private String descripcion;
	//faltan las categorias
	
	public void obtenerEventosFuentesExternas ()
	{
		
	}
	
	public void crearEvento()
	{
		
	}
	
}
