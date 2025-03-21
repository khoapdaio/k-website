package com.khoapd.core.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    public static <T> ResponseEntity<ApiResponseDto<T>> success(T data) {
        return new ResponseEntity<>(ApiResponseDto.success(data), HttpStatus.OK);
    }

    public static <T> ResponseEntity<ApiResponseDto<T>> success(T data, String message) {
        return new ResponseEntity<>(ApiResponseDto.success(data, message), HttpStatus.OK);
    }


    public static <T> ResponseEntity<ApiResponseDto<T>> created(T data) {
        return new ResponseEntity<>(ApiResponseDto.success(data), HttpStatus.CREATED);
    }

    public static ResponseEntity<ApiResponseDto<ErrorResponseDto>> error(ErrorResponseDto data) {
        return new ResponseEntity<>(ApiResponseDto.error(data), HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<ApiResponseDto<ErrorResponseDto>> error(ErrorResponseDto data, HttpStatus status) {
        return new ResponseEntity<>(ApiResponseDto.error(data), status);
    }

    public static ResponseEntity<ApiResponseDto<ErrorResponseDto>> error(ErrorResponseDto data,String message, HttpStatus status) {
        return new ResponseEntity<>(ApiResponseDto.error(data,message), status);
    }
}
