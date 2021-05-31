package com.example.tdd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.BookingModel;

public interface BookingRepository extends JpaRepository<BookingModel , String> {
	
	Optional<BookingModel> findByReserveName(String name);
}
