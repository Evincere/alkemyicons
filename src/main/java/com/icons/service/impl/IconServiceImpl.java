
package com.icons.service.impl;

import com.icons.dto.IconBasicDTO;
import com.icons.dto.IconDTO;
import com.icons.entity.IconEntity;
import com.icons.mapper.IconMapper;
import com.icons.repository.IconRepository;
import com.icons.service.IconService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IconServiceImpl implements IconService{

    @Autowired
    IconRepository iconRepository;
    
    @Autowired
    IconMapper iconMapper;
  
    
    public IconDTO save(IconDTO dto) {
        IconEntity entity = iconMapper.iconDTO2Entity(dto, true);
        IconEntity entitySaved = iconRepository.save(entity);
        IconDTO result = iconMapper.iconEntity2DTO(entitySaved, true);
        return result;
    }

    
    public List<IconBasicDTO> getAllBasicIcons() {
        List<IconEntity> entities = iconRepository.findAll();
        List<IconBasicDTO> dtos = iconMapper.iconListEntityBasic2DTO(entities);
        return dtos;
    }

    public List<IconDTO> getAllIcons() {
        List<IconEntity> entities = iconRepository.findAll();
        List<IconDTO> result = iconMapper.iconEntitySet2DTOList(entities, false);
        return result;
    }

    public void delete(Long id) {
        iconRepository.deleteById(id);
    }
    
  
    
}
