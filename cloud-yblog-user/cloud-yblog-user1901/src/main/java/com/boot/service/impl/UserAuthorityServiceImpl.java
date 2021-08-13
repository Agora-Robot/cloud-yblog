package com.boot.service.impl;

import com.boot.pojo.UserAuthority;
import com.boot.service.UserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthorityServiceImpl implements UserAuthorityService {

    @Autowired
    private com.boot.dao.UserAuthorityMapper userAuthorityMapper;

    @Override
    public void changeUserAuthority(UserAuthority UserAuthority) {
        userAuthorityMapper.changeUserAuthority(UserAuthority);
    }

    @Override
    public int selectAuthorityID(long userid) {
        return userAuthorityMapper.selectAuthorityID(userid);
    }
}
