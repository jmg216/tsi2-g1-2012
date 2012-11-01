package com.geored.frontoffice.activities;

import java.util.ArrayList;
import java.util.List;

import com.geored.frontoffice.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ListAdapter;

public class mapActivity extends MapActivity {

	private Button btnActualizar;
	private LocationManager locManager;
	private LocationListener locListener;
	private MapView mapView ;
	private MapController myMapController;
	//para agregar los overlays
	private List<Overlay> mOverlays;
	//mi ubicacion
	private MyLocationOverlay mOverlayLocation;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        MapView mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        myMapController = mapView.getController();
        mOverlays = mapView.getOverlays();
        mOverlayLocation = new MyLocationOverlay(this, mapView);
        
       
        
       btnActualizar = (Button)findViewById(R.id.BtnActualizar);
       
       btnActualizar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				comenzarLocalizacion();
			}
		});
       
     
//      //Si el GPS no está habilitado
//        if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//             mostrarAvisoGpsDeshabilitado();
//        }
//        
        
    }
    //PARA LA CREACION DE DATOS DE PRUEBA
    void MensajeBox(String mensaje) {    
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);    
    	builder.setMessage(mensaje)            
    		.setCancelable(false)            
    		.setNeutralButton("Aceptar",                    
    				new DialogInterface.OnClickListener() {                        
    					public void onClick(DialogInterface dialog, int id) {                            
    						dialog.cancel();                        
    						}                    
    					});    
    	AlertDialog alert = builder.create();    
    	alert.show();
    }
    void mostrarAvisoGpsDeshabilitado(){
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);    
    	builder.setMessage("GPS Deshabilitado")            
    		.setCancelable(false)            
    		.setNeutralButton("Aceptar",                    
    				new DialogInterface.OnClickListener() {                        
    					public void onClick(DialogInterface dialog, int id) {                            
    						dialog.cancel();                        
    						}                    
    					});    
    	AlertDialog alert = builder.create();    
    	alert.show();
    	
    }
    
       
    private void comenzarLocalizacion()
    {
    	//Obtenemos una referencia al LocationManager
    	locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    	
    	
    	//Obtenemos mejor proveedor diisponible
        Criteria criteria=new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_HIGH);
        String provider=locManager.getBestProvider(criteria, true);
        
        //locManager.requestLocationUpdates(provider, 1000, 0,locListener);
      //Obtenemos la última posición conocida
    	Location loc = locManager.getLastKnownLocation(provider);
    	
    	
    	//Mostramos la última posición conocida
    	mostrarPosicion(loc);
    	
    	//Nos registramos para recibir actualizaciones de la posición
    	locListener = new LocationListener() {
	    		    		
    		public void onLocationChanged(Location location) {
                mostrarPosicion(location);
            }
         
            public void onProviderDisabled(String provider){
                MensajeBox("Provider OFF");//mensaje de gps desactivado o no disponible y opcion de activar el gps
            }
         
            public void onProviderEnabled(String provider){
            	MensajeBox("Provider ON");//mensaje de gps encendido
            }
         
            public void onStatusChanged(String provider, int status, Bundle extras){
            	MensajeBox("Provider Status: " + status);
	    	}
    	};
    	
    	locManager.requestLocationUpdates(
    			LocationManager.GPS_PROVIDER, 30000, 0, locListener);
    }
    
  private void mostrarPosicion(Location loc) {
  if(loc != null)
  {

	  //me centra en mi hubicacion por GPS
	  GeoPoint centro = new GeoPoint((int) (loc.getLatitude() * 1E6), (int) (loc.getLongitude() * 1E6));
	  myMapController.setCenter(centro);
	  myMapController.setZoom(14); 
	  
	  //OverlayItem overlayMiUbicacion = new OverlayItem(centro, "woopa", "Estoy en mi posicion");
	  mOverlayLocation.enableMyLocation();
      mOverlayLocation.enableCompass();
	  mOverlays.add(mOverlayLocation);
	  //mapView.postInvalidate(); //para actualizar correctamente el mapa
	 
	  Double d1 = loc.getLatitude();
	  Double d2 = loc.getLongitude();
	  
	  
  	String lat =  Location.convert(d1,Location.FORMAT_DEGREES);
  	String lon = Location.convert(d2,Location.FORMAT_DEGREES);
  	MensajeBox("latitud: "+lat+"longitud: "+lon );
  	
  	//Prueba de los markers de sitios de interes
  	MyItemizedOverlay markers = new MyItemizedOverlay(getResources().getDrawable(R.drawable.ic_launcher), this);
  	//para mostrar los sitios de interes aca tengo que traerme la lista de sitios interes a pintar
  	//recorrer la lista y aplicarle el addgeopoint, modificando el addgeopoint para que obtenga las coordes, titulo y descripcion
  	//despues capturar las pulsaciones con el metodo ontap, lo defino dentro de itemizedOverlay y ahi obtengo las caracteristicas las muestro t la idea es dentro 
  	//del mesageBox ponerle un boton con intent a la descripcion del sitio interes
  	GeoPoint p = new GeoPoint((int) (loc.getLatitude() * 1E6), (int) (loc.getLongitude() * 1E6));//prueba poniendo el marker en el punto de locacion del usuario camina
  	markers.addGeoPoit(p);
  	
  	mOverlays.add(markers);
  	
  	

  }
  else
  {
  	 MensajeBox("no cargo la lat y long");
  }
}
    
  public class MyItemizedOverlay extends ItemizedOverlay<OverlayItem> {
	    private List<OverlayItem> mOverlays;
	    private Context mContext;
	 
	    public MyItemizedOverlay(Drawable defaultMarker,Context context) {
	        super(boundCenter(defaultMarker));
	        mOverlays =new ArrayList<OverlayItem>();
	        mContext = context;
	    }
	    
	    public void addOverlay(OverlayItem overlay) {
	        mOverlays.add(overlay);
	        populate();//si secargan muchos elementos, el polulate deberia ir despues de cargarlos todos
	    }
	    
	    public void addGeoPoit(GeoPoint geoPoint) {
	    	    OverlayItem overlayitem = new OverlayItem(geoPoint, "Sitio Interes ", "Sitios de geored");
	    	    addOverlay(overlayitem);
	    	}
	 
	 @Override
	    protected OverlayItem createItem(int index) {
	        return mOverlays.get(index);
	    }
	 
	    @Override
	    public int size() {
	        return mOverlays.size();
	    }
	 
	}
    
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void onPause() {
		mOverlayLocation.disableMyLocation();
		mOverlayLocation.disableCompass();
		super.onPause();
	}

	@Override
	protected void onResume() {
		mOverlayLocation.enableMyLocation();
		mOverlayLocation.enableCompass();
		super.onResume();
	}
}
