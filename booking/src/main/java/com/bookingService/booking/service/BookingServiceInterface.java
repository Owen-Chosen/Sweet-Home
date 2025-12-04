package com.bookingService.booking.service;

import com.bookingService.booking.entity.BookingInfoEntity;
import org.springframework.stereotype.Service;

@Service
public interface BookingServiceInterface {

    public BookingInfoEntity acceptBookingDetails ( BookingInfoEntity bookingInfoEntity );

    public BookingInfoEntity acceptPaymentDetails ( Object paymentDetails );

}
