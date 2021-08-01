package com.boot.service;

import com.boot.pojo.userDetail;

public interface UserDetailService {

    //根据当前的用户名（唯一）去查找userDetail
    public userDetail selectUserDetailByUserName(String name);

    //个人资料，修改用户信息
    public void updateUserDetail(userDetail userDetail);

    public void addUserDetail(userDetail userDetail);
}
