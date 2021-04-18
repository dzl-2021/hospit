package com.jskj.springboot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.jskj.springboot.utils.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jskj.springboot.common.ResultMsg;
import com.jskj.springboot.common.UserContext;
import com.jskj.springboot.pojo.MyArticle;
import com.jskj.springboot.pojo.MyArticleBody;
import com.jskj.springboot.pojo.SysUser;
import com.jskj.springboot.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/article/addArticle")
	public String  addArticle(HttpServletRequest request,ModelMap modelMap) {
		SysUser user = UserContext.getUser();
		if(user == null) {
			 return "redirect:/index?" + ResultMsg.errorMsg("请先登录!").asUrlParams();
		}
		return "/article/addArticle";
		 
	}
	@RequestMapping("/article/show")
	@ResponseBody
	public MessageInfo<Object> showAr(ModelMap modelMap){
		return new MessageInfo<Object>();
	}
	
	@RequestMapping("/article/showArticle")
	public String  showArticle(HttpServletRequest request,ModelMap modelMap) {
		return "/article/showArticle";
	}
	
	
	@RequestMapping("/article/getArticles")
	@ResponseBody
	public Map<String,Object>  getArticles(HttpServletRequest request,ModelMap modelMap) {
		SysUser user = UserContext.getUser();
		return articleService.getArticleAll(user.getId());
		 
	}
	
	@RequestMapping("/article/getArticleBytitle")
	@ResponseBody
	public Map<String,Object>  getArticleBytitle(HttpServletRequest request,ModelMap modelMap,int id) {
		return articleService.getArticleBytitle(id);
		 
	}
	
	@RequestMapping("/article/save")
	public String save(HttpServletRequest request,String title,String author, String textarea) {
		System.out.println(textarea);
		articleService.save(title, author, textarea);
		return "/article/showArticle";
	}
}
