package com.khoapd.account.mapper;

import com.khoapd.account.dto.AccountRequestDto;
import com.khoapd.account.dto.AccountResponseDto;
import com.khoapd.account.entity.AccountEntity;
import com.khoapd.core.mapper.IBaseMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountMapperImpl implements IBaseMapper<AccountEntity, AccountRequestDto, AccountResponseDto> {
    private final ModelMapper modelMapper;


    @Override
    public AccountResponseDto toDto(AccountRequestDto requestDto) {
        return modelMapper.map(requestDto, AccountResponseDto.class);
    }

    @Override
    public AccountResponseDto toDto(AccountEntity entity) {
        return modelMapper.map(entity, AccountResponseDto.class);
    }

    @Override
    public AccountEntity toEntity(AccountRequestDto requestDto) {
        return modelMapper.map(requestDto, AccountEntity.class);
    }

    @Override
    public List<AccountResponseDto> toDtos(List<AccountEntity> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<AccountResponseDto> toDtos(Page<AccountEntity> entities) {
        return entities.map(this::toDto);
    }
}
