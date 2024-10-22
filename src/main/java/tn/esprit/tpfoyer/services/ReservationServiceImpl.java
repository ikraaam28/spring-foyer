package tn.esprit.tpfoyer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.ReservationRepository;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService{
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void delete(int id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation readById(int id) {
        return reservationRepository.findById(id).orElse(new Reservation());
    }

    @Override
    public List<Reservation> readAll() {
        return reservationRepository.findAll();
    }
}
