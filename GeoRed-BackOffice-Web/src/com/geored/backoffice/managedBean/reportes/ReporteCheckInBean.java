package com.geored.backoffice.managedBean.reportes;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.rpc.ServiceException;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.backoffice.utiles.UtilesGeocoding;
import com.geored.negocio.CheckInDTO;
import com.geored.negocio.DaoException;
import com.geored.negocio.NegocioException;
import com.geored.negocio.SitioServiceImpl;
import com.geored.negocio.SitioServiceImplServiceLocator;
import com.geored.negocio.UsuarioServiceImpl;
import com.geored.negocio.UsuarioServiceImplServiceLocator;

@ManagedBean(name="reporteCheckInBean")
@SessionScoped
public class ReporteCheckInBean extends BaseBean implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
			SitioServiceImpl sitioWS = new SitioServiceImplServiceLocator().getSitioServiceImplPort();
			UsuarioServiceImpl usuarioWS = new UsuarioServiceImplServiceLocator().getUsuarioServiceImplPort();
			
			CheckInDTO[] arrayCheckIn = usuarioWS.obtenerListadoCheckIns();
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
					
						String direccion = sitioWS.obtener(check.getIdSitio()).getUbicacionGeografica();
						com.google.code.geocoder.model.LatLng coordenadas = UtilesGeocoding.geocoding(direccion);
						
						LatLng coord = new LatLng(coordenadas.getLat().floatValue(),coordenadas.getLng().floatValue());
						
						checkinMap.addOverlay(new Marker(coord));
				}
			}
		
		} catch (ServiceException e) 
		
		{
			addMessage(MSJ_ERROR_COMUNICACION_WS);
			
		} catch (NegocioException e)
		
		{
			addMessage(MSJ_ERROR_COMUNICACION_WS);
			
		} catch (DaoException e) 
		
		{
			addMessage(e.getMessage());
			
		} catch (RemoteException e) 
		
		{
			addMessage(MSJ_ERROR_COMUNICACION_WS);
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
