package it.practice.local.common.exception.exceptions;

import it.practice.local.common.exception.enums.ErrorCode;

public class InternalErrorException extends BusinessBaseException{
    public InternalErrorException(String message) {
        super(message);
    }

    public InternalErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalErrorException(Throwable cause) {
        super(cause);
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.INTERNAL_ERROR;
    }
}
