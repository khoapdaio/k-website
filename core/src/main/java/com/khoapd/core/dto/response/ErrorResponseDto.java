package com.khoapd.core.dto.response;

import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponseDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @SchemaProperty(name = "HTTP status")
    private String errorCode ;

    @SchemaProperty(name = "Nội dung thông báo")
    private String errorMessage ;

    @SchemaProperty(name = "Đường dẫn api")
    private String target ;




}
