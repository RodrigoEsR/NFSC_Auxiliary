package com.nfscauxiliary.models.entities;

import javax.sql.*;
import java.util.*;

public class Address {
    private Integer idAddress;
    private String street;
    private String district;
    private String residence_number;
    private String city;
    private String state;
    private String uf;
    private String zipCode;

    public Address(String street) {
        this.street = street;
    }
    public Address(Integer idAddress, String street, String district, String residence_number, 
                    String city, String state, String uf, String zipCode) {
        this.idAddress = idAddress;
        this.street = street;
        this.residence_number = residence_number;
        this.district = district;
        this.city = city;
        this.state = state;
        this.uf = uf;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address idAddress=" + idAddress 
                + "\n street = " + street 
                + "\n district = " + district
                + "\n residence number = " + residence_number 
                + "\n city =" + city 
                + "\n state = " + state 
                + "\n uf = " + uf
                + "\n zipCode = " + zipCode + "]";
    }

    

}
