
package com.icons.mapper;

import com.icons.dto.CityDTO;
import com.icons.dto.IconBasicDTO;
import com.icons.dto.IconDTO;
import com.icons.entity.CityEntity;
import com.icons.entity.IconEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IconMapper {
  
    @Autowired
    CityMapper cityMapper;
    
    public IconEntity iconDTO2Entity(IconDTO dto,boolean loadPaises){
        IconEntity entity = new IconEntity();
        entity.setImagen(dto.getImagen());
        entity.setDenominacion(dto.getDenominacion());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setAltura(dto.getAltura());
        entity.setHistoria(dto.getHistoria());
        if (loadPaises) {
            List<CityEntity> paises = cityMapper.cityDTOList2EntityList(dto.getListPaises());
            entity.setListPaises(paises);
        }
        return entity;
    }

    public IconDTO iconEntity2DTO(IconEntity entity, boolean loadCities) {
        IconDTO dto = new IconDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setAltura(entity.getAltura());
        dto.setHistoria(entity.getHistoria());
        if(loadCities){
            List<CityDTO> citiesDTO = cityMapper.cityEntityList2DTOList(entity.getListPaises(), false);
            dto.setListPaises(citiesDTO);
            
        }
        
        return dto;

    }

    public List<IconBasicDTO> iconListEntityBasic2DTO(List<IconEntity> entities) {
        List<IconBasicDTO> dtos = new ArrayList<>();
        for(IconEntity entity : entities){
            dtos.add(this.iconEntity2BasicDTO(entity));
        }
        return dtos;
    }


    private IconBasicDTO iconEntity2BasicDTO(IconEntity entity) {
        IconBasicDTO iconBasic = new IconBasicDTO();
        iconBasic.setId(entity.getId());
        iconBasic.setDenominacion(entity.getDenominacion());
        iconBasic.setImagen(entity.getImagen());
        return iconBasic;
    }

    public List<IconDTO> iconEntitySet2DTOList(Collection<IconEntity> entities, boolean loadIcons) {
        List<IconDTO> dtos = new ArrayList<>();
        for(IconEntity entity : entities){
            dtos.add(this.iconEntity2DTO(entity,loadIcons));
        }
        return dtos;
    }
    
    public Set<IconEntity> iconDTOList2EntityList(List<IconDTO> icons) {
        Set<IconEntity> entities = new HashSet<>();
        for (IconDTO dto : icons){
            entities.add(iconDTO2Entity(dto, false));
        }
        return entities;
    }

    public void iconEntityRefreshValues(IconEntity entity, IconDTO dto) {
        entity.setImagen(dto.getImagen());
        entity.setDenominacion(dto.getDenominacion());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setAltura(dto.getAltura());
        entity.setHistoria(dto.getHistoria());
        
    }
}
