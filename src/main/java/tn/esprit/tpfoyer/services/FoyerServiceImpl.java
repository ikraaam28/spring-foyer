package tn.esprit.tpfoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService{
    @Autowired
    FoyerRepository foyerRepository;

    @Override
    public Foyer create(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void delete(int id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public Foyer update(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer readById(int id) {
        return foyerRepository.findById(id).orElse(new Foyer());
    }

    @Override
    public List<Foyer> readAll() {
        return foyerRepository.findAll();
    }
}
