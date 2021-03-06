
package com.services.webcarservices;

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
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DealerService", targetNamespace = "http://webcarservices.services.com/", wsdlLocation = "http://LAPTOP-GT898CL0:8080/CarServicesWebApp/DealerService?wsdl")
public class DealerService_Service
    extends Service
{

    private final static URL DEALERSERVICE_WSDL_LOCATION;
    private final static WebServiceException DEALERSERVICE_EXCEPTION;
    private final static QName DEALERSERVICE_QNAME = new QName("http://webcarservices.services.com/", "DealerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://LAPTOP-GT898CL0:8080/CarServicesWebApp/DealerService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DEALERSERVICE_WSDL_LOCATION = url;
        DEALERSERVICE_EXCEPTION = e;
    }

    public DealerService_Service() {
        super(__getWsdlLocation(), DEALERSERVICE_QNAME);
    }

    public DealerService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), DEALERSERVICE_QNAME, features);
    }

    public DealerService_Service(URL wsdlLocation) {
        super(wsdlLocation, DEALERSERVICE_QNAME);
    }

    public DealerService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DEALERSERVICE_QNAME, features);
    }

    public DealerService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DealerService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DealerService
     */
    @WebEndpoint(name = "DealerServicePort")
    public DealerService getDealerServicePort() {
        return super.getPort(new QName("http://webcarservices.services.com/", "DealerServicePort"), DealerService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DealerService
     */
    @WebEndpoint(name = "DealerServicePort")
    public DealerService getDealerServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webcarservices.services.com/", "DealerServicePort"), DealerService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DEALERSERVICE_EXCEPTION!= null) {
            throw DEALERSERVICE_EXCEPTION;
        }
        return DEALERSERVICE_WSDL_LOCATION;
    }

}
