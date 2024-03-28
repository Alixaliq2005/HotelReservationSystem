package az.ingress.HotelReservation.dto.response;

import az.ingress.HotelReservation.entity.RoomType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotelResponse {
    Long id;

    String hotelName;

    String location;

    RoomType roomType;

    Double price;



}
