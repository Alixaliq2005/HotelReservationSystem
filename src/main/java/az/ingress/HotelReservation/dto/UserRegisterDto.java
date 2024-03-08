package az.ingress.HotelReservation.dto;

import lombok.Data;

@Data
public class UserRegisterDto {


    String userName;

    String password;

    String repeatPassword;

    String email;
}
