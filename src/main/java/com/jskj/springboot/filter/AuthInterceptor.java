/**
 * 
 */
package com.jskj.springboot.filter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Joiner;
import com.jskj.springboot.common.CommonConstans;
import com.jskj.springboot.common.UserContext;
import com.jskj.springboot.pojo.SysUser;

/**
 *
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
  
  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
          throws Exception {
    Map<String, String[]> map = req.getParameterMap();
    map.forEach((k,v) ->req.setAttribute(k, Joiner.on(",").join(v)));
    String requestURI = req.getRequestURI();
    if (requestURI.startsWith("/static") || requestURI.startsWith("/error")) {
      return true;
    }
   HttpSession session = req.getSession();
   SysUser user =(SysUser)session.getAttribute(CommonConstans.USER_ATTRIBUTE);
   SysUser userlocal= UserContext.getUser();
   if(user != null && userlocal==null) {
	   UserContext.setUser(user);
   }
    return true;
  }
  

  @Override
  public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler,
          ModelAndView modelAndView) throws Exception {
    
  }
  
  

  @Override
  public void afterCompletion(HttpServletRequest req, HttpServletResponse response, Object handler, Exception ex)
          throws Exception {
	  UserContext.remove();
  }
}
