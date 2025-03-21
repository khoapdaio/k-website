package com.khoapd.core.service;

import com.khoapd.core.dto.request.BaseRequestDto;
import com.khoapd.core.dto.response.BaseResponseDto;
import com.khoapd.core.entity.AbstractBaseEntity;
import com.khoapd.core.exception.BadRequestException;
import com.khoapd.core.mapper.IBaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Transactional
public abstract class AbstractBaseService<
        E extends AbstractBaseEntity,
        R extends BaseRequestDto,
        D extends BaseResponseDto, ID> implements IBaseService<R, D, ID> {
    protected abstract JpaRepository<E, ID> getRepository();

    protected abstract IBaseMapper<E, R, D> getMapper();

    protected abstract void beforeCreate(R request);

    protected abstract void afterCreate(D response);

    protected abstract void beforeUpdate(E entity, E oldEntity);

    protected abstract void afterUpdate(E entity);

    @Override
    @Transactional(readOnly = true)
    public D create(R requestDto) {
        beforeCreate(requestDto);
        E request = getMapper().toEntity(requestDto);
        E entity = Optional.of(getRepository().save(request)).orElseThrow(
                () -> new BadRequestException("Unable to create entity")
        );
        D response = getMapper().toDto(entity);
        afterCreate(response);
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public D update(ID id, R requestDto) {
        E existingEntity = getRepository().findById(id).orElseThrow(
                () -> new BadRequestException("Unable to find entity")
        );
        E request = getMapper().toEntity(requestDto);
        beforeUpdate(existingEntity, request);
        E entity = Optional.of(getRepository().save(request)).orElseThrow(
                () -> new BadRequestException("Unable to update entity")
        );
        afterUpdate(entity);
        return getMapper().toDto(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public D findById(ID id) {
        return getMapper().toDto(getRepository().findById(id).orElseThrow(
                () -> new BadRequestException("Unable to find entity")
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public void deleteById(ID id) {
        E existingEntity = getRepository().findById(id).orElseThrow(
                () -> new BadRequestException("Unable to find entity")
        );
        existingEntity.setDeleted(true);
        Optional.of(getRepository().save(existingEntity)).orElseThrow(
                () -> new BadRequestException("Unable to update entity")
        );
    }
}
