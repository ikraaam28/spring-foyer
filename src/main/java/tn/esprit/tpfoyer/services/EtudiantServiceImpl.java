package tn.esprit.tpfoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.User;
import tn.esprit.tpfoyer.repository.EtudiantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantServiceImpl implements IEtudiantService{
    @Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public User saveOrUpdateUser(User user) {
        return etudiantRepository.save(user);
    }

    // Get a user by ID
    @Override
    public Optional<User> getUserById(Long id) {
        return etudiantRepository.findById(id);
    }

    // Get all users
    @Override
    public List<User> getAllUsers() {
        return etudiantRepository.findAll();
    }

    // Delete a user by ID
    @Override
    public void deleteUser(Long id) {
        etudiantRepository.deleteById(id);
    }
}
