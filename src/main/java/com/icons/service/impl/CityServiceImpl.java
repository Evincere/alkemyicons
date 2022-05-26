
package com.icons.service.impl;

import com.icons.dto.CityBasicDTO;
import com.icons.dto.CityDTO;
import com.icons.entity.CityEntity;
import com.icons.exceptions.ParamNotFound;
import com.icons.mapper.CityMapper;
import com.icons.repository.CityRepository;
import com.icons.service.CityService;
import static java.lang.System.console;
import java.util.List;
import java.util.Optional;
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

    public CityDTO getOne(Long id) {
        CityDTO dto = cityMapper.cityEntity2DTO(cityRepository.getById(id), true);
        return dto;
    }
    
    public CityDTO update(Long id, CityDTO cityDTO){
//      CityDTO dtoRecovery = this.getOne(id);
//      dtoRecovery.setDenominacion(cityDTO.getDenominacion());
//      dtoRecovery.setImagen(cityDTO.getImagen());
//      dtoRecovery.setContinenteId(cityDTO.getContinenteId());
//      dtoRecovery.setCantidadHabitantes(cityDTO.getCantidadHabitantes());
//      dtoRecovery.setSuperficie(cityDTO.getSuperficie());
//      dtoRecovery.setListIcons(cityDTO.getListIcons());
//      cityRepository.save(cityMapper.cityDTO2Entity(cityDTO, false));
//      return dtoRecovery;
        Optional<CityEntity> entity = cityRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Error: Id de pais no válido");
        }
        cityMapper.paisEntityRefreshValues(entity.get(), cityDTO);
        CityEntity entitySaved = cityRepository.save(entity.get());
        CityDTO result = cityMapper.cityEntity2DTO(entitySaved, false);
        return result;
    }
}
