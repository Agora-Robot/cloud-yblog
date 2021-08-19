package com.boot.feign.article.fallback.impl;

import com.boot.feign.article.fallback.TagFallbackFeign;
import com.boot.pojo.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class TagFallbackFeignImpl implements TagFallbackFeign {
    @Override
    public List<Tag> selectTagsByLimit8() {
        return null;
    }

    @Override
    public List<Tag> selectAllTag() {
        return null;
    }

    @Override
    public int selectTagCount() {
        return 0;
    }

    @Override
    public List<Tag> selectTags_echarts() {
        return null;
    }
}
