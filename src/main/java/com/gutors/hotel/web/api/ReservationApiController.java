package com.gutors.hotel.web.api;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gutors.hotel.data.entity.Reservation;
import com.gutors.hotel.data.repository.ReservationRepository;
import com.gutors.hotel.web.exception.BadRequestException;
import com.gutors.hotel.web.exception.NotFoundException;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {

    private final ReservationRepository reservationRepository;

    public ReservationApiController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("")
    public List<Reservation> getReservations(@RequestParam(required = false) String reservationDate) {
        if (reservationDate != null) {
            return reservationRepository.findAllByReservationDate(Date.valueOf(reservationDate));
        } else {
            return reservationRepository.findAll();
        }
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        
        if (reservation.isPresent()) {
            return reservation.get();
        } else {
            throw new NotFoundException("Reservation not found with id: " + id);
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation createReservation(@RequestBody Reservation entity) {
        return reservationRepository.save(entity);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation entity) {
        if (id != entity.getId()) {
            throw new BadRequestException("Reservation ID mismatch");
        }

        return reservationRepository.save(entity);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteReservation(@PathVariable Long id) {
        this.reservationRepository.deleteById(id);
    }
    
}
