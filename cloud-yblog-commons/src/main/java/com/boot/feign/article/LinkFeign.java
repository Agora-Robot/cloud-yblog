package com.boot.feign.article;

import com.boot.data.CommonResult;
import com.boot.pojo.Link;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * ？？？？？？？？？？？？？？？？
 * 实测：如果feign接口写了fallback方法，即使在fallback方法里面抛出Runtime异常也不能让全局事务回滚========
 * ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
 * 所以，暂时把fallback方法取消
 */
@Component
//@FeignClient(value = "cloud-yblog-article",fallback = LinkFeignImpl.class)
@FeignClient(value = "cloud-yblog-article")
public interface LinkFeign {


    @ResponseBody
    @PostMapping(path = "/feign/link/insertLink")
    public String insertLink(@RequestBody Link link);

    @ResponseBody
    @PostMapping(path = "/feign/link/updateLink")
    public String updateLink(@RequestBody Link link);

    @ResponseBody
    @GetMapping(path = "/feign/link/deleteLink")
    public String deleteLink(@RequestParam("id") long id);

}
