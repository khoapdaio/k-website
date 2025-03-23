package com.khoapd.account.entity;

import com.khoapd.core.entity.AbstractBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "accounts")
public class AccountEntity extends AbstractBaseEntity {

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "avatar_url", nullable = false)
    private String avatar_url;

    @Column(name = "email", nullable = false, unique = true, updatable = false)
    @Email
    private String email;

    @Column(name = "phone", nullable = false, unique = true, updatable = false)
    private String phone;


}
