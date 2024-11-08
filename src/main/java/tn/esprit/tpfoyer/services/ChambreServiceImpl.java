package tn.esprit.tpfoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.repository.ChambreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChambreServiceImpl implements IChambreService {

    @Autowired
    ChambreRepository chambreRepository;

    // Create or update a chambre
    @Override
    public Chambre saveOrUpdateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    // Get a chambre by ID
    @Override
    public Optional<Chambre> getChambreById(Long id) {
        return chambreRepository.findById(id);
    }

    // Get all chambres
    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    // Delete a chambre by ID
    @Override
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }
}
