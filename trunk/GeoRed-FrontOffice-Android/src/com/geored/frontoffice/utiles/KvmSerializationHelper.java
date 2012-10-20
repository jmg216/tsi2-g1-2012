package com.geored.frontoffice.utiles;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Hashtable;
import java.util.Map;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class KvmSerializationHelper
{
	private KvmSerializable dtoObject;
	private Class dtoClass;
	
	// Diccionarios de fields
	private Map<Integer, String> fieldsNames;
	private Map<Integer, Method> fieldsGetters;
	private Map<Integer, Method> fieldsSetters;
	private Map<Integer, Type> fieldsTypes;
	
	// Constructor
	public KvmSerializationHelper(KvmSerializable dtoObject)
	{
		this.dtoObject = dtoObject;
		this.dtoClass = dtoObject.getClass().getSuperclass();
		
		Field[] fieldsArray = dtoClass.getDeclaredFields();
		Method[] methodsArray  = dtoClass.getMethods();
		
		// Para cada field busco su nombre, getter, setter y type. Los agrego al Map correspondiente
		int index = 0;
		for(Field field : fieldsArray)
		{
			String capitalizedFieldName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(2);
			
			for(Method method : methodsArray)
			{
				// Nombre
				fieldsNames.put(index, field.getName());
				
				// Getters y Setters methods
				if(method.getName().equals("get" + capitalizedFieldName))
				{
					fieldsGetters.put(index, method);
				}
				else if(method.getName().equals("set" + capitalizedFieldName))
				{
					fieldsSetters.put(index, method);
				}
				
				// Field Type
				fieldsTypes.put(index, field.getType());
			}
			
			index++;
		}
	}

	// Operaciones utilizarias para KvmSerializable
	public int getPropertyCount()
	{
		return dtoClass.getFields().length;
	}
	
	public Object getProperty(int index) 
	{	
		// Obtengo el getter a invocar
        Method getter = fieldsGetters.get(index);
        
        try
		{
			return getter.invoke(dtoObject, new Object[]{});
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
        
        return null;
	}

	public void setProperty(int index, Object value) 
	{
		// Obtengo el setter del field
		Method setter = fieldsSetters.get(index);
		
        try
		{
			setter.invoke(dtoObject, new Object[] { value });
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
	}
	
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) 
	{
		info.name = fieldsNames.get(index);
		info.type = resolveKsoapClass(fieldsTypes.get(index));
	}
	
	private Class resolveKsoapClass(Type type)
	{
		if(type.equals(String.class))
		{
			return PropertyInfo.STRING_CLASS;
		}
		else if(type.equals(Integer.class))
		{
			return PropertyInfo.INTEGER_CLASS;
		}
		else if(type.equals(Long.class))
		{
			return PropertyInfo.LONG_CLASS;
		}
		
		// TODO Faltan varios tipos fijarse en PropertyInfo
		
		return PropertyInfo.OBJECT_CLASS;
			
	}
	
}