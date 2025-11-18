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
        return "Address [idAddress=" + idAddress + ", street=" + street + ", district=" + district
                + ", residence_number=" + residence_number + ", city=" + city + ", state=" + state + ", uf=" + uf
                + ", zipCode=" + zipCode + "]";
    }

    

}
