package com.paymentService.payment.exception.ExceptionHandlers;

import com.paymentService.payment.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private String NO_RECORDS_FOUND ="NO_RECORDS_FOUND";

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponses> handleRecordNotFoundException(RecordNotFoundException e, WebRequest req){
        List<String> errorDetails = new ArrayList<>();
        errorDetails.add(e.getLocalizedMessage());
        ErrorResponses response = new ErrorResponses(NO_RECORDS_FOUND, errorDetails);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
