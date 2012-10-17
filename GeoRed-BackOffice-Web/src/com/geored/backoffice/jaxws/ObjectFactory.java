
package com.geored.backoffice.jaxws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.geored.backoffice.jaxws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Obtener_QNAME = new QName("http://negocio.geored.com/", "obtener");
    private final static QName _Eliminar_QNAME = new QName("http://negocio.geored.com/", "eliminar");
    private final static QName _ActualizarResponse_QNAME = new QName("http://negocio.geored.com/", "actualizarResponse");
    private final static QName _ObtenerListado_QNAME = new QName("http://negocio.geored.com/", "obtenerListado");
    private final static QName _NegocioException_QNAME = new QName("http://negocio.geored.com/", "NegocioException");
    private final static QName _InsertarResponse_QNAME = new QName("http://negocio.geored.com/", "insertarResponse");
    private final static QName _Actualizar_QNAME = new QName("http://negocio.geored.com/", "actualizar");
    private final static QName _Insertar_QNAME = new QName("http://negocio.geored.com/", "insertar");
    private final static QName _EliminarResponse_QNAME = new QName("http://negocio.geored.com/", "eliminarResponse");
    private final static QName _ObtenerResponse_QNAME = new QName("http://negocio.geored.com/", "obtenerResponse");
    private final static QName _ObtenerListadoResponse_QNAME = new QName("http://negocio.geored.com/", "obtenerListadoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.geored.backoffice.jaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerListadoResponse }
     * 
     */
    public ObtenerListadoResponse createObtenerListadoResponse() {
        return new ObtenerListadoResponse();
    }

    /**
     * Create an instance of {@link EliminarResponse }
     * 
     */
    public EliminarResponse createEliminarResponse() {
        return new EliminarResponse();
    }

    /**
     * Create an instance of {@link ObtenerResponse }
     * 
     */
    public ObtenerResponse createObtenerResponse() {
        return new ObtenerResponse();
    }

    /**
     * Create an instance of {@link ActualizarResponse }
     * 
     */
    public ActualizarResponse createActualizarResponse() {
        return new ActualizarResponse();
    }

    /**
     * Create an instance of {@link NegocioException }
     * 
     */
    public NegocioException createNegocioException() {
        return new NegocioException();
    }

    /**
     * Create an instance of {@link ObtenerListado }
     * 
     */
    public ObtenerListado createObtenerListado() {
        return new ObtenerListado();
    }

    /**
     * Create an instance of {@link InsertarResponse }
     * 
     */
    public InsertarResponse createInsertarResponse() {
        return new InsertarResponse();
    }

    /**
     * Create an instance of {@link Insertar }
     * 
     */
    public Insertar createInsertar() {
        return new Insertar();
    }

    /**
     * Create an instance of {@link Actualizar }
     * 
     */
    public Actualizar createActualizar() {
        return new Actualizar();
    }

    /**
     * Create an instance of {@link Obtener }
     * 
     */
    public Obtener createObtener() {
        return new Obtener();
    }

    /**
     * Create an instance of {@link Eliminar }
     * 
     */
    public Eliminar createEliminar() {
        return new Eliminar();
    }

    /**
     * Create an instance of {@link EventoDTO }
     * 
     */
    public EventoDTO createEventoDTO() {
        return new EventoDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obtener }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://negocio.geored.com/", name = "obtener")
    public JAXBElement<Obtener> createObtener(Obtener value) {
        return new JAXBElement<Obtener>(_Obtener_QNAME, Obtener.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Eliminar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://negocio.geored.com/", name = "eliminar")
    public JAXBElement<Eliminar> createEliminar(Eliminar value) {
        return new JAXBElement<Eliminar>(_Eliminar_QNAME, Eliminar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://negocio.geored.com/", name = "actualizarResponse")
    public JAXBElement<ActualizarResponse> createActualizarResponse(ActualizarResponse value) {
        return new JAXBElement<ActualizarResponse>(_ActualizarResponse_QNAME, ActualizarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerListado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://negocio.geored.com/", name = "obtenerListado")
    public JAXBElement<ObtenerListado> createObtenerListado(ObtenerListado value) {
        return new JAXBElement<ObtenerListado>(_ObtenerListado_QNAME, ObtenerListado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NegocioException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://negocio.geored.com/", name = "NegocioException")
    public JAXBElement<NegocioException> createNegocioException(NegocioException value) {
        return new JAXBElement<NegocioException>(_NegocioException_QNAME, NegocioException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://negocio.geored.com/", name = "insertarResponse")
    public JAXBElement<InsertarResponse> createInsertarResponse(InsertarResponse value) {
        return new JAXBElement<InsertarResponse>(_InsertarResponse_QNAME, InsertarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Actualizar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://negocio.geored.com/", name = "actualizar")
    public JAXBElement<Actualizar> createActualizar(Actualizar value) {
        return new JAXBElement<Actualizar>(_Actualizar_QNAME, Actualizar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Insertar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://negocio.geored.com/", name = "insertar")
    public JAXBElement<Insertar> createInsertar(Insertar value) {
        return new JAXBElement<Insertar>(_Insertar_QNAME, Insertar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://negocio.geored.com/", name = "eliminarResponse")
    public JAXBElement<EliminarResponse> createEliminarResponse(EliminarResponse value) {
        return new JAXBElement<EliminarResponse>(_EliminarResponse_QNAME, EliminarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://negocio.geored.com/", name = "obtenerResponse")
    public JAXBElement<ObtenerResponse> createObtenerResponse(ObtenerResponse value) {
        return new JAXBElement<ObtenerResponse>(_ObtenerResponse_QNAME, ObtenerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerListadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://negocio.geored.com/", name = "obtenerListadoResponse")
    public JAXBElement<ObtenerListadoResponse> createObtenerListadoResponse(ObtenerListadoResponse value) {
        return new JAXBElement<ObtenerListadoResponse>(_ObtenerListadoResponse_QNAME, ObtenerListadoResponse.class, null, value);
    }

}
