package com.khoapd.core.exception;

import com.khoapd.core.enums.IEnumError;
import org.springframework.http.HttpMethod;

public class MethodNotAllowedException extends CustomsRuntimeException {
    public MethodNotAllowedException(String message) {
        super(message);
    }
    public MethodNotAllowedException(HttpMethod httpMethod, String javaMethod) {
        super(String.format("[%s] has Java method [%s] not allowed.", httpMethod.name(), javaMethod));
    }

    public MethodNotAllowedException(IEnumError iEnumError, Object... args) {
        super( (Throwable)null, iEnumError, args);
    }
}
