
package com.icons.mapper;

import com.icons.dto.CityBasicDTO;
import com.icons.dto.CityDTO;
import com.icons.dto.IconDTO;
import com.icons.entity.CityEntity;
import com.icons.entity.IconEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {
    
    @Autowired
    IconMapper iconMapper;
    
    public CityEntity cityDTO2Entity(CityDTO dto, boolean loadIcons ){
        CityEntity entity = new CityEntity();
        entity.setDenominacion(dto.getDenominacion());
        entity.setImagen(dto.getImagen());
        entity.setContinenteId(dto.getContinenteId());
        entity.setCantidadHabitantes(dto.getCantidadHabitantes());
        entity.setSuperficie(dto.getSuperficie());
        
        if (loadIcons) {
            Set<IconEntity> icons = iconMapper.iconDTOList2EntityList(dto.getListIcons());
            entity.setListIcons(icons);
        }
        return entity;
    }

    public CityDTO cityEntity2DTO(CityEntity entitySaved, boolean loadIcons) {
        CityDTO dtoSaved = new CityDTO();
        dtoSaved.setId(entitySaved.getId());
        dtoSaved.setDenominacion(entitySaved.getDenominacion());
        dtoSaved.setImagen(entitySaved.getImagen());
        dtoSaved.setContinenteId(entitySaved.getContinenteId());
        dtoSaved.setCantidadHabitantes(entitySaved.getCantidadHabitantes());
        dtoSaved.setSuperficie(entitySaved.getSuperficie());
        if(loadIcons){
            List<IconDTO> iconDTOS = iconMapper.iconEntitySet2DTOList(entitySaved.getListIcons(), false);
            dtoSaved.setListIcons(iconDTOS);
        }
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

    public List<CityDTO> cityEntityList2DTOList(List<CityEntity> entities, boolean loadIcons) {
        List<CityDTO> dtos = new ArrayList<>();
        for(CityEntity entity : entities){
            dtos.add(this.cityEntity2DTO(entity, loadIcons));
        }
        return dtos;
    }
    
    public List<CityEntity> cityDTOList2EntityList(List<CityDTO> dtos) {
        List<CityEntity> paisEntities = new ArrayList<>();
        for (CityDTO dto : dtos){
            paisEntities.add(cityDTO2Entity(dto, true));
        }
        return paisEntities;
    }
}
