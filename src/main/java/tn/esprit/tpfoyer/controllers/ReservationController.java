package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.services.IReservationService;

import java.util.List;

@Tag(name = "Gestion Réservations", description = "API pour la gestion des réservations dans le système")
@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    IReservationService iReservationService;

    @Operation(summary = "Créer une réservation", description = "Permet de créer une nouvelle réservation dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Réservation créée avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur lors de la création de la réservation")
    })
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        try {
            Reservation createdReservation = iReservationService.createReservation(reservation);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdReservation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "Obtenir une réservation par ID", description = "Récupère les détails d'une réservation spécifique par son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Réservation trouvée"),
            @ApiResponse(responseCode = "404", description = "Réservation non trouvée avec cet ID")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Object> readReservationById(@PathVariable Long id) {
        Reservation reservation = iReservationService.readReservationById(id);
        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Réservation avec l'ID " + id + " n'a pas été trouvée.");
        }
    }

    @Operation(summary = "Obtenir toutes les réservations", description = "Récupère la liste de toutes les réservations dans la base de données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Liste de réservations trouvée"),
            @ApiResponse(responseCode = "204", description = "Aucune réservation trouvée")
    })
    @GetMapping
    public ResponseEntity<List<Reservation>> readAllReservations() {
        List<Reservation> reservations = iReservationService.readAllReservations();
        if (reservations.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(reservations);
        }
        return ResponseEntity.ok(reservations);
    }

    @Operation(summary = "Mettre à jour une réservation", description = "Met à jour les informations d'une réservation existante.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Réservation mise à jour avec succès"),
            @ApiResponse(responseCode = "404", description = "Réservation non trouvée pour la mise à jour"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur lors de la mise à jour de la réservation")
    })
    @PutMapping
    public ResponseEntity<String> updateReservation(@RequestBody Reservation reservation) {
        try {
            Reservation updatedReservation = iReservationService.updateReservation(reservation);
            if (updatedReservation != null) {
                return ResponseEntity.ok("Réservation mise à jour avec succès avec l'ID : " + updatedReservation.getIdReservation());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Réservation avec l'ID " + reservation.getIdReservation() + " n'a pas été trouvée.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la mise à jour de la réservation : " + e.getMessage());
        }
    }

    @Operation(summary = "Supprimer une réservation par ID", description = "Supprime une réservation de la base de données en utilisant son ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Réservation supprimée avec succès"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur lors de la suppression de la réservation")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id) {
        try {
            iReservationService.deleteReservation(id);
            return ResponseEntity.ok("Réservation supprimée avec succès avec l'ID : " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de la réservation : " + e.getMessage());
        }
    }
}
