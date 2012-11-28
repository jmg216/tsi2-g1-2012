package com.geored.frontoffice.activities.mapa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.geored.frontoffice.activities.R;
import com.geored.frontoffice.activities.sitio.SitioActivity;
import com.geored.frontoffice.activities.sitio.SitioDetalleActivity;
import com.geored.frontoffice.activities.sitio.SitioGroupActivity;
import com.geored.frontoffice.dto.SitioADTO;
import com.geored.frontoffice.wsclient.FactoryWS;
import com.geored.frontoffice.wsclient.SitioWS;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MapGeoRedActivity extends MapActivity {

	private SitioWS sitioWS = FactoryWS.getInstancia().getSitioWS();
	private List<SitioADTO> listaSitios;
	private Button btnActualizar;
	private LocationManager locManager;
	private MapView mapView;
	private MapController myMapController;
	Location loc;	
	private List<Overlay> mOverlays; //para agregar los overlays
	//mi ubicacion
	//private MyLocationOverlay mOverlayLocation;//Funciona perfectamente en un dispositivo real
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        myMapController = mapView.getController();
        mOverlays = mapView.getOverlays();
        //mOverlayLocation = new MyLocationOverlay(this, mapView);//Funciona perfectamente en un dispositivo real
               
       btnActualizar = (Button)findViewById(R.id.BtnActualizar);      
       btnActualizar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				comenzarLocalizacion();
			}
		});                    
    }
    //Mensajes Customizados
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
    void mostrarAvisoProveedoresDeshabilitado(){
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);    
    	builder.setMessage("Dispositivos GPS y/o WIFI Deshabilitado")            
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
    	//Obtenemos mejor proveedor disponible
        Criteria criteria=new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_HIGH);
        String provider=locManager.getBestProvider(criteria, true);
        
    	loc = locManager.getLastKnownLocation(provider);
    	LocationListener l = new LocationListener() {
			
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
				
			}
			
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			public void onProviderDisabled(String provider) {
				mostrarAvisoProveedoresDeshabilitado();
				
			}
			
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				 MensajeBox("Su localizacion cambio");
			}
		};
		locManager.requestLocationUpdates(provider, 800000, 0,l);
    	
    	//Mostramos la �ltima posici�n conocida
    	mostrarPosicion(loc);
    	
    }
    
	  private void mostrarPosicion(Location loc) {
	  if(loc != null)
	  {
			  //me centra en mi hubicacion
			GeoPoint centro = new GeoPoint((int) (loc.getLatitude() * 1E6), (int) (loc.getLongitude() * 1E6));
			myMapController.setCenter(centro);
			myMapController.setZoom(14); 
			  
			  //esto funca en un dispositivo real
			//mOverlayLocation.enableMyLocation();
		    //mOverlayLocation.enableCompass();
		    //mOverlays.add(mOverlayLocation);
			//mapView.postInvalidate(); //para actualizar correctamente el mapa
			  
			MyItemizedOverlay markerMiUbicacion = new MyItemizedOverlay(getResources().getDrawable(R.drawable.mi_ubicacion), this);
			markerMiUbicacion.addGeoPoit(centro);
			mOverlays.clear();
			mOverlays.add(markerMiUbicacion);
			
			Double d1 = loc.getLatitude();
			Double d2 = loc.getLongitude();    
		  	String lat =  Location.convert(d1,Location.FORMAT_DEGREES);
		  	String lon = Location.convert(d2,Location.FORMAT_DEGREES);
		  	MensajeBox("Aqui esta usted:   latitud: "+lat+"longitud: "+lon );
		  	
		
		  	MyItemizedOverlay markersSitio = new MyItemizedOverlay(getResources().getDrawable(R.drawable.marker3), this);
			  listaSitios = sitioWS.obtenerListado();
			  	Iterator<SitioADTO> it = listaSitios.iterator();
			  	while (it.hasNext()) {
			  		SitioADTO sitio = (SitioADTO) it.next();
			  		markersSitio.addSitio(sitio);
				}
			  	mOverlays.add(markersSitio);
			  	mapView.postInvalidate();
		  	 	
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
	    	    OverlayItem overlayitem = new OverlayItem(geoPoint, "Informacion: ", " Aqui esta usted!");
	    	    addOverlay(overlayitem);
	    	}
	    
	    public void addSitio(SitioADTO sitio) {
	    	try{
	    		GeoPoint p = null;
				Double longit , latit = null;
				String aux= null;
				aux = sitio.getUbicacionGeografica();
				String[] coordes = aux.split(",");
				latit = Double.parseDouble(coordes[0]);
				longit = Double.parseDouble(coordes[1]);
				p = new GeoPoint((int) (latit * 1E6), (int) (longit * 1E6));
				OverlayItem overlayItem = new OverlayItem(p, "sitio: "+ sitio.getNombre(), "Descripcion: " +sitio.getDescripcion());
				addOverlay(overlayItem);
	    	} catch (Exception e) {
	    		MensajeBox("Error de Datos de Ubicacion para el sitio: " + sitio.getNombre());
				}	    	    
	    }
	 
	 @Override
	    protected OverlayItem createItem(int index) {
	        return mOverlays.get(index);
	    }
	 
	    @Override
	    public int size() {
	        return mOverlays.size();
	    }
	    
	    protected final boolean onTap(final int index) {
	    	if(index==0){ //index de mi ubicacion
	        MensajeBox(mOverlays.get(index).getTitle() + mOverlays.get(index).getSnippet());
	    	}
	        // C�digo espec�fico de un ejemplo
	        //mContext.startActivity(new IntentParada(mContext, mParadas.get(index).getId()));
	        if(index!=0){	        
	        	AlertDialog.Builder builder = new AlertDialog.Builder(mContext);    
	        	builder.setMessage( mOverlays.get(index).getTitle() + mOverlays.get(index).getSnippet())            
	        		.setCancelable(false)            
	        		.setNeutralButton("Ir al Sitio",                    
	        				new DialogInterface.OnClickListener() {                        
	        					public void onClick(DialogInterface dialog, int id) {                            
	        						Intent i = new Intent(mContext, SitioDetalleActivity.class);
	        				        SitioADTO sitioSeleccionado = (SitioADTO) listaSitios.get(index);
	        				        
	        				        i.putExtra("nombreSitio", sitioSeleccionado.getNombre());  
	        				        i.putExtra("imagenSitio", sitioSeleccionado.getUrlImagen());
	        				        i.putExtra("descSitio", sitioSeleccionado.getDescripcion());
	        				        
	        				        startActivity(i);                        
	        						}                    
	        					}).setNegativeButton("Cancelar",                    
	        	        				new DialogInterface.OnClickListener() {                        
		        					public void onClick(DialogInterface dialog, int id) {                            
		        						closeContextMenu();                       
		        						}                    
		        					});    
	        	AlertDialog alert = builder.create();    
	        	alert.show();        
	        }
	        return true;
	    }
	 
	}
    
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void onPause() {
		//Funciona correctamente en un dispositivo real
//		mOverlayLocation.disableMyLocation(); 
//		mOverlayLocation.disableCompass();
		super.onPause();
	}

	@Override
	protected void onResume() {
		//Funciona correctamente en un dispositivo real
//		mOverlayLocation.enableMyLocation();
//		mOverlayLocation.enableCompass();
		super.onResume();
	}
}