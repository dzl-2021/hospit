package com.jskj.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jskj.springboot.pojo.Supplier;

@Mapper
public interface SupplierMapper {

	int saveSupplier(@Param("info")Supplier info);

	Supplier findSupplierByName(@Param("gysmc")String gysmc);

	int updatesupplier(@Param("info")Supplier info);

	List<Supplier> findSupplierByid(@Param("gysid")int gysid);

}
