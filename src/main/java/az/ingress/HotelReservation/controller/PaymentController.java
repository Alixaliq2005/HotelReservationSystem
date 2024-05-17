package az.ingress.HotelReservation.controller;

import az.ingress.HotelReservation.dto.request.PaymentRequest;
import az.ingress.HotelReservation.dto.response.PaymentResponse;
import az.ingress.HotelReservation.entity.Payment;
import az.ingress.HotelReservation.service.PaymentServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentServiceImpl paymentService;


    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(paymentService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponse>> findAll(){
        return new ResponseEntity<>(paymentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PaymentResponse> save(@RequestBody PaymentRequest paymentRequest){
        return new ResponseEntity<>(paymentService.save(paymentRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> update(@RequestBody PaymentRequest paymentRequest,
                                          @PathVariable Long id){
        return new ResponseEntity<>(paymentService.update(paymentRequest, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        paymentService.delete(id);
    }
}
