package com.boot.feign.article.fallback;

import com.boot.feign.article.fallback.impl.LikeFallbackFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(value = "cloud-yblog-article",fallback = LikeFallbackFeignImpl.class)
public interface LikeFallbackFeign {


    @ResponseBody
    @GetMapping(path = "/feign/like/selectLikeExsit")
    public String selectLikeExsit(@RequestParam("username") String username,
                                  @RequestParam("articleid") long articleid);

    @ResponseBody
    @GetMapping(path = "/feign/article/selectLikeCount")
    public int selectLikeCount(@RequestParam("id") long id);

}
