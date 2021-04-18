package com.jskj.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jskj.springboot.pojo.SupplierInfo;

@Mapper
public interface SupplierInfoMapper {
	
	public List<SupplierInfo> selectSupplier();
	
	
}
