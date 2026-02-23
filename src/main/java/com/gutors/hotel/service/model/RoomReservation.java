package com.gutors.hotel.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomReservation {

    private Long roomId;
    private String roomName;
    private String roomNumber;
    private Long guestId;
    private String firstName;
    private String lastName;
    private Long reservationId;
    private String reservationDate;
    
}
