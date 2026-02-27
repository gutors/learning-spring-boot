package com.gutors.hotel.web.api;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gutors.hotel.data.entity.Room;
import com.gutors.hotel.data.repository.RoomRepository;
import com.gutors.hotel.web.exception.BadRequestException;
import com.gutors.hotel.web.exception.NotFoundException;

@RestController
@RequestMapping("/api/rooms")
public class RoomApiController {
    
    private final RoomRepository roomRepository;

    public RoomApiController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("")
    public List<Room> getRooms() {
        return this.roomRepository.findAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Room createRoom(@RequestBody Room room) {
        Room entity = this.roomRepository.save(room);
        
        return entity;
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        Optional<Room> room = this.roomRepository.findById(id);
        
        if (room.isEmpty()) {
            throw new NotFoundException("Room not found with id: " + id);
        }

        return room.get();
    }
    
    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room room) {
        if (id != room.getId()) {
            throw new BadRequestException("Room ID mismatch");
        }
        
        return this.roomRepository.save(room);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteRoom(@PathVariable Long id) {
        this.roomRepository.deleteById(id);
    }
    
}