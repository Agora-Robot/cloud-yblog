package com.boot.feign.article.fallback;

import com.boot.feign.article.fallback.impl.ArticleFallbackFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author 游政杰
 * 2021/8/13
 */

//***实现一部分接口需要自定义fallback一部分接口不需要自定义fallback，起到一个分离的作用
@Component
@FeignClient(value = "cloud-yblog-article",fallback = ArticleFallbackFeignImpl.class)
public interface ArticleFallbackFeign {

    @ResponseBody
    @GetMapping(path = "/feign/like/selectLikeExsit")
    public String selectLikeExsit(@RequestParam("username") String username,
                                  @RequestParam("articleid") long articleid);


}
