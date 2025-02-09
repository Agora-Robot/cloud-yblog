package com.boot.pojo;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.sql.Date;

@ApiModel(value = "用户实体类", description = "封装用户信息")
public class User implements Serializable {

    private long id;
    private String username; //用户名
    private String password; //密码
    private String email; //邮箱
    private Date date; //创建日期
    private int valid;  //是否有效
    private UserAuthority UserAuthority;//拥有权限

    private UserDetail userDetail;

    //    新增加的get方法-----加了这个远程feign调用就会报错》》》
//    public int getAuthority_id() {
//        return UserAuthority.getAuthority_id();
//    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public com.boot.pojo.UserAuthority getUserAuthority() {
        return UserAuthority;
    }

    public void setUserAuthority(com.boot.pojo.UserAuthority userAuthority) {
        UserAuthority = userAuthority;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", valid=" + valid +
                ", UserAuthority=" + UserAuthority +
                ", userDetail=" + userDetail +
                '}';
    }
}
