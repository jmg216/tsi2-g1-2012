package com.geored.frontoffice.utiles;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class BitMapImageConverter {

	public static Bitmap getImageBitmap(String url) 
	{
        Bitmap bm = null;
        
        try 
        {	//TODO parsear url. Si no es valida poner una imagen por defecto.
            URL aURL = new URL(url);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
            
       } 
       catch (IOException e) 
       {
    	   Log.e("ERROR", "Error al cargar imagen");
       }
        
       return bm;
    }  
}
