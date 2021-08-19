package com.boot.feign.system.fallback;

import com.boot.feign.system.fallback.impl.ImgFallbackFeignImpl;
import com.boot.pojo.Img;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@FeignClient(value = "cloud-yblog-system",fallback = ImgFallbackFeignImpl.class)
public interface ImgFallbackFeign {


    @ResponseBody
    @GetMapping(path = "/feign/img/selectImgCount")
    public int selectImgCount();

    @ResponseBody
    @GetMapping(path = "/feign/img/selectAllImg")
    public List<Img> selectAllImg();

    @ResponseBody
    @GetMapping(path = "/feign/img/selectImgByid")
    public Img selectImgByid(@RequestParam("id") long id);

}
