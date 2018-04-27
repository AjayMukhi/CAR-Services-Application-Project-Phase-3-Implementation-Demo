
package com.services.webcarservices;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DealerService", targetNamespace = "http://webcarservices.services.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DealerService {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.services.webcarservices.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDealerDetailsById", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetDealerDetailsById")
    @ResponseWrapper(localName = "getDealerDetailsByIdResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetDealerDetailsByIdResponse")
    @Action(input = "http://webcarservices.services.com/DealerService/getDealerDetailsByIdRequest", output = "http://webcarservices.services.com/DealerService/getDealerDetailsByIdResponse")
    public List<User> getDealerDetailsById(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.Boolean
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createDelearUser", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.CreateDelearUser")
    @ResponseWrapper(localName = "createDelearUserResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.CreateDelearUserResponse")
    @Action(input = "http://webcarservices.services.com/DealerService/createDelearUserRequest", output = "http://webcarservices.services.com/DealerService/createDelearUserResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webcarservices.services.com/DealerService/createDelearUser/Fault/Exception")
    })
    public Boolean createDelearUser(
        @WebParam(name = "arg0", targetNamespace = "")
        User arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<com.services.webcarservices.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDealerList", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetDealerList")
    @ResponseWrapper(localName = "getDealerListResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetDealerListResponse")
    @Action(input = "http://webcarservices.services.com/DealerService/getDealerListRequest", output = "http://webcarservices.services.com/DealerService/getDealerListResponse")
    public List<User> getDealerList();

    /**
     * 
     * @param arg0
     * @throws Exception_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteDealerById", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.DeleteDealerById")
    @ResponseWrapper(localName = "deleteDealerByIdResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.DeleteDealerByIdResponse")
    @Action(input = "http://webcarservices.services.com/DealerService/deleteDealerByIdRequest", output = "http://webcarservices.services.com/DealerService/deleteDealerByIdResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webcarservices.services.com/DealerService/deleteDealerById/Fault/Exception")
    })
    public void deleteDealerById(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0)
        throws Exception_Exception
    ;

}
