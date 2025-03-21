package com.khoapd.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ECommonErrorCode implements IEnumError {
    ;

    private final String code;
    private final String message;

}
