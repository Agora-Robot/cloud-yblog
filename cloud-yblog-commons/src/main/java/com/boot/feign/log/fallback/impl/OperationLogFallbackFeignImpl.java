package com.boot.feign.log.fallback.impl;

import com.boot.feign.log.fallback.OperationLogFallbackFeign;
import com.boot.pojo.OperationLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class OperationLogFallbackFeignImpl implements OperationLogFallbackFeign {
    @Override
    public List<OperationLog> selectOperationLogByLimit(int limit) {
        return null;
    }

    @Override
    public String operationLogData(int page, int limit) {
        return null;
    }

    @Override
    public List<OperationLog> selectAllOperationLog(int page, int limit) {
        return null;
    }

    @Override
    public int selectOperationCount() {
        return 0;
    }
}
