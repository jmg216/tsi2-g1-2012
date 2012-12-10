package com.geored.utiles;

public class ConstantesGenerales
{
	public static class TiposNotificacion
	{
		public static final Long ID_NUEVA_OFERTA = 1L;
		public static final Long ID_NUEVO_SITIO = 2L;
		public static final Long ID_NUEVO_EVENTO = 3L;
		public static final Long ID_CHECKIN_AMIGO = 4L;
		public static final Long ID_SOLICITUD_AMISTAD = 5L;
	}
	
	/**
	 * 	Codigo para saber si el mensaje que se va a enviar
	 *	por gcm de tipo NotificacionDTO o de tipo MensajeAmistadoDTO
	 * */
	public static class TiposCodigoMensaje
	{
		public static final String NOTIFICACION = "N";
		public static final String CHAT = "C";
	}
	
	public static class Generales
	{
		public static final Integer DISTANCIA_CERCANA_KM = 5;  
	}
	
}