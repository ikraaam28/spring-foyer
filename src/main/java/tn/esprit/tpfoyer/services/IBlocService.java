package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

public interface IBlocService {

    // Create a new Bloc
    Bloc createBloc(Bloc bloc);

    // Delete an existing Bloc by ID
    void deleteBloc(Long id);

    // Update an existing Bloc
    Bloc updateBloc(Bloc bloc);

    // Read a Bloc by ID
    Bloc readBlocById(Long id);

    // Read all Blocs
    List<Bloc> readAllBlocs();
}
