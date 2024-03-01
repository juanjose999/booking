package com.booking;

import com.booking.dto.UserResponseDto;
import com.booking.model.Booking;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BookingApplicationTests {

	@Test
	public void testGetAllBooking(){
		BookingController bookingController = new BookingController;

		List<Booking> bookingList = bookingController.getAllBookings;

		assertEquals(2, bookingList.size());
	}

	@Test
	public void testfindBookingById(){
		BookingController bookingController = new BookingController;

		BookingResponseDto bookingResponseDto = bookingController.findById;

		List<UserResponseDto> userListExpect = Array.asList(
				new UserResponseDto("123zxc","Jamilton","Ordaz","ordaz@gmail.com","passxxx"));

		BookingResponseDto expect = new BookingResponseDto("f24f44", "ADA", userListExpect,2024, 3, 1, 2024, 3, 6);

		assertEquals(bookingResponseDto, result);
	}

	@Test
	public void testSaveBooking(){
		BookingController bookingController = new BookingController;

		BookingResponseDto bookingResponseDto = bookingController.saveBooking(bookingResponseDto);

		List<UserResponseDto> userListExpect = Array.asList(
				new UserResponseDto("123zxc","Jamilton","Ordaz","ordaz@gmail.com","passxxx"));
		BookingResponseDto expect = new BookingResponseDto("f24f44", "ADA", userListExpect,2024, 3, 1, 2024, 3, 6);

		assertEqual(bookingResponseDto, expect);
	}

	@Test
	public void testUpdateBooking(){
		BookingController bookingController = new BookingController;

		BookingResponseDto updateBooking = bookingController.updateBooking("123", bookingResquestDto);

		List<UserResponseDto> userListExpect = Array.asList(
				new UserResponseDto("123zxc","Jamilton","Ordaz","ordaz@gmail.com","passxxx"));
		BookingResponseDto expectedUpdatedBookingResponseDto = new BookingResponseDto("f24f44", "ADA", updatedUserListExpect, LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 6));

		assertEquals(expectedUpdatedBookingResponseDto, expectedUpdatedBookingResponseDto);

	}

	@Test
	public void testDeleteBooking(){
		BookingController bookingController = new BookingController;

		String bookingIdToDelete = "123db";

		boolean isBookingDeleted = bookingController.deleteBooking(bookingIdToDelete);

		assertTrue(isBookingDeleted);
	}
}
