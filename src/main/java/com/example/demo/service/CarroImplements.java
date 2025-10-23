package com.example.demo.service;
import com.example.demo.dto.CarroRequest;
import com.example.demo.dto.CarroResponse;
import com.example.demo.mapper.CarroMapper;
import com.example.demo.model.Carro;
import com.example.demo.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroImplements implements CarroService {

    @Autowired
    private CarroRepository repository;

    @Override
    public List<CarroResponse> listarCarros() {
        return repository.findAll().stream().map(CarroMapper::toResponse).toList();
    }

    @Override
    public CarroResponse criarCarro(CarroRequest request) {
        if (request == null) throw new RuntimeException("Carro vazio");
        Carro salvo = repository.save(CarroMapper.toEntity(request));
        return CarroMapper.toResponse(salvo);
    }

    @Override
    public void deletarCarro(Long id) {
        if (id == null || id <= 0) throw new RuntimeException("id inválido");
        Carro carro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));
        repository.delete(carro);
    }

    @Override
    public CarroResponse atualizaCarro(Long id, CarroRequest request) {
        Carro carro = repository.findById(id).orElseThrow(() -> new RuntimeException("Carro não encontrado"));
        if (request.getNome() != null) carro.setNome(request.getNome());
        if (request.getMarca() != null) carro.setMarca(request.getMarca());
        if (request.getValor() != null) carro.setValor(request.getValor());
        carro.setDescricao(request.getDescricao());
        if (request.getFoto() != null) carro.setFoto(request.getFoto());
        return CarroMapper.toResponse(repository.save(carro));
    }

    @Override
    public CarroResponse buscarPorId(Long id) {
        if (id == null || id <= 0) throw new RuntimeException("id inválido");
        return repository.findById(id)
                .map(CarroMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));
    }
}
