package com.gutors.hotel.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gutors.hotel.data.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
