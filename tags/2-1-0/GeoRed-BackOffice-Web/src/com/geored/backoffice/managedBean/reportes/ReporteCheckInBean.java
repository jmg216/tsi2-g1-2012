package com.geored.backoffice.managedBean.reportes;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.negocio.CheckInDTO;

@ManagedBean(name="reporteCheckInBean")
@SessionScoped
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
						
						Integer mes = check.getFechaCreacion().get(Calendar.MONTH);
						int sum = mes + 1;
						
						String fechaMostrar = check.getFechaCreacion().get(Calendar.DAY_OF_MONTH) + "/" + sum  + "/" + check.getFechaCreacion().get(Calendar.YEAR);
						String data = "Hecho por: " + check.getNombreUsuario() + "\n en la fecha: " + fechaMostrar;
						
						checkinMap.addOverlay(new Marker(coord,check.getNombreSitio(), data,"http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
				}
			}
			
			if(checkinMap.getMarkers().size() == 0) 
			{
				FacesMessage message = new FacesMessage();
				
				message.setSummary("Reporte de Check-In");
				message.setDetail("No hay check-ins en las fechas indicadas...");
				
				FacesContext.getCurrentInstance().addMessage(null, message);
			}	
		
		} 
		catch (Exception e) 
		{
			handleWSException(e);
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
	
	public void onMarkerSelect(OverlaySelectEvent event) 
	{
		marcador = (Marker) event.getOverlay();
	}
	
}
