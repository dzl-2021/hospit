package com.jskj.springboot.utils;

import java.io.Serializable;

import com.jskj.springboot.common.RestCode;

/**
 *  前台消息或业务处理中间件(处理类)
 */
public class MessageInfo<T>  implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final String SUCCESS="1";
	public static final String WARNING="0";
	public static final String FAILE="-1";
	public static final String validatecodeNUll="-2";
	public static final String validatecodeError="-3";
	
	/** 桥接字段，用来处理业务逻辑特殊需求   ***/
	private String bridge="";
	private String message="";
	private String doResult=FAILE;
	private String type="";
	private T result;
	private int code;
	private String url="";
	
	private Object info=null;
	private Object info1=null;
	private Object infomx=null;
	
	
	public static <T> MessageInfo<T> success(){
		return new MessageInfo<T>();
	}
	
	public static <T> MessageInfo<T> success(T result){
		MessageInfo<T> response = new MessageInfo<T>();
		response.setResult(result);
		return response;
	}
	
	public static <T> MessageInfo<T> error(RestCode code){
		return new MessageInfo<T>(code.code,code.msg);
	}
	
	public MessageInfo(){
		this(RestCode.OK.code,RestCode.OK.msg);
	}
	
	public MessageInfo(int code,String message){
		this.setCode(code);
		this.message = message;
	}
	
	public Object getInfomx() {
		return infomx;
	}

	public void setInfomx(Object infomx) {
		this.infomx = infomx;
	}

	/**
	 * 添加构造函数及 默认值处理方法 
	 * @param doResult
	 * @param message
	 */
	public MessageInfo(String doResult,String message){
		this.message = message;
		this.doResult = doResult;
		this.type="";
	}
	
	/**
	 * 添加包含桥接消息→构造函数及 默认值处理方法 
	 * @param doResult
	 * @param message
	 * @param bridge
	 */
	public MessageInfo(String doResult,String message,String bridge){
		this.message = message;
		this.doResult = doResult;
		this.bridge=bridge;
		this.type="";
	}
	/**
	 * 添加包含桥接消息→构造函数及 默认值处理方法 --注册选择理财师时的验证
	 * @param doResult
	 * @param message
	 * @param bridge
	 */
	public MessageInfo(String doResult,String message,String bridge,String type){
		this.message = message;
		this.doResult = doResult;
		this.bridge=bridge;
		this.type=type;
	}
	
	/**
	 * 跳转成功
	 * @param message
	 * @return
	 */
	public MessageInfo<T> doSucc(String message){
		this.doResult ="1";
		this.message = message;
		this.type="";
		return this;
	}
	/**
	 * 跳转失败
	 * @param message
	 * @return
	 */
	public MessageInfo<T> doFail(String message){
		this.doResult="-1";
		this.message = message;
		this.type="";
		return this;
	}
	
	public String getBridge() {
		return "".equals(this.bridge)==true?"":this.bridge;
	}

	public void setBridge(String bridge) {
		this.bridge = bridge;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDoResult() {
		return doResult;
	}
	public void setDoResult(String doResult) {
		this.doResult = doResult;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Object getInfo1() {
		return info1;
	}

	public void setInfo1(Object info1) {
		this.info1 = info1;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	
}
