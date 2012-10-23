
package com.geored.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "EventoServiceImplService", targetNamespace = "http://negocio.geored.com/", wsdlLocation = "http://localhost:8080/GeoRed-Business-EJB/EventoServiceImpl?wsdl")
public class EventoServiceImplService
    extends Service
{

    private final static URL EVENTOSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.geored.ws.EventoServiceImplService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.geored.ws.EventoServiceImplService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/GeoRed-Business-EJB/EventoServiceImpl?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/GeoRed-Business-EJB/EventoServiceImpl?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        EVENTOSERVICEIMPLSERVICE_WSDL_LOCATION = url;
    }

    public EventoServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EventoServiceImplService() {
        super(EVENTOSERVICEIMPLSERVICE_WSDL_LOCATION, new QName("http://negocio.geored.com/", "EventoServiceImplService"));
    }

    /**
     * 
     * @return
     *     returns EventoServiceImpl
     */
    @WebEndpoint(name = "EventoServiceImplPort")
    public EventoServiceImpl getEventoServiceImplPort() {
        return super.getPort(new QName("http://negocio.geored.com/", "EventoServiceImplPort"), EventoServiceImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EventoServiceImpl
     */
    @WebEndpoint(name = "EventoServiceImplPort")
    public EventoServiceImpl getEventoServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://negocio.geored.com/", "EventoServiceImplPort"), EventoServiceImpl.class, features);
    }

}