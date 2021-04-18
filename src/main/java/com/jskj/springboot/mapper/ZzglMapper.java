package com.jskj.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jskj.springboot.pojo.QualificationsInfo;
@Mapper
public interface ZzglMapper {
	int getListjson(@Param("strNow")String strNow);

	int getListjsonzc(@Param("strNow")String strNow);

	int getListjsonGyszc(@Param("strNow")String strNow);

	int getListjsonGysgq(@Param("strNow")String strNow);

	int getListjsonCszc(@Param("strNow")String strNow);

	int getListjsonCsgq(@Param("strNow")String strNow);

	int getListjsonCpzc(@Param("strNow")String strNow);

	int getListjsonCpgq(@Param("strNow")String strNow);

	List<QualificationsInfo> getListjsongqzz(@Param("strNow")String strNow,@Param("businessTypeCode")String businessTypeCode);


}
