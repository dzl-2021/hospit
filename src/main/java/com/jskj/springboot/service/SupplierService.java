package com.jskj.springboot.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jskj.springboot.mapper.SupplierMapper;
import com.jskj.springboot.pojo.Supplier;
import com.jskj.springboot.utils.MessageInfo;

@Service
public class SupplierService {
	@Autowired
	SupplierMapper supplierMapper;
	public MessageInfo<Object> saveSupplier(Map<String, Object> params) {
		MessageInfo<Object> msg = new MessageInfo<Object>(MessageInfo.FAILE,"保存失败!");
		String gysmc = (String)params.get("gysmc");
		Supplier old = supplierMapper.findSupplierByName(gysmc);
		Supplier info = new Supplier();
		 	info.setCjsj(new Date(System.currentTimeMillis()));
			info.setGysmc((String)params.get("gysmc"));
			info.setGysjc((String)params.get("gysjc"));
			info.setTyxydm((String)params.get("tyxydm"));
			info.setJyfw((String)params.get("jyfw"));
			info.setFddbr((String)params.get("fddbr"));
			info.setSfzhm((String)params.get("sfzhm"));
			info.setZczj((String)params.get("zczj"));
			info.setKhh((String)params.get("khh"));
			info.setKhhzh((String)params.get("khhzh"));
			info.setZycp((String)params.get("zycp"));
			info.setJyms((String)params.get("jyms"));
			info.setYwy((String)params.get("ywy"));
			info.setYwylxdh((String)params.get("ywylxdh"));
			info.setTxdz((String)params.get("txdz"));
			info.setDescrip((String)params.get("descrip"));
			info.setQyzt("1");
		if(old==null) {
			int i = supplierMapper.saveSupplier(info);
			if(i>0) {
				msg.setInfo(info);
				msg = new MessageInfo<Object>(MessageInfo.SUCCESS,"保存成功!");
			}
		}else {
			info.setId(old.getId());
			info.setCjsj(old.getCjsj());
			info.setGxsj(new Date(System.currentTimeMillis()));
			int j =  supplierMapper.updatesupplier(info);
			if(j>0) {
				msg.setInfo(info);
				msg = new MessageInfo<Object>(MessageInfo.SUCCESS,"保存成功!");
			}
		}
		   
		return msg;
	}
	public Supplier findSupplier(int gysid) {
		List<Supplier> list = supplierMapper.findSupplierByid(gysid);
		if (!list.isEmpty()) {
		   return list.get(0);
		}else {
			return null;
		}
	}

}
