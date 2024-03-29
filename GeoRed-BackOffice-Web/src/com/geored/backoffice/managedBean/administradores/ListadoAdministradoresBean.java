package com.geored.backoffice.managedBean.administradores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.negocio.AdministradorDTO;

@ManagedBean(name="listadoAdministradoresBean")
@RequestScoped
public class ListadoAdministradoresBean extends BaseBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6024226771137458953L;

	private static final String TO_GESTION_ADMINISTRADOR = "to_gestion_administrador";
	
	private Long idAdministrador;
	
	private List<AdministradorDTO> listaAdministradores = new ArrayList<AdministradorDTO>();
	
	public ListadoAdministradoresBean()
	{	
		try
		{	
			AdministradorDTO[] arrayAdministradores = getAdminPort().obtenerListado();
			
			if(arrayAdministradores != null)
			{
				listaAdministradores = Arrays.asList(arrayAdministradores);
			}
			else
			{
				listaAdministradores = new ArrayList<AdministradorDTO>();
			}			
		} 
		catch (Exception e)
		{
			handleWSException(e);
		} 
	}
	
	public String eliminarAdministrador()
	{
		try
		{
			getAdminPort().eliminar(idAdministrador);
		} 
		catch (Exception e)
		{
			handleWSException(e);
		}
		
		return SUCCESS;
	}
	
	public String toGestionAdministrador()
	{
		return TO_GESTION_ADMINISTRADOR;
	}

	public Long getIdAdministrador()
	{
		return idAdministrador;
	}

	public void setIdAdministrador(Long idAdministrador)
	{
		this.idAdministrador = idAdministrador;
	}

	public List<AdministradorDTO> getListaAdministradores()
	{
		return listaAdministradores;
	}

	public void setListaAdministradores(List<AdministradorDTO> listaAdministradores)
	{
		this.listaAdministradores = listaAdministradores;
	}
}