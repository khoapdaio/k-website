package com.khoapd.core.service;

import com.khoapd.core.dto.request.BaseRequestDto;
import com.khoapd.core.dto.response.BaseResponseDto;

public interface IBaseService<R extends BaseRequestDto, D extends BaseResponseDto, ID> {
    D create(R requestDto);

    D update(ID id, R requestDto);

    D findById(ID id);

    void deleteById(ID id);

}
