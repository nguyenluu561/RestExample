/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.axonactive.training.sniffer.data.bom;

import java.util.Date;

/**
 *
 * @author nvmuon
 */
public class Sniffer {
    
    private String productCode;
    
    private String name;
    
    private String address;
    
    private String type;
    
    private Date registerDate; 

    public Sniffer() {
    }
    
    

    public Sniffer(String productCode, String name, String address, String type, Date registerDate) {
        this.productCode = productCode;
        this.name = name;
        this.address = address;
        this.type = type;
        this.registerDate = registerDate;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
