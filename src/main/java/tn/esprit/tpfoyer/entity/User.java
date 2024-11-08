package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "T_Etudiant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "id", includeFieldNames = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "etd_id")
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
     Long id;

    @Column(name = "etd_name")
     protected String nom;

    @Column(name = "etd_FirstName")
     String prenom;

    @Column(name = "etd_cin")
     Long cin;

    @Column(name = "etd_ecole")
     String ecole;

    @Column(name = "etd_date_naissance")
     Date dateNaissance;
    @ManyToMany(mappedBy = "etudiants")
    Set<Reservation> reservations;
}
