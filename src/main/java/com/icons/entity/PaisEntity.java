
package com.icons.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "pais")
@Getter
@Setter
@SQLDelete(sql = "UPDATE pais SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class PaisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String denominacion;

    @Column(name = "cant_habitantes")
    private Long cantidadHabitantes;

    private Long superficie;// m2

    //uno o muchos paises van a corresponder a solo un continente
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //inicializacion de tipo temprana (fetch tipo EAGER)
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)              //cuando se pida un pais si o si va a volver con su continente
    private ContinenteEntity continente;

    @Column(name = "continente_id", nullable = false)
    private Long continenteId;

    
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "icon_pais",
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id"))
    private Set<IconEntity> listIcons = new HashSet<>();

    private boolean deleted = Boolean.FALSE;
}
