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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AjayMukhi
 */

@Entity
@Table(name = "car")
public class Car implements Serializable {
    
    
    @Id
    private Integer id;
    private String productId;      
    private String productName;
    private String model;
    private String vin;
    private String description;    
    private String displayUnder;    
    private double retailPrice;   
    private double price;    
    private String engine;    
    private String body;    
    private String trans;    
    private String year;       
    private String interior;    
    private String exterior;
    private String imageURL;
    
    
    public Car() {
    }


    public Car(Integer id, String productId, String productName, String model, String vin, String description, String displayUnder, double retailPrice, double price, String engine, String body, String trans, String year, String interior, String exterior, String imageURL) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.model = model;
        this.vin = vin;
        this.description = description;
        this.displayUnder = displayUnder;
        this.retailPrice = retailPrice;
        this.price = price;
        this.engine = engine;
        this.body = body;
        this.trans = trans;
        this.year = year;
        this.interior = interior;
        this.exterior = exterior;
        this.imageURL = imageURL;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayUnder() {
        return displayUnder;
    }

    public void setDisplayUnder(String displayUnder) {
        this.displayUnder = displayUnder;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getExterior() {
        return exterior;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
   
    
    
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", productId=" + productId + ", productName=" + productName + ", model=" + model + ", vin=" + vin + ", description=" + description + ", displayUnder=" + displayUnder + ", retailPrice=" + retailPrice + ", price=" + price + ", engine=" + engine + ", body=" + body + ", trans=" + trans + ", year=" + year + ", interior=" + interior + ", exterior=" + exterior + ", imageURL=" + imageURL + '}';
    }
    
    
    
    
}
