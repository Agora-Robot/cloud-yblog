package com.boot.feign.user.fallback;

import com.boot.feign.user.fallback.impl.UserFallbackFeignImpl;
import com.boot.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "cloud-yblog-user",fallback = UserFallbackFeignImpl.class)
public interface UserFallbackFeign {


    @ResponseBody
    @PostMapping(path = "/feign/user/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email);


    @GetMapping(path = "/feign/user/selectPasswordByuserName")
    @ResponseBody
    public String selectPasswordByuserName(@RequestParam("name") String name);


    @ResponseBody
    @GetMapping(path = "/feign/user/selectUseridByUserName")
    public int selectUseridByUserName(@RequestParam("username") String username);


    @ResponseBody
    @GetMapping(path = "/feign/user/userCount")
    public int userCount();

    @ResponseBody
    @GetMapping(path = "/feign/user/selectAllUser")
    public List<User> selectAllUser(@RequestParam("page") int page,
                                    @RequestParam("limit") int limit);

    @ResponseBody
    @GetMapping(path = "/feign/user/selectUserByUsernameAndEmail")
    public List<User> selectUserByUsernameAndEmail(@RequestParam("username") String username,
                                                   @RequestParam("email") String email);

    @ResponseBody
    @GetMapping(path = "/feign/user/selectUserCountByUsernameAndEmail")
    public int selectUserCountByUsernameAndEmail(@RequestParam("username") String username,
                                                 @RequestParam("email") String email);


    @ResponseBody
    @GetMapping(path = "/feign/user/selectUserInfoByuserName")
    public User selectUserInfoByuserName(@RequestParam("name") String name);

}
