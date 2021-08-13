package com.boot.feign.log;

import com.boot.pojo.Visitor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ？？？？？？？？？？？？？？？？
 * 实测：如果feign接口写了fallback方法，即使在fallback方法里面抛出Runtime异常也不能让全局事务回滚========
 * ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
 * 所以，暂时把fallback方法取消
 */

//@FeignClient(value = "cloud-yblog-log",fallback = VisitorFeignImpl.class)
@FeignClient(value = "cloud-yblog-log")
@Component
public interface VisitorFeign {


    @ResponseBody
    @PostMapping(path = "/feign/visitor/insertVisitor")
    public String insertVisitor(@RequestBody Visitor visitor);

}
