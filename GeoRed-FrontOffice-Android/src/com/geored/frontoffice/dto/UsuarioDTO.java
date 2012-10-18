package com.geored.frontoffice.dto;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import com.geored.frontoffice.utiles.KvmSerializableHelper;

public class UsuarioDTO extends com.geored.dto.UsuarioDTO implements KvmSerializable
{
	private KvmSerializableHelper kvmHelper;
	
	public UsuarioDTO()
	{
		kvmHelper = new KvmSerializableHelper(this);
	}
	
	public int getPropertyCount() {

		return kvmHelper.getPropertyCount();
	}

	public Object getProperty(int index) 
	{
        return kvmHelper.getProperty(index);
	}

	public void setProperty(int index, Object value) 
	{
		kvmHelper.setProperty(index, value);
	}
	
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) 
	{
		kvmHelper.getPropertyInfo(index, arg1, info);
	}
}