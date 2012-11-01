package com.geored.backoffice.managedBean.reportes;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="reporteCheckInBean")
@SessionScoped
public class ReporteCheckInBean implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date fechaInicial;
	private Date fechaFinal;
	
	public ReporteCheckInBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() 
	{
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
	
	
}
