package com.geored.backoffice.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.geored.backoffice.utiles.UtilesWeb;

@FacesConverter("com.geored.backoffice.converter.CalendarConverter")
public class CalendarConverter implements Converter
{
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(UtilesWeb.DATE_PATTERN);
			
			Calendar cal = Calendar.getInstance();
			
			cal.setTime(sdf.parse(value));
			
			return cal;
		} 
		catch (ParseException e)
		{
			e.printStackTrace();
			
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		if(value instanceof Calendar)
		{
			SimpleDateFormat sdf = new SimpleDateFormat(UtilesWeb.DATE_PATTERN);
			
			return sdf.format(((Calendar) value).getTime());
		}
		
		return "";
	}
	
}