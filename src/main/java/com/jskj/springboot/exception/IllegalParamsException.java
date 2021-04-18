package com.jskj.springboot.exception;

import com.jskj.springboot.exception.UserException.Type;

public class IllegalParamsException extends RuntimeException implements WithTypeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Type type;
	
	public IllegalParamsException(String message) {
	    super(message);
	    this.type = Type.WRONG_TYPE;
	  }
	
	public IllegalParamsException(Type type,String msg){
		super(msg);
		this.type = type;
	}
	
	public Type type(){
		return type;
	}
	
	public enum Type{
		WRONG_PAGE_NUM,WRONG_TYPE
	}
}
