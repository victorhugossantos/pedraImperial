package com.pedraimperial.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

    public static void closeConnection(Connection conn, PreparedStatement st, ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            System.err.println("Erro ao fechar o ResultSet" + e.getMessage());
        }

        try {
            if (st != null) st.close();
        } catch (SQLException e) {
            System.err.println("Erro ao fechar o PreparedStatement: " + e.getMessage());
        }

        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao fechar o Connection: " + e.getMessage());
        }
    }
    
}