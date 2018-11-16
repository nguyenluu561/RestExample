/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axonactive.training.sniffer.entity.restricted;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author nvmuon
 */
@Entity
@Table(name = "db_sniffer")
public class SnifferEntity extends GenericEntity implements Serializable {
    
    @Column(name = "product_code", length = 10, nullable = false, unique = true)
    private String productCode;
    
    @Column(name = "sniffer_name", length = 100)
    private String name;
    
    @Column(name = "address", length = 1000)
    private String address;
    
    @Column(name = "product_type", nullable = false)
    private ProductType type;
    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date registerDate;

    public SnifferEntity() {
    }
    
    public SnifferEntity(String productCode, String name, String address, ProductType type) {
        this.productCode = productCode;
        this.name = name;
        this.address = address;
        this.type = type;
        this.registerDate = new Date();
    }


    
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Sniffer{" + "productCode=" + productCode + ", name=" + name + ", address=" + address + ", type=" + type + ", registerDate=" + registerDate + '}';
    }
    
    
}
