
# Reservas

Este servicio es parte integral del proyecto desarrollado como parte del curso de Spring Boot en Ada School. El proyecto se compone de dos microservicios: el controlador `BookingController` y el servicio asociado `BookingService`. El controlador expone un endpoint `PUT /bookings/{idBooking}` diseñado para actualizar información de reservas mediante el servicio correspondiente. El objetivo principal del proyecto es demostrar el uso de Spring Boot en la construcción de microservicios y su integración para implementar funcionalidades de gestión de reservas.

## Registro de Reserva

Cuando creas una nueva reserva, debes utilizar el endpoint `/v1/bookin`. Debes pasar los datos en formato JSON para la reserva y el usuario. El usuario puede ser nuevo o puede ya existir en la base de datos. Aquí hay un ejemplo:

```json
{
  "nameHotel": "Santurban Cúcuta",
  "roomNumber": 22,
  "durationBooking": 10,
  "userData": [
    {
      "firstName": "Homero",
      "lastName": "Simpson",
      "birthDay": "2020-12-02",
      "email": "nidiosat88@mail.com",
      "password": "nncczz"
    }
  ]
}
````
![Entidades](https://github.com/juanjose999/booking/blob/main/hotel.png?raw=true)https://github.com/juanjose999/booking/blob/main/hotel.png?raw=true)
