package com.booking;

import com.booking.controller.booking.BookingController;
import com.booking.dto.booking.BookingDto;
import com.booking.dto.booking.BookingMapper;
import com.booking.dto.booking.BookingResponseDto;
import com.booking.model.booking.Booking;
import com.booking.service.booking.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;


import static org.bson.assertions.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put; // Import the correct put method
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
@SpringBootTest
class BookingApplicationTests {

	final String URL = "/booking";

	@MockBean
	private BookingService bookingService;

	@Autowired
	private BookingController bookingController;
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = standaloneSetup(bookingController).build();
	}



	@Test
	public void testGetAllBookingList(){
		BookingResponseDto object1 = FakeDataBookingResponsDto.getObject1();
		BookingResponseDto object2 = FakeDataBookingResponsDto.getObject2();
		List<BookingResponseDto> mockBookings = Arrays.asList(object1, object2);

		when(bookingService.getAllBooking()).thenReturn(mockBookings);

		// Ejecutar el método del controlador
		ResponseEntity<List<BookingResponseDto>> responseEntity = bookingController.getAllBookings();

		// Verificar el resultado
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(mockBookings, responseEntity.getBody());
	}
	@Test
	public void testFindBookingByIdExistingBooking() throws Exception {

	}




	@Test
	public void testFindBookingByIdNotExisting() throws Exception {

	}

	@Test
	public void testSaveNewBooking() throws Exception {

	}


	@Test
	public void testUpdateBookingExisting() throws Exception {

	}



	@Test
	public void testDeleteBooking(){
		BookingDto bookingDto = FakeDataBookingResponsDto.getObject3();
		Booking booking = BookingMapper.bookingDtoToBooking(bookingDto);
		when(bookingService.findBookingById("1")).thenReturn(Optional.of(BookingMapper.bookingToBookingResponseDto(booking)));;

		// Llamar al método de eliminación
		bookingService.deleteBooking("1");

		verify(bookingService, Mockito.times(1)).deleteBooking("1");

	}
}

