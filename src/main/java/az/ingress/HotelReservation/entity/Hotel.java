package az.ingress.HotelReservation.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String hotelName;
    String location;
    @Enumerated(EnumType.STRING)
    RoomType roomType;
    String parking;
    Boolean taxi_service;
    @Enumerated(EnumType.STRING)
    Meal meal;
    Double price;

    Boolean swimming_pool;

}