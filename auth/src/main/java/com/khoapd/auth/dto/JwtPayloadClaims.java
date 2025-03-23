package com.khoapd.auth.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

import java.io.Serializable;
import java.util.Date;

@UUID
@Data
@NoArgsConstructor
public class JwtPayloadClaims implements Serializable {
    private String iss;
    private Date exp;
    private Date nbf;
    private Date iat;
    private String jti;
    private String uid;
    private String ema;
    private String ufn;
    private boolean otp;
    
}
