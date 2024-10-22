package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Chambre;

import java.util.List;

public interface IChambreService {

    Chambre create(Chambre chambre);


    Chambre update( Chambre chambre);


    void delete(int id);


    Chambre readById(int id);


    List<Chambre> readAll();
}
