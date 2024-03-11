package az.ingress.HotelReservation.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "reset_Password")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResetPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String email;

    String oldPassword;

    String newPassword;
}
