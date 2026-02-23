package com.gutors.hotel.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gutors.hotel.data.entity.Guest;
import com.gutors.hotel.data.entity.Reservation;
import com.gutors.hotel.data.entity.Room;
import com.gutors.hotel.data.repository.GuestRepository;
import com.gutors.hotel.data.repository.ReservationRepository;
import com.gutors.hotel.data.repository.RoomRepository;
import com.gutors.hotel.service.model.RoomReservation;

import io.micrometer.common.util.StringUtils;

@Service
public class RoomReservationService {
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    public RoomReservationService(GuestRepository guestRepository, RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(String reservationDate) {
        Date date = null;

        if (StringUtils.isEmpty(reservationDate)) {
            date = new Date(System.currentTimeMillis());
        } else {
            date = Date.valueOf(reservationDate);
        }

        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        List<Room> rooms = roomRepository.findAll();
        List<Reservation> reservations = reservationRepository.findAllByReservationDate(date);
        
        rooms.forEach(room -> {
            RoomReservation roomReservatoin = new RoomReservation();
            roomReservatoin.setRoomId(room.getId());
            roomReservatoin.setRoomName(room.getRoomName());
            roomReservatoin.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getId(), roomReservatoin);
        });
        
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setReservationDate(reservationDate);
            roomReservation.setGuestId(reservation.getGuestId());
            Guest guest = guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
        });

        return roomReservationMap.values().stream().toList();
    }
    
}
