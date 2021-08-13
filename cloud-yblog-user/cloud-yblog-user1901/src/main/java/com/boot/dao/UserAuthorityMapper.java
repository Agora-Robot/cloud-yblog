package com.boot.dao;

import com.boot.pojo.UserAuthority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserAuthorityMapper {

    void changeUserAuthority(UserAuthority UserAuthority);

    int selectAuthorityID(@Param("userid") long userid);

}
