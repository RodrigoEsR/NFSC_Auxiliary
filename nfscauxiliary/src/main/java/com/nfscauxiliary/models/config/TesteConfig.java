package com.nfscauxiliary.models.config;

import com.nfscauxiliary.models.entities.Address;
import com.nfscauxiliary.models.services.AddresService;
import com.nfscauxiliary.models.services.JDBCConnection;

import java.sql.*;

public class TesteConfig {
    public static void main(String[] args) {
        JDBCConnection jdbcConnection = new JDBCConnection();

        try (Connection conn = jdbcConnection.connectionDB() ) {
            AddresService adserv = new AddresService();
            System.out.println("Teste de auto preenchimento de endereço pelo CEP:");
            Address address = adserv.autoFillByZipCode("01001-000");
            System.out.println(address.toString());
            
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            jdbcConnection.closeConnection();
        }

    }
}