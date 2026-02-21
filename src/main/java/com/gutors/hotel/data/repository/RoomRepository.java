package com.gutors.hotel.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gutors.hotel.data.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    
    Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);

}
