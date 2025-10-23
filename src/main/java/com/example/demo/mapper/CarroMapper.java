package com.example.demo.mapper;

import com.example.demo.dto.CarroRequest;
import com.example.demo.dto.CarroResponse;
import com.example.demo.model.Carro;

public class CarroMapper {

    public static CarroResponse toResponse(Carro carro){
        CarroResponse r = new CarroResponse();
        r.setId(carro.getId());
        r.setNome(carro.getNome());
        r.setMarca(carro.getMarca());
        r.setDescricao(carro.getDescricao());
        r.setValor(carro.getValor());
        r.setFoto(carro.getFoto());
        return r;
    }

    public static CarroResponse toResponse(CarroRequest req, Long id){
        CarroResponse r = new CarroResponse();
        r.setId(id);
        r.setNome(req.getNome());
        r.setMarca(req.getMarca());
        r.setDescricao(req.getDescricao());
        r.setValor(req.getValor());
        r.setFoto(req.getFoto());
        return r;
    }

    public static Carro toEntity(CarroRequest req){
        Carro c = new Carro();
        c.setNome(req.getNome());
        c.setMarca(req.getMarca());
        c.setDescricao(req.getDescricao());
        c.setValor(req.getValor());
        c.setFoto(req.getFoto());
        return c;
    }
}
