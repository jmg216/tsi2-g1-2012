package com.geored.backoffice.managedBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean(name="reportesBean")
@SessionScoped
public class ReportesBean {
	
	private MapModel checkInModel;
	private Marker marker;
	
	//private List<checkIn> checkins;
	
	public ReportesBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		checkInModel = new DefaultMapModel();
		//Obtener CheckIns del sistema
		/*Cdrear Marcadores para mostrar.
		for(Ofertas oferta : ofertas) {
			LatLng coord = new LatLng(oferta.getLatitud(), oferta.getLongitud());
			advancedModel.addOverlay(new Marker(coord,"Javier","1348963234_country.png","Javier/WebContent/Imagenes/1348963234_country.png"));
		}*/
	}

	public MapModel getCheckInModel() {
		return checkInModel;
	}

	public void setCheckInModel(MapModel checkInModel) {
		this.checkInModel = checkInModel;
	}

	public Marker getMarker() {
		return marker;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}
	
	
}
