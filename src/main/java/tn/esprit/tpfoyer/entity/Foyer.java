package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Set;

@Entity

@Table(name = "T_Foyer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "idFoyer", includeFieldNames = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fyr_id")
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
     Long idFoyer;

    @Column(name = "fyr_nom")
     String nomFoyer;

    @Column(name = "fyr_capacite")
     Long capaciteFoyer;

    @OneToOne(mappedBy ="foyer")
     Universite universite;


   @OneToMany(cascade = CascadeType.ALL,mappedBy = "foyer")
   Set<Bloc> blocs;
}
