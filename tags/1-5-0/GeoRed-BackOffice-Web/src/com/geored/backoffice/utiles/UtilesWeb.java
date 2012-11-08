package com.geored.backoffice.utiles;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	
	// Utilidades para encriptar password
  	public static String encriptarMD5(String cadena)
	{
  		final char[] CONSTS_HEX = { '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f' };
  		
		try
		{
			MessageDigest msgd = MessageDigest.getInstance("MD5");
			
			byte[] bytes = msgd.digest(cadena.getBytes());
			
			StringBuilder strCadenaMD5 = new StringBuilder(2 * bytes.length);
			
			for (int i = 0; i < bytes.length; i++)
			{
				int bajo = (int)(bytes[i] & 0x0f);
				int alto = (int)((bytes[i] & 0xf0) >> 4);
				strCadenaMD5.append(CONSTS_HEX[alto]);
				strCadenaMD5.append(CONSTS_HEX[bajo]);
			}
			
			return strCadenaMD5.toString();
		} 
		catch (NoSuchAlgorithmException e) 
		{
		   return null;
		}
	}
}