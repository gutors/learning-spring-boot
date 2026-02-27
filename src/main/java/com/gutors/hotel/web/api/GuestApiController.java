package com.gutors.hotel.web.api;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gutors.hotel.data.entity.Guest;
import com.gutors.hotel.data.repository.GuestRepository;
import com.gutors.hotel.web.exception.BadRequestException;
import com.gutors.hotel.web.exception.NotFoundException;

@RestController
@RequestMapping("/api/guests")
public class GuestApiController {
    
    private final GuestRepository guestRepository;

    public GuestApiController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping("")
    public List<Guest> getGuests() {
        return guestRepository.findAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Guest createGuest(@RequestBody Guest guest) {
        guestRepository.save(guest);

        return guest;
    }
    
    @GetMapping("/{id}")
    public Guest getGuestById(@RequestParam Long id) {
        Optional<Guest> guest = guestRepository.findById(id);

        if (guest.isEmpty()) {
            throw new NotFoundException("Guest not found with id: " + id);
        }

        return guest.get();
    }
    
    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable Long id, @RequestBody Guest guest) {
        if (id != guest.getId()) {
            throw new BadRequestException("Guest ID mismatch");
        }
        
        return guestRepository.save(guest);
    }
    

}