package tn.esprit.tpfoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.UniversiteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UniversiteServiceImpl implements IUniversiteService {

    @Autowired
    UniversiteRepository universiteRepository;

    // Create or update a university
    @Override
    public Universite saveOrUpdateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    // Get a university by ID
    @Override
    public Optional<Universite> getUniversiteById(Long id) {
        return universiteRepository.findById(id);
    }

    // Get all universities
    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    // Delete a university by ID
    @Override
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);
    }
}
