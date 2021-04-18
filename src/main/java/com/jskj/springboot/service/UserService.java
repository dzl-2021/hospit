package com.jskj.springboot.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.jskj.springboot.exception.UserException;
import com.jskj.springboot.exception.UserException.Type;
import com.jskj.springboot.mapper.UserMapper;
import com.jskj.springboot.pojo.SysUser;
import com.jskj.springboot.utils.MessageInfo;
import com.jskj.springboot.utils.StringUtil;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper ;
	@Transactional(rollbackFor=Exception.class)
	public SysUser getUser(){
		List<SysUser> list = userMapper.findUser();
		return list.get(0);
	}
	@Transactional(rollbackFor=Exception.class)
	public MessageInfo<Object> regist(String username, String password,String phone,String email) {
		MessageInfo<Object> msg = new MessageInfo<Object>(MessageInfo.FAILE,"操作失败");
		try {
			SysUser old = userMapper.findUserByName(username).get(0);

				SysUser user = new SysUser();
				user.setUsername(username);
				String userKey = UUID.randomUUID().toString();
				user.setActive("1");
				user.setUserKey(userKey);
				user.setCreatedate(new Timestamp(System.currentTimeMillis()));
				user.setPassword(StringUtil.stringToMD5(password));
				user.setPhone(phone);
				user.setEmail(email);
				userMapper.insertUser(user);
				msg = new MessageInfo<Object>(MessageInfo.SUCCESS,"添加成功！");
				msg.setUrl("/index");


		} catch (Exception e) {
			e.printStackTrace();
			throw new UserException(Type.USER_ALREADY_EXIt,"用户名已存在！");
		}
		
		
		return msg;
	}
	public SysUser auth(String username, String password) {
		SysUser user = new SysUser();
		List<SysUser> list = userMapper.findUserByName(username);
		if(list.isEmpty()){
			throw new UserException(Type.USER_NOT_FOUND,"用户名不存在！");
		}else {
			
			user=list.get(0);
			String pwd = StringUtil.stringToMD5(password + list.get(0).getUserKey());
			if(!pwd.equals(user.getPassword())){
				throw new UserException(Type.USER_AUTH_FAIL,"输入的密码有误！");
			}
			return user;
		}
		
	}
	public MessageInfo<Object> logout(SysUser user) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<SysUser> getUsers() {
		List<SysUser> list = userMapper.findUser();
		return list;
		// TODO Auto-generated method stub
		
	}
	public SysUser getPassword(String username) {
		List<SysUser> list = userMapper.findUserByName(username);
		if(list.isEmpty()) {
			return null;
		}
		return list.get(0);
		
	}
	
}
