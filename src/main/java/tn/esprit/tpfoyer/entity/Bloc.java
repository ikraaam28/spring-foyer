package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "idBloc", includeFieldNames = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "T_Bloc")
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blc_id")
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
     Long idBloc;

    @Column(name = "blc_nom")

     String nomBloc;

    @Column(name = "blc_capacite")
    Long capaciteBloc;

    @ManyToOne
     Foyer foyer;


    @OneToMany(mappedBy = "bloc", cascade = CascadeType.ALL)
    Set<Chambre> chambres;
}
