package az.ingress.HotelReservation.service;


import az.ingress.HotelReservation.dto.request.PaymentRequest;
import az.ingress.HotelReservation.dto.response.PaymentResponse;
import az.ingress.HotelReservation.entity.Payment;
import az.ingress.HotelReservation.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl{

    private final PaymentRepository paymentRepository;

    private final ModelMapper modelMapper;

    public PaymentResponse findById(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() ->
                new RuntimeException ());
        return modelMapper.map(payment, PaymentResponse.class);
    }


    public List<PaymentResponse> findAll() {
        return paymentRepository
                .findAll()
                .stream()
                .map(payment -> modelMapper.map(payment, PaymentResponse.class))
                .collect(Collectors.toList());
    }


    public PaymentResponse save(PaymentRequest paymentRequest) {
        Payment payment = modelMapper.map(paymentRequest, Payment.class);
        return modelMapper.map(paymentRepository.save(payment), PaymentResponse.class);
    }


    public Payment update(PaymentRequest paymentRequest, Long id) {
        paymentRepository.findById(id).orElseThrow(() -> new RuntimeException ());
        Payment responsePayment = modelMapper.map(paymentRequest, Payment.class);
        responsePayment.setPaymentId(id);
        return modelMapper.map(paymentRepository.save(responsePayment), Payment.class);
    }


    public void delete(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(() ->
                new RuntimeException ());
        paymentRepository.delete(payment);
    }
}
