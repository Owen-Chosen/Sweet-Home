package com.bookingService.booking.controller;

import com.bookingService.booking.dao.BookingInfoEntityDao;
import com.bookingService.booking.entity.BookingInfoEntity;
import com.bookingService.booking.service.BookingServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.awt.*;

@RestController
@RequestMapping (value = "/hotel")
public class BookingServiceController {

    @Autowired
    BookingServiceImpl bookingServiceImpl;

    @Autowired
    BookingInfoEntity bookingInfoEntity;


    @PostMapping (value = "/booking", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <BookingInfoEntity> addNewBooking (@RequestBody BookingInfoEntity bookingInfoEntity) {
        return new ResponseEntity <BookingInfoEntity>
                (bookingServiceImpl.acceptBookingDetails(bookingInfoEntity), HttpStatus.CREATED);
    }

    @PostMapping (value = "booking/{bookingId}/transaction" , consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <BookingInfoEntity> initiateTransaction (@PathVariable(name = "bookingId") int id,
                                                                   @RequestBody Object paymentDetails ) {
        return new ResponseEntity <BookingInfoEntity>
                (bookingServiceImpl.acceptPaymentDetails(paymentDetails), HttpStatus.CREATED);
    }

}
