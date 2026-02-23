package com.gutors.hotel;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gutors.hotel.data.repository.GuestRepository;
import com.gutors.hotel.data.repository.ReservationRepository;
import com.gutors.hotel.data.repository.RoomRepository;
import com.gutors.hotel.service.RoomReservationService;
import com.gutors.hotel.service.model.RoomReservation;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    private final RoomReservationService roomReservationService;

    public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.roomReservationService = new RoomReservationService(guestRepository, roomRepository, reservationRepository);
    }

	@Override
	public void run(String... args) throws Exception {
        List<RoomReservation> roomReservations = roomReservationService.getRoomReservationsForDate("2023-08-28");

        roomReservations.forEach(System.out::println);
        // Optional<Room> room =roomRepository.findByRoomNumberIgnoreCase("p1");
        // List<Room> rooms = roomRepository.findAll();
        // List<Guest> guests = guestRepository.findAll();
        // List<Reservation> reservations = reservationRepository.findAll();

        // System.out.println("Room found: " + room.get().toString());
        
        // System.out.println("### ROOMS ### ");
        // rooms.forEach(System.out::println);

        // System.out.println("### GUESTS ### ");
        // guests.forEach(System.out::println);

        // System.out.println("### RESERVATIONS ### ");
        // reservations.forEach(System.out::println);
	}
    
}
