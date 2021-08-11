package com.boot.pojo;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

@ApiModel(value = "黑名单")
public class Blacklist implements Serializable {

    private long id;
    //黑名单Ip
    private String black_ip;
    //黑名单Ip对应的地址
    private String black_address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBlack_ip() {
        return black_ip;
    }

    public void setBlack_ip(String black_ip) {
        this.black_ip = black_ip;
    }

    public String getBlack_address() {
        return black_address;
    }

    public void setBlack_address(String black_address) {
        this.black_address = black_address;
    }

    @Override
    public String toString() {
        return "Blacklist{" +
                "id=" + id +
                ", black_ip='" + black_ip + '\'' +
                ", black_address='" + black_address + '\'' +
                '}';
    }
}
