
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
    IconRepository repository;
    
    @Autowired
    IconMapper mapper;
  
    
    public IconDTO save(IconDTO dto) {
        IconEntity iconSaved = repository.save(mapper.iconDTO2Entity(dto));
        IconDTO IconDTOSaved = mapper.iconEntity2DTO(iconSaved);
        return IconDTOSaved;
    }

    
    public List<IconBasicDTO> getAllBasicIcons() {
        List<IconEntity> entities = repository.findAll();
        List<IconBasicDTO> dtos = mapper.iconListEntityBasic2DTO(entities);
        return dtos;
    }

    public List<IconDTO> getAllIcons() {
        List<IconEntity> entities = repository.findAll();
        List<IconDTO> dtos = mapper.iconListEntity2DTO(entities);
        return dtos;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    
  
    
}
