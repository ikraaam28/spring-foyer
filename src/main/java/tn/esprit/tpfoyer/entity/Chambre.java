package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "T_Chambre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "idChambre", includeFieldNames = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chb_id")
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    Long idChambre;

    @Column(name = "chb_numero")
     Long numeroChambre;

    @Enumerated(EnumType.STRING)
    @Column(name = "chb_type")
    TypeChambre typeC;

    @ManyToOne
     Bloc bloc;


    @OneToMany( cascade = CascadeType.ALL)
    Set<Reservation> reservations;

}
