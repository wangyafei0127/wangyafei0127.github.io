package com.chukyotech.server.user;

import com.chukyotech.server.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertUser(@Param("userName") String userName,
                   @Param("userAge") Integer userAge,
                   @Param("userPhone") String userPhone,
                   @Param("userAddres") String userAddres,
                   @Param("userLanguage") String userLanguage,
                   @Param("userEmail") String userEmail);

    int insertSelective(User record);

    User selectByPrimaryKey(@Param("id") int id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}