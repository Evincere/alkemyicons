package com.icons.controllers;

import com.icons.dto.CityDTO;
import com.icons.dto.ContinenteDTO;
import com.icons.service.ContinenteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("continentes")
public class ContinenteController {

    @Autowired
    private ContinenteService continenteService;

    //I. endpoint para guardar un genero
    @PostMapping
    public ResponseEntity<ContinenteDTO> save(@RequestBody ContinenteDTO continente) {
        ContinenteDTO continenteSaved = continenteService.save(continente);
        return ResponseEntity.status(HttpStatus.CREATED).body(continenteSaved);
    }

    //II. endpoint para devolver lista completa de continentes
    @GetMapping
    public ResponseEntity<List<ContinenteDTO>> getAll() {
        List<ContinenteDTO> listContinentes = continenteService.getAllContinentes();
        return ResponseEntity.ok().body(listContinentes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContinenteDTO> update(@PathVariable Long id, @RequestBody ContinenteDTO dto) {
        ContinenteDTO result = continenteService.update(id, dto);
        return ResponseEntity.ok().body(result);
    }

}
