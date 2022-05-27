
package com.icons.service.impl;

import com.icons.dto.IconBasicDTO;
import com.icons.dto.IconDTO;
import com.icons.dto.IconFiltersDTO;
import com.icons.entity.IconEntity;
import com.icons.exceptions.ParamNotFound;
import com.icons.mapper.IconMapper;
import com.icons.repository.IconRepository;
import com.icons.repository.specifications.IconSpecification;
import com.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class IconServiceImpl implements IconService{

    @Autowired
    private IconSpecification iconSpecification;

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

    public List<IconBasicDTO> getAll() {
        List<IconEntity> entities = iconRepository.findAll();
        List<IconBasicDTO> dtos = iconMapper.iconEntitySet2BasicDTOList(entities);
        return dtos;
    }

    public List<IconDTO> getAllIcons() {
        List<IconEntity> entities = iconRepository.findAll();
        List<IconDTO> result = iconMapper.iconEntitySet2DTOList(entities, true);
        return result;
    }

    public void delete(Long id) {
        iconRepository.deleteById(id);
    }

    public IconDTO update(Long id, IconDTO dto) {
        Optional<IconEntity> entity = iconRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Error: Id de icono no válido");
        }
        iconMapper.iconEntityRefreshValues(entity.get(), dto);
        IconEntity entitySaved = iconRepository.save(entity.get());
        IconDTO result = iconMapper.iconEntity2DTO(entitySaved, false);
        return result;

    }

    public IconEntity getEntityById(Long id) {
        return iconRepository.getById(id);
    }
    
    public IconDTO getOne(Long id) {
        IconDTO dto = iconMapper.iconEntity2DTO(iconRepository.getById(id), true);
        return dto;
    }

    public List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order) {
        IconFiltersDTO filtersDTO = new IconFiltersDTO(name, date, cities, order);
        List<IconEntity> entities = iconRepository.findAll(iconSpecification.getByFilters(filtersDTO));
        List<IconDTO> dtos = iconMapper.iconEntitySet2DTOList(entities, true);
        return dtos;
    }
    
  
    
}
