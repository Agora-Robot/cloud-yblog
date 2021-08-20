package com.boot.feign.log.fallback.impl;

import com.boot.feign.log.fallback.TimeCalcFallbackFeign;
import com.boot.pojo.TimeCalc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class TimeCalcFallbackFeignImpl implements TimeCalcFallbackFeign {
    @Override
    public List<TimeCalc> selectAllTimeCalc(int page, int limit) {
        return null;
    }

    @Override
    public int selectAllCount() {
        return 0;
    }

    @Override
    public List<TimeCalc> selectAllTimeCalcByUri(int page, int limit, String uri) {
        return null;
    }

    @Override
    public int selectCountByUri(String uri) {
        return 0;
    }
}
