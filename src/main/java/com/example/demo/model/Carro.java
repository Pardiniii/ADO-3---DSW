package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Carro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(nullable = false)
    private String nome;

    @NotBlank @Column(nullable = false)
    private String marca;

    @Column(length = 500)
    private String descricao; // opcional

    @NotNull @Positive @Column(nullable = false)
    private Double valor;

    // URL/Path público para a imagem
    @Column(length = 300)
    private String foto; // ex.: /uploads/uuid-arquivo.png

    public Carro() {}
    public Carro(Long id, String nome, String marca, String descricao, Double valor, String foto) {
        this.id = id; this.nome = nome; this.marca = marca; this.descricao = descricao; this.valor = valor; this.foto = foto;
    }

    // getters/setters
    public Long getId() { return id; }                 public void setId(Long id){ this.id=id; }
    public String getNome(){ return nome; }            public void setNome(String nome){ this.nome=nome; }
    public String getMarca(){ return marca; }          public void setMarca(String marca){ this.marca=marca; }
    public String getDescricao(){ return descricao; }  public void setDescricao(String d){ this.descricao=d; }
    public Double getValor(){ return valor; }          public void setValor(Double v){ this.valor=v; }
    public String getFoto(){ return foto; }            public void setFoto(String f){ this.foto=f; }
}
