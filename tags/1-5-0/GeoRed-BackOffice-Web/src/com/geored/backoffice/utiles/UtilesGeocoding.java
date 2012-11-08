package com.geored.backoffice.utiles;

import java.util.List;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.LatLng;

public class UtilesGeocoding {
	
	// Metodo de Geocoding. Se le pasa una direccion y obtiene las coordenadas de esa direcccion y las devuelve
	// El formato de la direccion es: Numero Calle, Ciudad, Pais. Ejemplo: 1312 18 de Julio, Montevideo, Uruguay
	public static LatLng geocoding (String direccion)
	{
		Geocoder geocoder = new Geocoder();
		
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(direccion).getGeocoderRequest();
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		List<GeocoderResult> resultados = geocoderResponse.getResults();
		
		return resultados.get(0).getGeometry().getLocation();
	}
	
	// En caso de que se llegue a precisas, el metodo inverso.
	public static String inverseGeocoding(LatLng coordenadas) {
		
		return null;
	}
	
	
	
}
