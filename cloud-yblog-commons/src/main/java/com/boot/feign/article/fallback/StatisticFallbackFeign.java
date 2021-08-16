package com.boot.feign.article.fallback;

import com.boot.feign.article.fallback.impl.StatisticFallbackFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(value = "cloud-yblog-article",fallback = StatisticFallbackFeignImpl.class)
public interface StatisticFallbackFeign {



}
