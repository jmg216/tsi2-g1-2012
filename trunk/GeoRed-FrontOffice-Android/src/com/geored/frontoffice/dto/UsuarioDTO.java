package com.geored.frontoffice.dto;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import com.geored.frontoffice.utiles.KvmSerializableUtil;

public class UsuarioDTO extends com.geored.dto.UsuarioDTO implements KvmSerializable
{
	private KvmSerializableUtil kvmUtil = KvmSerializableUtil.instance(this);
	
	public int getPropertyCount() {

		return kvmUtil.getPropertyCount();
	}

	public Object getProperty(int index) 
	{
        return kvmUtil.getProperty(index);
	}

	public void setProperty(int index, Object value) 
	{
        kvmUtil.setProperty(index, value);
	}
	
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) 
	{
        kvmUtil.getPropertyInfo(index, arg1, info);
	}
}