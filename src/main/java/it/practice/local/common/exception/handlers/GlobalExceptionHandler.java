package it.practice.local.common.exception.handlers;


import it.practice.local.common.exception.enums.ErrorCode;
import it.practice.local.common.exception.exceptions.BusinessBaseException;
import it.practice.local.common.exception.exceptions.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.OffsetDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessBaseException.class)
    protected ResponseEntity<ErrorMessage> handleBusinessBaseException(BusinessBaseException ex, WebRequest request) {
        String requestUri = ((ServletWebRequest) request).getRequest().getRequestURI();
        log.info("requestUri: {}", requestUri);
        log.info("Exception StackTrace: ",ex);
        ErrorMessage errorMessage = getErrorMessage(ex.getErrorCode());

        return ResponseEntity.status(errorMessage.getStatus()).body(errorMessage);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<ErrorMessage> genericException(Exception ex, WebRequest request){
        String requestUri = ((ServletWebRequest) request).getRequest().getRequestURI();
        log.debug("requestUri: {}", requestUri);
        log.debug(ex.getMessage(), ex);
        ErrorMessage errorMessage = getErrorMessage(ErrorCode.INTERNAL_ERROR);
        return ResponseEntity.status(errorMessage.getStatus()).body(errorMessage);
    }

    private ErrorMessage getErrorMessage(ErrorCode errorCode) {
        return new ErrorMessage(
                errorCode.getHttpStatus().value(),
                errorCode.getMessage(),
                OffsetDateTime.now()
        );
    }
}
