
package com.icons.controllers;

import com.icons.dto.CityDTO;
import com.icons.service.CityService;
import com.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
