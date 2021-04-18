package com.jskj.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jskj.springboot.pojo.SysUser;

@Mapper
public interface UserMapper {

	List<SysUser> findUser();

	int insertUser(@Param("user")SysUser user);

	List<SysUser> findUserByName(@Param("username")String username);



}
