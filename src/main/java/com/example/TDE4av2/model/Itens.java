package com.example.TDE4av2.model;

import jakarta.persistence.*;

@Entity
public class Itens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_item", nullable = false, length = 100)
    private String nome;

    @Column(name = "descricao_item", length = 255)
    private String descricao;

    @Column(name = "quantidade_item", nullable = false)
    private int quantidade;

    @Column(name = "preco_item", nullable = false)
    private double preco;

    // Construtor padrão
    public Itens() {
    }

    // Construtor com parâmetros
    public Itens(String nome, String descricao, int quantidade, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNome() {
        return Double.parseDouble(nome);
    }

    public void setNome(double nome) {
        this.nome = String.valueOf(nome);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
