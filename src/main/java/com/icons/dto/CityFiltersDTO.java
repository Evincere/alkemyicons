
package com.icons.dto;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class CityFiltersDTO {
    private String denominacion;
    private Long idContinente;
    private String order;
    
    public CityFiltersDTO (String denominacion, Long idContinente, String order){
        this.denominacion = denominacion;
        this.idContinente = idContinente;
        this.order= order;
    }
    
    public boolean isASC(){
        return this.order.compareToIgnoreCase("ASC") == 0;
    }
    public boolean isDESC(){
        return this.order.compareToIgnoreCase("DESC")== 0;
    }
}
