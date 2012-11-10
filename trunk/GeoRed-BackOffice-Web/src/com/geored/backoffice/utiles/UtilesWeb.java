package com.geored.backoffice.utiles;


public class UtilesWeb
{
	public static final Long ID_TIPO_ADMIN_GLOBAL = 1L;
	
	public static final Long ID_TIPO_ADMIN_EMPRESA = 2L;
	
	public static final String DEFAULT_PASS = "admin";
	
	public static boolean isNullOrEmpty(String str)
	{
		return (str == null) || (str != null && str.isEmpty());
	}
	
	public static boolean isNullOrZero(Long lng)
	{
		return (lng == null) || (lng != null && lng <= 0L);
	}
}