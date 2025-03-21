package com.khoapd.core.webapi;

import com.khoapd.core.dto.request.BaseRequestDto;
import com.khoapd.core.dto.response.ApiResponseDto;
import com.khoapd.core.dto.response.BaseResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IBaseController<
        R extends BaseRequestDto,
        D extends BaseResponseDto, ID> {

    @GetMapping("/{id}")
    ResponseEntity<ApiResponseDto<D>> findById(@PathVariable ID id);

    @PostMapping
    ResponseEntity<ApiResponseDto<D>> create(@RequestBody R requestDto);

    @PutMapping("/{id}")
    ResponseEntity<ApiResponseDto<D>> update(@PathVariable ID id, @RequestBody R requestDto);

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponseDto<String>> deleteById(@PathVariable ID id);


}
