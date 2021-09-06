package com.boot.feign.generate;

import com.boot.pojo.Code;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(value = "cloud-yblog-generate")
public interface GenerateFeign {

    @PostMapping(path = "/generate/autoGenerate")
    @ResponseBody
    public String autoGenerate(@RequestBody Code code);

}
