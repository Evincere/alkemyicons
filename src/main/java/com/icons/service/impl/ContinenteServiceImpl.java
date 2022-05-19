
package com.icons.service.impl;

import com.icons.dto.ContinenteDTO;
import com.icons.entity.ContinenteEntity;
import com.icons.mapper.ContinenteMapper;
import com.icons.repository.ContinenteRepository;
import com.icons.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinenteServiceImpl implements ContinenteService{
    
    @Autowired
    ContinenteMapper mapper;
    
    @Autowired
    ContinenteRepository repository;
    
    public ContinenteDTO save(ContinenteDTO dto){
        //TODO: VALIDAR QUE CONTINENTE NO EXISTA
        //guardar
        ContinenteEntity continenteSaved = repository.save(mapper.continenteDTO2Entity(dto));
        ContinenteDTO continenteDTOSaved = mapper.continenteEntity2DTO(continenteSaved);
        return continenteDTOSaved;
    }
}
