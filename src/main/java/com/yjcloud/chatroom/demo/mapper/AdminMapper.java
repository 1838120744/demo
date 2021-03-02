package com.yjcloud.chatroom.demo.mapper;

import com.yjcloud.chatroom.demo.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface  AdminMapper{
    public  List<Admin> findByNameAndPsw(@Param("name") String name,@Param("psw") String psw);
}
