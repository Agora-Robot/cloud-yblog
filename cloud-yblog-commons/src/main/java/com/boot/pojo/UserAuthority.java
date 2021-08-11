package com.boot.pojo;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "用户权限实体类",description = "封装每个用户对应的权限")
public class UserAuthority {

    private long user_id; //用户id
    private long authority_id; //所拥有的权限id

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getAuthority_id() {
        return authority_id;
    }

    public void setAuthority_id(long authority_id) {
        this.authority_id = authority_id;
    }

    @Override
    public String toString() {
        return "user_authority{" +
                "user_id=" + user_id +
                ", authority_id=" + authority_id +
                '}';
    }
}
