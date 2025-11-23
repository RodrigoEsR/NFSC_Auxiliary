package com.nfscauxiliary.models.services;
import java.sql.*;
public class JDBCConnection {

    private Connection connection = null;
    private String url = "jdbc:sqlite:/home/rodrigo/Documentos/VSCode/NFSC_Auxiliary/auxiliary_db/nfscauxiliarydb/nfscauxiliarydb.db";


    public Connection connectionDB(){
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Sucesfull connection with auxiliaryDB!");
            return connection;
        }
        catch(SQLException e){
            System.out.println("Error: " + e);
        }
        return null;
    }

    public void closeConnection(){
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}


