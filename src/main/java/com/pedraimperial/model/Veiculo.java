package com.pedraimperial.model;

public class Veiculo {
    private String placa;
    private String modelo;
    private String cor;
    private int idMorador; 

    public Veiculo (String placa, String modelo, String cor, int idMorador){
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.idMorador = idMorador;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getIdMorador() {
        return idMorador;
    }

    public void setIdMorador(int idMorador) {
        this.idMorador = idMorador;
    }


}


