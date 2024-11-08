package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.services.IChambreService;

import java.util.List;
import java.util.Optional;

@Tag(name = "Gestion Chambres", description = "API pour la gestion des chambres dans le système")
@RestController
@RequestMapping("/api/chambres")
public class ChambreController {

    @Autowired
    IChambreService chambreService;

    @Operation(summary = "Créer ou mettre à jour une chambre", description = "Crée une nouvelle chambre ou met à jour une chambre existante.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Chambre créée ou mise à jour avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur lors de la création ou mise à jour de la chambre")
    })
    @PostMapping
    public ResponseEntity<Chambre> saveChambre(@RequestBody Chambre chambre) {
        Chambre savedChambre = chambreService.saveOrUpdateChambre(chambre);
        return new ResponseEntity<>(savedChambre, HttpStatus.CREATED);
    }

    @Operation(summary = "Obtenir toutes les chambres", description = "Récupère la liste de toutes les chambres dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste de chambres trouvée"),
            @ApiResponse(responseCode = "204", description = "Aucune chambre trouvée")
    })
    @GetMapping
    public ResponseEntity<List<Chambre>> getAllChambres() {
        List<Chambre> chambres = chambreService.getAllChambres();
        return new ResponseEntity<>(chambres, HttpStatus.OK);
    }

    @Operation(summary = "Obtenir une chambre par ID", description = "Récupère les détails d'une chambre spécifique par son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chambre trouvée"),
            @ApiResponse(responseCode = "404", description = "Chambre non trouvée avec cet ID")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getChambreById(@PathVariable Long id) {
        Optional<Chambre> chambre = chambreService.getChambreById(id);
        return chambre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Supprimer une chambre par ID", description = "Supprime une chambre de la base de données en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Chambre supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Chambre non trouvée pour la suppression"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur lors de la suppression de la chambre")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable Long id) {
        chambreService.deleteChambre(id);
        return ResponseEntity.noContent().build();
    }
}
