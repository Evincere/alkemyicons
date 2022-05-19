
package com.icons.mapper;

import com.icons.dto.CityDTO;
import com.icons.entity.CityEntity;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {
    
    public CityEntity cityDTO2Entity(CityDTO dto){
        CityEntity entity = new CityEntity();
        
        entity.setDeleted(false);
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
        
        dtoSaved.setDeleted(false);
        dtoSaved.setDenominacion(entitySaved.getDenominacion());
        dtoSaved.setImagen(entitySaved.getImagen());
        dtoSaved.setContinenteId(entitySaved.getContinenteId());
        dtoSaved.setCantidadHabitantes(entitySaved.getCantidadHabitantes());
        dtoSaved.setSuperficie(entitySaved.getSuperficie());
        dtoSaved.setListIcons(entitySaved.getListIcons());
        
        return dtoSaved;

    }
}
