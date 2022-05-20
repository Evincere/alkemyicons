
package com.icons.service;

import com.icons.dto.CityBasicDTO;
import com.icons.dto.CityDTO;
import java.util.List;


public interface CityService {

    CityDTO save(CityDTO city);

    List<CityBasicDTO> getAllCitiesBasic();

    List<CityDTO> getAllCities();

    void delete(Long id);
    
    
}
