package com.bookingService.booking.dao;

import com.bookingService.booking.entity.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingInfoEntityDao extends JpaRepository <BookingInfoEntity, Integer> {
}
