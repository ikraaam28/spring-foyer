package tn.esprit.tpfoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.repository.ChambreRepository;

import java.util.List;

@Service
public class ChambreServiceImpl implements IChambreService{
    @Autowired
    ChambreRepository chambreRepository;

    @Override
    public Chambre create(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void delete(int id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public Chambre update(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre readById(int id) {
        return chambreRepository.findById(id).orElse(new Chambre());
    }

    @Override
    public List<Chambre> readAll() {
        return chambreRepository.findAll();
    }
}
