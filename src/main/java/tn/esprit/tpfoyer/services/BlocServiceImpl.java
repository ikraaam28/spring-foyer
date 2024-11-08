package tn.esprit.tpfoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BlocServiceImpl implements IBlocService {

    @Autowired
    BlocRepository blocRepository;

    // Create a new Bloc
    @Override
    public Bloc createBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    // Delete an existing Bloc by ID
    @Override
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }

    // Update an existing Bloc
    @Override
    public Bloc updateBloc(Bloc bloc) {
        // Ensure the bloc exists before updating
            return blocRepository.save(bloc);

    }

    // Read a Bloc by ID
    @Override
    public Bloc readBlocById(Long id) {
        Optional<Bloc> bloc = blocRepository.findById(id);
        return bloc.orElse(null);  // Return null if bloc doesn't exist
    }

    // Read all Blocs
    @Override
    public List<Bloc> readAllBlocs() {
        return blocRepository.findAll();
    }
}
