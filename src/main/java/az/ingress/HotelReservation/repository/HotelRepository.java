package az.ingress.HotelReservation.repository;


import az.ingress.HotelReservation.entity.Hotel;
import az.ingress.HotelReservation.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
    List<Hotel> findByRoomType(RoomType roomType);
}
