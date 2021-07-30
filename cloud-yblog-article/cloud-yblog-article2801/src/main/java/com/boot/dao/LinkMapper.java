package com.boot.dao;

import com.boot.pojo.link;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LinkMapper {


    List<link> selectAllLink(); //查询所有友链

    void updateLink(link link); //修改友链

    void insertLink(link link); //添加友链

    void deleteLink(@Param("id") int id); //删除友链

    @Select("select count(*) from t_link")
    int linkCount();


    List<link> selectLinkByTitle(@Param("title") String title);

    int selectCountByTitle(@Param("title") String title);


}
