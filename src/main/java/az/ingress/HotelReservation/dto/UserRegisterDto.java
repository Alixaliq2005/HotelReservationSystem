package az.ingress.HotelReservation.dto;

import lombok.Data;

@Data
public class UserRegisterDto extends UserDto {

    String repeatPassword;

}
