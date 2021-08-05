package com.boot.feign.user.impl;

import com.boot.data.CommonResult;
import com.boot.feign.user.UserDetailFeign;
import com.boot.pojo.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserDetailFeignImpl implements UserDetailFeign {


    @Override
    public UserDetail selectUserDetailByUserName(String name) {
        log.error("UserDetailFeignImpl---selectUserDetailByUserName---fallback");
        return null;
    }


}
