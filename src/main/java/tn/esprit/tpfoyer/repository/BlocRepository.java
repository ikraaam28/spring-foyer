package tn.esprit.tpfoyer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {
    List<Bloc> findByFoyerUniversite(Universite universite);}