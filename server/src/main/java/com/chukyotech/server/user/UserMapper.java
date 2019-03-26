package com.chukyotech.server.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    List<User> selectUsers();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateUser(@Param("id") Integer id,
                   @Param("userName") String userName,
                   @Param("userAge") Integer userAge,
                   @Param("userPhone") String userPhone,
                   @Param("userAddres") String userAddres,
                   @Param("userLanguage") String userLanguage,
                   @Param("userEmail") String userEmail);
}