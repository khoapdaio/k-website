package com.khoapd.core.exception;

import com.khoapd.core.enums.IEnumError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends CustomsRuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;


    public InternalServerException(String message) {
        super(message);
    }

    public InternalServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServerException(Throwable cause) {
        super(cause);
    }

    public InternalServerException(String format, Object... args) {
        super(format, args);
    }

    public InternalServerException(IEnumError error, Object... args) {
        super((Throwable) null, error, args);
    }
}
