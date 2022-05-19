
package com.icons.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "continente")
@Getter
@Setter
class ContinenteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String imagen;
    private String denominacion;
}