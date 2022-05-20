
package com.icons.mapper;

import com.icons.dto.IconBasicDTO;
import com.icons.dto.IconDTO;
import com.icons.entity.IconEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class IconMapper {
    
    
    public IconEntity iconDTO2Entity(IconDTO dto){
        IconEntity entity = new IconEntity();
//        entity.setDeleted(false);
        entity.setImagen(dto.getImagen());
        entity.setDenominacion(dto.getDenominacion());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setAltura(dto.getAltura());
        entity.setHistoria(dto.getHistoria());
        entity.setListPaises(dto.getListPaises());
        
        return entity;
    }

    public IconDTO iconEntity2DTO(IconEntity entity) {
        IconDTO dto = new IconDTO();
//        dto.setDeleted(false);
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setAltura(entity.getAltura());
        dto.setHistoria(entity.getHistoria());
        dto.setListPaises(entity.getListPaises());
        
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

    public List<IconDTO> iconListEntity2DTO(List<IconEntity> entities) {
        List<IconDTO> dtos = new ArrayList<>();
        for(IconEntity entity : entities){
            dtos.add(this.iconEntity2DTO(entity));
        }
        return dtos;
    }
}
