package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IBlocService {


    Bloc create(Bloc bloc);

    void delete(Long id);

    Bloc update(Bloc bloc);

    Bloc readById(Long id);

    List<Bloc> readAll();
    List<Bloc> findByUniversite(Universite universite);
}
