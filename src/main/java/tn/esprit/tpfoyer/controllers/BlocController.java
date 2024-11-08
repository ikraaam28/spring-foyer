package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.services.IBlocService;

import java.util.List;

@Tag(name = "Gestion Blocs", description = "API pour la gestion des blocs dans le système")
@RestController
@RequestMapping("/api/blocs")
public class BlocController {

    @Autowired
    IBlocService iBlocService;

    @Operation(summary = "Créer un bloc", description = "Permet de créer un nouveau bloc dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Bloc créé avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur lors de la création du bloc")
    })
    @PostMapping
    public ResponseEntity<Bloc> createBloc(@RequestBody Bloc bloc) {
        try {
            Bloc createdBloc = iBlocService.createBloc(bloc);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBloc);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Obtenir un bloc par ID", description = "Récupère les détails d'un bloc spécifique par son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bloc trouvé"),
            @ApiResponse(responseCode = "404", description = "Bloc non trouvé avec cet ID")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Object> readBlocById(@PathVariable Long id) {
        Bloc bloc = iBlocService.readBlocById(id);
        if (bloc != null) {
            return ResponseEntity.ok(bloc);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Bloc avec l'ID " + id + " n'a pas été trouvé.");
        }
    }

    @Operation(summary = "Obtenir tous les blocs", description = "Récupère la liste de tous les blocs de la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste de blocs trouvée"),
            @ApiResponse(responseCode = "204", description = "Aucun bloc trouvé")
    })
    @GetMapping
    public ResponseEntity<List<Bloc>> readAllBlocs() {
        List<Bloc> blocs = iBlocService.readAllBlocs();
        if (blocs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(blocs);
        }
        return ResponseEntity.ok(blocs);
    }

    @Operation(summary = "Mettre à jour un bloc", description = "Met à jour les informations d'un bloc existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bloc mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Bloc non trouvé pour la mise à jour"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur lors de la mise à jour du bloc")
    })
    @PutMapping
    public ResponseEntity<String> updateBloc(@RequestBody Bloc bloc) {
        try {
            Bloc updatedBloc = iBlocService.updateBloc(bloc);
            if (updatedBloc != null) {
                return ResponseEntity.ok("Bloc mis à jour avec succès avec l'ID : " + updatedBloc.getIdBloc());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Bloc avec l'ID " + bloc.getIdBloc() + " n'a pas été trouvé.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la mise à jour du bloc : " + e.getMessage());
        }
    }

    @Operation(summary = "Supprimer un bloc par ID", description = "Supprime un bloc de la base de données en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bloc supprimé avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur lors de la suppression du bloc")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBloc(@PathVariable Long id) {
        try {
            iBlocService.deleteBloc(id);
            return ResponseEntity.ok("Bloc supprimé avec succès avec l'ID : " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression du bloc : " + e.getMessage());
        }
    }
}
