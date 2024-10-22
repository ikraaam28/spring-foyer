package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation create(Reservation reservation);

    Reservation update( Reservation reservation);

    void delete(int id);

    Reservation readById(int id);

    List<Reservation> readAll();
}
