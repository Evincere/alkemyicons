
package com.icons.controllers;

import com.icons.dto.ContinenteDTO;
import com.icons.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<ContinenteDTO> save(@RequestBody ContinenteDTO continente){
        
        //TODO: GUARDAR
        ContinenteDTO continenteSaved = continenteService.save(continente);
        return ResponseEntity.status(HttpStatus.CREATED).body(continenteSaved);
    }
}
