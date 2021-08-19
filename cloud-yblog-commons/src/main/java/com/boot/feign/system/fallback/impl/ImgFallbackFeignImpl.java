package com.boot.feign.system.fallback.impl;

import com.boot.feign.system.fallback.ImgFallbackFeign;
import com.boot.pojo.Img;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ImgFallbackFeignImpl implements ImgFallbackFeign {
    @Override
    public int selectImgCount() {
        return 0;
    }

    @Override
    public List<Img> selectAllImg() {
        return null;
    }

    @Override
    public Img selectImgByid(long id) {
        return null;
    }
}
