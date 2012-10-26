package com.geored.backoffice.managedBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.rpc.ServiceException;

import com.geored.negocio.AdminServiceImpl;
import com.geored.negocio.AdminServiceImplServiceLocator;
import com.geored.negocio.EmpresaServiceImpl;
import com.geored.negocio.EmpresaServiceImplServiceLocator;


@ManagedBean(name="indexAdminEmpresas")
@SessionScoped
public class IndexAdminEmpresasBean {
	
	private String usuario;
	private String passwordUsuario;
	private String password;
	private String passwordNueva;	
	private AdminServiceImplServiceLocator locatorAdmin;
	private AdminServiceImpl adminWS;
	private EmpresaServiceImplServiceLocator locatorEmp;
	private EmpresaServiceImpl empWS;
	
	public IndexAdminEmpresasBean() {
	
	}
	
	@PostConstruct
	public void init() throws ServiceException{
		
		locatorAdmin = new AdminServiceImplServiceLocator();
		adminWS = locatorAdmin.getAdminServiceImplPort();
		
		locatorEmp = new EmpresaServiceImplServiceLocator();
		empWS = locatorEmp.getEmpresaServiceImplPort();
		
		usuario = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
		
		//Obtener administrador de la empresa
		//Obtener locales de la empresa
	}
	
	public void CambiarPassword(){
		
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordNueva() {
		return passwordNueva;
	}

	public void setPasswordNueva(String passwordNueva) {
		this.passwordNueva = passwordNueva;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}
	
	
}
