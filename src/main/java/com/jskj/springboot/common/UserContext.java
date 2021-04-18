package com.jskj.springboot.common;

import com.jskj.springboot.pojo.SysUser;
/**
 * 管理ThreadLocal的包装类
 * @author admin
 *
 */
public class UserContext {
  private static final ThreadLocal<SysUser> USER_HOLDER = new ThreadLocal<SysUser>();
  
  public static void setUser(SysUser user){
    USER_HOLDER.set(user);
  }
  
  public static void remove() {
    USER_HOLDER.remove();
  }
  
  public static SysUser getUser() {
    return USER_HOLDER.get();
  }

}
