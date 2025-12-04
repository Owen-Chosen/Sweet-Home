package com.paymentService.payment.service;

import com.paymentService.payment.Dao.TransactionDetailsEntityDao;
import com.paymentService.payment.entity.TransactionDetailsEntity;
import com.paymentService.payment.exception.ExceptionHandlers.CustomExceptionHandler;
import com.paymentService.payment.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionDetailsEntityDao transactionDetailsEntityDao;

    @Override
    public TransactionDetailsEntity getTransactionDetails(int transactionId) {
        return transactionDetailsEntityDao.findById(transactionId).orElseThrow(
                ()-> new RecordNotFoundException("Invalid Booking Id"));
    }

    @Override
    public Integer saveTransactionDetails(TransactionDetailsEntity transactionDetailsEntity){

        TransactionDetailsEntity transactionDetailsEntity1 = new TransactionDetailsEntity();

        transactionDetailsEntity1.setBookingId(transactionDetailsEntity.getBookingId());
        if ( transactionDetailsEntity.getPaymentMode().equals("CARD" )) {
            transactionDetailsEntity1.setPaymentMode(transactionDetailsEntity.getPaymentMode());
            transactionDetailsEntity1.setCardNumber(transactionDetailsEntity.getCardNumber());
        }
        else if ( transactionDetailsEntity.getPaymentMode().equals("UPI" ) ) {
            transactionDetailsEntity1.setPaymentMode(transactionDetailsEntity.getPaymentMode());
            transactionDetailsEntity1.setUpiId(transactionDetailsEntity.getUpiId());
        }else {
            throw new RecordNotFoundException("Invalid mode of payment");
        }
        return transactionDetailsEntityDao.save(transactionDetailsEntity1).getTransactionId();
    }
}
