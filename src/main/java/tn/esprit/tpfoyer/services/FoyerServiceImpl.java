package tn.esprit.tpfoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoyerServiceImpl implements IFoyerService{
    @Autowired
    FoyerRepository foyerRepository;

    public Foyer createFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }

    public Foyer updateFoyer(Foyer foyer) {
        if (foyerRepository.existsById(foyer.getIdFoyer())) {
            return foyerRepository.save(foyer);
        }
        return null;
    }

    public Foyer readFoyerById(Long id) {
        Optional<Foyer> foyer = foyerRepository.findById(id);
        return foyer.orElse(null);
    }

    public List<Foyer> readAllFoyers() {
        return foyerRepository.findAll();
    }
}
