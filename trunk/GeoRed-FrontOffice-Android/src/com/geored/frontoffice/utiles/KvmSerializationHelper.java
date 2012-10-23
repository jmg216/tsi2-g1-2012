package com.geored.frontoffice.utiles;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class KvmSerializationHelper
{
	private KvmSerializable dtoObject;
	private Class dtoClass;
	
	// Diccionarios de fields
	private Map<Integer, String> fieldsNames = new HashMap<Integer, String>();
	private Map<Integer, Method> fieldsGetters = new HashMap<Integer, Method>();
	private Map<Integer, Method> fieldsSetters = new HashMap<Integer, Method>();
	private Map<Integer, Type> fieldsTypes = new HashMap<Integer, Type>();
	
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
			// Nombre
			fieldsNames.put(index, field.getName());
			
			// Field Type
			fieldsTypes.put(index, field.getType());
			
			String capitalizedFieldName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
			
			for(Method method : methodsArray)
			{
				// Getters y Setters methods
				if(method.getName().equals("get" + capitalizedFieldName))
				{
					fieldsGetters.put(index, method);
				}
				else if(method.getName().equals("set" + capitalizedFieldName))
				{
					fieldsSetters.put(index, method);
				}
			}
			
			index++;
		}
	}

	// Operaciones utilizarias para KvmSerializable
	public int getPropertyCount()
	{
		return dtoClass.getDeclaredFields().length;
	}
	
	public Object getProperty(int index) 
	{	
		// Obtengo el getter a invocar
        Method getter = fieldsGetters.get(index);
        
        try
		{
			Object getterValue = getter.invoke(dtoObject, new Object[]{});
			
			if(fieldsTypes.get(index).equals(Long.class) && getterValue == null)
			{
				return new Long(0L);
			}
			
			return getterValue;
		} 
        catch (IllegalArgumentException e)
		{
			e.printStackTrace();
			
			return null;
		} 
        catch (IllegalAccessException e)
		{
			e.printStackTrace();
			
			return null;
		} 
        catch (InvocationTargetException e)
		{
			e.printStackTrace();
			
			return null;
		}         
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
		else if(type.equals(Boolean.class))
		{
			return PropertyInfo.BOOLEAN_CLASS;
		}
		else if(type.equals(Vector.class))
		{
			return PropertyInfo.VECTOR_CLASS;
		}
		
		return PropertyInfo.OBJECT_CLASS;
			
	}
	
}