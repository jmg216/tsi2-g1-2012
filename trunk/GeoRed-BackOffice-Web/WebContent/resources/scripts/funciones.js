function refreshView()
{
	window.location.refresh(windows.location.page);
}

// Funciones mapa selector
function showMapaSelector(idCampoSelector, callbackRefreshFn) 
{
	dlgMapaSelector.show();   
	
	initializeMapaSelector(idCampoSelector, callbackRefreshFn);
}

var mapSelector;
var lastMarkerSelector;

function initializeMapaSelector(idCampoSelector, callbackRefreshFn) 
{
    var campoSelector = $("#" + idCampoSelector.replace(":", "\\:"));
    
    var myOptions = {
      zoom: 10,
      center: new google.maps.LatLng(-34.89269, -56.164856),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    
    mapSelector = new google.maps.Map(document.getElementById("containerMapaSelector"), myOptions);

    google.maps.event.addListener(mapSelector, 'click', function (event) {
        campoSelector.val(event.latLng);
        campoSelector.val(campoSelector.val().replace("(", "").replace(")", ""));
        addMarker(event.latLng);
        callbackRefreshFn();
    });
}

function addMarker(location) 
{
    var marker = new google.maps.Marker({
        position: location,
        map: mapSelector
    });

    if (lastMarkerSelector != null) 
    {
        lastMarkerSelector.setMap(null);
    }

    lastMarkerSelector = marker;
    mapSelector.setCenter(location);
}