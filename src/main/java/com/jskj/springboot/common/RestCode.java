package com.jskj.springboot.common;

public enum RestCode {
	OK(0,"ok"),
	UNKNOWN_ERROR(1,"未知异常"),
	TOKEN_INVALID(2,"TOKEN失效"),
	USER_NOT_EXIST(3,"用户不存在"),
	USER_AUTH_FAIL(4,"输入的密码有误！"),
	WRONG_PAGE(10100,"页码不合法"),
    LACK_PARAMS(10101,"缺少参数"),
	USER_ALREADY_EXIt(5,"用户已存在");
	public final int code;
	public final String msg;
	
	private RestCode(int code,String msg){
		this.code = code;
		this.msg = msg;
	}
}
