package com.geored.utiles;

public class UtilesNegocio
{

	public static final double radioTierraKm = 6371;
	
	public static double CalcularDistanciaCoordenadas(String strLat1, String strLon1, String strLat2, String strLon2)
    {
        double lat1 = Rad(Double.parseDouble(strLat1.replace(".", ",")));
        double lon1 = Rad(Double.parseDouble(strLon1.replace(".", ",")));
        double lat2 = Rad(Double.parseDouble(strLat2.replace(".", ",")));
        double lon2 = Rad(Double.parseDouble(strLon2.replace(".", ",")));

        // Calculo la diferencia de distancias en radianes
        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(lat1) * Math.cos(lat2) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        //Devuelve la distancia entre los dos puntos.
        return radioTierraKm * c;
    }
	
	private static double Rad(double x)
    {
		return x * (Math.PI / 180);
    }

}