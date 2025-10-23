package com.example.demo.dto;

public class CarroResponse {
    private Long id;
    private String nome;
    private String marca;
    private String descricao;
    private Double valor;
    private String foto;

    public CarroResponse(){}

    public CarroResponse(Long id, String nome, String marca, String descricao, Double valor, String foto) {
        this.id=id; this.nome=nome; this.marca=marca; this.descricao=descricao; this.valor=valor; this.foto=foto;
    }

    // getters/setters
    public Long getId(){ return id; }                  public void setId(Long id){ this.id=id; }
    public String getNome(){ return nome; }            public void setNome(String n){ this.nome=n; }
    public String getMarca(){ return marca; }          public void setMarca(String m){ this.marca=m; }
    public String getDescricao(){ return descricao; }  public void setDescricao(String d){ this.descricao=d; }
    public Double getValor(){ return valor; }          public void setValor(Double v){ this.valor=v; }
    public String getFoto(){ return foto; }            public void setFoto(String f){ this.foto=f; }
}
