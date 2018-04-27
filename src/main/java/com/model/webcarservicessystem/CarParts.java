/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.webcarservicessystem;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author AjayMukhi
 */
@Entity
public class CarParts implements Serializable {
    
    @Id
    private Integer id;
    private String partid;
    private String partName;
    private String type;
    private String description;    
    private double retailPrice;   
    private double price;    
    private String color;    
    private String SKU; 
    private String stock;

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
    private String quantityinstock;    
    private String imageURL;
    
    
    
    public CarParts(){
    
    }

    public CarParts(Integer id, String partid, String partName, String type, String description, double retailPrice, double price, String color, String SKU, String stock, String quantityinstock, String imageURL) {
        this.id = id;
        this.partid = partid;
        this.partName = partName;
        this.type = type;
        this.description = description;
        this.retailPrice = retailPrice;
        this.price = price;
        this.color = color;
        this.SKU = SKU;
        this.stock = stock;
        this.quantityinstock = quantityinstock;
        this.imageURL = imageURL;
    }

    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartid() {
        return partid;
    }

    public void setPartid(String partid) {
        this.partid = partid;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getQuantityinstock() {
        return quantityinstock;
    }

    public void setQuantityinstock(String quantityinstock) {
        this.quantityinstock = quantityinstock;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "CarParts{" + "id=" + id + ", partid=" + partid + ", partName=" + partName + ", type=" + type + ", description=" + description + ", retailPrice=" + retailPrice + ", price=" + price + ", color=" + color + ", SKU=" + SKU + ", stock=" + stock + ", quantityinstock=" + quantityinstock + ", imageURL=" + imageURL + '}';
    }

    
    
}
