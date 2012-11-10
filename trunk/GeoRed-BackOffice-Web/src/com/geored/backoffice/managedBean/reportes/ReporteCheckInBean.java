package com.geored.backoffice.managedBean.reportes;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.xml.rpc.ServiceException;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.negocio.CheckInDTO;
import com.geored.negocio.DaoException;
import com.geored.negocio.NegocioException;

@ManagedBean(name="reporteCheckInBean")
@RequestScoped
public class ReporteCheckInBean extends BaseBean implements Serializable
{		
	/**
	 * 
	 */
	private static final long serialVersionUID = 4395706490596718928L;
	
	private Date fechaInicial;
	private Date fechaFinal;
	private List<CheckInDTO> listadoCheckIns;
	private MapModel checkinMap;
	private Marker marcador;
	
	public ReporteCheckInBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() 
	{
		listadoCheckIns = null;
	}
	
	public void mostrarReporte()
	{
		try 
		{
			
			CheckInDTO[] arrayCheckIn = getUsuarioPort().obtenerListadoCheckIns();
			listadoCheckIns = Arrays.asList(arrayCheckIn);
			checkinMap = new DefaultMapModel();
			
			//Conversion de Date To Calendar
			Calendar fechaIni = Calendar.getInstance();
			Calendar fechaFi = Calendar.getInstance();
			fechaIni.setTime(fechaInicial);
			fechaFi.setTime(fechaFinal);
			
			for (CheckInDTO check: listadoCheckIns)
			{
				if(check.getFechaCreacion().after(fechaIni) && check.getFechaCreacion().before(fechaFi)) { 
					
						String direccion = getSitioPort().obtener(check.getIdSitio()).getUbicacionGeografica(); 
						
						String limitador = "[,]";
						String[] token = direccion.split(limitador);
						Double latitud = Double.parseDouble(token[0]);
						Double longitud = Double.parseDouble(token[1]);
						
						LatLng coord = new LatLng(latitud,longitud);
						
						checkinMap.addOverlay(new Marker(coord));
				}
				
				else 
				{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No hay check-ins en las fechas indicadas..."));
				}
			}
		
		} catch (ServiceException e) 
		
		{
			addBeanError(MSJ_ERROR_COMUNICACION_WS);
			
		} catch (NegocioException e)
		
		{
			addBeanError(MSJ_ERROR_COMUNICACION_WS);
			
		} catch (DaoException e) 
		
		{
			addBeanError(e.getMessage());
			
		} catch (RemoteException e) 
		
		{
			addBeanError(MSJ_ERROR_COMUNICACION_WS);
		}
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public List<CheckInDTO> getListadoCheckIns() {
		return listadoCheckIns;
	}

	public void setListadoCheckIns(List<CheckInDTO> listadoCheckIns) {
		this.listadoCheckIns = listadoCheckIns;
	}

	public MapModel getCheckinMap() {
		return checkinMap;
	}

	public void setCheckinMap(MapModel checkinMap) {
		this.checkinMap = checkinMap;
	}

	public Marker getMarcador() {
		return marcador;
	}

	public void setMarcador(Marker marcador) {
		this.marcador = marcador;
	}	
	
}
