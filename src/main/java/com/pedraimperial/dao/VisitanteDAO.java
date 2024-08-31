package com.pedraimperial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.pedraimperial.model.Visitante;
import com.pedraimperial.util.DBUtils;
import com.pedraimperial.util.Database;

public class VisitanteDAO {
    
    // inserir novo visitante no banco de dados
    
    public static boolean addVisitante(Visitante visitante) {
        String sql = "INSERT INTO visitantes (name, cpf, data_entrada, idMorador) VALUES (?, ?, ?, ?)";
        boolean sucesso = false;
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = Database.getConnection();
            st = conn.prepareStatement(sql);

            st.setString(1, visitante.getNome());
            st.setString(2, visitante.getCpf());
            st.setTimestamp(3, visitante.getDataEntrada());
            st.setInt(4, visitante.getIdMorador());

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0 ) {
                sucesso = true;
                System.out.println("Visitante inserido com sucesso!");
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao inserir visitante: " + e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, st, null);
        }
        return sucesso;
    }

    // metodo para buscar um visitante por Id 

    public static Visitante getVisitanteById(int id ) {
        String sql = "SELECT * FROM moradores WHERE id = ?";
        Visitante visitante = null;

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;

        try {
            conn = Database.getConnection();
            st = conn.prepareStatement(sql);

            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Timestamp dataEntrada = rs.getTimestamp("data_entrada");
                Timestamp dataSaida = rs.getTimestamp("data_saida");
                int idMorador = rs.getInt("idMorador");

                visitante = new Visitante(nome, cpf, dataEntrada, dataSaida, idMorador);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar visitante: " + e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, st, null);
        }

        return visitante;

    }

    // metodo para buscar todos os visitantes pela data


    // metodo para listar todos os visitantes 


}