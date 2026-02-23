package com.gutors.hotel.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gutors.hotel.service.RoomReservationService;

import io.micrometer.common.util.StringUtils;


@Controller
@RequestMapping("/occupancy")
public class OccupancyController {
    
    private final RoomReservationService roomReservationService;

    public OccupancyController(RoomReservationService roomReservationService) {
        this.roomReservationService = roomReservationService;
    }

    @GetMapping
    public String getMethodName(Model model,
         @RequestParam(value = "date", required = false) String dateString) {
        Date date = new Date();

        if (StringUtils.isNotBlank(dateString)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = dateFormat.parse(dateString);
            } catch (ParseException e) {
                // Handle parsing error gracefully
                throw new IllegalArgumentException("Invalid date format", e);
            }
        }

        model.addAttribute("date", date);
        model.addAttribute("reservations", roomReservationService.getRoomReservationsForDate(dateString));

        return "occupancy";
    }
    
}
