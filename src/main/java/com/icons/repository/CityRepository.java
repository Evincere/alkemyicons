
package com.icons.repository;

import com.icons.entity.CityEntity;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long>, JpaSpecificationExecutor<CityEntity>{

    List<CityEntity> findAll(Specification<CityEntity> byFilters);
    
}
