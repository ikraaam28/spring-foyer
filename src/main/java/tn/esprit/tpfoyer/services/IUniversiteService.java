package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;
import java.util.Optional;

public interface IUniversiteService {

    // Method to create or update a university
    Universite saveOrUpdateUniversite(Universite universite);

    // Method to get a university by its ID
    Optional<Universite> getUniversiteById(Long id);

    // Method to get all universities
    List<Universite> getAllUniversites();

    // Method to delete a university by its ID
    void deleteUniversite(Long id);
}
