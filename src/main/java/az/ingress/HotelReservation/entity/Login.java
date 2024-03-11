package az.ingress.HotelReservation.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "login")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String userName;

    String password;
}
