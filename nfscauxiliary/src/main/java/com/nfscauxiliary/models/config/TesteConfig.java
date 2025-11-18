package com.nfscauxiliary.models.config;

import com.nfscauxiliary.models.entities.Address;

public class TesteConfig {
    public static void main(String[] args) {

        System.out.println("Teste de config executed");
        Address address = new Address(1, "123 Main St","Chesterfield", "198",
                                         "Springfield", "IL", "NY", "87393-192");
        System.out.println(address);
    }
}