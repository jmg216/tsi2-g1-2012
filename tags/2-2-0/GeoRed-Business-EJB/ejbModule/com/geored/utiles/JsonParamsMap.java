package com.geored.utiles;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class JsonParamsMap
{
	private Map<String, String> jsonParams;
	
	private Gson gson;
	
	public JsonParamsMap(String jsonString)
	{
		gson = new Gson();
		
		if(UtilesNegocio.isNullOrEmpty(jsonString))
		{
			jsonParams = new HashMap<String, String>();
		}
		else
		{
			// Parseo y corrijo los objetos
			jsonParams = gson.fromJson(jsonString, Map.class);
			
			for(String keyParam : jsonParams.keySet())
			{
				String jsonParam = gson.toJson(jsonParams.get(keyParam));			
				
				jsonParams.put(keyParam, jsonParam);
			}
		}
	}
	
	public Object getParam(String key, Class<?> clazz)
	{
		String jsonParam = jsonParams.get(key);
		
		if(jsonParam != null)
		{
			return gson.fromJson(jsonParam, clazz);
		}
		
		return null;
	}
}