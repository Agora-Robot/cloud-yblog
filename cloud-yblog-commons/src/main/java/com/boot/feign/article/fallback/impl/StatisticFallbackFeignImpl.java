package com.boot.feign.article.fallback.impl;

import com.boot.feign.article.fallback.StatisticFallbackFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StatisticFallbackFeignImpl implements StatisticFallbackFeign {
}
