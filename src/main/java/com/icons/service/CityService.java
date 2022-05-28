
package com.icons.service;

import com.icons.dto.CityBasicDTO;
import com.icons.dto.CityDTO;
import java.util.List;


public interface CityService {

    CityDTO save(CityDTO city);

    List<CityBasicDTO> getAllCitiesBasic();

    List<CityDTO> getAllCities();

    void delete(Long id);

    CityDTO getOne(Long id);

    CityDTO update(Long id, CityDTO cityDTO);

    List<CityDTO> getByFilters(String denominacion, Long idContinente, String order);

   
    
    
}
