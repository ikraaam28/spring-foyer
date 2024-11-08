package tn.esprit.tpfoyer.services;
import tn.esprit.tpfoyer.entity.User;

import java.util.List;
import java.util.Optional;
public interface IEtudiantService {

    // Method to create or update a user
    User saveOrUpdateUser(User user);

    // Method to get a user by its ID
    Optional<User> getUserById(Long id);

    // Method to get all users
    List<User> getAllUsers();

    // Method to delete a user by its ID
    void deleteUser(Long id);
}
