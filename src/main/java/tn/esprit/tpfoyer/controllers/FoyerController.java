package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.services.IFoyerService;

import java.util.List;

@Tag(name = "Gestion Foyers", description = "API pour la gestion des foyers dans le système")
@RestController
@RequestMapping("/api/foyers")
public class FoyerController {

    @Autowired
    IFoyerService iFoyerService;

    @Operation(summary = "Créer un foyer", description = "Permet de créer un nouveau foyer dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Foyer créé avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur lors de la création du foyer")
    })
    @PostMapping
    public ResponseEntity<Foyer> createFoyer(@RequestBody Foyer foyer) {
        Foyer createdFoyer = iFoyerService.createFoyer(foyer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFoyer);
    }

    @Operation(summary = "Obtenir un foyer par ID", description = "Récupère les détails d'un foyer spécifique par son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Foyer trouvé"),
            @ApiResponse(responseCode = "404", description = "Foyer non trouvé avec cet ID")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Object> readFoyerById(@PathVariable Long id) {
        Foyer foyer = iFoyerService.readFoyerById(id);
        if (foyer != null) {
            return ResponseEntity.ok(foyer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Foyer avec l'ID " + id + " n'a pas été trouvé.");
        }
    }

    @Operation(summary = "Obtenir tous les foyers", description = "Récupère la liste de tous les foyers de la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste de foyers trouvée"),
            @ApiResponse(responseCode = "204", description = "Aucun foyer trouvé")
    })
    @GetMapping
    public ResponseEntity<List<Foyer>> readAllFoyers() {
        List<Foyer> foyers = iFoyerService.readAllFoyers();
        return ResponseEntity.ok(foyers);
    }

    @Operation(summary = "Mettre à jour un foyer", description = "Met à jour les informations d'un foyer existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Foyer mis à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Foyer non trouvé pour la mise à jour")
    })
    @PutMapping
    public ResponseEntity<String> updateFoyer(@RequestBody Foyer foyer) {
        Foyer updatedFoyer = iFoyerService.updateFoyer(foyer);
        if (updatedFoyer != null) {
            return ResponseEntity.ok("Foyer mis à jour avec succès.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Foyer non trouvé.");
    }

    @Operation(summary = "Supprimer un foyer par ID", description = "Supprime un foyer de la base de données en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Foyer supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Foyer non trouvé pour la suppression"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur lors de la suppression du foyer")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFoyer(@PathVariable Long id) {
        iFoyerService.deleteFoyer(id);
        return ResponseEntity.ok("Foyer supprimé avec succès.");
    }
}
