
package com.icons.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDTO {
    private Long id;
    private boolean deleted = Boolean.FALSE;
    private String imagen;
    private String denominacion;
    private Long cantidadHabitantes;
    private Long superficie;
    private Long continenteId;
    private List<IconDTO> listIcons;
}
