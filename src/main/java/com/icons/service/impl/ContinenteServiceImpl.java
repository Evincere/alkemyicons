
package com.icons.service.impl;

import com.icons.dto.ContinenteDTO;
import com.icons.service.ContinenteService;
import org.springframework.stereotype.Service;

@Service
public class ContinenteServiceImpl implements ContinenteService{
    
    public ContinenteDTO save(ContinenteDTO dto){
        //TODO: VALIDAR QUE CONTINENTE NO EXISTA
        //guardar
        System.out.println("CONTINENTE GUARDADO");
        return dto;
    }
}
