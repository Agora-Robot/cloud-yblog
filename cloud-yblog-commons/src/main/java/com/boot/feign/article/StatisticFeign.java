package com.boot.feign.article;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(value = "cloud-yblog-article")
public interface StatisticFeign {




}
