package com.geored.frontoffice.utiles;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.geored.dto.MensajeAmistadDTO;
import com.geored.dto.NotificacionDTO;

public class UtilesAndroid 
{
	// Ubicacion actual del movil
	public static Location ubicacionActual = null;
	
	// Coleccion estatica de notificaciones y mensajes
	public static List<NotificacionDTO> listaNotificaciones = new ArrayList<NotificacionDTO>();	
	public static List<MensajeAmistadDTO> listaMensajes = new ArrayList<MensajeAmistadDTO>();
	
	// WebServices Endpoints
	public static final String HOST_WS="10.0.2.2:8080";
//	public static final String HOST_WS="192.168.1.112:8080";
	
	public static final String URL_WS_USUARIO = "http://" + HOST_WS +"/GeoRed-Business-EJB/UsuarioServiceImpl?wsdl";
	public static final String URL_WS_SITIO   = "http://" + HOST_WS +"/GeoRed-Business-EJB/SitioServiceImpl?wsdl";
	public static final String URL_WS_ADMIN   = "http://" + HOST_WS +"/GeoRed-Business-EJB/AdminServiceImpl?wsdl";
	public static final String URL_WS_EMPRESA = "http://" + HOST_WS +"/GeoRed-Business-EJB/EmpresaServiceImpl?wsdl";
	public static final String URL_WS_OFERTA  = "http://" + HOST_WS +"/GeoRed-Business-EJB/OfertaServiceImpl?wsdl";
	public static final String URL_WS_EVENTO  = "http://" + HOST_WS +"/GeoRed-Business-EJB/EventoServiceImpl?wsdl";
	public static final String URL_WS_GLOBAL  = "http://" + HOST_WS +"/GeoRed-Business-EJB/GlobalServiceImpl?wsdl";
	public static final String URL_WS_COMPRA  = "http://" + HOST_WS +"/GeoRed-Business-EJB/CompraServiceImpl?wsdl";

	// Utilidades Localizacion y Ubicacion
	public static final double DISTANCIA_CERCANA_KM = 10;
	
	public static final double radioTierraKm = 6371;
	
	public static double calcularDistanciaCoordenadas(String strLat1, String strLon1, String strLat2, String strLon2)
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
	
	public static void iniciarLocalizacion(Context context)
	{
		// Obtenemos una referencia al LocationManager
		LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		
		// Obtenemos mejor proveedor disponible
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setAltitudeRequired(false);
		criteria.setBearingRequired(false);
		criteria.setCostAllowed(true);
		criteria.setPowerRequirement(Criteria.POWER_HIGH);
		
		String provider = locationManager.getBestProvider(criteria, true);
		
		ubicacionActual = locationManager.getLastKnownLocation(provider);
		
		LocationListener locationListener = new LocationListener()
		{
			public void onStatusChanged(String provider, int status, Bundle extras)
			{	
				System.out.print("El estado de localicacion cambio");
			}

			public void onProviderEnabled(String provider)
			{
				System.out.print("Proveedor localizacion (" + provider +") activado");
			}

			public void onProviderDisabled(String provider)
			{
				System.out.print("Proveedor localizacion (" + provider +") desactivado");
			}

			public void onLocationChanged(Location location)
			{
				ubicacionActual = location;
			}
		};
		locationManager.requestLocationUpdates(provider, (1 * 60 * 1000), 0, locationListener);
	}
}
