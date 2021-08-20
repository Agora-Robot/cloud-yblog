package com.boot.feign.log.fallback.impl;

import com.boot.feign.log.fallback.LoginLogFallbackFeign;
import com.boot.pojo.LoginLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class LoginLogFallbackFeignImpl implements LoginLogFallbackFeign {
    @Override
    public String loginLogData(int page, int limit) {
        return null;
    }

    @Override
    public List<LoginLog> selectLoginLogAll(int page, int limit) {
        return null;
    }

    @Override
    public int loginLogCount() {
        return 0;
    }
}
