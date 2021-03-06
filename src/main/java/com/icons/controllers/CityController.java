
package com.icons.controllers;

import com.icons.dto.CityBasicDTO;
import com.icons.dto.CityDTO;
import com.icons.service.CityService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cities")
public class CityController {
    
    @Autowired
    CityService cityService;
    
    @PostMapping
    public ResponseEntity<CityDTO> save(@RequestBody CityDTO city){
        CityDTO citySaved = cityService.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(citySaved);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<CityBasicDTO>> getAllCitiesBasic(){
       List<CityBasicDTO> listBasicCities = cityService.getAllCitiesBasic();
       return ResponseEntity.ok().body(listBasicCities);
       
    }
    
    @GetMapping("/details")
    public ResponseEntity<List<CityDTO>> getAllCities(){
        List<CityDTO> listCities = cityService.getAllCities();
        return ResponseEntity.ok().body(listCities);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cityService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> getOne(@PathVariable Long id){
        CityDTO cityReturn = cityService.getOne(id);
        return ResponseEntity.ok().body(cityReturn);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CityDTO> update(@PathVariable Long id, @RequestBody CityDTO dto){
        CityDTO result = cityService.update(id, dto);
        return ResponseEntity.ok().body(result);
    }
    
    @GetMapping("/filters")
    public ResponseEntity<List<CityDTO>> getDetailsByFilters(
            @RequestParam(required=false) String denominacion,
            @RequestParam(required=false) Long idContinente,
            @RequestParam(required=false, defaultValue = "ASC") String order
    ){
        List<CityDTO> cities = cityService.getByFilters(denominacion, idContinente , order);
        return ResponseEntity.ok(cities);
    }
}
