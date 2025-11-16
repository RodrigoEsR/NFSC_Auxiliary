package com.nfscauxiliary.models.config;

import com.nfscauxiliary.models.entities.Address;

public class TesteConfig {
    public static void main(String[] args) {

        System.out.println("Teste de configuraçao executed");
        Address address = new Address(1, "123 Main St", "Springfield", "IL", "62701", "USA");
        System.out.println(address);
    }
}