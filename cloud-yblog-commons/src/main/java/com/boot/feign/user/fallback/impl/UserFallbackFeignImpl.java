package com.boot.feign.user.fallback.impl;

import com.boot.feign.user.fallback.UserFallbackFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserFallbackFeignImpl implements UserFallbackFeign {
    @Override
    public String register(String username, String password, String email) {
        log.error("UserFallbackFeignImpl---register---fallback");
        return "register error";
    }

    @Override
    public String selectPasswordByuserName(String name) {
        return null;
    }

    @Override
    public int selectUseridByUserName(String username) {
        return 0;
    }
}
