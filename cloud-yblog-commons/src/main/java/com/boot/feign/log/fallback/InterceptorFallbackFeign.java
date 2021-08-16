package com.boot.feign.log.fallback;

import com.boot.feign.log.fallback.impl.InterceptorFallbackFeignImpl;
import com.boot.pojo.Intercept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "cloud-yblog-log",fallback = InterceptorFallbackFeignImpl.class)
@Component
public interface InterceptorFallbackFeign {


    @ResponseBody
    @GetMapping(path = "/feign/interceptor/selectIntercepts")
    public List<Intercept> selectIntercepts(@RequestParam(value = "page") int page,
                                            @RequestParam(value = "limit") int limit);

    @ResponseBody
    @GetMapping(path = "/feign/interceptor/selectInterceptCount")
    public int selectInterceptCount();

}
