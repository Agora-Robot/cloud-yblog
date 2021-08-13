package com.boot.feign.log;

import com.boot.pojo.TimeCalc;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 游政杰
 * 2021/8/12
 */

/**
 * ？？？？？？？？？？？？？？？？
 * 实测：如果feign接口写了fallback方法，即使在fallback方法里面抛出Runtime异常也不能让全局事务回滚========
 * ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
 * 所以，暂时把fallback方法取消
 */
//@FeignClient(value = "cloud-yblog-log",fallback = TimeCalcFeignImpl.class)
@FeignClient(value = "cloud-yblog-log")
@Component
public interface TimeCalcFeign {


    @ResponseBody
    @PostMapping(path = "/feign/timecalc/insertTimeCalc")
    public String insertTimeCalc(@RequestBody TimeCalc timeCalc);

}
