package tn.esprit.tpfoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.UniversiteRepository;

import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService{
    @Autowired
    UniversiteRepository universiteRepository;

    @Override
    public Universite create(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void delete(int id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public Universite update(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite readById(int id) {
        return universiteRepository.findById(id).orElse(new Universite());
    }

    @Override
    public List<Universite> readAll() {
        return universiteRepository.findAll();
    }
}
