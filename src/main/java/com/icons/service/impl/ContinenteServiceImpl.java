
package com.icons.service.impl;

import com.icons.dto.ContinenteDTO;
import com.icons.entity.ContinenteEntity;
import com.icons.exceptions.ParamNotFound;
import com.icons.mapper.ContinenteMapper;
import com.icons.repository.ContinenteRepository;
import com.icons.service.ContinenteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinenteServiceImpl implements ContinenteService{
    
    @Autowired
    ContinenteMapper mapper;
    
    @Autowired
    ContinenteRepository repository;
    
    public ContinenteDTO save(ContinenteDTO dto){
        ContinenteEntity continenteSaved = repository.save(mapper.continenteDTO2Entity(dto));
        ContinenteDTO continenteDTOSaved = mapper.continenteEntity2DTO(continenteSaved);
        return continenteDTOSaved;
    }

    public List<ContinenteDTO> getAllContinentes() {
        List<ContinenteEntity> entities = repository.findAll();
        List<ContinenteDTO> dtos = mapper.continenteListEntity2DTO(entities);
        return dtos;
    }

    public ContinenteDTO update(Long id, ContinenteDTO dto) {
        Optional<ContinenteEntity> entity = repository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Error: Id de continente no válido");
        }
        mapper.continenteEntityRefreshValues(entity.get(), dto);
        ContinenteEntity entitySaved = repository.save(entity.get());
        ContinenteDTO result = mapper.continenteEntity2DTO(entitySaved);
        return result;


    }
}
