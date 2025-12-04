package com.paymentService.payment.controller;

import com.paymentService.payment.entity.TransactionDetailsEntity;
import com.paymentService.payment.service.TransactionServiceImpl;
import jakarta.ws.rs.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
public class TransactionController {

    @Autowired
    TransactionServiceImpl transactionServiceImpl;

    @PostMapping (value = "/transaction", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Integer> createNewTransaction (@RequestBody TransactionDetailsEntity paymentDetails) {
        return new ResponseEntity<>(transactionServiceImpl.saveTransactionDetails(paymentDetails), HttpStatus.CREATED);
    }

    @GetMapping (value = "/transaction/{transactionId}")
    public ResponseEntity <TransactionDetailsEntity> getTransactionDetails (@PathVariable(name = "transactionId") int id) {

        return new ResponseEntity<>(transactionServiceImpl.getTransactionDetails(id), HttpStatus.OK);
    }

}
