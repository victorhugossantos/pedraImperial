package com.pedraimperial.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pedraimperial.model.Morador;
import com.pedraimperial.util.DBUtils;
import com.pedraimperial.util.Database;

public class MoradorDAO {    
    // metodo para adicionar um morador ao banco de dados
    public static boolean addMorador(Morador morador){
        String sql = "INSERT INTO moradores (nome, cpf, telefone, email, bloco, unidade) VALUES (?, ?, ?, ?, ?, ?)";
        boolean sucesso = false;
        Connection conn = null;
        PreparedStatement st = null;

        try {

            conn = Database.getConnection();
            st = conn.prepareStatement(sql);
            
            //parametros para a intruducao no sql

            st.setString(1, morador.getNome());
            st.setString(2, morador.getCpf());
            st.setString(3, morador.getTelefone());
            st.setString(4, morador.getEmail());
            st.setString(5, morador.getBloco());
            st.setInt(6, morador.getUnidade());

            int linhasAfetadas = st.executeUpdate();

            if(linhasAfetadas > 0) {
                System.out.println("Morador: " + morador.getNome() + "inserido com sucesso");
                sucesso = true;
            } else {
                System.err.println("Falha ao inserir o morador: " + morador.getNome());
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao tentar inserir o morador: " + e.getMessage());
                } finally {
            DBUtils.closeConnection(conn, st, null);
        }

        return sucesso;
    }

    public static Morador getMoradorById(int id) {
        String sql = "SELECT * FROM moradores WHERE id = ?";
        Morador morador = null;
        // conexoes com o banco de dados
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
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String bloco = rs.getString("bloco");
                int unidade = rs.getInt("unidade");

                // Criando um objeto morador com os dados recuperados 
                morador = new Morador(nome, cpf, telefone, email, bloco, unidade);   
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar morador com ID " + ":" + e.getMessage());
        } finally {
            // Fechando a conexao com o banco de dados
            DBUtils.closeConnection(conn, st, null);
        }

        return morador;

    }

    // metodo para listar todos os moradores

    public static List<Morador> getAllMoradores() {
        String sql = "SELECT * FROM moradores";
        List<Morador> moradores = new ArrayList<>();

        // conexoes com o banco de dados
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;


        try {

            conn = Database.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String bloco = rs.getString("bloco");
                int unidade = rs.getInt("unidade");

                // criando o ojeto para armazenar cada morador do banco de dados
                Morador morador = new Morador(id, nome, cpf, telefone, email, bloco, unidade);
                moradores.add(morador);
            }


        } catch (SQLException e ){
            System.err.println("Erro ao buscar os morados " + e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, st, rs);
        }

        return moradores;
    }

    public static boolean  deleteMorador(int id) {
        String sql = "DELETE FROM moradores WHERE id = ?";
        boolean sucesso = false;

        // conexoes com o banco de dados
        Connection conn = null;
        PreparedStatement st = null; 

        try {

            conn = Database.getConnection();
            st = conn.prepareStatement(sql);

            // Definindo o ID do morador a ser deletado
            st.setInt(1, id);
            
            // executando a instrucao
            int linhasAfetadas = st.executeUpdate();

            // Verifica se alguma linha foi afetada 
            if (linhasAfetadas > 0) {
                System.out.println("Morador ID: " + id + " Deletado com sucesso");
                sucesso = true;
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao tentar deletar morador com ID " + id + " " + e.getMessage());
        } finally {
            DBUtils.closeConnection(conn, st, null);
        }

        return sucesso;
    }
}


