package com.boot.feign.article.fallback;


import com.boot.feign.article.fallback.impl.TagFallbackFeignImpl;
import com.boot.pojo.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@FeignClient(value = "cloud-yblog-article",fallback = TagFallbackFeignImpl.class)
public interface TagFallbackFeign {


    @ResponseBody
    @GetMapping(path = "/feign/tag/selectTagsByLimit8")
    public List<Tag> selectTagsByLimit8();

    @ResponseBody
    @GetMapping(path = "/feign/tag/selectAllTag")
    public List<Tag> selectAllTag();

    @ResponseBody
    @GetMapping(path = "/feign/tag/selectTagCount")
    public int selectTagCount();
}
