package com.khoapd.core.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.khoapd.core.enums.EStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Api Response DTO")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDto<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "HTTP status")
    private String status;

    @SchemaProperty(name = "Nội dung thông báo")
    private String message;

    @SchemaProperty(name = "Có thành công hay không?")
    private boolean success = true;

    @SchemaProperty(name = "Kết quả dữ liệu")
    private transient T data;

    public static <T> ApiResponseDto<T> success(T data) {
        return ApiResponseDto.<T>builder()
                .status(EStatus.SUCCESS.getValueEnum())
                .success(true)
                .data(data)
                .build();
    }

    public static <T> ApiResponseDto<T> success(T data, String message) {
        return ApiResponseDto.<T>builder()
                .status(EStatus.SUCCESS.getValueEnum())
                .success(true)
                .data(data)
                .message(message)
                .build();
    }

    public static <T> ApiResponseDto<T> error(T error) {
        return ApiResponseDto.<T>builder()
                .status(EStatus.FAILURE.getValueEnum())
                .success(false)
                .data(error)
                .build();
    }

    public static <T> ApiResponseDto<T> error( T error,String message) {
        return ApiResponseDto.<T>builder()
                .status(EStatus.FAILURE.getValueEnum())
                .success(false)
                .message(message)
                .data(error)
                .build();
    }
}
