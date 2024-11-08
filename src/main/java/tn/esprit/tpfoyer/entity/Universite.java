package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "T_Universite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "idUniversite", includeFieldNames = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uni_id")
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
     Long idUniversite;

    @Column(name = "uni_nom")
     String nomUniversite;

    @Column(name = "uni_adresse")
     String adresse;

    @OneToOne
     Foyer foyer;
}
