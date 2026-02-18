package by.tms.calculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
public static Connection instance;
    public static Connection getConnection() {
        try {
            if (instance == null) {
                return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
            }
            return instance;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}