package az.ingress.HotelReservation.dto.request;

import az.ingress.HotelReservation.entity.PaymentMethod;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentRequest {
    String paymentAmount;

    String paymentDate;

    PaymentMethod paymentMethod;
}
