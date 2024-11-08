package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.services.IUniversiteService;

import java.util.List;
import java.util.Optional;

@Tag(name = "Gestion Universités", description = "API pour la gestion des universités dans le système")
@RestController
@RequestMapping("/api/universites")
public class UniversiteController {

    @Autowired
    IUniversiteService universiteService;

    @Operation(summary = "Créer ou mettre à jour une université", description = "Permet de créer une nouvelle université ou de mettre à jour une université existante.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Université créée ou mise à jour avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur lors de la sauvegarde ou de la mise à jour de l'université")
    })
    @PostMapping
    public ResponseEntity<Universite> saveUniversite(@RequestBody Universite universite) {
        Universite savedUniversite = universiteService.saveOrUpdateUniversite(universite);
        return new ResponseEntity<>(savedUniversite, HttpStatus.CREATED);
    }

    @Operation(summary = "Obtenir toutes les universités", description = "Récupère la liste de toutes les universités de la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste des universités trouvée"),
            @ApiResponse(responseCode = "204", description = "Aucune université trouvée")
    })
    @GetMapping
    public ResponseEntity<List<Universite>> getAllUniversites() {
        List<Universite> universites = universiteService.getAllUniversites();
        return new ResponseEntity<>(universites, HttpStatus.OK);
    }

    @Operation(summary = "Obtenir une université par ID", description = "Récupère les détails d'une université spécifique par son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Université trouvée"),
            @ApiResponse(responseCode = "404", description = "Université non trouvée avec cet ID")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Universite> getUniversiteById(@PathVariable Long id) {
        Optional<Universite> universite = universiteService.getUniversiteById(id);
        return universite.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Supprimer une université par ID", description = "Supprime une université de la base de données en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Université supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Université non trouvée pour la suppression"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur lors de la suppression de l'université")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
        return ResponseEntity.noContent().build();
    }
}
