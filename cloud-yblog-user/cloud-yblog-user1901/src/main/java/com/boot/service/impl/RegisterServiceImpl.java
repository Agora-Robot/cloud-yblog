package com.boot.service.impl;

import com.boot.constant.ThemeConstant;
import com.boot.feign.system.SettingFeign;
import com.boot.pojo.Setting;
import com.boot.pojo.User;
import com.boot.pojo.UserAuthority;
import com.boot.pojo.UserDetail;
import com.boot.service.RegisterService;
import com.boot.service.UserDetailService;
import com.boot.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class RegisterServiceImpl implements RegisterService {

  @Autowired private UserService userService;

  @Autowired private SettingFeign settingFeign;

  @Autowired private UserDetailService userDetailService;

  // 分布式事务
  @GlobalTransactional(name = "seata_register", rollbackFor = Exception.class)
  @Override
  public void register(User user) {

    // 注册代码
    Date date = new Date(new java.util.Date().getTime());
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    // 进行BCryptPasswordEncoder加密
    String encode_password = bCryptPasswordEncoder.encode(user.getPassword());
    user.setPassword(encode_password);
    user.setDate(date);
    user.setValid(1);

    userService.addUser(user);

    UserAuthority userAuthority = new UserAuthority();
    userAuthority.setUser_id(user.getId());
    userAuthority.setAuthority_id(2);
    userService.addUserAuthority(userAuthority);


//    int i=10/0;

    // 设置userDetail
    UserDetail userDetail = new UserDetail();
    userDetail.setName(user.getUsername());
    userDetailService.addUserDetail(userDetail);

    // 添加用户默认设置
    Setting setting = new Setting();
    setting.setName(user.getUsername());
    setting.setTheme(ThemeConstant.CALM_THEME);
    setting.setFoot("----2021----");
    setting.setLogo("/user/img/bloglogo.jpg");
    settingFeign.addSettingByUser(setting);
  }
}
