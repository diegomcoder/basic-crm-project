package com.diegomd.basiccrmproject.repository;

import com.diegomd.basiccrmproject.shared.constants.Constants;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null)
            instance = new DatabaseConnection();
        return instance;
    }

    private DatabaseConnection() {
        try {
            this.createConnection();
        } catch (SQLException e) {
            System.out.println("SQL Error: " +  e.getMessage());
        }
    }

    private void createConnection() throws SQLException {
        connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/crm_db", "root", Constants.DATABASE_PASSWORD);
        connection.setAutoCommit(true);
    }
}
