package com.gutors.hotel.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "guests")
@Data
public class Guest {
    
    @Id
    @Column(name = "guest_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name="country")
    private String country;

    @Column(name="state")
    private String state;

    @Column(name = "phone_number")
    private String phoneNumber;
    
}
