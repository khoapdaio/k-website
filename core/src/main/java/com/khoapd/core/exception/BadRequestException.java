package com.khoapd.core.exception;

import com.khoapd.core.enums.IEnumError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Slf4j
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends CustomsRuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    public BadRequestException(String format, Object... args) {
        super(format, args);
    }

    public BadRequestException(IEnumError error, Object... args) {
        super((Throwable) null, error, args);
    }


}