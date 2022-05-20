
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
    private CityRepository cityRepository;
    @Autowired
    private CityMapper cityMapper;
    
    
    public CityDTO save(CityDTO dto){
        CityEntity entity = cityMapper.cityDTO2Entity(dto, true);
        CityEntity entitySaved = cityRepository.save(entity);
        CityDTO result = cityMapper.cityEntity2DTO(entitySaved, true);
        return result;
    }

    public List<CityBasicDTO> getAllCitiesBasic() {
        List<CityEntity> entities = cityRepository.findAll();
        List<CityBasicDTO> dtos = cityMapper.cityListEntityBasic2DTO(entities);
        return dtos;
    }

    public List<CityDTO> getAllCities() {
        List<CityEntity> entities = cityRepository.findAll();
        List<CityDTO> result = cityMapper.cityEntityList2DTOList(entities, true);
        return result;
    }

    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
