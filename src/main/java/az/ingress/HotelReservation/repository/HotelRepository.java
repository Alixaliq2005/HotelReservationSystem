package az.ingress.HotelReservation.repository;


import az.ingress.HotelReservation.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
