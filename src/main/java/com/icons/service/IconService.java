
package com.icons.service;

import com.icons.dto.IconBasicDTO;
import com.icons.dto.IconDTO;
import com.icons.entity.IconEntity;
import java.util.List;
import java.util.Set;


public interface IconService {
    
    IconDTO save(IconDTO dto);

    List<IconBasicDTO> getAll();

    List<IconDTO> getAllIcons();

    void delete(Long id);

    IconDTO update(Long id, IconDTO dto);

    IconDTO getOne(Long id);

    List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order);
    
    IconEntity getEntityById(Long id);
}
