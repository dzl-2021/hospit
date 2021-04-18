package com.jskj.springboot.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jskj.springboot.common.UserContext;
import com.jskj.springboot.exception.IllegalParamsException;
import com.jskj.springboot.exception.IllegalParamsException.Type;
import com.jskj.springboot.exception.UserException;
import com.jskj.springboot.mapper.ArticleMapper;
import com.jskj.springboot.pojo.MyArticle;
import com.jskj.springboot.pojo.MyArticleBody;
import com.jskj.springboot.pojo.SysUser;
import com.jskj.springboot.utils.StringUtil;

@Service("articleService")
public class ArticleService {
	@Autowired
	ArticleMapper articleMapper;
	
	@Transactional(rollbackFor = Exception.class)
	public int save(String title,String author, String textarea) {
			SysUser user = UserContext.getUser();
			MyArticle ma = new MyArticle();
			if(StringUtil.strNotNUllBoolean(author)) {
				ma.setAuthor(author);
			}
			ma.setAuthorId(user.getId());
			ma.setTitle(title);
			ma.setCreateTime(new Date(System.currentTimeMillis()));
			articleMapper.save(ma);
			MyArticleBody info = new MyArticleBody();
			info .setBody(textarea);
			info.setCreatTime(new Date(System.currentTimeMillis()));
			info.setArticleId(ma.getId());
			articleMapper.saveBody(info);
			return 1;
	}

	public List<MyArticle> getArticles(int id) {
		List<MyArticle> list = articleMapper.findByUserId(id);
		return list;
	}

	public List<MyArticleBody> getArticleBody(int articleId) {
		List<MyArticleBody> list = articleMapper.getArticleBodyByAuthor(articleId);
		return null;
	}

	public Map<String, Object> getArticleAll(int id) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<MyArticle> list = articleMapper.findByUserId(id);
		MyArticle info = list.get(0);
		List<MyArticleBody> listBody = articleMapper.getArticleBodyByAuthor(info.getId());
		map.put("list", list);
		map.put("info", info);
		map.put("detail", listBody);
		return map;
	}

	public Map<String, Object> getArticleBytitle(int id) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<MyArticleBody> listBody = articleMapper.getArticleBodyByAuthor(id);
		map.put("detail", listBody);
		return map;

	}
	
	
	
	
	
	
	
}
