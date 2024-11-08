package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Chambre;

import java.util.List;
import java.util.Optional;

public interface IChambreService {

    // Method to create or update a chambre
    Chambre saveOrUpdateChambre(Chambre chambre);

    // Method to get a chambre by its ID
    Optional<Chambre> getChambreById(Long id);

    // Method to get all chambres
    List<Chambre> getAllChambres();

    // Method to delete a chambre by its ID
    void deleteChambre(Long id);
}
