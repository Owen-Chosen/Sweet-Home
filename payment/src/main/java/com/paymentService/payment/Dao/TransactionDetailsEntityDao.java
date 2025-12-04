package com.paymentService.payment.Dao;

import com.paymentService.payment.entity.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailsEntityDao extends JpaRepository <TransactionDetailsEntity, Integer> {
}
