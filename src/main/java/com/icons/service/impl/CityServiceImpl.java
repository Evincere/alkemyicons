
package com.icons.service.impl;

import com.icons.dto.CityBasicDTO;
import com.icons.dto.CityDTO;
import com.icons.entity.CityEntity;
import com.icons.mapper.CityMapper;
import com.icons.repository.CityRepository;
import com.icons.service.CityService;
import java.util.List;
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

    public List<CityBasicDTO> getAllCitiesBasic() {
        List<CityEntity> entities = repository.findAll();
        List<CityBasicDTO> dtos = mapper.cityListEntityBasic2DTO(entities);
        return dtos;
    }

    public List<CityDTO> getAllCities() {
        List<CityEntity> entities = repository.findAll();
        List<CityDTO> dtos = mapper.cityListEntity2DTO(entities);
        return dtos;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
