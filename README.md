
#Reservas

Este servicio forma parte del proyecto integrador desarrollado como parte del curso de Spring Boot en Ada School. El proyecto consta de dos microservicios: un controlador `BookingController` y un servicio asociado `BookingService`. El controlador expone un endpoint PUT `/bookings/{idBooking}`, diseñado para actualizar información de reservas utilizando el servicio correspondiente. El objetivo principal del proyecto es demostrar el uso de Spring Boot en la construcción de microservicios y su integración para implementar funcionalidades de gestión de reservas.

#Registro de reserva

Cuando creas una nueva reserva deberas usar el endpoint de /v1/bookin, al cual tendras que pasarle los datos en formato json de la booking y el user, el usuario puede ser nuevo y alguno que ya este en base de datos, ejemplo:

{
  "nameHotel": "Santurban Cucùta", 
  "roomNumber": 22,
  "durationBooking":10,
  "userData": [
    {
        "firstName": "Homero",
        "lastName": "Simson",
        "birthDay": "2020-12-02",
        "email": "nidiosat88@mail.com",
        "password": "nncczz"
    }
  ]
}

![Texto Alternativo]([URL de la Imagen](https://github.com/juanjose999/booking/blob/main/hotel.png?raw=true)https://github.com/juanjose999/booking/blob/main/hotel.png?raw=true)
