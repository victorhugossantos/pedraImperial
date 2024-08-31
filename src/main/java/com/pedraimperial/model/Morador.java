package com.pedraimperial.model;

public class Morador {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String bloco;
    private int unidade;

    // Construtor
    public Morador(int id, String nome, String cpf, String bloco, int unidade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.bloco = bloco;
        this.unidade = unidade;
    }

    public Morador (String nome, String cpf, String bloco, int unidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.bloco = bloco;
        this.unidade = unidade;
    }

    public Morador(String nome, String cpf, String telefone, String email, String bloco, int unidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.bloco = bloco;
        this.unidade = unidade;
    }

    public Morador (int id, String nome, String cpf, String telefone, String email, String bloco, int unidade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.bloco = bloco;
        this.unidade = unidade;
    }


    // Metodos
    public int getId(){
        return id;
    }

    public void setId(int id) {
        //O id sera feito automaticamento por um outro metodo
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;

    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloco(){
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public int getUnidade(){
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return "Morador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", bloco='" + bloco + '\'' +
                ", unidade=" + unidade +
                '}';
    }
}
