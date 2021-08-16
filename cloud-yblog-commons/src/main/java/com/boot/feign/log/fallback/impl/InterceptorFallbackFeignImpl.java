package com.boot.feign.log.fallback.impl;

import com.boot.feign.log.fallback.InterceptorFallbackFeign;
import com.boot.pojo.Intercept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class InterceptorFallbackFeignImpl implements InterceptorFallbackFeign {
    @Override
    public List<Intercept> selectIntercepts(int page, int limit) {
        return null;
    }

    @Override
    public int selectInterceptCount() {
        return 0;
    }
}
