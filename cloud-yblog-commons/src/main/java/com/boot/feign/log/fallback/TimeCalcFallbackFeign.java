package com.boot.feign.log.fallback;


import com.boot.feign.log.fallback.impl.TimeCalcFallbackFeignImpl;
import com.boot.pojo.TimeCalc;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "cloud-yblog-log",fallback = TimeCalcFallbackFeignImpl.class)
@Component
public interface TimeCalcFallbackFeign {

    @ResponseBody
    @GetMapping(path = "/feign/timecalc/selectAllTimeCalc")
    public List<TimeCalc> selectAllTimeCalc(@RequestParam("page") int page,
                                            @RequestParam("limit") int limit);

    @ResponseBody
    @GetMapping(path = "/feign/timecalc/selectAllCount")
    public int selectAllCount();

    @ResponseBody
    @GetMapping(path = "/feign/timecalc/selectAllTimeCalcByUri")
    public List<TimeCalc> selectAllTimeCalcByUri(@RequestParam("page") int page,
                                                 @RequestParam("limit") int limit,
                                                 @RequestParam("uri") String uri);

    @ResponseBody
    @GetMapping(path = "/feign/timecalc/selectCountByUri")
    public int selectCountByUri(@RequestParam("uri") String uri);

}
