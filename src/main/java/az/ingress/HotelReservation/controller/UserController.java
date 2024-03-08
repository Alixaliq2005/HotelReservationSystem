package az.ingress.HotelReservation.controller;

import az.ingress.HotelReservation.dto.LoginDto;
import az.ingress.HotelReservation.dto.UserRegisterDto;
import az.ingress.HotelReservation.entity.ResetPassword;
import az.ingress.HotelReservation.entity.User;
import az.ingress.HotelReservation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {


    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterDto userRegisterDto) {
        userService.register (userRegisterDto);
        return new ResponseEntity<> ("User registered successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<> (userService.findUser (id), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) {
        if (userService.login (loginDto)) {
            return new ResponseEntity<> ("User login successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<> ("Password and userName is incorrect", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPassword resetPassword) {
        userService.resetPassword(resetPassword);
        return new ResponseEntity<> ("User reset the password", HttpStatus.CREATED);
    }

}
