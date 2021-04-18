package com.jskj.springboot.pojo;

import java.io.Serializable;


public class QualificationsInfoType implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code;

	private String enableCode;

	private String jb;

	private String name;

	private String type;

	public QualificationsInfoType() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEnableCode() {
		return this.enableCode;
	}

	public void setEnableCode(String enableCode) {
		this.enableCode = enableCode;
	}

	public String getJb() {
		return this.jb;
	}

	public void setJb(String jb) {
		this.jb = jb;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}