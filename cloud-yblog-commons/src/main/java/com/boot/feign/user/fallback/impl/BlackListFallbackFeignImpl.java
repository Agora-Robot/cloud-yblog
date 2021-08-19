package com.boot.feign.user.fallback.impl;

import com.boot.feign.user.fallback.BlackListFallbackFeign;
import com.boot.pojo.BlackList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class BlackListFallbackFeignImpl implements BlackListFallbackFeign {


    @Override
    public List<BlackList> selectBlackList(int page, int limit) {
        return null;
    }

    @Override
    public int selectBlackCount() {
        return 0;
    }
}
