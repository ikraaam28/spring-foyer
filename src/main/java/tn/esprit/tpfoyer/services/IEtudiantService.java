package tn.esprit.tpfoyer.services;


import tn.esprit.tpfoyer.entity.User;

import java.util.List;

public interface IEtudiantService {

    User create(User etudiant);

    User update( User etudiant);

    void delete(int id);

    User readById(int id);

    List<User> readAll();
}
