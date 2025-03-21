package com.khoapd.core.webapi;

import com.khoapd.core.dto.request.BaseRequestDto;
import com.khoapd.core.dto.response.ApiResponseDto;
import com.khoapd.core.dto.response.BaseResponseDto;
import com.khoapd.core.dto.response.ResponseBuilder;
import com.khoapd.core.entity.AbstractBaseEntity;
import com.khoapd.core.service.AbstractBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;

@Slf4j
@Validated
@CrossOrigin
public abstract class AbstractBaseRestController<
        E extends AbstractBaseEntity,
        R extends BaseRequestDto,
        D extends BaseResponseDto, ID> implements IBaseController<R, D, ID> {

    protected abstract AbstractBaseService<E, R, D, ID> getService();

    protected abstract String getEntityName();

    @Override
    public ResponseEntity<ApiResponseDto<D>> findById(ID id) {
        log.debug("REST request to get {} by id: {}", getEntityName(), id);
        return ResponseBuilder.success(getService().findById(id));
    }

    @Override
    public ResponseEntity<ApiResponseDto<D>> create(R requestDto) {
        log.debug("REST request to save {}: {}", getEntityName(), requestDto);
        return ResponseBuilder.success(getService().create(requestDto));
    }

    @Override
    public ResponseEntity<ApiResponseDto<D>> update(ID id, R requestDto) {
        log.debug("REST request to update {} with id: {}", getEntityName(), id);
        return ResponseBuilder.success(getService().update(id, requestDto));
    }

    @Override
    public ResponseEntity<ApiResponseDto<String>> deleteById(ID id) {
        log.debug("REST request to delete {} with id: {}", getEntityName(), id);
        getService().deleteById(id);
        return ResponseBuilder.success("OK");
    }
}
