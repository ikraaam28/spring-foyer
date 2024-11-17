
package tn.esprit.tpfoyer.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.services.BlocServiceImpl;

import java.util.List;

@RestController
@RequestMapping("api/bloc")
public class BlocController {

    @Autowired
    private BlocServiceImpl blocService;


    @PostMapping
    public ResponseEntity<Bloc> createBloc(@RequestBody Bloc bloc) {
        Bloc createdBloc = blocService.create(bloc);
        return new ResponseEntity<>(createdBloc, HttpStatus.CREATED);
    }


    @GetMapping("by-id/{id}")
    public ResponseEntity<Bloc> getBlocById(@PathVariable Long id) {
        Bloc bloc = blocService.readById(id);
        return bloc != null ? new ResponseEntity<>(bloc, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping
    public ResponseEntity<List<Bloc>> getAllBlocs() {
        List<Bloc> blocs = blocService.readAll();
        return new ResponseEntity<>(blocs, HttpStatus.OK);
    }


    @PutMapping("upd/{id}")
    public ResponseEntity<Bloc> updateBloc(@PathVariable Long id, @RequestBody Bloc bloc) {
        Bloc existingBloc = blocService.readById(id);
        if (existingBloc != null) {
            bloc.setId(id); // Assurez-vous que l'ID est défini pour éviter de créer un nouvel objet
            Bloc updatedBloc = blocService.update(bloc);
            return new ResponseEntity<>(updatedBloc, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("del//{id}")
    public ResponseEntity<Void> deleteBloc(@PathVariable Long id) {
        blocService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
