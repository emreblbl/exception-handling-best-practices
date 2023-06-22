package it.practice.local.common.exception.exceptions;

import it.practice.local.common.exception.enums.ErrorCode;

public class ItemNotFoundException extends BusinessBaseException{
    private static final long serialVersionUID = 1L;
    public ItemNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.NOT_FOUND;
    }


}
