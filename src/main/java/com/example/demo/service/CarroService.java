package com.example.demo.service;

import com.example.demo.dto.CarroRequest;
import com.example.demo.dto.CarroResponse;

import java.util.List;

public interface CarroService {
    List<CarroResponse> listarCarros();
    CarroResponse criarCarro(CarroRequest request);
    void deletarCarro(Long id);
    CarroResponse atualizaCarro(Long id, CarroRequest request);
    CarroResponse buscarPorId(Long id);
}
