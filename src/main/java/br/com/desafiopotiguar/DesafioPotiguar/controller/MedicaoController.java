package br.com.desafiopotiguar.DesafioPotiguar.controller;

import br.com.desafiopotiguar.DesafioPotiguar.dto.MedicaoDTO;
import br.com.desafiopotiguar.DesafioPotiguar.entity.Medicao;
import br.com.desafiopotiguar.DesafioPotiguar.service.MedicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicoes")
@CrossOrigin(origins = "*") // Permitir CORS para ESP32
public class MedicaoController {
    @Autowired
    private MedicaoService service;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody MedicaoDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    public List<Medicao> listar() {
        return service.listarTodas();
    }
}
