package com.jskj.springboot.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;


/**
 * 非空处理工具类
 * @author hetral
 *
 */
public class Def2Val {
	/**
	 * 医保编码是否模糊查询
	 */
	public static boolean ybdmsfmhcx=true;
	/**
	 * 字符串非空处理
	 * @param str
	 * @return
	 */
	public static String strNotNUll(String str){
		if(StringUtils.isNotBlank(str)==false){
			return "";
		}
		if(str.equals("null")){
			return "";
		}
		return str;
	}
	/**
	 * 字符串非空处理
	 * @param str
	 * @return
	 */
	public static String strNotNUll(String str,String def){
		if(StringUtils.isNotBlank(str)==false){
			return def;
		}
		if(str.equals("null")){
			return def;
		}
		return str;
	}
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static Boolean strNotNUllBoolean(String str){
		if(StringUtils.isNotBlank(str)==false){
			return false;
		}
		if(str.equals("null")){
			return false;
		}
		return true;
	}
	/**
	 * Timestamp非空格式化输出
	 * @param date 时间戳
	 * @param format 格式化输出
	 * @return
	 */
	public static String  yyyyMMddNotNUll(Timestamp date, String format){
		if(date==null){
			return "";
		}
		DateFormat sdf = new SimpleDateFormat(format);   
       return sdf.format(date);
	}
	
	/**
	 * date非空格式化输出
	 * @param date 时间戳
	 * @param format 格式化输出
	 * @return
	 */
	public static String  yyyyMMddNotNUll(Date date, String format){
		if(date==null){
			return "";
		}
		return DateUtil.getDateByformat(date, format); 
	}
	/**
	 * 字符串转Timestamp
	 * @param date 时间戳
	 * @param format 格式化输出
	 * @return
	 */
	public static Timestamp  yyyyMMddNotNUll(String date, String format){
		if(date==null){
			return null;
		}
		return Timestamp.valueOf(date);
      /* try {
		return (Timestamp) new SimpleDateFormat(format).parse(date);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	return null;*/
	}
	/**
	 * 两个字符串Timestamp时间比较大小
	 * @param date
	 * @param dateNew
	 * @return
	 */
	public static boolean  timestampBjdx(String date,String dateNew){
		Timestamp a = Timestamp.valueOf(date);
		Timestamp b = Timestamp.valueOf(dateNew);
		return a.before(b);
	}
	/**
	 * 字符串转Date
	 * @param date 时间戳
	 * @param format 格式化输出
	 * @return
	 */
	public static String  yyyyMMddDateNotNUll(Date date, String format){
		if(date==null){
			return "";
		}
		DateFormat sdf = new SimpleDateFormat(format);   
       return sdf.format(date);
	}
	/**
	 * Date非空格式化输出
	 * @param date 时间戳
	 * @param format 格式化输出
	 * @return
	 */
	public static Date  yyyyMMddDateNotNUll(String date, String format){
		if(date==null){
			return null;
		}
       try {
		return new SimpleDateFormat(format).parse(date);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	return null;
	}
	/**
	 * BigDecimal转字符串处理
	 * @param str
	 * @return
	 */
	public static String strNotBigDecimalNUll(BigDecimal str){
		return str==null?"0":str.toString();
	}
	/**
	 * BigDecimal转字符串处理
	 * @param str
	 * @return
	 */
	public static String strNotBigDecimalNUll(BigDecimal str,String mrz){
		return str==null?mrz:str.toString();
	}
	/**
	 * 字符串转BigDecimal非空处理
	 * @param str
	 * @return
	 */
	public static BigDecimal strBigDecimalNUll(String str){
		return strNotNUllBoolean(str)==true?new BigDecimal(str):new BigDecimal("0");
	}
	/**
	 * 判断当前字符串是否为整数
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){ 
		if(strNotNUllBoolean(str)==false){
			return false;
		}
	   Pattern pattern = Pattern.compile("[0-9]*"); 
	   Matcher isNum = pattern.matcher(str);
	   if( !isNum.matches() ){
	       return false; 
	   } 
	   return true; 
	}
	/**
	 * 是否是图片验证--资质验证用
	 * @param str
	 * @return
	 */
	public static boolean imgYz(String str){
		if(Def2Val.strNotNUllBoolean(str)==false){
			return false;
		}
		if(str.toLowerCase().lastIndexOf(".pdf")>0){
			return false;
		}
		return true;
		
		/*if(str.toLowerCase().lastIndexOf(".ico")>0 || str.toLowerCase().lastIndexOf(".bmp")>0 || str.toLowerCase().lastIndexOf(".jpg")>0 || str.toLowerCase().lastIndexOf(".jpeg")>0 || str.toLowerCase().lastIndexOf(".png")>0 || str.toLowerCase().lastIndexOf(".gif")>0){
			return true;
		}
		return false;*/
	}
	/**
	 * 判断一个数组是否为空
	 * @param list
	 * @return
	 */
	public static <E> boolean isSz(List<E> list){
		if(list==null){
			return false;
		}
		if(list.size()==0){
			return false;
		}
		return true;
	}
	/**
	 * 判断一个map是否为空
	 */
	public static <E> boolean isMap(Map<E,E> map){
		if(map==null){
			return false;
		}
		if(map.size()==0){
			return false;
		}
		return true;
	}
	/**
	 * 去除字符串首尾单引号
	 * @param str
	 * @return
	 */
	public static String getQczfcSwdyh(String str){
		if(Def2Val.strNotNUllBoolean(str)==false){
			return "";
		}
		if(str.substring(0, 1).equals("'") && str.substring(str.length()-1, str.length()).equals("'")){
			return str.substring(1,str.length()-1);
		}
		if(str.substring(0, 1).equals("'") && !str.substring(str.length()-1, str.length()).equals("'")){
			return str.substring(1,str.length());
		}
		if(!str.substring(0, 1).equals("'") && str.substring(str.length()-1, str.length()).equals("'")){
			return str.substring(0,str.length()-1);
		}
		return str;
		
	}
	public static void main(String[] args) {
		System.out.println(getQczfcSwdyh("'123'"));
	}
	/**
	 * 判断字符串中是否仅包含英文字母、数字
	 * @param str
	 * @return
	 */
	public static boolean isLetterDigitOrChinese(String str) {
		if(strNotNUllBoolean(str)==false){
			return false;
		}
		  //String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";//包含英文字母、数字和汉字
		 String regex = "^[a-z0-9A-Z]+$";//包含英文字母、数字
		  return str.matches(regex);
	 }
	
	/**
	 * BigDecimal 计算百分比
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String percent(BigDecimal num1,BigDecimal num2){
		BigDecimal percent =  num1.divide(num2,2,BigDecimal.ROUND_HALF_UP); 
		percent=percent.multiply(new BigDecimal(100));
        return percent+"%";
	}
	public static String clobZStr(Clob clob) {
		String content="";
		try {
			Reader is=clob.getCharacterStream();
			BufferedReader buff=new BufferedReader(is);// 得到流  
			String line=buff.readLine();
			StringBuffer sb=new StringBuffer();
			while (line!=null){// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING  
				sb.append(line);
				line=buff.readLine();
			}
			content=sb.toString();
		} catch (Exception e) {
		}
		return content;
	}
	/**
	 * 验证医生角色职位
	 * @param zw
	 * @return
	 */
	public static boolean getYzysjs(String zw) {
		if(Def2Val.strNotNUllBoolean(zw)==false) {
			return false;
		}
		if(zw.equals("2")) {//医生
			return true;
		}
		if(zw.equals("6")) {//科员-财务
			return true;
		}
		if(zw.equals("5")) {//科员
			return true;
		}
		if(zw.equals("9")) {//护士
			return true;
		}
		return false;
	}
	/**
	 * 验证主任角色职位
	 * @param zw
	 * @return
	 */
	public static boolean getYzzrjs(String zw) {
		if(Def2Val.strNotNUllBoolean(zw)==false) {
			return false;
		}
		if(zw.equals("3")) {//主任
			return true;
		}
		if(zw.equals("4")) {//科长
			return true;
		}
		if(zw.equals("10")) {//护士长
			return true;
		}
		if(zw.equals("1")) {//管理员
			return true;
		}
		return false;
	}
	/**
	 * 验证sql结果集是否执行成功
	 * @param jgj
	 * @param zxjl
	 * @return
	 * @throws Exception
	 */
	public static boolean getYzsqljgjsfzxcg(int[] jgj, int zxjl)throws Exception {
		if(jgj==null) {
			return false;
		}
		if(jgj.length!=zxjl) {
			return false;
		}
		for (int i = 0; i < jgj.length; i++) {
			if(jgj[i]!=-2) {
				return false;
			}
		}
		return true;
	}
	
	public static String getHcgJsonzfGsc(String jsonStr) {
		jsonStr=jsonStr.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");
		jsonStr=jsonStr.replace("<string xmlns=\"http://tempuri.org/\">", "");
		jsonStr=jsonStr.replace("</string>", "");
		jsonStr=jsonStr.replace("", "");
		return jsonStr;
	}
	// Clob类型 转String
    public static String ClobToString(Clob clob) throws SQLException, IOException {
      String reString = "";
      Reader is = clob.getCharacterStream();
      BufferedReader br = new BufferedReader(is);
      String s = br.readLine();
      StringBuffer sb = new StringBuffer();
      while (s != null) {
          sb.append(s);
          s = br.readLine();
      }
      reString = sb.toString();
      if(br!=null){
          br.close();
      }
      if(is!=null){
          is.close();
      }
      return reString;
     }
    /**
     * 判断一个字符串是否为字母
     * @param fstrData
     * @return
     */
    public static boolean check(String fstrData) {
        char c = fstrData.charAt(0);
        if (((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
            return true;
        } else {
            return false;
        }
    }
}
