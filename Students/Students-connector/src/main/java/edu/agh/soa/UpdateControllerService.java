
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
@WebServiceClient(name = "UpdateControllerService", targetNamespace = "http://controllers/", wsdlLocation = "http://localhost:8080/Students-ejb/update?wsdl")
public class UpdateControllerService
    extends Service
{

    private final static URL UPDATECONTROLLERSERVICE_WSDL_LOCATION;
    private final static WebServiceException UPDATECONTROLLERSERVICE_EXCEPTION;
    private final static QName UPDATECONTROLLERSERVICE_QNAME = new QName("http://controllers/", "UpdateControllerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/Students-ejb/update?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        UPDATECONTROLLERSERVICE_WSDL_LOCATION = url;
        UPDATECONTROLLERSERVICE_EXCEPTION = e;
    }

    public UpdateControllerService() {
        super(__getWsdlLocation(), UPDATECONTROLLERSERVICE_QNAME);
    }

    public UpdateControllerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), UPDATECONTROLLERSERVICE_QNAME, features);
    }

    public UpdateControllerService(URL wsdlLocation) {
        super(wsdlLocation, UPDATECONTROLLERSERVICE_QNAME);
    }

    public UpdateControllerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, UPDATECONTROLLERSERVICE_QNAME, features);
    }

    public UpdateControllerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UpdateControllerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns UpdateController
     */
    @WebEndpoint(name = "UpdateControllerPort")
    public UpdateController getUpdateControllerPort() {
        return super.getPort(new QName("http://controllers/", "UpdateControllerPort"), UpdateController.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UpdateController
     */
    @WebEndpoint(name = "UpdateControllerPort")
    public UpdateController getUpdateControllerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://controllers/", "UpdateControllerPort"), UpdateController.class, features);
    }

    private static URL __getWsdlLocation() {
        if (UPDATECONTROLLERSERVICE_EXCEPTION!= null) {
            throw UPDATECONTROLLERSERVICE_EXCEPTION;
        }
        return UPDATECONTROLLERSERVICE_WSDL_LOCATION;
    }

}
