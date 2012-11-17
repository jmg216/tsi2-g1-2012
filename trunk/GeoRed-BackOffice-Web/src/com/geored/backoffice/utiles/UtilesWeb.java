package com.geored.backoffice.utiles;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.geored.negocio.AdministradorDTO;
import com.geored.negocio.EmpresaDTO;

@ManagedBean(name="utilesWeb")
@SessionScoped
public class UtilesWeb
{
	public static final Long ID_TIPO_ADMIN_APLICACION = 1L;
	
	public static final Long ID_TIPO_ADMIN_EMPRESA = 2L;
	
	public static boolean isNullOrEmpty(String str)
	{
		return (str == null) || (str != null && str.isEmpty());
	}
	
	public static boolean isNullOrZero(Long lng)
	{
		return (lng == null) || (lng != null && lng <= 0L);
	}
	
	public static boolean hayUsuarioAutenticado()
	{
		return UtilesSeguridadWeb.hayUsuarioAutenticado();
	}
	
	public static AdministradorDTO obtenerUsuarioAutenticado()
	{
		return UtilesSeguridadWeb.obtenerUsuarioAutenticado();
	}
	
	public static boolean esAdministradorEmpresa()
	{
		return UtilesSeguridadWeb.obtenerUsuarioAutenticado().getIdTipoAdministrador().equals(ID_TIPO_ADMIN_EMPRESA);
	}
	
	public static EmpresaDTO obtenerEmpresaAdministrada()
	{
		return UtilesSeguridadWeb.obtenerEmpresaAutenticada();
	}
}