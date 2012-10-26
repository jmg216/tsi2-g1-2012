package com.geored.backoffice.managedBean;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.xml.rpc.ServiceException;

import com.geored.negocio.AdminServiceImpl;
import com.geored.negocio.AdminServiceImplService;
import com.geored.negocio.AdminServiceImplServiceLocator;
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
	private Boolean recordar;
	private AdminServiceImpl admiWs;
	private AdminServiceImplServiceLocator locator;
	
	
	public LoginBean() {
	
	}
	
	@PostConstruct
	public void init() {
		usuario = "";
		password = "";
	}
	
	public void LogIn() throws ServiceException {
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		
		locator = new AdminServiceImplServiceLocator();
		admiWs = locator.getAdminServiceImplPort();
		
		AdministradorDTO admin;
		
		try {
			
			admin = admiWs.obtenerAdminPorEmailYPass(usuario, password);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", usuario);
			FacesContext.getCurrentInstance().getExternalContext().redirect("IndexAdminEmpresas.xhtml");
			
		} catch (RemoteException e1) {
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Datos incorrectos"));
		
		} catch (IOException e) {
			
			e.printStackTrace();
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
	
	public Boolean getRecordar() {
		return recordar;
	}

	public void setRecordar(Boolean recordar) {
		this.recordar = recordar;
	}

}
