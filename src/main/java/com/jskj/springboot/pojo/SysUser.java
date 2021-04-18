package com.jskj.springboot.pojo;

import java.io.Serializable;
import java.sql.Timestamp;


public class SysUser  implements Serializable {
	 private static final long serialVersionUID = 1L;
	 private int id;
	 private String username;
	 private String password;
	 private String email;
	 private String userKey;
	 private String token;
	 private String active;
	 private String phone;
	 private Timestamp createdate;
	 private int gysid;
	 public int getGysid() {
		return gysid;
	}
	public void setGysid(int gysid) {
		this.gysid = gysid;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	 public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String cjsj;
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
