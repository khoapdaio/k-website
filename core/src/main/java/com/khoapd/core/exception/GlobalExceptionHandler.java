package com.khoapd.core.exception;


import com.khoapd.core.util.KhoapdCustomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;
import java.util.UUID;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    public static final String N_A = "N/A";
    private static final String STATUS = "status";
    private static final String ID = "id";
    private static final String CODE = "code";
    private static final String NAME = "name";
    private static final String HELP = "help";
    private static final String PATH = "path";
    private static final String MESSAGE = "message";
    private static final String TRACE = "trace";
    private static final String REF_DATA = "refData";

    @ExceptionHandler(value = {CustomsRuntimeException.class})
    public final ResponseEntity<Object> handlerCustomCommonException(
            CustomsRuntimeException ex, WebRequest request) {
        HttpStatus httpStatus;
        DefaultErrorAttributes dea = new DefaultErrorAttributes();
        String id = UUID.randomUUID().toString();
        Map<String, Object> errorAttributes = dea.getErrorAttributes(request,
                ErrorAttributeOptions.of(
                        ErrorAttributeOptions.Include.EXCEPTION,
                        ErrorAttributeOptions.Include.STACK_TRACE,
                        ErrorAttributeOptions.Include.MESSAGE,
                        ErrorAttributeOptions.Include.BINDING_ERRORS,
                        ErrorAttributeOptions.Include.STATUS,
                        ErrorAttributeOptions.Include.ERROR,
                        ErrorAttributeOptions.Include.PATH
                )
        );

        if (ex instanceof BadRequestException) {
            httpStatus = HttpStatus.BAD_REQUEST;
        } else if (ex instanceof ConflictException) {
            httpStatus = HttpStatus.CONFLICT;
        } else if (ex instanceof InternalServerException) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        } else if (ex instanceof MethodNotAllowedException) {
            httpStatus = HttpStatus.METHOD_NOT_ALLOWED;
        } else if (ex instanceof ResourceNotFoundException) {
            httpStatus = HttpStatus.NOT_FOUND;
        } else {
            httpStatus = HttpStatus.NOT_IMPLEMENTED;
        }
        errorAttributes.put(STATUS, httpStatus.value());
        errorAttributes.put(CODE, ex.code);
        errorAttributes.replace(MESSAGE, ex.getMessage());
        errorAttributes.put(ID, id);
        log.error("[{}]: [{}]", id, KhoapdCustomUtils.getStackTrace(ex.getCause()));

        return new ResponseEntity<>(errorAttributes, httpStatus);
    }
} 