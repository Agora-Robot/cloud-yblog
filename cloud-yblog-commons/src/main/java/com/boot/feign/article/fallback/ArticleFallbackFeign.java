package com.boot.feign.article.fallback;

import com.boot.feign.article.fallback.impl.ArticleFallbackFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;


/**
 * @author 游政杰
 * 2021/8/13
 */

//***所有Article模块中需要自定义fallback的feign接口放到这里，实现一部分接口需要自定义fallback
// 一部分接口不需要自定义fallback，起到一个分离的作用
@Component
@FeignClient(value = "cloud-yblog-article",fallback = ArticleFallbackFeignImpl.class)
public interface ArticleFallbackFeign {


}
