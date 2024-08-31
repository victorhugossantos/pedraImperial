package com.pedraimperial.model;

import java.sql.Timestamp;

public class Visitante {
    private int id;
    private String nome;
    private String cpf;
    private Timestamp dataEntrada;
    private Timestamp dataSaida;
    private int idMorador;

    // Construtor
    public Visitante(int id, String nome, String cpf, Timestamp dataEntrada, Timestamp dataSaida, int idMorador) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.idMorador = idMorador;
    }

    public Visitante(String nome, String cpf, Timestamp dataEntrada, Timestamp dataSaida, int idMorador) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.idMorador = idMorador;
    }

    public Visitante(String nome, String cpf, Timestamp dataEntrada, int idMorador) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataEntrada = dataEntrada;
        this.idMorador = idMorador;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Timestamp getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Timestamp dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Timestamp getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Timestamp dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getIdMorador() {
        return idMorador;
    }

    public void setIdMorador(int idMorador) {
        this.idMorador = idMorador;
    }

    @Override
    public String toString() {
        return "Visitante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataEntrada=" + dataEntrada +
                ", dataSaida=" + dataSaida +
                ", idMorador=" + idMorador +
                '}';
    }
}
