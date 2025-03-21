package com.khoapd.core.mapper;

import com.khoapd.core.dto.request.BaseRequestDto;
import com.khoapd.core.dto.response.BaseResponseDto;
import com.khoapd.core.entity.AbstractBaseEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBaseMapper<E extends AbstractBaseEntity, R extends BaseRequestDto, D extends BaseResponseDto> {
    D toDto(R requestDto);

    D toDto(E entity);

    E toEntity(R requestDto);

    List<D> toDtos(List<E> entities);

    Page<D> toDtos(Page<E> entities);
}
