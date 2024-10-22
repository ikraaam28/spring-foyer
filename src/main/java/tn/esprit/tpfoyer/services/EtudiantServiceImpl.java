package tn.esprit.tpfoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.User;
import tn.esprit.tpfoyer.repository.EtudiantRepository;

import java.util.List;

@Service
public class EtudiantServiceImpl implements IEtudiantService{
    @Autowired
    EtudiantRepository etudiantRepository;


    @Override
    public User create(User etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void delete(int id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public User update(User etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public User readById(int id) {
        return etudiantRepository.findById(id).orElse(new User());
    }

    @Override
    public List<User> readAll() {
        return etudiantRepository.findAll();
    }
}
