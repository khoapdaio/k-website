package com.khoapd.core.exception;

import com.khoapd.core.enums.IEnumError;

public class ConflictException extends CustomsRuntimeException {
    public ConflictException(String message) {
        super(message);
    }

    public ConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConflictException(Throwable cause) {
        super(cause);
    }

    public ConflictException(String format, Object... args) {
        super(format, args);
    }

    public ConflictException(IEnumError error, Object... args) {
        super((Throwable) null, error, args);
    }

}
