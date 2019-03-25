package com.chukyotech.server.admin;

import com.chukyotech.server.admin.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    int insertAdmin(@Param("adminName") String adminName, @Param("adminPass") String adminPass);

    Admin selectByPrimaryKey(Integer id);

    Admin selectByName(@Param("adminName") String adminName);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}