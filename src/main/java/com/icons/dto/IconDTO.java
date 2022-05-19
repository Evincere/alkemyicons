
package com.icons.dto;

import com.icons.entity.CityEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IconDTO {
    
    private Long id;
    private boolean deleted = Boolean.FALSE;
    private String imagen;
    private String denominacion;
    private LocalDate fechaCreacion;
    private Long altura;
    private String historia;
    private List<CityEntity> listPaises = new ArrayList<>();
}
