package com.geored.backoffice.managedBean.empresas;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.rpc.ServiceException;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.negocio.DaoException;
import com.geored.negocio.EmpresaDTO;
import com.geored.negocio.NegocioException;


@ManagedBean(name="gestionEmpresaBean")
@RequestScoped
public class GestionEmpresaBean extends BaseBean implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idEmpresa;
	
	private EmpresaDTO empresaDTO;
	
	public String gestionar()
	{
		if(idEmpresa == null)
		{
			empresaDTO = new EmpresaDTO();
		}
		else
		{
			try
			{
				empresaDTO = getEmpresaPort().obtener(idEmpresa);
			} 
			catch (NegocioException e)
			{
				addMessage(e.getMessage());
			} 
			catch (DaoException e)
			{
				addMessage(e.getMessage());
			} 
			catch (RemoteException e)
			{
				addMessage(MSJ_ERROR_COMUNICACION_WS);
			} 
			catch (ServiceException e)
			{
				addMessage(MSJ_ERROR_COMUNICACION_WS);
			}
		}
		
		return SUCCESS;
	}
	
	public String guardarEmpresa()
	{
		try
		{
			// Si estoy creando 
			if(empresaDTO.getId() == null)
			{
				getEmpresaPort().insertar(empresaDTO);
			}
			else // Si estoy modificando
			{
				getEmpresaPort().actualizar(empresaDTO);
			}
		}
		catch(NegocioException e)
		{
			addMessage(e.getMessage());
		} 
		catch (DaoException e)
		{
			addMessage(e.getMessage());
		} 
		catch (RemoteException e)
		{
			addMessage(MSJ_ERROR_COMUNICACION_WS);
		} 
		catch (ServiceException e)
		{
			addMessage(MSJ_ERROR_COMUNICACION_WS);
		}
		
		return SUCCESS;
	}

	public Long getIdEmpresa()
	{
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa)
	{
		this.idEmpresa = idEmpresa;
	}

	public EmpresaDTO getEmpresaDTO()
	{
		return empresaDTO;
	}

	public void setEmpresaDTO(EmpresaDTO empresaDTO)
	{
		this.empresaDTO = empresaDTO;
	}
}
