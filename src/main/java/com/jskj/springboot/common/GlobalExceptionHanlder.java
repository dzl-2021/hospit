package com.jskj.springboot.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jskj.springboot.utils.MessageInfo;

@ControllerAdvice
public class GlobalExceptionHanlder {
	private static final Logger Logger = LoggerFactory.getLogger(GlobalExceptionHanlder.class);
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(value = Throwable.class)  //定义处理异常的方法
	@ResponseBody//序列化成json
	public MessageInfo<Object> handler(HttpServletRequest req, Throwable throwable){
		Logger.error(throwable.getMessage(),throwable);
//	    tracer.addTag(Span.SPAN_ERROR_TAG_NAME, ExceptionUtils.getExceptionMessage(throwable));
//	    System.out.println(tracer.getCurrentSpan().getTraceId());
		RestCode restCode = Exception2CodeRepo.getCode(throwable);
		MessageInfo<Object> response = new MessageInfo<Object>(restCode.code,restCode.msg);
		return response;
	}
}
