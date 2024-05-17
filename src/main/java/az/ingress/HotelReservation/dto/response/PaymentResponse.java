package az.ingress.HotelReservation.dto.response;


import az.ingress.HotelReservation.entity.PaymentMethod;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentResponse {
    Long id;

    String paymentAmount;

    String paymentDate;

    PaymentMethod paymentMethod;

}
