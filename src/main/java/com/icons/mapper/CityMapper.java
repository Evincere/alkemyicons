
package com.icons.mapper;

import com.icons.dto.CityBasicDTO;
import com.icons.dto.CityDTO;
import com.icons.entity.CityEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {
    
    public CityEntity cityDTO2Entity(CityDTO dto){
        CityEntity entity = new CityEntity();
//        entity.setDeleted(false);
        entity.setDenominacion(dto.getDenominacion());
        entity.setImagen(dto.getImagen());
        entity.setContinenteId(dto.getContinenteId());
        entity.setCantidadHabitantes(dto.getCantidadHabitantes());
        entity.setSuperficie(dto.getSuperficie());
        entity.setListIcons(dto.getListIcons());
        
        return entity;
    }

    public CityDTO cityEntity2DTO(CityEntity entitySaved) {
        CityDTO dtoSaved = new CityDTO();
//        dtoSaved.setDeleted(false);
        dtoSaved.setId(entitySaved.getId());
        dtoSaved.setDenominacion(entitySaved.getDenominacion());
        dtoSaved.setImagen(entitySaved.getImagen());
        dtoSaved.setContinenteId(entitySaved.getContinenteId());
        dtoSaved.setCantidadHabitantes(entitySaved.getCantidadHabitantes());
        dtoSaved.setSuperficie(entitySaved.getSuperficie());
        dtoSaved.setListIcons(entitySaved.getListIcons());
        
        return dtoSaved;

    }

    public List<CityBasicDTO> cityListEntityBasic2DTO(List<CityEntity> entities) {
        List<CityBasicDTO> dtos = new ArrayList<>();
        for(CityEntity entity : entities){
            dtos.add(this.cityBasic2DTO(entity));
        }
        return dtos;
    }

    private CityBasicDTO cityBasic2DTO(CityEntity entity) {
        CityBasicDTO dto = new CityBasicDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setCantidadHabitantes(entity.getCantidadHabitantes());
 
        return dto;
    }

    public List<CityDTO> cityListEntity2DTO(List<CityEntity> entities) {
        List<CityDTO> dtos = new ArrayList<>();
        for(CityEntity entity : entities){
            dtos.add(this.cityEntity2DTO(entity));
        }
        return dtos;
    }
}
