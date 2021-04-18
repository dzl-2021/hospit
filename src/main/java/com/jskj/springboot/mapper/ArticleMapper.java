package com.jskj.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jskj.springboot.pojo.MyArticle;
import com.jskj.springboot.pojo.MyArticleBody;

@Mapper
public interface ArticleMapper {
	int save(@Param("info")MyArticle info);

	int saveBody(@Param("infoBody")MyArticleBody infoBody);

	List<MyArticle> findByUserId(@Param("id")int id);

	List<MyArticleBody> getArticleBodyByAuthor(@Param("articleId")int articleId);

}
