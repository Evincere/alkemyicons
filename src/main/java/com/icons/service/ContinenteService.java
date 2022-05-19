
package com.icons.service;

import com.icons.dto.ContinenteDTO;
import java.util.List;


public interface ContinenteService {
    ContinenteDTO save(ContinenteDTO dto);

    List<ContinenteDTO> getAllContinentes();
}
