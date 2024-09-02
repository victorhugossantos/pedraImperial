package com.pedraimperial.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://35.199.72.145:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Imperial@2024";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("Conexao realizada com sucesso");
        } catch (SQLException e) {
            System.err.println("erro ao se conectar ao banco de dados: "  + e.getMessage());
            e.printStackTrace();
        }
    }

}
