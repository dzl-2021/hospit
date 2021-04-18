package com.jskj.springboot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jskj.springboot.common.CommonConstans;
import com.jskj.springboot.common.UserContext;
import com.jskj.springboot.pojo.SysUser;
import com.jskj.springboot.service.UserService;
import com.jskj.springboot.utils.MessageInfo;
import com.jskj.springboot.utils.StringUtil;
import com.jskj.springboot.utils.TokenUtil;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/index")
	public String login(HttpServletRequest request,ModelMap modelMap) {
		return "login";
	}
	
	@RequestMapping("/")
	public String tologin(HttpServletRequest request,ModelMap modelMap) {
		return "login";
	}
	@RequestMapping("/vue")
	public String vue(HttpServletRequest request,ModelMap modelMap,String username,String password) {
		return "vue";
	}
	
	
	@RequestMapping("/home")
	public String index(HttpServletRequest request,ModelMap modelMap,String username,String password) {
		return "index";
	}
	@RequestMapping("/homePage")
	public String homePage(HttpServletRequest request,ModelMap modelMap) {
		List<SysUser> list = userService.getUsers();
		modelMap.put("list", list);
		return "homePage";
	}
	@RequestMapping("/getUsers")
	@ResponseBody
	public MessageInfo<Object> getUsers(HttpServletRequest request,ModelMap modelMap) {
		MessageInfo<Object> msg = new MessageInfo<Object>();
		List<SysUser> list = userService.getUsers();
		msg.setResult(list);
		return msg;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public MessageInfo<Object> login(HttpServletRequest request,ModelMap modelMap,@RequestBody Map<String, Object> params) {
		MessageInfo<Object> msg = new MessageInfo<Object>(MessageInfo.FAILE,"登录失败！");
		String username = (String) params.get("username");
		String password = (String) params.get("password");
		if(StringUtil.strNotNUll(username)=="" || StringUtil.strNotNUll(password)=="" ) {
			msg= new MessageInfo<Object>(MessageInfo.FAILE,"请输入用户名密码！");
			return msg;
		}
		String token = TokenUtil.sign(username,StringUtil.stringToMD5(password));
        if (token != null){
        	SysUser info = new SysUser();
        	info.setUsername(username);
        	info.setPassword(password);
        	info.setToken(token);
        	msg= new MessageInfo<Object>(MessageInfo.SUCCESS,"登录成功！");
        	msg.setInfo(info);
        }
		return msg;
	}
	

	@SuppressWarnings("unchecked")
	@RequestMapping("/regist")
	@ResponseBody
	public MessageInfo<Object> register(HttpServletRequest request,ModelMap modelMap,@RequestBody Map<String, Object> params) {
		Map<String, Object> map = (Map<String, Object>)params.get("params");
		String username = (String)map.get("username");
		String password = (String)map.get("password");
		String phone = (String)map.get("phone");
		String email = (String)map.get("email");
		return userService.regist(username,password,phone,email);
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,ModelMap modelMap) {
		UserContext.remove();
		return "/index";
	}
	
}
