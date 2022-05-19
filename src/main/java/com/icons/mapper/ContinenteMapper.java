
package com.icons.mapper;

import com.icons.dto.ContinenteDTO;
import org.springframework.stereotype.Component;
import com.icons.entity.ContinenteEntity;
@Component
public class ContinenteMapper {
    
    public ContinenteEntity continenteDTO2Entity(ContinenteDTO dto){
        ContinenteEntity entity = new ContinenteEntity();
        entity.setImagen(dto.getImagen());
        entity.setDenominacion(dto.getDenominacion());
        return entity;
    }
    
    public ContinenteDTO continenteEntity2DTO(ContinenteEntity entity){
        ContinenteDTO dto = new ContinenteDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        return dto;
    }
}
