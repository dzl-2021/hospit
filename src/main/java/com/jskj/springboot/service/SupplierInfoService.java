package com.jskj.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jskj.springboot.mapper.SupplierInfoMapper;
import com.jskj.springboot.pojo.SupplierInfo;

@Service
public class SupplierInfoService {
	@Autowired
	private SupplierInfoMapper sMapper;
	public List<SupplierInfo> getSupplier() {
		List<SupplierInfo> list = new ArrayList<SupplierInfo>();
		list=sMapper.selectSupplier();
		return list;
	}
	public List<SupplierInfo> saveSupplier(Map<String, Object> params) {
		
		return null;
	}
	
}
