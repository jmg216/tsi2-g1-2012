package com.geored.backoffice.managedBean.reportes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.PieChartModel;

import com.geored.backoffice.managedBean.BaseBean;
import com.geored.negocio.CompraDTO;
import com.geored.negocio.OfertaDTO;

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
	private List<CompraDTO> listadoComprasOferta;
	private List<OfertaDTO> listadoOfertas;
	private PieChartModel pieModel;

	public ReporteComprasBean()
	{
		
	}
	
	@PostConstruct
	public void init() 
	{
		
	}
	
	public void mostrarReporte () 
	{
		try 
		{
			OfertaDTO [] arrayOfertas = getOfertaPort().obtenerListado();
			
			listadoOfertas = Arrays.asList(arrayOfertas);
			listadoCompras = new ArrayList<CompraDTO>();
			
			pieModel = new PieChartModel();
			
			//Conversion de Date To Calendar
			Calendar fechaIni = Calendar.getInstance();
			Calendar fechaFi = Calendar.getInstance();
			fechaIni.setTime(fechaInicial);
			fechaFi.setTime(fechaFinal);
			
			for (OfertaDTO oferta: listadoOfertas)
			{
				CompraDTO[] arrayComprasOferta = getCompraPort().obtenerListadoPorOferta(oferta.getId());
				listadoComprasOferta = Arrays.asList(arrayComprasOferta);
				
				for(CompraDTO compra: listadoComprasOferta)
				{
					if(compra.getFechaCreacion().after(fechaIni) && compra.getFechaCreacion().before(fechaFi)) 
					{
						listadoCompras.add(compra);
						pieModel.set(oferta.getNombre(), listadoCompras.size());
						
					}
				}
					
			}
			
			if(pieModel.getData().isEmpty()) 
			{
				FacesMessage message = new FacesMessage();
				
				message.setSummary("Reporte de Compras");
				message.setDetail("No hay compras de oferta en las fechas indicadas...");
				
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

	public List<CompraDTO> getListadoCompras() {
		return listadoCompras;
	}

	public void setListadoCompras(List<CompraDTO> listadoCompras) {
		this.listadoCompras = listadoCompras;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

}
