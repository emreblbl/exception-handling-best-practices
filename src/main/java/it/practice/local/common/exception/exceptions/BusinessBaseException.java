package it.practice.local.common.exception.exceptions;

import it.practice.local.common.exception.enums.ErrorCode;
import org.springframework.http.HttpStatus;

public abstract class BusinessBaseException extends RuntimeException{
    public BusinessBaseException(String message) {
        super(message);
    }

    public BusinessBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessBaseException(Throwable cause) {
        super(cause);
    }

    public abstract ErrorCode getErrorCode();


}
