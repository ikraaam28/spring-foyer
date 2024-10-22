package tn.esprit.tpfoyer.services;


import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {

    Foyer create(Foyer foyer);

    Foyer update( Foyer foyer);

    void delete(int id);

    Foyer readById(int id);

    List<Foyer> readAll();
}
