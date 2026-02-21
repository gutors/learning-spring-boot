package com.gutors.hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gutors.hotel.data.entity.Room;
import com.gutors.hotel.data.repository.RoomRepository;

@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;

    public CLRunner(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

	@Override
	public void run(String... args) throws Exception {
        Optional<Room> room =roomRepository.findByRoomNumberIgnoreCase("p1");
        List<Room> rooms = roomRepository.findAll();

        System.out.println("Room found: " + room);
        // System.out.println("All rooms: " + rooms);
        rooms.forEach(System.out::println);
	}
    
}
