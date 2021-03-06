
package edu.agh.soa;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "FindControllerService", targetNamespace = "http://controllers/", wsdlLocation = "http://localhost:8080/Students-ejb/find?wsdl")
public class FindControllerService
    extends Service
{

    private final static URL FINDCONTROLLERSERVICE_WSDL_LOCATION;
    private final static WebServiceException FINDCONTROLLERSERVICE_EXCEPTION;
    private final static QName FINDCONTROLLERSERVICE_QNAME = new QName("http://controllers/", "FindControllerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/Students-ejb/find?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FINDCONTROLLERSERVICE_WSDL_LOCATION = url;
        FINDCONTROLLERSERVICE_EXCEPTION = e;
    }

    public FindControllerService() {
        super(__getWsdlLocation(), FINDCONTROLLERSERVICE_QNAME);
    }

    public FindControllerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FINDCONTROLLERSERVICE_QNAME, features);
    }

    public FindControllerService(URL wsdlLocation) {
        super(wsdlLocation, FINDCONTROLLERSERVICE_QNAME);
    }

    public FindControllerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FINDCONTROLLERSERVICE_QNAME, features);
    }

    public FindControllerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FindControllerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FindController
     */
    @WebEndpoint(name = "FindControllerPort")
    public FindController getFindControllerPort() {
        return super.getPort(new QName("http://controllers/", "FindControllerPort"), FindController.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FindController
     */
    @WebEndpoint(name = "FindControllerPort")
    public FindController getFindControllerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://controllers/", "FindControllerPort"), FindController.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FINDCONTROLLERSERVICE_EXCEPTION!= null) {
            throw FINDCONTROLLERSERVICE_EXCEPTION;
        }
        return FINDCONTROLLERSERVICE_WSDL_LOCATION;
    }

}
