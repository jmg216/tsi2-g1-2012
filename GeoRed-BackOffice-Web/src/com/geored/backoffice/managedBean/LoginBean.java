package com.geored.backoffice.managedBean;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.xml.rpc.ServiceException;

import com.geored.negocio.AdminServiceImpl;
import com.geored.negocio.AdminServiceImplService;
import com.geored.negocio.AdministradorDTO;
import com.geored.negocio.DaoException;
import com.geored.negocio.NegocioException;


@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String password;
	private AdminServiceImplService service;
	private AdminServiceImpl admiWs;
	
	
	public LoginBean() {
	
	}
	
	@PostConstruct
	public void init() {
		usuario = "";
		password = "";
	}
	
	public void LogIn() throws ServiceException, NegocioException, DaoException, RemoteException {
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		
		admiWs = service.getAdminServiceImplPort();
		AdministradorDTO admin = admiWs.obtenerAdminPorEmailYPass(usuario, password);
		
		if(admin != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("", usuario);
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("Registro.xhtml");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos incorrectos"));
		}
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
	
	
}
