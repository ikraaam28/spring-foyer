package tn.esprit.tpfoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.BlocRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BlocServiceImpl implements IBlocService {



    @Autowired
    BlocRepository blocRepository;


    @Override
    public Bloc create(Bloc bloc) {
        return blocRepository.save(bloc);
    }


    @Override
    public void delete(Long id) {
        blocRepository.deleteById(id);
    }


    @Override
    public Bloc update(Bloc bloc) {


            return blocRepository.save(bloc);

    }


    @Override
    public Bloc readById(Long id) {

        return  blocRepository.findById(id).orElse(new Bloc());
    }


    @Override
    public List<Bloc> readAll() {
        return blocRepository.findAll();
    }

    @Override
    public List<Bloc> findByUniversite(Universite universite) {
        return blocRepository.findByFoyerUniversite(universite);
    }
}
