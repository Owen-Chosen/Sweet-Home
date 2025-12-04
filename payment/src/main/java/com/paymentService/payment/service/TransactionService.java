package com.paymentService.payment.service;

import com.paymentService.payment.entity.TransactionDetailsEntity;

public interface TransactionService {

    public Integer saveTransactionDetails (TransactionDetailsEntity transactionDetailsEntity);

    public TransactionDetailsEntity getTransactionDetails (int transactionId);

}
