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
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    String paymentAmount;

    String paymentDate;

    @Enumerated(EnumType.STRING)
    PaymentMethod paymentMethod;


}

