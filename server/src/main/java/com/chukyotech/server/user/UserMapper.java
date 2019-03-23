package com.chukyotech.server.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    @Insert("insert into chukyo_user (name, age, language, phone) values (#{name}, #{age}, #{language}, #{phone})")
    void insert(@Param("name") String name,
                @Param("age") int age,
                @Param("language") String language,
                @Param("phone") String phone);
}
