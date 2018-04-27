
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
@WebService(name = "CarService", targetNamespace = "http://webcarservices.services.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CarService {


    /**
     * 
     * @return
     *     returns java.util.List<com.services.webcarservices.Car>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCarChevroletList", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarChevroletList")
    @ResponseWrapper(localName = "getCarChevroletListResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarChevroletListResponse")
    @Action(input = "http://webcarservices.services.com/CarService/getCarChevroletListRequest", output = "http://webcarservices.services.com/CarService/getCarChevroletListResponse")
    public List<Car> getCarChevroletList();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.services.webcarservices.Car>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCarDetailsById", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarDetailsById")
    @ResponseWrapper(localName = "getCarDetailsByIdResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarDetailsByIdResponse")
    @Action(input = "http://webcarservices.services.com/CarService/getCarDetailsByIdRequest", output = "http://webcarservices.services.com/CarService/getCarDetailsByIdResponse")
    public List<Car> getCarDetailsById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @return
     *     returns java.util.List<com.services.webcarservices.Car>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCarHyundaiList", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarHyundaiList")
    @ResponseWrapper(localName = "getCarHyundaiListResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarHyundaiListResponse")
    @Action(input = "http://webcarservices.services.com/CarService/getCarHyundaiListRequest", output = "http://webcarservices.services.com/CarService/getCarHyundaiListResponse")
    public List<Car> getCarHyundaiList();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.services.webcarservices.Car>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCarDetailsByproductId", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarDetailsByproductId")
    @ResponseWrapper(localName = "getCarDetailsByproductIdResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarDetailsByproductIdResponse")
    @Action(input = "http://webcarservices.services.com/CarService/getCarDetailsByproductIdRequest", output = "http://webcarservices.services.com/CarService/getCarDetailsByproductIdResponse")
    public List<Car> getCarDetailsByproductId(
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
    @RequestWrapper(localName = "createCar", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.CreateCar")
    @ResponseWrapper(localName = "createCarResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.CreateCarResponse")
    @Action(input = "http://webcarservices.services.com/CarService/createCarRequest", output = "http://webcarservices.services.com/CarService/createCarResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webcarservices.services.com/CarService/createCar/Fault/Exception")
    })
    public Boolean createCar(
        @WebParam(name = "arg0", targetNamespace = "")
        Car arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param id
     * @return
     *     returns com.services.webcarservices.Car
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCarById", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarById")
    @ResponseWrapper(localName = "getCarByIdResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarByIdResponse")
    @Action(input = "http://webcarservices.services.com/CarService/getCarByIdRequest", output = "http://webcarservices.services.com/CarService/getCarByIdResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webcarservices.services.com/CarService/getCarById/Fault/Exception")
    })
    public Car getCarById(
        @WebParam(name = "id", targetNamespace = "")
        Integer id)
        throws Exception_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<com.services.webcarservices.Car>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCarBuickList", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarBuickList")
    @ResponseWrapper(localName = "getCarBuickListResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarBuickListResponse")
    @Action(input = "http://webcarservices.services.com/CarService/getCarBuickListRequest", output = "http://webcarservices.services.com/CarService/getCarBuickListResponse")
    public List<Car> getCarBuickList();

    /**
     * 
     * @return
     *     returns java.util.List<com.services.webcarservices.Car>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCarGMCList", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarGMCList")
    @ResponseWrapper(localName = "getCarGMCListResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarGMCListResponse")
    @Action(input = "http://webcarservices.services.com/CarService/getCarGMCListRequest", output = "http://webcarservices.services.com/CarService/getCarGMCListResponse")
    public List<Car> getCarGMCList();

    /**
     * 
     * @return
     *     returns java.util.List<com.services.webcarservices.Car>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCarList", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarList")
    @ResponseWrapper(localName = "getCarListResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarListResponse")
    @Action(input = "http://webcarservices.services.com/CarService/getCarListRequest", output = "http://webcarservices.services.com/CarService/getCarListResponse")
    public List<Car> getCarList();

    /**
     * 
     * @return
     *     returns java.util.List<com.services.webcarservices.Car>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCarToyotaList", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarToyotaList")
    @ResponseWrapper(localName = "getCarToyotaListResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.GetCarToyotaListResponse")
    @Action(input = "http://webcarservices.services.com/CarService/getCarToyotaListRequest", output = "http://webcarservices.services.com/CarService/getCarToyotaListResponse")
    public List<Car> getCarToyotaList();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateCarById", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.UpdateCarById")
    @ResponseWrapper(localName = "updateCarByIdResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.UpdateCarByIdResponse")
    @Action(input = "http://webcarservices.services.com/CarService/updateCarByIdRequest", output = "http://webcarservices.services.com/CarService/updateCarByIdResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webcarservices.services.com/CarService/updateCarById/Fault/Exception")
    })
    public boolean updateCarById(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Car arg1)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws Exception_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteCarById", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.DeleteCarById")
    @ResponseWrapper(localName = "deleteCarByIdResponse", targetNamespace = "http://webcarservices.services.com/", className = "com.services.webcarservices.DeleteCarByIdResponse")
    @Action(input = "http://webcarservices.services.com/CarService/deleteCarByIdRequest", output = "http://webcarservices.services.com/CarService/deleteCarByIdResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://webcarservices.services.com/CarService/deleteCarById/Fault/Exception")
    })
    public void deleteCarById(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0)
        throws Exception_Exception
    ;

}
