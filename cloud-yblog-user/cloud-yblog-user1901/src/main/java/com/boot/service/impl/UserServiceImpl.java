package com.boot.service.impl;

import com.boot.pojo.user;
import com.boot.pojo.user_authority;
import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private com.boot.dao.UserMapper userMapper;

    @Override
    public void addUser(user user) {
        userMapper.addUser(user);
    }

    @Override
    public void addUserAuthority(user_authority user_authority) {
        userMapper.addUserAuthority(user_authority);
    }

    @Override
    public void updateEmail(String email, String username) {
        userMapper.updateEmail(email, username);
    }

    @Override
    public user selectUserInfoByuserName(String username) {
        return userMapper.selectUserInfoByuserName(username);
    }

    @Override
    public String selectPasswordByuserName(String username) {
        return userMapper.selectPasswordByuserName(username);
    }

    @Override
    public void updatePassword(String username, String password) {
        userMapper.updatePassword(username,password);
    }

    @Override
    public List<user> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public void updateValidTo_0(String username) {
        userMapper.updateValidTo_0(username);
    }

    @Override
    public void updateValidTo_1(String username) {
        userMapper.updateValidTo_1(username);
    }

    @Override
    public void updateUserForEmail(int id, String email) {
     userMapper.updateUserForEmail(id, email);
    }

    @Override
    public int selectUseridByUserName(String username) {
        return userMapper.selectUseridByUserName(username);
    }

    @Override
    public int userCount() {
        return userMapper.userCount();
    }

    @Override
    public List<user> selectUserByUsernameAndEmail(String username, String email) {
        return userMapper.selectUserByUsernameAndEmail(username,email);
    }

    @Override
    public int selectUserCountByUsernameAndEmail(String username, String email) {
        return userMapper.selectUserCountByUsernameAndEmail(username,email);
    }

}
