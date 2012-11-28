package com.geored.backoffice.managedBean.ofertas;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.faces.bean.ManagedBean;
import javax.xml.rpc.ServiceException;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesWeb;
import com.geored.negocio.DaoException;
import com.geored.negocio.NegocioException;
import com.geored.negocio.OfertaDTO;

@ManagedBean(name="gestionOfertaBean")
public class GestionOfertaBean extends BaseBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String TO_LISTADO = "to_listado";
	
	//private AdministradorDTO administradorDTO = new AdministradorDTO();
	
	private OfertaDTO ofertaDTO = new OfertaDTO();
	
	//private List<Local> listaAdministradores = new ArrayList<AdministradorDTO>();
	
	public GestionOfertaBean() 
	{
		String idOferta = getParameter("idOferta");                
				
		if(UtilesWeb.isNullOrEmpty(idOferta))
		{
			ofertaDTO = new OfertaDTO();
		}
		else
		{
			try
			{
				ofertaDTO = getOfertaPort().obtener(Long.valueOf(idOferta)); 
			} 
			catch (NegocioException e)
			{
				addError(e.getMessage());
			} 
			catch (DaoException e)
			{
				addError(e.getMessage());
			} 
			catch (RemoteException e)
			{
				addError(MSJ_ERROR_COMUNICACION_WS);
			} 
			catch (ServiceException e)
			{
				addError(MSJ_ERROR_COMUNICACION_WS);
			}
		}
		
		//cargarDatosIniciales();
		
	}
	
	/*private void cargarDatosIniciales()
	{
		try
		{
			//listaAdministradores = Arrays.asList(getAdministradorPort().obtenerListado());
		}
		catch (DaoException e)
		{
			addError(e.getMessage());
		} 
		catch (RemoteException e)
		{
			addError(MSJ_ERROR_COMUNICACION_WS);
		} 
		catch (ServiceException e)
		{
			addError(MSJ_ERROR_COMUNICACION_WS);
		}
	}*/
	
	public String guardarOferta()
	{
		try
		{
			// Si estoy creando 
			if(ofertaDTO.getId() == null)
			{
				getOfertaPort().insertar(ofertaDTO);
			}
			else // Si estoy modificando
			{
				getOfertaPort().actualizar(ofertaDTO);
			}
		}
		catch(NegocioException e)
		{
			addError(e.getMessage());
		} 
		catch (DaoException e)
		{
			addError(e.getMessage());
		} 
		catch (RemoteException e)
		{
			addError(MSJ_ERROR_COMUNICACION_WS);
		} 
		catch (ServiceException e)
		{
			addError(MSJ_ERROR_COMUNICACION_WS);
		}
		
		return SUCCESS;
	}
	
	public String toListado()
	{
		return TO_LISTADO;
	}

	public OfertaDTO getOfertaDTO() {
		return ofertaDTO;
	}

	public void setOfertaDTO(OfertaDTO ofertaDTO) {
		this.ofertaDTO = ofertaDTO;
	}
	
	
}