package com.booking;

import com.booking.controller.BookingController;
import com.booking.dto.booking.BookingDto;
import com.booking.dto.booking.BookingMapper;
import com.booking.dto.booking.BookingResponseDto;
import com.booking.dto.user.UserDto;
import com.booking.model.Booking;
import com.booking.service.booking.BookingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


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
		BookingResponseDto object1 = FakeDataBookingResponsDto.getObject1();
		when(bookingService.findBookingById(anyString())).thenReturn(object1);

		mockMvc.perform(get(URL + "/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.idBooking").value(object1.getIdBooking()))
				.andExpect(jsonPath("$.nameHotel").value(object1.getNameHotel()))
				.andExpect(jsonPath("$.startBooking").value(object1.getStartBooking().format(DateTimeFormatter.ISO_DATE_TIME)))
				.andExpect(jsonPath("$.endBooking").value(object1.getEndBooking().format(DateTimeFormatter.ISO_DATE_TIME)))
				.andExpect(jsonPath("$.userData[0].firstName").value(object1.getUserData().get(0).getFirstName()))
				.andExpect(jsonPath("$.userData[0].lastName").value(object1.getUserData().get(0).getLastName()))
				.andExpect(jsonPath("$.userData[0].email").value(object1.getUserData().get(0).getEmail()))
				.andExpect(jsonPath("$.userData[0].password").value(object1.getUserData().get(0).getPassword()));


		verify(bookingController, times(1)).findBookingById("1");
	}

	@Test
	public void testFindBookingByIdNotExisting() throws Exception {
		String id = "420";
		when(bookingController.findBookingById(id)).thenReturn(Optional.empty());

		mockMvc.perform(get("URL" + "/" + id))
				.andExpect(status().isNotFound());

		verify(bookingController, times(1)).findBookingById(id);
	}

	@Test
	public void testSaveNewBooking() throws Exception {
		BookingDto bookingDto = FakeDataBookingResponsDto.getObject3();
		Booking booking = BookingMapper.bookingDtoToBooking(bookingDto);
		BookingService bookingServiceMock = Mockito.mock(BookingService.class);

		when(bookingServiceMock.saveBooking(any())).thenReturn(booking);

		ResultActions result = mockMvc.perform(post("/bookings")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(bookingDto)));

		result.andExpect(status().isCreated());
		verify(bookingService.saveBooking(any()));
	}

	@Test
	public void testUpdateBookingExisting() throws JsonProcessingException {
		BookingDto bookingDto = FakeDataBookingResponsDto.getObject3();
		Booking booking = BookingMapper.bookingDtoToBooking(bookingDto);
		BookingService bookingServiceMock = Mockito.mock(BookingService.class);

		when(bookingServiceMock.findBookingById("1")).thenReturn(Optional.of(booking));

		ResultActions result = mockMvc.perform(put("/bookings/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(bookingDto)));

		// Verificar que la solicitud devuelve un estado HTTP 200 OK
		result.andExpect(status().isOk());

		// Obtener la respuesta actualizada del cuerpo de la respuesta
		BookingResponseDto updatedBookingResponseDto = new ObjectMapper()
				.readValue(result.andReturn().getResponse().getContentAsString(), BookingResponseDto.class);
		assertEquals(expectedUpdatedBookingResponseDto, updatedBookingResponseDto);

		// Verificar que el método findBookingById del servicio BookingService fue llamado una vez
		verify(bookingServiceMock, times(1)).findBookingById("1");

	}

	@Test
	public void testDeleteBooking(){
		BookingDto bookingDto = FakeDataBookingResponsDto.getObject3();
		Booking booking = BookingMapper.bookingDtoToBooking(bookingDto);
		when(bookingService.findBookingById("1")).thenReturn(Optional.of(booking));

		// Llamar al método de eliminación
		bookingService.deleteBooking("1");

		verify(bookingService, Mockito.times(1)).deleteBooking("1");

	}
}

