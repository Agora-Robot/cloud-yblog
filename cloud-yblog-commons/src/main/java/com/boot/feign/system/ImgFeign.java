package com.boot.feign.system;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(value = "cloud-yblog-system")
public interface ImgFeign {

    @ResponseBody
    @PostMapping(path = "/feign/img/addImgPath")
    public String addImgPath(@RequestParam("id") long id,
                             @RequestParam("big") String big,
                             @RequestParam("small") String small);

    @ResponseBody
    @GetMapping(path = "/feign/img/deleteImgByid")
    public String deleteImgByid(@RequestParam("id") long id);
}
