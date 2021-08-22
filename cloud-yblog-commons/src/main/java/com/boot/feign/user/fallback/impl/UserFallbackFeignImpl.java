package com.boot.feign.user.fallback.impl;

import com.boot.feign.user.fallback.UserFallbackFeign;
import com.boot.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class UserFallbackFeignImpl implements UserFallbackFeign {
    @Override
    public String register(String username, String password, String email) {
        log.error("UserFallbackFeignImpl---register---fallback");
        return "register error";
    }

    @Override
    public String selectPasswordByuserName(String name) {
        return null;
    }

    @Override
    public int selectUseridByUserName(String username) {
        return 0;
    }



    @Override
    public int userCount() {
        return 0;
    }

    @Override
    public List<User> selectAllUser(int page, int limit) {
        return null;
    }

    @Override
    public List<User> selectUserByUsernameAndEmail(String username, String email) {
        return null;
    }

    @Override
    public int selectUserCountByUsernameAndEmail(String username, String email) {
        return 0;
    }

    @Override
    public User selectUserInfoByuserName(String name) {
        return null;
    }


}
