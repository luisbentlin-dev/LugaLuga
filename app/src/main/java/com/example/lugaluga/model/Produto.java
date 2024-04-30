package com.example.lugaluga.model;

public class Produto {

    private String nome;
    private String descricao;
    private String preco;
    private Integer qtd;
    private String status;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public String getStatus() {
        return status;
    }

    public Produto(String nome, String descricao, String preco, Integer qtd, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtd = qtd;
        this.status = status;
    }

    public Produto() {
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
