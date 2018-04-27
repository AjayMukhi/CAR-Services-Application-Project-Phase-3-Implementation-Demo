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
@Table(name = "cart", catalog = "test", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c")
    , @NamedQuery(name = "Cart.findById", query = "SELECT c FROM Cart c WHERE c.id = :id")
    , @NamedQuery(name = "Cart.findByPartid", query = "SELECT c FROM Cart c WHERE c.partid = :partid")
    , @NamedQuery(name = "Cart.findByPartname", query = "SELECT c FROM Cart c WHERE c.partname = :partname")
    , @NamedQuery(name = "Cart.findByType", query = "SELECT c FROM Cart c WHERE c.type = :type")
    , @NamedQuery(name = "Cart.findByDescription", query = "SELECT c FROM Cart c WHERE c.description = :description")
    , @NamedQuery(name = "Cart.findByRetailPrice", query = "SELECT c FROM Cart c WHERE c.retailPrice = :retailPrice")
    , @NamedQuery(name = "Cart.findByPrice", query = "SELECT c FROM Cart c WHERE c.price = :price")
    , @NamedQuery(name = "Cart.findByQuantity", query = "SELECT c FROM Cart c WHERE c.quantity = :quantity")
    , @NamedQuery(name = "Cart.findByColor", query = "SELECT c FROM Cart c WHERE c.color = :color")
    , @NamedQuery(name = "Cart.findBySku", query = "SELECT c FROM Cart c WHERE c.sku = :sku")
    , @NamedQuery(name = "Cart.findByImageURL", query = "SELECT c FROM Cart c WHERE c.imageURL = :imageURL")
    , @NamedQuery(name = "Cart.findByUserid", query = "SELECT c FROM Cart c WHERE c.userid = :userid")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "partid")
    private String partid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "partname")
    private String partname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "retail_price")
    private double retailPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SKU")
    private String sku;
    @Size(max = 40)
    @Column(name = "imageURL")
    private String imageURL;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "userid")
    private String userid;

    public Cart() {
    }

    public Cart(Integer id) {
        this.id = id;
    }

    public Cart(Integer id, String partid, String partname, String type, String description, double retailPrice, double price, int quantity, String color, String sku, String userid) {
        this.id = id;
        this.partid = partid;
        this.partname = partname;
        this.type = type;
        this.description = description;
        this.retailPrice = retailPrice;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.sku = sku;
        this.userid = userid;
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

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", partid=" + partid + ", partname=" + partname + ", type=" + type + ", description=" + description + ", retailPrice=" + retailPrice + ", price=" + price + ", quantity=" + quantity + ", color=" + color + ", sku=" + sku + ", imageURL=" + imageURL + ", userid=" + userid + '}';
    }




    
}
