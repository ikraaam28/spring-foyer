package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.User;
import tn.esprit.tpfoyer.services.IEtudiantService;

import java.util.List;
import java.util.Optional;

@Tag(name = "Gestion Etudiants", description = "API pour la gestion des étudiants dans le système")
@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    IEtudiantService iEtudiantService;

    @Operation(summary = "Créer ou mettre à jour un utilisateur", description = "Crée un nouvel utilisateur ou met à jour un utilisateur existant.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Utilisateur créé ou mis à jour avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur lors de la création ou mise à jour de l'utilisateur")
    })
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = iEtudiantService.saveOrUpdateUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Obtenir tous les utilisateurs", description = "Récupère la liste de tous les utilisateurs dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste d'utilisateurs trouvée"),
            @ApiResponse(responseCode = "204", description = "Aucun utilisateur trouvé")
    })
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = iEtudiantService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(summary = "Obtenir un utilisateur par ID", description = "Récupère les détails d'un utilisateur spécifique par son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateur trouvé"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé avec cet ID")
    })
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = iEtudiantService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Supprimer un utilisateur par ID", description = "Supprime un utilisateur de la base de données en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Utilisateur supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé pour la suppression"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur lors de la suppression de l'utilisateur")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        iEtudiantService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
