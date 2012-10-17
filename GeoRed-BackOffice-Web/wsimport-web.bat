cd\
cd "C:\Eclipse\workspace\GeoRed-BackOffice-Web\src"
wsimport -p com.geored.backoffice.jaxws -keep -Xnocompile http://localhost:8080/GeoRed-Business-EJB/UsuarioServiceImpl?wsdl
wsimport -p com.geored.backoffice.jaxws -keep -Xnocompile http://localhost:8080/GeoRed-Business-EJB/EmpresaServiceImpl?wsdl
wsimport -p com.geored.backoffice.jaxws -keep -Xnocompile http://localhost:8080/GeoRed-Business-EJB/OfertaServiceImpl?wsdl
wsimport -p com.geored.backoffice.jaxws -keep -Xnocompile http://localhost:8080/GeoRed-Business-EJB/AdminServiceImpl?wsdl
wsimport -p com.geored.backoffice.jaxws -keep -Xnocompile http://localhost:8080/GeoRed-Business-EJB/SitioServiceImpl?wsdl
wsimport -p com.geored.backoffice.jaxws -keep -Xnocompile http://localhost:8080/GeoRed-Business-EJB/EventoServiceImpl?wsdl