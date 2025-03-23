package com.khoapd.account.service;

import com.khoapd.account.dto.AccountRequestDto;
import com.khoapd.account.dto.AccountResponseDto;
import com.khoapd.account.entity.AccountEntity;
import com.khoapd.account.repository.IAccountRepository;
import com.khoapd.core.mapper.IBaseMapper;
import com.khoapd.core.service.AbstractBaseService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService extends AbstractBaseService<AccountEntity, AccountRequestDto, AccountResponseDto, Long> {
    private final IAccountRepository accountRepository;
    private final IBaseMapper<AccountEntity, AccountRequestDto, AccountResponseDto> mapper;


    @Override
    protected JpaRepository<AccountEntity, Long> getRepository() {
        return this.accountRepository;
    }

    @Override
    protected IBaseMapper<AccountEntity, AccountRequestDto, AccountResponseDto> getMapper() {
        return this.mapper;
    }

    @Override
    protected void beforeCreate(AccountRequestDto request) {

    }

    @Override
    protected void afterCreate(AccountResponseDto response) {

    }

    @Override
    protected void beforeUpdate(AccountEntity entity, AccountEntity oldEntity) {

    }

    @Override
    protected void afterUpdate(AccountEntity entity) {

    }
}
