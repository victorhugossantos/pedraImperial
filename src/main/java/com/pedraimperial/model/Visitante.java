package com.pedraimperial.model;

import java.sql.Timestamp;

public class Visitante extends Pessoa{
    private int id;
    private Timestamp dataEntrada;
    private Timestamp dataSaida;
    private int idMorador;

    // Construtor
    public Visitante(int id, String nome, String cpf, Timestamp dataEntrada, Timestamp dataSaida, int idMorador) {
        super(nome, cpf);
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.idMorador = idMorador;
    }

    public Visitante(String nome, String cpf, Timestamp dataEntrada, Timestamp dataSaida, int idMorador) {
        super(nome, cpf);
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.idMorador = idMorador;
    }

    public Visitante(String nome, String cpf, Timestamp dataEntrada, int idMorador) {
        super(nome, cpf);
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
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", dataEntrada=" + getDataEntrada() +
                ", dataSaida=" + getDataSaida() +
                ", idMorador=" + getIdMorador() +
                '}';
    }

   
}
