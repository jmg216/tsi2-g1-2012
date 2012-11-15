package com.geored.frontoffice.wsclient;

public class FactoryWS {

	//Singleton de la clase para obtener una unica instancia de la misma.
	private static FactoryWS instancia = null;
	
	private FactoryWS(){}

	public static FactoryWS getInstancia()
	{
		if (instancia == null)
		{
			instancia = new FactoryWS();
		}
		return instancia;
	}
	
	
	//UsuarioWS
	private UsuarioWS usuarioWS;
	
	public UsuarioWS getUsuarioWS()
	{
		if (usuarioWS == null)
		{
			usuarioWS = new UsuarioWS();
		}
		return usuarioWS;
	}
	
	//SitioWS
	private SitioWS sitioWS;
	
	public SitioWS getSitioWS()
	{
		if (sitioWS == null)
		{
			sitioWS = new SitioWS();
		}
		return sitioWS;
	}
	
	//EmpresaWS
	private EmpresaWS empresaWS;
	
	public EmpresaWS getEmpresaWS()
	{
		if (empresaWS == null)
		{
			empresaWS = new EmpresaWS();
		}
		return empresaWS;
	}
	
	//EventoWS
	private EventoWS eventoWS;
	
	public EventoWS getEventoWS()
	{
		if(eventoWS == null)
		{
			eventoWS = new EventoWS();
		}
		return eventoWS;
	}
	
	//OfertaWS
	private OfertaWS ofertaWS;
	
	public OfertaWS getOfertaWS()
	{
		if (ofertaWS == null)
		{
			ofertaWS = new OfertaWS();
		}
		return ofertaWS;
	}
	
	//GlobalWS
	private GlobalWS globalWS;
	
	public GlobalWS getGlobalWS()
	{
		if (globalWS == null)
		{
			globalWS = new GlobalWS();
		}
		return globalWS;
	}
	
	//CompraWs
	private CompraWS compraWS;
	
	public CompraWS getCompraWS()
	{
		if (compraWS == null)
		{
			compraWS = new CompraWS();
		}
		return compraWS;
	}
	
	//AdminWS
	private AdminWS adminWS;
	
	public AdminWS getAdminWS()
	{
		if (adminWS == null)
		{
			adminWS = new AdminWS();
		}
		return adminWS;
	}
}
