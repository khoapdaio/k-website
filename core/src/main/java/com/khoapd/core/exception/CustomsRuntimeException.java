package com.khoapd.core.exception;

import com.khoapd.core.enums.IEnumError;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Slf4j
@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class CustomsRuntimeException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    public final String code;

    public CustomsRuntimeException(String message) {
        super(message);
        this.code = null;
        log.error(this.getMessage());
    }

    public CustomsRuntimeException(String format, Object... args) {
        super(String.format(StringUtils.trimToEmpty(format), args));
        this.code = null;
        log.error(this.getMessage());
    }

    public CustomsRuntimeException(String message, Throwable cause) {
        super(message, cause);
        this.code = null;
        log.error("{} - {}", this.getMessage(), cause == null ? null : cause.getMessage());
    }

    public CustomsRuntimeException(Throwable cause) {
        this(cause, (IEnumError) null);
    }

    public CustomsRuntimeException(Throwable cause, IEnumError error, Object... args) {
        super(String.format(StringUtils.trimToEmpty(error.name()), args), cause);
        this.code = getCode(error);
        log.error("{} - {}", this.getMessage(), cause == null ? null : cause.getMessage());
    }

    private static String getMessage(Throwable cause, IEnumError iEnumError, Object... args) {
        String message = String.format(StringUtils.trimToEmpty(getMsg(iEnumError)), args);
        if (StringUtils.isEmpty(message)) {
            message = cause.getMessage();
        }

        return message;
    }

    private static String getCode(IEnumError iEnumError) {
        if (iEnumError == null) {
            return null;
        } else {
            return StringUtils.isBlank(iEnumError.getCode()) ? iEnumError.name() : iEnumError.getCode();
        }
    }

    private static String getMsg(IEnumError iEnumError) {
        if (iEnumError == null) {
            return null;
        } else {
            return StringUtils.isBlank(iEnumError.getMessage()) ? iEnumError.name() : iEnumError.getMessage();
        }
    }
}
