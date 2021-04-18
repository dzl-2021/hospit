package com.jskj.springboot.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConf extends WebMvcConfigurerAdapter {
  
  @Autowired
  private AuthActionInterceptor authActionInterceptor;
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(authActionInterceptor).addPathPatterns("/**").addPathPatterns("/article/**")
    .excludePathPatterns("/static/**").excludePathPatterns("/login").excludePathPatterns("/regist");
    super.addInterceptors(registry);
  }
  
  /* *
   * @Author lsc
   * <p> 将拦截器注入context </p>
   * @Param []
   * @Return com.zszxz.jwt.interceptor.JwtInterceptor
   */
  @Bean
  public AuthActionInterceptor authenticationInterceptor() {
      return new AuthActionInterceptor();
  }
  /* *
   * @Author lsc
   * <p>跨域支持 </p>
   * @Param [registry]
   * @Return void
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**")
              .allowedOrigins("*")
              .allowCredentials(true)
              .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS", "HEAD")
              .maxAge(3600 * 24);
  }

}
