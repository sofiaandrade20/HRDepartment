package com.example.hrdepartment.exception;

import com.example.hrdepartment.controller.response.HttpErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler({EmployeeNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpErrorResponse handleGenericException(EmployeeNotFound exception) {
        return new HttpErrorResponse(
                404,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler({ServiceNotAvailable.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public HttpErrorResponse handleServiceNotAvailable(ServiceNotAvailable exception) {
        return new HttpErrorResponse(
                503,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }
}