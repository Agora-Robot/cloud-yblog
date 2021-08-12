package com.boot.feign.log.impl;

import com.boot.feign.log.OperationLogFeign;
import com.boot.pojo.OperationLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OperationLogFeignImpl implements OperationLogFeign {


    @Override
    public String insertOperationLog(OperationLog operationLog) {
        throw new RuntimeException();
    }
}
