
package com.icons.service.impl;

import com.icons.dto.CityDTO;
import com.icons.entity.CityEntity;
import com.icons.mapper.CityMapper;
import com.icons.repository.CityRepository;
import com.icons.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService{
    
    @Autowired
    CityRepository repository;
    @Autowired
    CityMapper mapper;
    
    
    public CityDTO save(CityDTO city){
        CityEntity entitySaved = repository.save(mapper.cityDTO2Entity(city));
        CityDTO dtoSaved = mapper.cityEntity2DTO(entitySaved);
        return dtoSaved;
    }
}
