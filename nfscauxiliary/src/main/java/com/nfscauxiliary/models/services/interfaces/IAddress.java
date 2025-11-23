package com.nfscauxiliary.models.services.interfaces;

import com.nfscauxiliary.models.entities.Address;
import com.nfscauxiliary.models.services.exceptions.ExceptionAddress;

public interface IAddress {
    String setStreet(String a) throws ExceptionAddress;
    String setDistrict(String a) throws ExceptionAddress;
    String setResidenceNumber(String a) throws ExceptionAddress;
    String setCity(String a) throws ExceptionAddress;
    String setUF(String a) throws ExceptionAddress;
    String setZipCode(String a) throws ExceptionAddress;
    String setState(String a) throws ExceptionAddress;

    Address createAddress();
    
}
