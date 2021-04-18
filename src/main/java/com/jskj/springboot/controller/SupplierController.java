package com.jskj.springboot.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jskj.springboot.common.UserContext;
import com.jskj.springboot.pojo.Supplier;
import com.jskj.springboot.pojo.SysUser;
import com.jskj.springboot.service.SupplierService;
import com.jskj.springboot.utils.MessageInfo;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("/gys/supplier")
	public String show() {
		return "/gysgl/show";
	}
	
	@RequestMapping(value = "/gys/findSupplier", method = RequestMethod.POST)
	@ResponseBody
	public Supplier findSupplier(HttpServletRequest request, ModelMap modelMap){
		SysUser user = UserContext.getUser();
		return supplierService.findSupplier(user.getGysid());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/gys/saveGys", method = RequestMethod.POST)
	@ResponseBody
	public MessageInfo<Object> saveSupplier(HttpServletRequest request, ModelMap modelMap,@RequestBody Map<String, Object> params){
		Map<String ,Object> param = (Map<String ,Object>)params.get("params");
		String token = request.getHeader("token");
		System.out.println(token);
		return supplierService.saveSupplier(param);
	}
}
