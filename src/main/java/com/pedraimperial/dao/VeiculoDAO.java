package com.pedraimperial.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pedraimperial.model.Veiculo;
import com.pedraimperial.util.DBUtils;
import com.pedraimperial.util.Database;

public class VeiculoDAO {
    
    // Metodo para adiconar um veiculo 
    public static boolean addVeiculo(Veiculo veiculo)  {
        String sql = "INSERT INTO veiculos (placa, modelo, cor, idMorador) VALEUS (?, ?, ?, ?)";
        boolean sucesso = false;
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = Database.getConnection();
            st = conn.prepareStatement(sql);

            st.setString(1, veiculo.getPlaca());
            st.setString(2, veiculo.getModelo());
            st.setString(3, veiculo.getCor());
            st.setInt(4, veiculo.getIdMorador());

            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0 )  {
                sucesso = true;
                System.out.println("Veiculo adicionado com sucesso");
            }

        } catch (SQLException e){
            System.err.println("Erro ao adiconar o veiculo: " + e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, st, null);
        }

        return sucesso;
    }

    // Metodo para buscar veiculo por placa
    public static Veiculo getVeiculoByPlaca(String placa) {
        String sql = "SELECT * FROM veiculos WHERE placa = ?";
        Veiculo veiculo = null;

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = Database.getConnection();
            st = conn.prepareStatement(sql);

            st.setString(1, placa);
            rs = st.executeQuery();

            if (rs.next()) {
                String modelo = rs.getString("Modelo");
                String cor = rs.getString("Cor");
                int idMorador = rs.getInt("idMorador");

                veiculo = new Veiculo(placa, modelo, cor, idMorador);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar veiculo" + e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, st, rs);
        }

        return veiculo;
    }

    // metodo para buscar todos os veiculos no banco de dados

    public static List<Veiculo> getAllVeiculos() {
        String sql = "SELECT * FROM veiculos";
        List<Veiculo> veiculos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = Database.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()){
                String placa = rs.getString("placa");
                String modelo = rs.getString("modelo");
                String cor = rs.getString("cor");
                int idMorador = rs.getInt("idMorador");

                Veiculo veiculo = new Veiculo(placa, modelo, cor, idMorador);
                veiculos.add(veiculo);

            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar veiculos: " + e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, st, rs);
        }

        return veiculos;
    }

    // metodo para deletar um veiculos 

    public static boolean deleteVeiculo(String placa) {
        String sql = "DELETE FROM veiculos WHERE placa = ?";
        boolean sucesso = false;

        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = Database.getConnection();
            st = conn.prepareStatement(sql);

            st.setString(1, placa);

            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0) {
                sucesso = true;
                System.out.println("Veiculo deletado com sucesso!");
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao deletar veiculo" + e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, st, null);
        }

        return sucesso;
    }
    
}
