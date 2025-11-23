package com.nfscauxiliary.models.dao.repositoryes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.sqlite.JDBC;

import com.nfscauxiliary.models.entities.Address;
import com.nfscauxiliary.models.services.JDBCConnection;

public class AddresRepositoryDAO {
    private JDBCConnection jdbcConnection = new JDBCConnection();

    String insertAddres = "INSERT INTO address (id, street, number, neighborhood, city, state, country, zip_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    public AddresRepositoryDAO() {
    }

    public void insertAddress(Address address) throws SQLException {
        try(Connection conn = jdbcConnection.connectionDB()) {
            PreparedStatement stmt = conn.prepareStatement(insertAddres);
            stmt.setString(2, insertAddres);
            stmt.setString(3, insertAddres);
            stmt.setString(4, insertAddres);
            stmt.setString(5, insertAddres);
            stmt.setString(6, insertAddres);
            stmt.setString(7, insertAddres);
            stmt.executeUpdate();

            
        }
    }
    
}
