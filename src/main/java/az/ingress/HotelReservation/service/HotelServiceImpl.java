package az.ingress.HotelReservation.service;


import az.ingress.HotelReservation.dto.request.HotelRequest;
import az.ingress.HotelReservation.dto.response.HotelResponse;
import az.ingress.HotelReservation.entity.Hotel;
import az.ingress.HotelReservation.entity.RoomType;
import az.ingress.HotelReservation.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl {

    private final HotelRepository hotelRepository;

    private final ModelMapper modelMapper;

    public HotelResponse findById(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException ());
        return modelMapper.map(hotel, HotelResponse.class);
    }

    public List<HotelResponse> findAll() {
        return hotelRepository
                .findAll()
                .stream()
                .map(hotel -> modelMapper.map(hotel, HotelResponse.class))
                .collect(Collectors.toList());
    }

    public List<Hotel> findSingleRooms() {
        return hotelRepository.findByRoomType(RoomType.SINGLE);
    }



    public List<Hotel> findDoubleRooms() {
        return hotelRepository.findByRoomType(RoomType.DOUBLE);
    }




    public HotelResponse save(HotelRequest hotelRequest) {
        Hotel hotel = modelMapper.map(hotelRequest, Hotel.class);
        return modelMapper.map(hotelRepository.save(hotel), HotelResponse.class);
    }

    public Hotel update(Long id, HotelRequest hotelRequest) {
        hotelRepository.findById(id).orElseThrow(() -> new RuntimeException ());
        Hotel responseHotel = modelMapper.map(hotelRequest, Hotel.class);
        responseHotel.setId(id);
        return modelMapper.map(hotelRepository.save(responseHotel), Hotel.class);
    }


    public void delete(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException ());
        hotelRepository.delete(hotel);
    }
}
