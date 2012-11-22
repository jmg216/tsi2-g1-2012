package com.geored.frontoffice.utiles;

public class UtilesAndorid {

	public static final String IP_PUERTO="10.0.2.2:8080";
	
	public static final double radioTierraKm = 6371;
	
	public static final String URL_WS_USUARIO = "http://" + IP_PUERTO +"/GeoRed-Business-EJB/UsuarioServiceImpl?wsdl";
	public static final String URL_WS_SITIO   = "http://" + IP_PUERTO +"/GeoRed-Business-EJB/SitioServiceImpl?wsdl";
	public static final String URL_WS_ADMIN   = "http://" + IP_PUERTO +"/GeoRed-Business-EJB/AdminServiceImpl?wsdl";
	public static final String URL_WS_EMPRESA = "http://" + IP_PUERTO +"/GeoRed-Business-EJB/EmpresaServiceImpl?wsdl";
	public static final String URL_WS_OFERTA  = "http://" + IP_PUERTO +"/GeoRed-Business-EJB/OfertaServiceImpl?wsdl";
	public static final String URL_WS_EVENTO  = "http://" + IP_PUERTO +"/GeoRed-Business-EJB/EventoServiceImpl?wsdl";
	public static final String URL_WS_GLOBAL  = "http://" + IP_PUERTO +"/GeoRed-Business-EJB/GlobalServiceImpl?wsdl";
	public static final String URL_WS_COMPRA  = "http://" + IP_PUERTO +"/GeoRed-Business-EJB/CompraServiceImpl?wsdl";

	
	public static double CalcularDistanciaCoordenadas(String strLat1, String strLon1, String strLat2, String strLon2)
    {
        double lat1 = Rad(Double.parseDouble(strLat1));
        double lon1 = Rad(Double.parseDouble(strLon1));
        double lat2 = Rad(Double.parseDouble(strLat2));
        double lon2 = Rad(Double.parseDouble(strLon2));


        // Calculo la diferencia de distancias en radianes
        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(lat1) * Math.cos(lat2) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        //Devuelve la distancia entre los dos puntos.
        return (radioTierraKm * c);
    }
	
	private static double Rad(double x)
    {
		return x * (Math.PI / 180);
    }

	
}
