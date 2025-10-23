package com.example.demo.dto;

import jakarta.validation.constraints.*;

public class CarroRequest {

    @NotBlank @Size(min = 3)
    private String nome;

    @NotBlank @Size(min = 4)
    private String marca;

    @Size(max = 500)
    private String descricao;

    @NotNull @Positive
    private Double valor;


    private String foto;

    public CarroRequest(){}

    public CarroRequest(Double valor, String descricao, String marca, String nome) {
        this.valor = valor; this.descricao = descricao; this.marca = marca; this.nome = nome;
    }

    // getters/setters
    public String getNome(){ return nome; }            public void setNome(String n){ this.nome=n; }
    public String getMarca(){ return marca; }          public void setMarca(String m){ this.marca=m; }
    public String getDescricao(){ return descricao; }  public void setDescricao(String d){ this.descricao=d; }
    public Double getValor(){ return valor; }          public void setValor(Double v){ this.valor=v; }
    public String getFoto(){ return foto; }            public void setFoto(String f){ this.foto=f; }
}
