package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation createReservation(Reservation reservation);

    void deleteReservation(Long id);

    Reservation updateReservation(Reservation reservation);

    Reservation readReservationById(Long id);

    List<Reservation> readAllReservations();
}
