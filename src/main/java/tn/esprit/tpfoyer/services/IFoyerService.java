package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Foyer;
import java.util.List;

public interface IFoyerService {

    Foyer createFoyer(Foyer foyer);

    Foyer updateFoyer(Foyer foyer);

    void deleteFoyer(Long id);

    Foyer readFoyerById(Long id);

    List<Foyer> readAllFoyers();
}
