
package com.icons.repository.specifications;

import com.icons.dto.CityFiltersDTO;
import com.icons.entity.CityEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;



@Component
public class CitySpecification {
    
    public Specification<CityEntity> getByFilters(CityFiltersDTO filtersDTO){
        return (root, query,criteriaBuilder) -> {
            
            List<Predicate> predicates = new ArrayList<>();
            if(StringUtils.hasLength(filtersDTO.getDenominacion())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("denominacion")),
                                "%" + filtersDTO.getDenominacion().toLowerCase()+ "%"
                        )
                );
            }
            if (!ObjectUtils.isEmpty(filtersDTO.getIdContinente())) {
                Long continenteId = filtersDTO.getIdContinente();
                predicates.add(
                        criteriaBuilder.equal(root.get("continenteId"), continenteId)
                );
            }
            
            
            query.distinct(true); // Remueve duplicados
            
            String orderByField = "denominacion";
            query.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) : 
                            criteriaBuilder.desc(root.get(orderByField))
            );
            
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    
}
