package com.geored.backoffice.managedBean.reportes;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.negocio.CompraDTO;

@ManagedBean(name="reporteComprasBean")
@RequestScoped
public class ReporteComprasBean extends BaseBean implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4370175574249396986L;
	
	private Date fechaInicial;
	private Date fechaFinal;
	private List<CompraDTO> listadoCompras;

	public ReporteComprasBean()
	{
		
	}
	
	@PostConstruct
	public void init() 
	{
		listadoCompras = null;
	}
	
	public void mostrarReporte () 
	{
		try 
		{
			CompraDTO[] arrayCompras = getCompraPort().obtenerListado();
			listadoCompras = Arrays.asList(arrayCompras);
			
			//Conversion de Date To Calendar
			Calendar fechaIni = Calendar.getInstance();
			Calendar fechaFi = Calendar.getInstance();
			fechaIni.setTime(fechaInicial);
			fechaFi.setTime(fechaFinal);
			
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

	public List<CompraDTO> getListadoCompras() {
		return listadoCompras;
	}

	public void setListadoCompras(List<CompraDTO> listadoCompras) {
		this.listadoCompras = listadoCompras;
	}
	
	
}
