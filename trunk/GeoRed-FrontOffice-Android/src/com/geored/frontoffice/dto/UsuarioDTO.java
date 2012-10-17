package com.geored.frontoffice.dto;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class UsuarioDTO implements KvmSerializable
{
	private Long id;
	
	private String nombre;
	
	private String email;
	
	private String pass;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Object getProperty(int arg0) {
		
        switch(arg0)
        {
	        case 0: return id;
	        case 1: return nombre;
	        case 2: return email;
	        case 3: return pass;                      
        }
        
        return null;
	}

	public int getPropertyCount() {

		return 4;
	}

	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
        switch(index)
        {
        case 0:
            info.type = PropertyInfo.LONG_CLASS;
            info.name = "id";
            break;
        case 1:
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "nombre";
            break;
        case 2:
        	info.type = PropertyInfo.STRING_CLASS;
        	info.name = "email";
            break;
        case 3:
        	info.type = PropertyInfo.STRING_CLASS;
        	info.name = "pass";
        	break;
        	
        default:break;
        }
	}

	public void setProperty(int index, Object value) {
        switch(index)
        {
        case 0:
            id = Long.valueOf(value.toString());
            break;
        case 1:
            nombre = value.toString();
            break;
        case 2:
        	email = value.toString();
        	break;
        case 3:
        	pass = value.toString();
           
        default:
            break;
        }
		
	}
}