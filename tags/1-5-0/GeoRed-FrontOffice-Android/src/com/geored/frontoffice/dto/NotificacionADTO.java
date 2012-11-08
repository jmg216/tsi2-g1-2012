package com.geored.frontoffice.dto;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import com.geored.frontoffice.utiles.KvmSerializationHelper;

public class NotificacionADTO extends com.geored.dto.NotificacionDTO implements KvmSerializable
{
	private KvmSerializationHelper kvmHelper;
	
	private KvmSerializationHelper getKvmSerializationHelper()
	{
		if(kvmHelper == null)
		{
			kvmHelper = new KvmSerializationHelper(this);
		}
		
		return kvmHelper;
	}
	
	public int getPropertyCount() {

		return getKvmSerializationHelper().getPropertyCount();
	}

	public Object getProperty(int index) 
	{
        return getKvmSerializationHelper().getProperty(index);
	}

	public void setProperty(int index, Object value) 
	{
		getKvmSerializationHelper().setProperty(index, value);
	}
	
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) 
	{
		getKvmSerializationHelper().getPropertyInfo(index, arg1, info);
	}
}