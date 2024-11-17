package tn.esprit.tpfoyer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {
  //  @Query("select b FROM BLOC b WHERE b.foyer.universite.nomuniversite like %.keyword%")
   // List<Bloc> findByFoyerUniversiteNomUniversiteContainingIgnoreCases(String keyword);

}