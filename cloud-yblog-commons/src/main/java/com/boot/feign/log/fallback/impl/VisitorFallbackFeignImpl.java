package com.boot.feign.log.fallback.impl;

import com.boot.feign.log.fallback.VisitorFallbackFeign;
import com.boot.pojo.Visitor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class VisitorFallbackFeignImpl implements VisitorFallbackFeign {
    @Override
    public List<String> selectDaysBy7() {
        return null;
    }

    @Override
    public int selectOneDayVisitor(String day) {
        return 0;
    }

    @Override
    public List<Visitor> selectVisitor(int page, int limit) {
        return null;
    }

    @Override
    public int selectVistorCount() {
        return 0;
    }
}
