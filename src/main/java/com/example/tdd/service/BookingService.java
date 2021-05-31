package com.example.tdd.service;

import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.BookingModel;
import com.example.tdd.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingRepository;

	public int daysCalculatorWithDatabase(String name) {
		Optional<BookingModel> bookingModelOptional = bookingRepository.findByReserveName(name);
		// retornar os dias entre checkIn e checkOut
		return Period.between(bookingModelOptional.get().getCheckIn(), bookingModelOptional.get().getCheckOut()).getDays();
	}

}
