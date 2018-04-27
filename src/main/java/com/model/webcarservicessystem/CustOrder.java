/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.webcarservicessystem;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AjayMukhi
 */
@Entity
@Table(name = "custorder", catalog = "test", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustOrder.findAll", query = "SELECT c FROM CustOrder c")
    , @NamedQuery(name = "CustOrder.findById", query = "SELECT c FROM CustOrder c WHERE c.id = :id")
    , @NamedQuery(name = "CustOrder.findByOrderid", query = "SELECT c FROM CustOrder c WHERE c.orderid = :orderid")
    , @NamedQuery(name = "CustOrder.findByItemid", query = "SELECT c FROM CustOrder c WHERE c.itemid = :itemid")
    , @NamedQuery(name = "CustOrder.findByItemname", query = "SELECT c FROM CustOrder c WHERE c.itemname = :itemname")
    , @NamedQuery(name = "CustOrder.findByDescription", query = "SELECT c FROM CustOrder c WHERE c.description = :description")
    , @NamedQuery(name = "CustOrder.findByQuantity", query = "SELECT c FROM CustOrder c WHERE c.quantity = :quantity")
    , @NamedQuery(name = "CustOrder.findByPrice", query = "SELECT c FROM CustOrder c WHERE c.price = :price")
    , @NamedQuery(name = "CustOrder.findByUserid", query = "SELECT c FROM CustOrder c WHERE c.userid = :userid")
    , @NamedQuery(name = "CustOrder.findByUsername", query = "SELECT c FROM CustOrder c WHERE c.username = :username")
    , @NamedQuery(name = "CustOrder.findByPhone", query = "SELECT c FROM CustOrder c WHERE c.phone = :phone")
    , @NamedQuery(name = "CustOrder.findByPaymentid", query = "SELECT c FROM CustOrder c WHERE c.paymentid = :paymentid")
    , @NamedQuery(name = "CustOrder.findByPaymenttype", query = "SELECT c FROM CustOrder c WHERE c.paymenttype = :paymenttype")
    , @NamedQuery(name = "CustOrder.findByCardnumber", query = "SELECT c FROM CustOrder c WHERE c.cardnumber = :cardnumber")
    , @NamedQuery(name = "CustOrder.findByExpirationdate", query = "SELECT c FROM CustOrder c WHERE c.expirationdate = :expirationdate")
    , @NamedQuery(name = "CustOrder.findByCvvcode", query = "SELECT c FROM CustOrder c WHERE c.cvvcode = :cvvcode")
    , @NamedQuery(name = "CustOrder.findByOrderdate", query = "SELECT c FROM CustOrder c WHERE c.orderdate = :orderdate")
    , @NamedQuery(name = "CustOrder.findByAddress", query = "SELECT c FROM CustOrder c WHERE c.address = :address")
    , @NamedQuery(name = "CustOrder.findByCity", query = "SELECT c FROM CustOrder c WHERE c.city = :city")
    , @NamedQuery(name = "CustOrder.findByState", query = "SELECT c FROM CustOrder c WHERE c.state = :state")
    , @NamedQuery(name = "CustOrder.findByZipcode", query = "SELECT c FROM CustOrder c WHERE c.zipcode = :zipcode")
    , @NamedQuery(name = "CustOrder.findByCountry", query = "SELECT c FROM CustOrder c WHERE c.country = :country")
    , @NamedQuery(name = "CustOrder.findByPlacedby", query = "SELECT c FROM CustOrder c WHERE c.placedby = :placedby")})
public class CustOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "orderid")
    private String orderid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "itemid")
    private String itemid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "itemname")
    private String itemname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "userid")
    private String userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paymentid")
    private int paymentid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "paymenttype")
    private String paymenttype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cardnumber")
    private String cardnumber;
    @Size(max = 20)
    @Column(name = "expirationdate")
    private String expirationdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cvvcode")
    private int cvvcode;
    @Size(max = 20)
    @Column(name = "orderdate")
    private String orderdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "zipcode")
    private String zipcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "placedby")
    private String placedby;

    public CustOrder() {
    }

    public CustOrder(Integer id) {
        this.id = id;
    }

    public CustOrder(Integer id, String orderid, String itemid, String itemname, String description, int quantity, double price, String userid, String username, String phone, int paymentid, String paymenttype, String cardnumber, int cvvcode, String address, String city, String state, String zipcode, String country, String placedby) {
        this.id = id;
        this.orderid = orderid;
        this.itemid = itemid;
        this.itemname = itemname;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.userid = userid;
        this.username = username;
        this.phone = phone;
        this.paymentid = paymentid;
        this.paymenttype = paymenttype;
        this.cardnumber = cardnumber;
        this.cvvcode = cvvcode;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
        this.placedby = placedby;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public int getCvvcode() {
        return cvvcode;
    }

    public void setCvvcode(int cvvcode) {
        this.cvvcode = cvvcode;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlacedby() {
        return placedby;
    }

    public void setPlacedby(String placedby) {
        this.placedby = placedby;
    }

    @Override
    public String toString() {
        return "CustOrder{" + "id=" + id + ", orderid=" + orderid + ", itemid=" + itemid + ", itemname=" + itemname + ", description=" + description + ", quantity=" + quantity + ", price=" + price + ", userid=" + userid + ", username=" + username + ", phone=" + phone + ", paymentid=" + paymentid + ", paymenttype=" + paymenttype + ", cardnumber=" + cardnumber + ", expirationdate=" + expirationdate + ", cvvcode=" + cvvcode + ", orderdate=" + orderdate + ", address=" + address + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", country=" + country + ", placedby=" + placedby + '}';
    }

    
    
    
}
