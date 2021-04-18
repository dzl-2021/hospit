package com.jskj.springboot.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.jskj.springboot.mapper.ZzglMapper;
import com.jskj.springboot.pojo.QualificationsInfo;
import com.jskj.springboot.vo.TongjiVo;
@Service("qualificationsInfoService")
public class QualificationsInfoService {
	@Autowired
	ZzglMapper zzglMapper;
	public Map<String,Object> getListjson(String gysdm) {
		Map<String,Object> map =  new HashMap<String, Object>();
		 try {
			 String strNow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString();
			 //过期总数
			 int gqzs = zzglMapper.getListjson(strNow);
			 //正常总数
			 int zczs = zzglMapper.getListjsonzc(strNow); 
			 //供应商正常
			 int gyszc = zzglMapper.getListjsonGyszc(strNow); 
			 //供应商过期
			 int gysgq = zzglMapper.getListjsonGysgq(strNow); 
			 //厂商正常
			 int cszc = zzglMapper.getListjsonCszc(strNow); 
			 //厂商过期
			 int csgq = zzglMapper.getListjsonCsgq(strNow); 
			 //产品正常
			 int cpzc = zzglMapper.getListjsonCpzc(strNow); 
			 //产品过期
			 int cpgq = zzglMapper.getListjsonCpgq(strNow); 
			 List<TongjiVo> list = Lists.newArrayList();
			 TongjiVo vo = new TongjiVo();
			 vo.setTitle("过期");
			 vo.setUrl("/totalGq");
			 vo.setResult(gqzs +"");
			 list.add(vo);
			 
			 map.put("listgq",new int [] {gqzs,gysgq,csgq,cpgq});
			 map.put("listzc",new int [] {zczs,gyszc,cszc,cpzc});
		 }catch(Exception e ){
			 e.printStackTrace();
		 }
		 
		 
		return map;
	}
	public Map<String,Object> getListjsongq(String businessTypeCode) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<QualificationsInfo> listjsongq = new ArrayList<QualificationsInfo>();
		String strNow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString();
		listjsongq=zzglMapper.getListjsongqzz(strNow,businessTypeCode);
		map.put("listgysgq", listjsongq);
		return map;
	}
	
}
