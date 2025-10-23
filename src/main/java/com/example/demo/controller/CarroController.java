package com.example.demo.controller;

import com.example.demo.dto.CarroRequest;
import com.example.demo.dto.CarroResponse;
import com.example.demo.mapper.CarroMapper;
import com.example.demo.service.CarroService;
import com.example.demo.storage.FileStorage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/")
    public String homePublica() { return "public/index"; }

    @GetMapping("/carros")
    public String listar(Model model) {
        List<CarroResponse> carros = carroService.listarCarros();
        model.addAttribute("carros", carros);
        return "app/carros/list"; // agora em cards
    }

    @GetMapping("/carros/novo")
    public String novoForm(Model model) {
        model.addAttribute("carro", new CarroResponse());
        model.addAttribute("title", "Novo Carro");
        return "app/carros/form";
    }

    @PostMapping("/carros")
    public String criar(@Valid @ModelAttribute("carro") CarroRequest request,
                        BindingResult br,
                        @RequestParam(value = "imagem", required = false) MultipartFile imagem,
                        Model model) throws IOException {

        if (br.hasErrors()) {
            model.addAttribute("carro", CarroMapper.toResponse(request, null));
            model.addAttribute("title", "Novo Carro");
            return "app/carros/form";
        }
        String fotoUrl = FileStorage.saveImage(imagem);
        request.setFoto(fotoUrl);

        CarroResponse criado = carroService.criarCarro(request);
        return "redirect:/carros?created=" + criado.getId();
    }

    @GetMapping("/carros/{id}/editar")
    public String editarForm(@PathVariable Long id, Model model) {
        CarroResponse carro = carroService.buscarPorId(id);
        model.addAttribute("carro", carro);
        model.addAttribute("title", "Editar Carro");
        return "app/carros/form";
    }

    @PostMapping("/carros/{id}")
    public String atualizar(@PathVariable Long id,
                            @Valid @ModelAttribute("carro") CarroRequest request,
                            BindingResult br,
                            @RequestParam(value = "imagem", required = false) MultipartFile imagem,
                            Model model) throws IOException {

        if (br.hasErrors()) {
            model.addAttribute("carro", CarroMapper.toResponse(request, id));
            model.addAttribute("title", "Editar Carro");
            return "app/carros/form";
        }
        String fotoUrl = FileStorage.saveImage(imagem);
        if (fotoUrl != null) request.setFoto(fotoUrl);

        carroService.atualizaCarro(id, request);
        return "redirect:/carros?updated=" + id;
    }

    @PostMapping("/carros/{id}/delete")
    public String deletar(@PathVariable Long id) {
        carroService.deletarCarro(id);
        return "redirect:/carros?deleted=" + id;
    }
}
