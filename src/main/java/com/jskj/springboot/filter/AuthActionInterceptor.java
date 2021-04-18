/**
 * 
 */
package com.jskj.springboot.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jskj.springboot.common.UserContext;
import com.jskj.springboot.pojo.SysUser;
import com.jskj.springboot.service.UserService;
import com.jskj.springboot.utils.TokenUtil;

/**
 *
 */
@Component
public class AuthActionInterceptor implements HandlerInterceptor {
  
	@Autowired
	UserService userService;
  
  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
          throws Exception {
	  String token = req.getHeader("token");
      // 如果不是映射到方法直接通过
      if(!(handler instanceof HandlerMethod)){
          return true;
      }
      if (token != null){
          String username = TokenUtil.getUserNameByToken(req);
          // 这边拿到的 用户名 应该去数据库查询获得密码，简略，步骤在service直接获取密码
          SysUser info = userService.getPassword(username);
          boolean result = TokenUtil.verify(token,username,info.getPassword());
          if(result){
              System.out.println("通过拦截器");
              UserContext.setUser(info);
              return true;
          }
      }
      return false;
  }

  @Override
  public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler,
          ModelAndView modelAndView) throws Exception {
     
  }

  @Override
  public void afterCompletion(HttpServletRequest req, HttpServletResponse response, Object handler, Exception ex)
          throws Exception {
  }
}
