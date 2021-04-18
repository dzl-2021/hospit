package com.jskj.springboot.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class StringUtil {

	public static String strNotNUll(Object obj) {
		if (obj != null) {
			String str = obj.toString();
			return str;
		}
		return "";
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
	public static String objectToJson(MessageInfo msg) {
		String jsonStringfj = JSON.toJSONString(msg);
		Object objfj = JSON.parse(jsonStringfj); // 防止特殊字符取值
		String strfj = JSON.toJSONString(objfj,
				SerializerFeature.BrowserCompatible);
		return strfj;
	}
	
	public static byte[] objectToByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            //LOGGER.error("objectToByteArray failed, " + e);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    //LOGGER.error("close objectOutputStream failed, " + e);
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    //LOGGER.error("close byteArrayOutputStream failed, " + e);
                }
            }

        }
        return bytes;
    }
	/**
     * 不够位数的在前面补0，保留num的长度位数字
     * @param code
     * @return
     */
	public static String autoGenericCode(String code, int num) {
        String result = "";
        // 保留num的位数
        // 0 代表前面补充0     
        // num 代表长度为4     
        // d 代表参数为正数型 
        result = String.format("%0" + num + "d", Integer.parseInt(code));

        return result;
    }
	
		/**
		 * 生成 MD5 
		 * @param plainText
		 * @return
		 */
	 public static String stringToMD5(String plainText) {
	        byte[] secretBytes = null;
	        try {
	            secretBytes = MessageDigest.getInstance("md5").digest(
	                    plainText.getBytes());
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException("没有这个md5算法！");
	        }
	        String md5code = new BigInteger(1, secretBytes).toString(16);
	        for (int i = 0; i < 32 - md5code.length(); i++) {
	            md5code = "0" + md5code;
	        }
	        return md5code;
	    }
}
