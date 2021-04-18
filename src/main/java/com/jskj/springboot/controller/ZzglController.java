package com.jskj.springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jskj.springboot.service.QualificationsInfoService;
import com.jskj.springboot.service.UserService;

@Controller
public class ZzglController {
		@Autowired
		UserService userInfoService;
		@Autowired
		QualificationsInfoService qualificationsInfoService;
	    @RequestMapping("/zzshow")
	    public String zzshow(ModelMap map){
	        return "zzshow";
	    }
	    @RequestMapping("/listjson")
	    @ResponseBody
	    public Map<String,Object> getlistjsonGq(ModelMap modelMap,String gysdm) {
	    	return qualificationsInfoService.getListjson(gysdm);
	    }
	    @RequestMapping("/zzmxshow")
	    public String zzmxshow(ModelMap map){
	        return "zzmxshow";
	    }
	    
	    @RequestMapping("/zzglshow")
	    public String zzglshow(ModelMap map){
	        return "/zzgl/zzglshow";
	    }
	    
	    @RequestMapping("/listjsongq")
	    @ResponseBody
	    public Map<String,Object> listjson(ModelMap modelMap,String businessTypeCode) {
	    	return qualificationsInfoService.getListjsongq(businessTypeCode);
	    }
	
}
