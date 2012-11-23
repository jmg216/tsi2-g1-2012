package com.geored.frontoffice.dto;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.List;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import com.geored.frontoffice.utiles.KvmSerializationHelper;

public class SitioADTO extends com.geored.dto.SitioDTO implements KvmSerializable
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
	
	public void parseSitioADTO(SoapObject response)
	{
			Field [] fieldsADTO = this.getClass().getSuperclass().getDeclaredFields();
			int indiceFields = 0;	
			int indiceIterPropInfo = 0;
			int cantidadIteraciones;
			String set = "set";
			Method method;
			
			if (response.getPropertyCount() < fieldsADTO.length)
			{
				cantidadIteraciones = fieldsADTO.length;
			}
			else
			{
				cantidadIteraciones = response.getPropertyCount();
			}
			
			for (int i = 0; i < cantidadIteraciones; i++)
			{			
				Field field = fieldsADTO[indiceFields];
				
				
				String capitalizedFieldName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);

					try
					{
						if (fieldsADTO[indiceFields].getType().equals(List.class))
						{
							if (response.getProperty(i) instanceof SoapObject)
							{
								SoapObject listaTematicas = (SoapObject) response.getProperty(i);
								PropertyInfo info = new PropertyInfo();
								response.getPropertyInfo(i+1, info);
								info.getName();
								
								if (!fieldsADTO[indiceFields].getName().equals(info.getName()))
								{
									indiceFields++;
								}								
							}
							else
							{
								indiceFields++;
							}
						}												
						else if (fieldsADTO[indiceFields].getType().equals(String.class))
						{	
							if (response.hasProperty(fieldsADTO[indiceFields].getName()))
							{
								if (response.getProperty(fieldsADTO[indiceFields].getName()) != null)
								{							
									method = this.getClass().getSuperclass().getDeclaredMethod(set + capitalizedFieldName, fieldsADTO[indiceFields].getType());
								
									method.invoke(this, response.getProperty(fieldsADTO[indiceFields].getName()).toString());
								}
							}
							indiceFields ++;
						}
						
						else if (fieldsADTO[indiceFields].getType().equals(Long.class))
						{	
							if (response.hasProperty(fieldsADTO[indiceFields].getName()))
							{		
								if (response.getProperty(fieldsADTO[indiceFields].getName()) != null)
								{							
									method = this.getClass().getSuperclass().getDeclaredMethod(set + capitalizedFieldName, fieldsADTO[indiceFields].getType());
	
									method.invoke(this, Long.valueOf(response.getProperty(fieldsADTO[indiceFields].getName()).toString()));
								}
							}	
							
							indiceFields ++;
						}
						
						else if (fieldsADTO[indiceFields].getType().equals(int.class))
						{
							if (response.hasProperty(fieldsADTO[indiceFields].getName()))
							{
								if (response.getProperty(fieldsADTO[indiceFields].getName()) != null)
								{							
									method = this.getClass().getSuperclass().getDeclaredMethod(set + capitalizedFieldName, fieldsADTO[indiceFields].getType());							
	
									method.invoke(this, Integer.valueOf(response.getProperty(fieldsADTO[indiceFields].getName()).toString()));
								}
							}	
							
							indiceFields ++;
						}						
					} 
			        catch (IllegalArgumentException e)
					{
						e.printStackTrace();						
					} 
			        catch (IllegalAccessException e)
					{
						e.printStackTrace();						
					} 
			        catch (InvocationTargetException e)
					{
						e.printStackTrace();					
					} 
					catch (SecurityException e) 
					{
						e.printStackTrace();
					} 
					catch (NoSuchMethodException e) 
					{
						e.printStackTrace();
					}   
				}		            											
	}	
}