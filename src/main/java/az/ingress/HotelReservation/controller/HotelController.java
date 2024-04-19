package az.ingress.HotelReservation.controller;

import az.ingress.HotelReservation.dto.request.HotelRequest;
import az.ingress.HotelReservation.dto.response.HotelResponse;
import az.ingress.HotelReservation.entity.Hotel;
import az.ingress.HotelReservation.entity.RoomType;
import az.ingress.HotelReservation.service.HotelServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;


import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels")
public class HotelController {

    private final HotelServiceImpl hotelService;

    @GetMapping
    public ResponseEntity<List<HotelResponse>> findAll() {
        return new ResponseEntity<> (hotelService.findAll (), HttpStatus.OK);
    }




    @GetMapping("/singleRooms")
    public ResponseEntity<List<Hotel>> findSingleRooms() {
        List<Hotel> singleRooms = hotelService.findSingleRooms();
        return new ResponseEntity<>(singleRooms, HttpStatus.OK);
    }

    @GetMapping("/doubleRooms")
    public ResponseEntity<List<Hotel>> findDoubleRooms() {
        List<Hotel> doubleRooms = hotelService.findDoubleRooms();
        return new ResponseEntity<>(doubleRooms, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<HotelResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<> (hotelService.findById (id), HttpStatus.OK);
    }

    @PostMapping("/createHotel")
    public ResponseEntity<HotelResponse> save(@RequestBody HotelRequest hotelRequest) {
        return new ResponseEntity<> (hotelService.save (hotelRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> update(@PathVariable Long id, @RequestBody HotelRequest hotelRequest) {
        return new ResponseEntity<> (hotelService.update (id, hotelRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        hotelService.delete (id);
    }
}
