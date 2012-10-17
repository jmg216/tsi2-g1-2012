package com.geored.frontoffice.dto;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class UsuarioDTO extends com.geored.dto.UsuarioDTO implements KvmSerializable
{
	public int getPropertyCount() {

		return 4;
	}

	public Object getProperty(int index) {
		
        switch(index)
        {
	        case 0: return this.getId();
	        case 1: return this.getNombre();
	        case 2: return this.getEmail();
	        case 3: return this.getPass();                      
        }
        
        return null;
	}

	public void setProperty(int index, Object value) 
	{
        switch(index)
        {
	        case 0:
	            this.setId(Long.valueOf(value.toString()));
	            break;
	        case 1:
	            this.setNombre(value.toString());
	            break;
	        case 2:
	        	this.setEmail(value.toString());
	        	break;
	        case 3:
	        	this.setPass(value.toString());
	           
	        default:
	            break;
        }
	}
	
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) 
	{
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
}