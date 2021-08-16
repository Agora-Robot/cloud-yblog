package com.boot.feign.system.fallback.impl;

import com.boot.feign.system.fallback.ImgFallbackFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ImgFallbackFeignImpl implements ImgFallbackFeign {
    @Override
    public int selectImgCount() {
        return 0;
    }
}
