package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection getConnection() {
        return connection;
    }

    private final Connection connection;
    public DBConnection(){
        try{
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/sms","postgres","Kothia@2724");

        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }

    }
}
