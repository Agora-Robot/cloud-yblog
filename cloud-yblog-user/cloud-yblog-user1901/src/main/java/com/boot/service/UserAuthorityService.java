package com.boot.service;

import com.boot.pojo.UserAuthority;

public interface UserAuthorityService {

    void changeUserAuthority(UserAuthority UserAuthority);

    int selectAuthorityID(long userid);
}
