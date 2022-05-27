
package com.icons.mapper;

import com.icons.dto.CityDTO;
import com.icons.dto.IconBasicDTO;
import com.icons.dto.IconDTO;
import com.icons.entity.CityEntity;
import com.icons.entity.IconEntity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        entity.setFechaCreacion(string2LocalDate(dto.getFechaCreacion()));
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
        dto.setFechaCreacion(entity.getFechaCreacion().toString());
        dto.setAltura(entity.getAltura());
        dto.setHistoria(entity.getHistoria());
        if(loadCities){
            List<CityDTO> citiesDTO = cityMapper.cityEntityList2DTOList(entity.getListPaises(), false);
            dto.setListPaises(citiesDTO);
        }
        return dto;
    }

    public List<IconBasicDTO> iconEntitySet2BasicDTOList(Collection<IconEntity> entities) {
        List<IconBasicDTO> dtos = new ArrayList<>();
        IconBasicDTO basicDTO;
        for (IconEntity entity : entities) {
            basicDTO = new IconBasicDTO();
            basicDTO.setId(entity.getId());
            basicDTO.setImagen(entity.getImagen());
            basicDTO.setDenominacion(entity.getDenominacion());
            dtos.add(basicDTO);
        }
        return dtos;
    }

    public List<IconDTO> iconEntitySet2DTOList(Collection<IconEntity> entities, boolean loadCities) {
        List<IconDTO> dtos = new ArrayList<>();
        for(IconEntity entity : entities){
            dtos.add(this.iconEntity2DTO(entity,loadCities));
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
        entity.setFechaCreacion(string2LocalDate(dto.getFechaCreacion()));
        entity.setAltura(dto.getAltura());
        entity.setHistoria(dto.getHistoria());
        
    }
    
    private LocalDate string2LocalDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;
    }
}
