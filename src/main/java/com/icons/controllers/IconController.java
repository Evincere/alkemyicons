
package com.icons.controllers;

import com.icons.dto.IconBasicDTO;
import com.icons.dto.IconDTO;
import com.icons.service.IconService;
import java.util.List;
import java.util.Set;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("icons")
public class IconController {
    
    @Autowired
    private IconService iconService;
    
    // I. endpoint para CREAR un Icon
    @PostMapping
    public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon){
        IconDTO iconSaved = iconService.save(icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(iconSaved);
    }
    // II. endpoint para devolver todos los iconos version Basic
    @GetMapping("/all")
    public ResponseEntity<List<IconBasicDTO>> getAllBasicIcons(){
        List<IconBasicDTO> listBasicIcons = iconService.getAll();
        return ResponseEntity.ok().body(listBasicIcons);
    }
    
    // III. endpoint para devolver todos los iconos con detalle
    @GetMapping("/details")
    public ResponseEntity<List<IconDTO>> getAllIcons(){
        List<IconDTO> listIcons = iconService.getAllIcons();
        return ResponseEntity.ok().body(listIcons);
    }
    
    // IV. endpoint para hacer soft delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    //V. endpoint para actualizar un icon
    @PutMapping("/{id}")
    public ResponseEntity<IconDTO> update(@PathVariable Long id, @RequestBody IconDTO dto){
        IconDTO result = iconService.update(id,dto);
        return ResponseEntity.ok().body(result);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<IconDTO> getOne(@PathVariable Long id){
        IconDTO result = iconService.getOne(id);
        return ResponseEntity.ok().body(result);
    }
    
    @GetMapping("/filters")
    public ResponseEntity<List<IconDTO>> getDetailsByFilters(
            @RequestParam(required=false) String name,
            @RequestParam(required=false) String date,
            @RequestParam(required=false) Set<Long> cities,
            @RequestParam(required=false, defaultValue="ASC") String order
    ){
        List<IconDTO> icons = iconService.getByFilters(name,date,cities,order);
        return ResponseEntity.ok(icons);
    }
    
}
