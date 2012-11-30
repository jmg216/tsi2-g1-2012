package com.geored.utiles;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.geored.dominio.Administrador;

public class UtilesNegocio
{
	public static final Long ID_ADMIN_PRINCIPAL = 1L;
	
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
	
	//Metodo que envia el mail al usuario administrador de la empresa
	public static void enviarMailAdministrador (Administrador administrador, String nombreEmpresa) {
		
		Properties propiedades = new Properties();
		propiedades.setProperty("mail.smtp.host", "smtp.gmail.com");
		propiedades.setProperty("mail.smtp.starttls.enable", "true");
		propiedades.setProperty("mail.smtp.port", "587");
		propiedades.setProperty("mail.smtp.auth","true");
		propiedades.setProperty("mail.debug", "true");
		
		Session session = Session.getInstance(propiedades, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication () {
				return new PasswordAuthentication("tsi2.g1@gmail.com", "admintsi2");
			}
		});
		
		MimeMessage mensaje = new MimeMessage(session);
		
		try {
			
			mensaje.setFrom(new InternetAddress("tsi2.g1@gmail.com", "GeoReduy - Grupo 01"));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(administrador.getEmail()));
			mensaje.setSubject("Hola " + administrador.getNombre() + "! ");
			
			MimeMultipart mp = new MimeMultipart();
			MimeBodyPart mpl = new MimeBodyPart();
			
			String html = 
					"<html>"+
		            "<head><title></title></head>"+
		            "<body>"+
		            "Se te ha asignado la empresa: " + "<b>" + nombreEmpresa + "</b>" + " para que la administres" +
                    "<br><br>" + "Entra a esta direccion: <br>" +
                    "<a href = http://localhost:8080/GeoRed-BackOffice-Web> GeoRedUy - Grupo 1 </a>" + "<br><br>" +
                    "E inicia sesion con tu usuario y contraseña provistos en este email: " + "<br><br>" +
                    
                    "<b>Nombre de Usuario:</b> " + administrador.getEmail() + "<br>" +
                    "<b>Password: </b>" + "admin" +  "<br><br>" +
                    
                    "Te recomendamos cambiar el password una vez hayas ingresado..." +  "<br><br>" +
                    "Atentamente. <b>Grupo 01</b>" +
                    "</body>" +
                    "</html>";
			
			mpl.setContent(html, "text/html");
			
			mp.addBodyPart(mpl);
			mensaje.setContent(mp);
			
			Transport.send(mensaje);
	
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
			
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
	}
	
	public static boolean isNullOrEmpty(String value)
	{
		return value == null || (value != null && value.length() == 0);
	}

}