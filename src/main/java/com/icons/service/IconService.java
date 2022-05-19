
package com.icons.service;

import com.icons.dto.IconBasicDTO;
import com.icons.dto.IconDTO;
import java.util.List;


public interface IconService {
    
    IconDTO save(IconDTO dto);

    List<IconBasicDTO> getAllBasicIcons();

    List<IconDTO> getAllIcons();
}
