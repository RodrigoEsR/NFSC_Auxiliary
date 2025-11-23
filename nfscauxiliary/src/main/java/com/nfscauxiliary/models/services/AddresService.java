package com.nfscauxiliary.models.services;

import java.util.Scanner;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.io.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.nfscauxiliary.models.entities.Address;
import com.nfscauxiliary.models.services.exceptions.ExceptionAddress;
import com.nfscauxiliary.models.services.interfaces.IAddress;

public class AddresService implements IAddress {
    Scanner sc = new Scanner(System.in);


    public String validateZipCode(String zipCode) {
        try {
            zipCode = zipCode.replaceAll("[^0-9]", "");
            System.out.println(zipCode);
            if (zipCode.length() != 8) {
                throw new ExceptionAddress("Error: CEP must have 8 digits.");
            }
            String url = "https://viacep.com.br/ws/" + zipCode + "/json/";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                                  .uri(URI.create(url))
                                  .header("User-agent", "NfscAuxiliaryApp/1.0 (nfscauxiliary@gmail.com)")
                                  .GET()
                                  .build();
            HttpResponse<String> response = 
                client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return json;
        }
        catch (Exception e) {
            return " ";
        }
    }

    public Address autoFillByZipCode(String zipCode) {
       
        String json = validateZipCode(zipCode);;

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        String street = jsonObject.get("logradouro").getAsString();
        String district = jsonObject.get("bairro").getAsString();
        String city = jsonObject.get("localidade").getAsString();
        String state = jsonObject.get("uf").getAsString();

        System.out.println("The address have house numvber? (y/n): ");
        String hasNumber = sc.nextLine();
        if (hasNumber.equalsIgnoreCase("y")) {
            System.out.println("Insira o número da residência: ");
            String residenceNumber = sc.nextLine();
        }
        else {
            String notNumber = "S/N";
        }
        System.out.println("Auto preenchimento realizado com sucesso!");
        

        //setCity(city);
        //setState(state);
        //setStreet(street);  
        //setDistrict(district);
        //setUF(state);  
        //setResidenceNumber(hasNumber);

        Address address = new Address(setStreet(street));
        return address;
        
    }

    public boolean confirmAddres(String address){
        try{
            String encoded = URLEncoder.encode(address, StandardCharsets.UTF_8);
            String url = "https://nominatim.openstreetmap.org/search?q=" + encoded +
                         "&format=json&limit=1";
            
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                                  .uri(URI.create(url))
                                  .header("User-agent", "NfscAuxiliaryApp/1.0 (nfscauxiliary@gmail.com)")
                                  .GET()
                                  .build();
            
            HttpResponse<String> response = 
                client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            return !json.trim().equals("[]");

        }
        catch (Exception e) {
            return false;
        }

    }

    @Override
    public String setStreet(String streetreceived) throws ExceptionAddress {
        String street;
        System.out.println("Insira a rua: ");
        if (streetreceived.equals(null)) {
            street = sc.nextLine();
        }
        street = streetreceived;
        System.out.println("Rua recebida: " + street);
        boolean specialCharInText = street.matches(".*[^\\p{L}0-9 \\-].*");
        if(street.length() > 100){
            throw new ExceptionAddress("Error: Char number limit excepted");
        }
        else if (specialCharInText) {
            throw new ExceptionAddress("Error: Special chars in text, remove for continue.");
        } 
        else {
           return street; 
        }

        
    }

    @Override
    public String setDistrict(String district) throws ExceptionAddress {
        throw new ExceptionAddress("Unimplemented method 'setDistrict'");
    }

    @Override
    public String setResidenceNumber(String residenceNumber) throws ExceptionAddress {
        throw new ExceptionAddress("Unimplemented method 'setResidenceNumber'");
    }

    @Override
    public String setCity(String city) throws ExceptionAddress {
        throw new ExceptionAddress("Unimplemented method 'setCity'");
    }

    @Override
    public String setUF(String uf) throws ExceptionAddress {
        throw new ExceptionAddress("Unimplemented method 'setUF'");
    }

    @Override
    public String setZipCode(String zipCode) throws ExceptionAddress {
        System.out.println("Insira o CEP: ");
        String zipcode = zipCode;
        validateZipCode(zipcode);
        return zipcode;
    }

    @Override
    public String setState(String state) throws ExceptionAddress {
        throw new ExceptionAddress("Unimplemented method 'setState'");
    }

    @Override
    public Address createAddress() throws ExceptionAddress {
        throw new ExceptionAddress("Unimplemented method 'createAddress'");
    }
    
}
