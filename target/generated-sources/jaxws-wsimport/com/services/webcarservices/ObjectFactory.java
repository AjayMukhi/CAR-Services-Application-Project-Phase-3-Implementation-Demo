
package com.services.webcarservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.services.webcarservices package. 
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

    private final static QName _CreateOrderResponse_QNAME = new QName("http://webcarservices.services.com/", "createOrderResponse");
    private final static QName _CustOrder_QNAME = new QName("http://webcarservices.services.com/", "custOrder");
    private final static QName _GetOrderUserName_QNAME = new QName("http://webcarservices.services.com/", "getOrderUserName");
    private final static QName _GetOrderUserNameResponse_QNAME = new QName("http://webcarservices.services.com/", "getOrderUserNameResponse");
    private final static QName _GetOrderById_QNAME = new QName("http://webcarservices.services.com/", "getOrderById");
    private final static QName _GetOrderList_QNAME = new QName("http://webcarservices.services.com/", "getOrderList");
    private final static QName _CreateOrder_QNAME = new QName("http://webcarservices.services.com/", "createOrder");
    private final static QName _Exception_QNAME = new QName("http://webcarservices.services.com/", "Exception");
    private final static QName _GetOrderListResponse_QNAME = new QName("http://webcarservices.services.com/", "getOrderListResponse");
    private final static QName _GetOrderByIdResponse_QNAME = new QName("http://webcarservices.services.com/", "getOrderByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.services.webcarservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateOrder }
     * 
     */
    public CreateOrder createCreateOrder() {
        return new CreateOrder();
    }

    /**
     * Create an instance of {@link GetOrderById }
     * 
     */
    public GetOrderById createGetOrderById() {
        return new GetOrderById();
    }

    /**
     * Create an instance of {@link GetOrderList }
     * 
     */
    public GetOrderList createGetOrderList() {
        return new GetOrderList();
    }

    /**
     * Create an instance of {@link CreateOrderResponse }
     * 
     */
    public CreateOrderResponse createCreateOrderResponse() {
        return new CreateOrderResponse();
    }

    /**
     * Create an instance of {@link CustOrder }
     * 
     */
    public CustOrder createCustOrder() {
        return new CustOrder();
    }

    /**
     * Create an instance of {@link GetOrderUserName }
     * 
     */
    public GetOrderUserName createGetOrderUserName() {
        return new GetOrderUserName();
    }

    /**
     * Create an instance of {@link GetOrderUserNameResponse }
     * 
     */
    public GetOrderUserNameResponse createGetOrderUserNameResponse() {
        return new GetOrderUserNameResponse();
    }

    /**
     * Create an instance of {@link GetOrderByIdResponse }
     * 
     */
    public GetOrderByIdResponse createGetOrderByIdResponse() {
        return new GetOrderByIdResponse();
    }

    /**
     * Create an instance of {@link GetOrderListResponse }
     * 
     */
    public GetOrderListResponse createGetOrderListResponse() {
        return new GetOrderListResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webcarservices.services.com/", name = "createOrderResponse")
    public JAXBElement<CreateOrderResponse> createCreateOrderResponse(CreateOrderResponse value) {
        return new JAXBElement<CreateOrderResponse>(_CreateOrderResponse_QNAME, CreateOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webcarservices.services.com/", name = "custOrder")
    public JAXBElement<CustOrder> createCustOrder(CustOrder value) {
        return new JAXBElement<CustOrder>(_CustOrder_QNAME, CustOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderUserName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webcarservices.services.com/", name = "getOrderUserName")
    public JAXBElement<GetOrderUserName> createGetOrderUserName(GetOrderUserName value) {
        return new JAXBElement<GetOrderUserName>(_GetOrderUserName_QNAME, GetOrderUserName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderUserNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webcarservices.services.com/", name = "getOrderUserNameResponse")
    public JAXBElement<GetOrderUserNameResponse> createGetOrderUserNameResponse(GetOrderUserNameResponse value) {
        return new JAXBElement<GetOrderUserNameResponse>(_GetOrderUserNameResponse_QNAME, GetOrderUserNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webcarservices.services.com/", name = "getOrderById")
    public JAXBElement<GetOrderById> createGetOrderById(GetOrderById value) {
        return new JAXBElement<GetOrderById>(_GetOrderById_QNAME, GetOrderById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webcarservices.services.com/", name = "getOrderList")
    public JAXBElement<GetOrderList> createGetOrderList(GetOrderList value) {
        return new JAXBElement<GetOrderList>(_GetOrderList_QNAME, GetOrderList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webcarservices.services.com/", name = "createOrder")
    public JAXBElement<CreateOrder> createCreateOrder(CreateOrder value) {
        return new JAXBElement<CreateOrder>(_CreateOrder_QNAME, CreateOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webcarservices.services.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webcarservices.services.com/", name = "getOrderListResponse")
    public JAXBElement<GetOrderListResponse> createGetOrderListResponse(GetOrderListResponse value) {
        return new JAXBElement<GetOrderListResponse>(_GetOrderListResponse_QNAME, GetOrderListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webcarservices.services.com/", name = "getOrderByIdResponse")
    public JAXBElement<GetOrderByIdResponse> createGetOrderByIdResponse(GetOrderByIdResponse value) {
        return new JAXBElement<GetOrderByIdResponse>(_GetOrderByIdResponse_QNAME, GetOrderByIdResponse.class, null, value);
    }

}
