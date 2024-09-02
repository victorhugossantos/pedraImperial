package com.pedraimperial.model;

public class Morador extends Pessoa{

    private int id;
    private String bloco;
    private int unidade;

    // Construtor
    public Morador(int id, String nome, String cpf, String bloco, int unidade) {
       super (nome, cpf);
       this.id = id;
       this.bloco = bloco;
       this.unidade = unidade;
    }

    public Morador (String nome, String cpf, String bloco, int unidade) {
        super(nome, cpf);
        this.bloco = bloco;
        this.unidade = unidade;
    }

    public Morador(String nome, String cpf, String telefone, String email, String bloco, int unidade) {
        super(nome, cpf, telefone, email);
        this.bloco = bloco;
        this.unidade = unidade;
   
    }

    public Morador (int id, String nome, String cpf, String telefone, String email, String bloco, int unidade) {
        super(nome, cpf, telefone, email);
        this.id = id;
        this.bloco = bloco;
        this.unidade = unidade;
    }
    // Metodos
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return "Morador{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", bloco='" + getBloco() + '\'' +
                ", unidade=" + getUnidade() +
                '}';
    }
}
