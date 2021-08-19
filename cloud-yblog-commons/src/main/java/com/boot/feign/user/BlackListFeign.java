package com.boot.feign.user;


import com.boot.pojo.BlackList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@FeignClient(value = "cloud-yblog-user")
public interface BlackListFeign {


    @ResponseBody
    @GetMapping(path = "/feign/blacklist/deleteBlackListByIp")
    public String deleteBlackListByIp(@RequestParam("ip") String ip);

    @ResponseBody
    @PostMapping(path = "/feign/blacklist/addBlackList")
    public String addBlackList(@RequestBody BlackList blackList);

    @ResponseBody
    @PostMapping(path = "/feign/blacklist/updateBlackIp")
    public String updateBlackIp(@RequestParam("oldIp") String oldIp,
                                @RequestParam("newIp") String newIp);
}
