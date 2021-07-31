package com.boot.service;

import com.boot.pojo.img;

import java.util.List;

public interface imgService {


    void addImgPath(String big_img, String small_img);

    //从数据库查找所有图片地址
    List<img> selectAllImg();

    img selectImgByid(int id);

    int selectImgCount();

    void deleteImgByid(int id);
}
