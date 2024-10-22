package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "T_Reservation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "idReservation", includeFieldNames = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Reservation {

    @Id
    @Column(name = "res_id")
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
     String idReservation;

    @Column(name = "res_annee_universitaire")
    Date anneeUniversitaire;

    @Column(name = "res_est_valide")
     boolean estValide;

   

    @ManyToMany(cascade = CascadeType.ALL)
     Set<User> etudiants;

}
