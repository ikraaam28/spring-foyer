package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite create(Universite universite);

    Universite update( Universite universite);

    void delete(int id);

    Universite readById(int id);

    List<Universite> readAll();
}
