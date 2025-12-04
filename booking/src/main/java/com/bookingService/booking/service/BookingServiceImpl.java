package com.bookingService.booking.service;

import com.bookingService.booking.dao.BookingInfoEntityDao;
import com.bookingService.booking.entity.BookingInfoEntity;
import com.bookingService.booking.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class BookingServiceImpl implements BookingServiceInterface{

    @Autowired
    BookingInfoEntityDao bookingInfoEntityDao;

    @Autowired
    RestTemplate restTemplate;

    public static ArrayList<String> getRandomNumbers(int count){
        Random rand = new Random();
        int upperBound = 100;
        ArrayList<String>numberList = new ArrayList<String>();
        for (int i=0; i<count; i++){
            numberList.add(String.valueOf(rand.nextInt(upperBound)));
        }
        return numberList;
    }

    @Override
    public BookingInfoEntity acceptBookingDetails(BookingInfoEntity bookingInfoEntity) {

        BookingInfoEntity bookingInfoEntity1 = new BookingInfoEntity();
        bookingInfoEntity1.setToDate(bookingInfoEntity.getToDate());
        bookingInfoEntity1.setFromDate(bookingInfoEntity.getFromDate());
        bookingInfoEntity1.setAadharNumber(bookingInfoEntity.getAadharNumber());
        bookingInfoEntity1.setNumOfRooms(bookingInfoEntity.getNumOfRooms());
        bookingInfoEntity1.setRoomNumbers(getRandomNumbers(bookingInfoEntity1.getNumOfRooms()).toString());
        bookingInfoEntity1.setRoomPrice(1000 * bookingInfoEntity1.getNumOfRooms());
        bookingInfoEntity1.setBookedOn(new Date());

        return bookingInfoEntityDao.save(bookingInfoEntity1);
    }

    @Override
    public BookingInfoEntity acceptPaymentDetails ( Object paymentDetails ) {
        String url = "http://localhost:8083/payment/transaction";
        return bookingInfoEntityDao.findById(restTemplate.postForObject(url,
                paymentDetails, Integer.class)).orElseThrow(
                ()-> new RecordNotFoundException("Invalid Booking Id"));

    }
}