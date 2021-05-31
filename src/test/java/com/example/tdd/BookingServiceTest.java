package com.example.tdd;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.model.BookingModel;
import com.example.tdd.repository.BookingRepository;
import com.example.tdd.service.BookingService;


//@RunWith(RunExtension.class) em versões do Junit inferior a 5

@ExtendWith(SpringExtension.class)
public class BookingServiceTest {
	
	@TestConfiguration
	static class BookingServiceTestConfiguration{
		
		@Bean
		public BookingService bookingService() {
			return new BookingService();
		}
	}

	@Autowired
	BookingService bookingService;
	
	@MockBean
	BookingRepository bookingRepository;
	
	@Test
	public void bookingTestServiceDayCalculator() {
		String name = "Renan";
		int days = bookingService.daysCalculatorWithDatabase(name);
		
		Assertions.assertEquals(days, 10);
	}
	
	//@Before em versões do Junit inferior a 5
	
	@BeforeEach
	public void setup() {
		LocalDate checkIn = LocalDate.parse("2021-05-31");
		LocalDate checkOut = LocalDate.parse("2021-06-10");
		BookingModel bookingModel = new BookingModel("1", "Renan", checkIn, checkOut, 2);
		
		Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
			.thenReturn(Optional.of(bookingModel));
	}
}
