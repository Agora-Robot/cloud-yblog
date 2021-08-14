package com.boot.feign.user.fallback.impl;

import com.boot.feign.user.fallback.AuthorityFallbackFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthorityFallbackFeignImpl implements AuthorityFallbackFeign {
    @Override
    public String selectAuthorityByid(int authorityid) {
        return null;
    }
}
