package com.geored.utiles;

public class ConstantesGenerales
{
	public static class TiposNotificacion
	{
		public static final Long ID_NUEVA_OFERTA = 1L;
		public static final Long ID_SITIO_OFERTA = 2L;
		public static final Long ID_EVENTO_OFERTA = 3L;
		public static final Long ID_CHECKIN_AMIGO_OFERTA = 4L;
		public static final Long ID_SOLICITUD = 5L;
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
	
}