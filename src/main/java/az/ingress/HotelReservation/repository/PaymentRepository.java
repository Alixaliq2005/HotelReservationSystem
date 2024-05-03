package az.ingress.HotelReservation.repository;


import az.ingress.HotelReservation.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
