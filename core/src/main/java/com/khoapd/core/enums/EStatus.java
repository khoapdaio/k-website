package com.khoapd.core.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EStatus implements IEnumEx<String> {
    SUCCESS("success"), FAILURE("failure");
    private final String status;

    @Override
    public String getValueEnum() {
        return this.status;
    }
}
