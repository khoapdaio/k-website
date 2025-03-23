package com.khoapd.account.controller;

import com.khoapd.account.dto.AccountRequestDto;
import com.khoapd.account.dto.AccountResponseDto;
import com.khoapd.account.entity.AccountEntity;
import com.khoapd.account.service.AccountService;
import com.khoapd.core.service.AbstractBaseService;
import com.khoapd.core.webapi.AbstractBaseRestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController extends AbstractBaseRestController<AccountEntity, AccountRequestDto, AccountResponseDto, Long> {

    private final AccountService accountService;

    @Override
    protected AbstractBaseService<AccountEntity, AccountRequestDto, AccountResponseDto, Long> getService() {
        return this.accountService;
    }

    @Override
    protected String getEntityName() {
        return "Account";
    }
}
