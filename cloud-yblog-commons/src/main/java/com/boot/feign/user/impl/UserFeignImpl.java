package com.boot.feign.user.impl;

import com.boot.data.CommonResult;
import com.boot.feign.user.UserFeign;
import com.boot.pojo.User;
import com.boot.pojo.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Slf4j
public class UserFeignImpl implements UserFeign {

    @Override
    public String selectPasswordByuserName(String name) {
        log.error("UserFeignImpl---selectPasswordByuserName--fallback");
        return null;
    }

    @Override
    public String register(String username,
                           String password,
                           String email) {
        throw new RuntimeException("UserFeignImpl---register--fallback");
//        return "registerFail";
    }


}
