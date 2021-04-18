package com.jskj.springboot.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;


/**
 * @author guqiong
 * 
 */
public class DateUtil {
	/*** 表示相加 ***/
	public static final String AFTER = "+";
	/*** 表示相减 ***/
	public static final String BEFORE = "-";

	/**
	 * 比任何系统真实日期都早的日期
	 * 
	 * @return Date
	 */
	public static Date getMinDay() {
		return new Date(0);
	}

	/**
	 * 获取有效的最大日期（now）
	 * 
	 * @return Date
	 */
	public static Date getMaxDay() {
		return new Date();
	}

	/**
	 * 获取支持的长日期格式
	 * 
	 * @return 字符串数组，每个元素代表一种格式
	 */
	public static String[] getDateTimeFormat() {
		return new String[] { "yyyy-MM-ddHH:mm:ss", "yyyy-MM-dd HH:mm:ss",
				"yyyyMMddHH:mm:ss", "yyyy/MM/ddHH:mm:ss" };
	}

	/**
	 * 获取支持的长日期格式
	 * 
	 * @return 字符串数组，每个元素代表一种格式
	 */
	public static String[] getDateFormat() {
		return new String[] { "yyyy-MM-dd", "yyyyMMdd", "yyyy/MM/dd",
				"yyyy-MM-ddHH:mm:ss", "yyyy-MM-dd HH:mm:ss",
				"yyyyMMddHH:mm:ss", "yyyy/MM/ddHH:mm:ss" };
	}

	/**
	 * 是否为DateUtil支持的有效的日期字符串
	 * 
	 * @param date
	 *            日期字符串
	 * @return boolean
	 */
	public static boolean isValidateDateFormat(String date) {
		if (date == null || (date.length() != 8 && date.length() != 10))
			return false;
		String[] formats = getDateFormat();
		try {
			DateUtils.parseDate(date, formats);
			return true;
		} catch (Exception e) {
			return false;

		}
	}

	/**
	 * 转换类型，从日期字符串到Date
	 * 
	 * @param date
	 *            日期字符串
	 * @return Date
	 * @throws Exception
	 */
	public static Date parseDate(String date) throws Exception {
		String[] formats = getDateFormat();
		return DateUtils.parseDate(date, formats);
	}

	/**
	 * 格式化时期为字符串
	 * 
	 * @param date
	 *            输入日期
	 * @param pattern
	 *            格式
	 * @return
	 * @throws Exception
	 */
	public static String formate(Date date, String pattern) {
		try {
			DateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		} catch (Exception e) {
			return "";
		}
	}

	public static String format(Timestamp timestamp, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		String str = df.format(timestamp);
		return str;
	}

	/**
	 * 获取一年中第一天
	 * 
	 * @param d
	 * @return
	 * @throws Exception
	 */
	public static Date getYearFirstDay(Date d) throws Exception {
		Calendar calenar = new GregorianCalendar();
		calenar.setTime(d);
		// note：月份从0月开始
		calenar.set(Calendar.MONTH, 0);
		calenar.set(Calendar.DATE, 1);
		return calenar.getTime();
	}

	/**
	 * 获取某一天的零点零分零秒的Date对象，进行类型转换
	 * 
	 * @param s
	 *            日期字符串(不带时间)
	 * @return Date
	 * @throws Exception
	 */
	public static Date addZeroTime(String s) throws Exception {
		String[] dateFormate = getDateTimeFormat();
		return DateUtils.parseDate(s + "00:00:00", dateFormate);

	}

	/**
	 * 获取某一天的23点59分59秒的Date对象，进行类型转换
	 * 
	 * @param s
	 *            日期字符串(不带时间)
	 * @return
	 * @throws Exception
	 */
	public static Date addEndTimeOfDay(String s) throws Exception {
		String[] dateFormate = getDateTimeFormat();
		return DateUtils.parseDate(s + "23:59:59", dateFormate);
	}

	/**
	 * 得到公安统计月
	 * 
	 * @param num
	 *            当num=0 时 为当月公安统计月,当num=1 时 上月公安统计月
	 * @return
	 * @throws Exception
	 */
	public static String[] getDyDate(int num) throws Exception {
		Date dt = new Date();
		String[] time = new String[2];
		int year = Integer.parseInt(getFormatDate(dt, "YYYY"));
		int month = Integer.parseInt(getFormatDate(dt, "MM")) - num;
		int day = Integer.parseInt(getFormatDate(dt, "dd"));
		if (month == 0) {
			year = year - 1;
			month = 12;
		}
		if (month == 12) {
			if (day > 20) {
				time[0] = getFormatDate(
						addZeroTime(year + "-" + month + "-21"),
						"yyyy-MM-dd HH:mm:ss");
				time[1] = getFormatDate(addEndTimeOfDay((year + 1) + "-1-20"),
						"yyyy-MM-dd HH:mm:ss");
			} else {
				time[0] = getFormatDate(addZeroTime(year + "-" + (month - 1)
						+ "-21"), "yyyy-MM-dd HH:mm:ss");
				time[1] = getFormatDate(addEndTimeOfDay((year) + "-" + month
						+ "-20"), "yyyy-MM-dd HH:mm:ss");
			}
		} else if (month == 1) {
			if (day > 20) {
				time[0] = getFormatDate(
						addZeroTime(year + "-" + month + "-21"),
						"yyyy-MM-dd HH:mm:ss");
				time[1] = getFormatDate(addEndTimeOfDay((year) + "-"
						+ (month + 1) + "-20"), "yyyy-MM-dd HH:mm:ss");
			} else {
				time[0] = getFormatDate(addZeroTime((year - 1) + "-12-21"),
						"yyyy-MM-dd HH:mm:ss");
				time[1] = getFormatDate(addEndTimeOfDay((year) + "-" + month
						+ "-20"), "yyyy-MM-dd HH:mm:ss");
			}
		} else {
			if (day > 20) {
				time[0] = getFormatDate(addZeroTime(year + "-" + (month)
						+ "-21"), "yyyy-MM-dd HH:mm:ss");
				time[1] = getFormatDate(addEndTimeOfDay((year) + "-"
						+ (month + 1) + "-20"), "yyyy-MM-dd HH:mm:ss");
			} else {
				time[0] = getFormatDate(addZeroTime((year) + "-" + (month - 1)
						+ "-21"), "yyyy-MM-dd HH:mm:ss");
				time[1] = getFormatDate(addEndTimeOfDay((year) + "-" + month
						+ "-20"), "yyyy-MM-dd HH:mm:ss");
			}
		}
		return time;
	}

	/**
	 * @param dt
	 *            时间格式
	 * @param str
	 *            获取时间格式如 YYYY
	 * @return
	 */
	public static String getFormatDate(Date dt, String str) {
		if (dt != null) {
			SimpleDateFormat df = new SimpleDateFormat(str);
			str = df.format(dt);
			return str;
		}
		return "";
	}

	/**
	 * 得到本年度公安统计
	 * 
	 * @param num
	 *            当num=0 时 为本年度公安统计,当num=1 时 上年度公安统计时间
	 * @return 时间
	 * @throws Exception
	 */
	public static String[] getBndDate(int num) throws Exception {
		Date dt = new Date();
		String[] time = new String[2];
		int year = Integer.parseInt(getFormatDate(dt, "YYYY")) - num;
		time[0] = getFormatDate(addZeroTime((year - 1) + "-12-21"),
				"yyyy-MM-dd HH:mm:ss");
		time[1] = getFormatDate(addEndTimeOfDay((year) + "-12-20"),
				"yyyy-MM-dd HH:mm:ss");
		return time;
	}

	/**
	 * 得到系统日期的年份
	 * 
	 * @return返回日期的格式为yyyy
	 */
	public static String getNowYear() {
		Date now = new Date();
		String str = "";
		try {
			str = formate(now, "yyyy");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;

	}

	/**
	 * 得到系统日期 的月份
	 * 
	 * @return返回日期的格式为mm
	 */
	public static String getNowMonth() {
		Date now = new Date();
		String months = "";
		try {
			months = formate(now, "MM");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return months;

	}

	/**
	 * 得到系统日期 的号数
	 * 
	 * @return返回日期的格式为dd
	 */
	public static String getNowDay() {
		Date now = new Date();
		String days = "";
		try {
			days = formate(now, "dd");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return days;

	}

	/**
	 * 得到几天前的日期
	 * 
	 * @param d
	 * @return
	 */
	public static Date getDateBefore(int day) {
		Calendar now = Calendar.getInstance();
		Date now1 = new Date();
		now.setTime(now1);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return now.getTime();
	}

	/**
	 * 得到几天后的日期
	 * 
	 * @param d
	 * @return
	 */
	public static Date getDateAfter(int day) {
		Calendar now = Calendar.getInstance();
		Date now1 = new Date();
		now.setTime(now1);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return now.getTime();
	}

	/**
	 * 得到字符串日期
	 * 
	 * @param day
	 * @return
	 * @throws Exception
	 */
	public static String getDateBeforeStr(int day) throws Exception {
		return formate(getDateBefore(day), "yyyy-MM-dd");
	}

	/**
	 * 得到当前日期的字符串
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getNowTime() throws Exception {
		Date now = new Date();
		return formate(now, "yyyy-MM-dd");
	}

	/**
	 * 初始化登记日期
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getDjrq() throws ParseException {
		SimpleDateFormat simpFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String djrq = simpFormat.format(new Date());
		return simpFormat.parse(djrq);
	}

	/**
	 * 带时分秒
	 * 
	 * @param d
	 * @return
	 */
	public static String getDatestr(Date d) {
		String datestr = "";
		try {
			datestr = DateUtil.formate(d, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {

		}
		return datestr;
	}

	/**
	 * 将日期格式转化为字符型，不带时分秒
	 * 
	 * @param d
	 * @return
	 */
	public static String getDatestr2(Date d) {
		String datestr = "";
		try {
			datestr = DateUtil.formate(d, "yyyy-MM-dd");
		} catch (Exception e) {

		}
		return datestr;
	}

	/**
	 * 功能描述：时间相减得到天数
	 * 
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @author Administrator
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		java.util.Date beginDate;
		java.util.Date endDate;
		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
			day = (endDate.getTime() - beginDate.getTime())
					/ (24 * 60 * 60 * 1000);
			// System.out.println("相隔的天数="+day);
		} catch (ParseException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return day;
	}

	public static String getDays(Timestamp birthday) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		String birth = format(birthday, "MM-dd");
		birth = calendar.get(Calendar.YEAR) + "-" + birth;
		int result = 0;
		result = (int) getDaySub(formate(new Date(), "yyyy-MM-dd"), birth);
		if (result == 0) {
			return "今天";
		} else if (result == 1) {
			return "明天";
		} else if (result == 2) {
			return "后天";
		} else if (result == 3) {
			return "大后天";
		}
		return result + "天后";
	}

	/**
	 * 计算还款日期
	 * 
	 * @param dzrq
	 *            到帐日期
	 * @param i
	 *            每一期
	 * @return
	 */
	public static Date getHkrq(Date dzrq, int i, int day) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		calendar.setTime(dzrq);
		calendar.add(Calendar.MONTH, i);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date hkrq = calendar.getTime();
		return hkrq;
	}

	/*****
	 * 将指定的日期进行相关的运算
	 * 
	 * @author JianWu Zhang <br>
	 *         2015年4月30日 下午4:36:15
	 * @param startDate
	 *            指定时间的时间戳
	 * @param year
	 *            运算的数值
	 * @param month
	 *            运算的数值
	 * @param day
	 *            运算的数值
	 * @param doType
	 *            运算法则，after 相加，before 相减
	 * @return Long 返回时间戳，便于转化为其他格式的时间类型
	 */
	public static long getDateByCalculate(long startDate, int year, int month,
			int day, String doType) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(startDate));
		switch (doType) {
		case AFTER:
			calendar.set(Calendar.DAY_OF_MONTH,
					calendar.get(Calendar.DAY_OF_MONTH) + day);
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + month);
			calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + year);// 让年
																			// 加
			break;
		case BEFORE:
			calendar.set(Calendar.DAY_OF_MONTH,
					calendar.get(Calendar.DAY_OF_MONTH) - day);
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - month);
			calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - year);
			break;
		default:
			break;
		}
		return calendar.getTimeInMillis();
	}

	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	// 获得当前月--开始日期
	public static String getMinMonthDate(String date) {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(dateFormat.parse(date));
			calendar.set(Calendar.DAY_OF_MONTH,
					calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			return dateFormat.format(calendar.getTime());
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getTimeByLongStr(String longStr) {
		String time;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date(Long.parseLong(longStr));
			time = sdf.format(date);
			return time;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return longStr;
		}

	}

	/**
	 * Thu Jul 28 00:00:00 CST 2016 日期格式化
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getTimeByStr(String dateStr) {
		SimpleDateFormat sdf1 = new SimpleDateFormat(
				"EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
		try {
			Date date = sdf1.parse(dateStr);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String sDate = sdf.format(date);
			return sDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * Thu Jul 28 00:00:00 CST 2016 日期格式化
	 * 
	 * @param dateStr
	 * @param gs
	 *            日期格式
	 * @return
	 */
	public static String getTimeByStr(String dateStr, String gs) {
		SimpleDateFormat sdf1 = new SimpleDateFormat(
				"EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
		try {
			Date date = sdf1.parse(dateStr);
			SimpleDateFormat sdf = new SimpleDateFormat(gs);
			String sDate = sdf.format(date);
			return sDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	// 获得当前月--结束日期
	public static String getMaxMonthDate(String date) {
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(dateFormat.parse(date));
			calendar.set(Calendar.DAY_OF_MONTH,
					calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			return dateFormat.format(calendar.getTime());
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 求两个日期之间相差月份
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public static int getMonthSpace(String date1, String date2)
			throws ParseException {

		int result = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(sdf.parse(date1));
		c2.setTime(sdf.parse(date2));

		result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

		return result == 0 ? 1 : Math.abs(result);

	}

	/**
	 * 求两个日期之间相差年份
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public static int getYearSpace(String date1, String date2)
			throws ParseException {

		int result = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(sdf.parse(date1));
		c2.setTime(sdf.parse(date2));

		result = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);

		return result == 0 ? 1 : Math.abs(result);

	}

	/**
	 * 获取年报半年报期初日期
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static Date stratRq(Date rq) {

		Calendar now = Calendar.getInstance();
		now.setTime(rq);

		switch (rq.getMonth()) {
		case 11:
			now.set(Calendar.YEAR, now.get(Calendar.YEAR) - 1);
			break;

		case 5:
			now.set(Calendar.MONTH, now.get(Calendar.MONTH) - 6);
			now.set(Calendar.DATE, now.get(Calendar.DATE) + 1);
			break;
		}
		return now.getTime();
	}

	/**
	 * 判断日期是否早于今天 true:早于今天 false：晚于今天
	 * 
	 * @return
	 */
	public static boolean getDateBjByNowDate(String dateStr) {
		try {
			Date nowdate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",
					Locale.CHINA);
			Date d = sdf.parse(dateStr);
			boolean flag = d.before(nowdate);
			return flag;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("日期比较出错！" + e);
		}
		return false;
	}

	/**
	 * 日期比较
	 * 
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static int compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				System.out.println("dt1 在dt2前");
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				System.out.println("dt1在dt2后");
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 日期比较
	 * 
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static int compare_date(Date dt1, Date dt2) {
		try {
			if (dt1.getTime() > dt2.getTime()) {
				System.out.println("dt1 在dt2前");
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				System.out.println("dt1在dt2后");
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			// exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 债券-距付息(单位:天)
	 * 
	 * @param dqrq
	 * @return
	 */
	public static long getJfxT(String dqrq) {
		try {
			String date = DateUtil.formate(DateUtil.parseDate(dqrq), "MM-dd");
			System.out.println(date);

			String yyyy = DateUtil.formate(new Date(), "yyyy");

			String date1 = DateUtil.formate(
					DateUtil.parseDate(yyyy + "-" + date), "yyyy-MM-dd");
			System.out.println(date1);

			String nowDate = DateUtil.formate(new Date(), "yyyy-MM-dd");

			if (DateUtil.compare_date(nowDate, date1) > 0) {
				long num = getDaySub(date1, nowDate);
				return 365 - num;
			} else {
				long num = getDaySub(nowDate, date1);
				return num;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;
		}

	}

	public static void main(String[] arg0) throws Exception {

		System.out.println(getDaySub("2017-05-10", "2017-07-06"));

		/*
		 * String date =
		 * DateUtil.formate(DateUtil.stratRq(DateUtil.parseDate("2015/6/30")),
		 * "yyyy-MM-dd"); System.out.println("+++++++++++++++++++++++" + date);
		 */
		/*
		 * SimpleDateFormat d = new SimpleDateFormat("YYYY-mm-dd "); String[] s;
		 * try { // 当月 s = DateUtil.getDyDate(0);
		 * System.out.println("当月开始时间------------" + s[0]);
		 * System.out.println("当月结束时间------------" + s[1]); // 上月 s =
		 * DateUtil.getDyDate(1); System.out.println("上月开始时间------------" +
		 * s[0]); System.out.println("上月结束时间------------" + s[1]); // 本季度 s =
		 * DateUtil.getBndDate(0); System.out.println("本季度开始时间------------" +
		 * s[0]); System.out.println("本季度结束时间------------" + s[1]); // 上季度 s =
		 * DateUtil.getBndDate(1); System.out.println("上季度 开始时间------------" +
		 * s[0]); System.out.println("上季度结束时间------------" + s[1]); } catch
		 * (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } Date now = new Date();
		 * System.out.println("日期：---------------------" + getDateBefore(30));
		 * try { String time = formate(getDateBefore(7), "yyyy-MM-dd");
		 * System.out.println("日期：---------------------" + time); } catch
		 * (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	/**
	 * 
	 * 功能: 判断是否是月末
	 * 
	 * @param 日期
	 * @return true月末,false不是月末
	 */
	public static boolean isYm(String rq) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(rq));
			if (calendar.get(Calendar.DATE) == calendar
					.getActualMaximum(Calendar.DAY_OF_MONTH))
				return true;
			else
				return false;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 判断当前日期是第几季度最后日期，不是返回当前日期
	 * 
	 * @param rq
	 * @return
	 */
	public static String getQjd(String rq) {
		try {
			// 当前日期不是月末最后，返回当前日期
			if (isYm(rq) == false) {
				return rq;
			}
			int m = Integer.parseInt(new SimpleDateFormat("MM")
					.format(new SimpleDateFormat("yyyy-MM-dd").parse(rq)));
			String nf = new SimpleDateFormat("yyyy")
					.format(new SimpleDateFormat("yyyy-MM-dd").parse(rq));
			if (m >= 1 && m <= 3)
				return nf + "第1季度";
			else if (m >= 4 && m <= 6)
				return nf + "第2季度";
			else if (m >= 7 && m <= 9)
				return nf + "第3季度";
			else if (m >= 10 && m <= 12)
				return nf + "第4季度";
			else
				return rq;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return rq;

	}

	/**
	 * 计算两个日期相隔天数--开始日期必须小于结束日期，否则返回0
	 * 
	 * @param date
	 *            开始日期
	 * @param dateNew
	 *            结束日期
	 * @return
	 *//*
	public static String getLgrqZcts(String date, String dateNew) {
		if (Def2Val.zfcFkyzBoolean(date) == false) {
			return "0";
		}
		if (Def2Val.zfcFkyzBoolean(dateNew) == false) {
			return "0";
		}
		try {
			long nowtime = new SimpleDateFormat("yyyy-MM-dd").parse(date)
					.getTime();
			long lasttime = new SimpleDateFormat("yyyy-MM-dd").parse(dateNew)
					.getTime();
			if (nowtime > lasttime) {
				return "0";
			}
			long ts1 = lasttime - nowtime;
			// System.out.println("相距毫秒数："+ts1);
			long days = ts1 / (1000 * 60 * 60 * 24);
			// System.out.println("相距的天数:"+days);
			return days + "";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "0";
	}
*/
	/**
	 * 计算两个日期相隔年限--开始日期必须小于结束日期，否则返回0
	 * 
	 * @param date
	 *            开始日期
	 * @param dateNew
	 *            结束日期
	 * @return
	 *//*
	public static String getJxsynx(String date, String dateNew) {
		BigDecimal xgts = new BigDecimal(DateUtil.getLgrqZcts(date, dateNew));
		if (xgts.compareTo(new BigDecimal("0")) == 0) {
			return "0";
		}
		return xgts.divide(new BigDecimal("365"), 3, BigDecimal.ROUND_HALF_UP)
				.toString();
	}*/
	
	/**
	 * 日期转
	 * 例：20151203转为：2015-12-03
	 * 例：201533转为：2015-03-03
	 * @param datestr
	 * @return
	 */
	public static String getDateStr(String datestr){
		String date="";
		try {
			if (StringUtils.isNotBlank(datestr)) {
				if (datestr.length()==6) {
					date=datestr.substring(0, 4)+"-"+datestr.substring(4, 5)+"-"+datestr.substring(5, 6);
				}else{
					date=datestr.substring(0, 4)+"-"+datestr.substring(4, 6)+"-"+datestr.substring(6, 8);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return date;
	}
	 /** 
     * 使用参数Format格式化Date成字符串 
     */  
    public static String getDateByformat(Date date, String pattern)  
    {  
        return date == null ? " " : new SimpleDateFormat(pattern).format(date);  
    }  
    public static Date parseDate(String str,String type) {  
        try {  
        	SimpleDateFormat sdf2M = new SimpleDateFormat(type);
            return sdf2M.parse(str);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        return null;
    }  
	/**
	 * 根据年份和月份获取当前月份开始日期
	 * @param rq yyyy-MM
	 * @return
	 * @throws Exception
	 */
    public static String getDayStartTime(String rq) throws Exception {
    	int nf=Integer.parseInt(new SimpleDateFormat("yyyy").format(new SimpleDateFormat("yyyy-MM").parse(rq)));
    	int yf=Integer.parseInt(new SimpleDateFormat("MM").format(new SimpleDateFormat("yyyy-MM").parse(rq)));
    	return getStartMonthDate(nf,yf);
    }

    /**
	 * 根据年份和月份获取当前月份结束日期
	 * @param rq yyyy-MM
	 * @return
	 * @throws Exception
	 */
    public static String getDayEndTime(String rq)throws Exception {
    	int nf=Integer.parseInt(new SimpleDateFormat("yyyy").format(new SimpleDateFormat("yyyy-MM").parse(rq)));
    	int yf=Integer.parseInt(new SimpleDateFormat("MM").format(new SimpleDateFormat("yyyy-MM").parse(rq)));
    	return getEndMonthDate(nf,yf);
    }
    /**
     * 获取某年某月的第一天日期
     * @param year
     * @param month
     * @return
     */
    public static String getStartMonthDate(int year, int month) {

           Calendar calendar = Calendar.getInstance();

           calendar.set(year, month - 1, 1);

           return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
       }

    

      /**
       * 获取某年某月的最后一天日期
       * @param year
       * @param month
       * @return
       */
      public static String getEndMonthDate(int year, int month) {

           Calendar calendar = Calendar.getInstance();

           calendar.set(year, month - 1, 1);

           int day = calendar.getActualMaximum(5);

           calendar.set(year, month - 1, day);

           return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());

       }
      /**
       * 根据年份和季度获取，当前季度开始日期和结束日期
       * @param year 数据类型年份数字
       * @param jd 数据类型季度数字
       * @return
       */
      public static String[] getGjNfJdHqJdksjsrq(String year, String jd) {
    	String[] str=new String[2];
    	switch (jd) {
		case "1":
			str[0]=year+"-01-01";
			str[1]=year+"-03-31";
			return str;
		case "2":
			str[0]=year+"-04-01";
			str[1]=year+"-06-30";
			return str;
		case "3":
			str[0]=year+"-07-01";
			str[1]=year+"-09-30";
			return str;
		case "4":
			str[0]=year+"-10-01";
			str[1]=year+"-12-31";
			return str;
		default:
			break;
		}
    	str[0]="";
		str[1]="";
		return str;
      }
      /**
       * 字符串日期格式化输出
       * @param rq 传递参数
       * @param csgs 参数格式
       * @param formatStr 需要转换的格式
       * @return
       * @throws Exception
       */
      public static String getZfcRqgsh(String rq,String csgs,String formatStr)throws Exception {
    	  Date date=new SimpleDateFormat(csgs).parse(rq);
    	  return new SimpleDateFormat(formatStr).format(date);
      }
      /**
       * 获取字符串日期前后几天日期
       * @param time 字符串日期 （yyyy-MM-dd）
       * @param hqrqbs 获取日期方式标识：+指定日期后几天日期，-指定日期前几天日期
       * @param ts 天数
       * @return
       */
      public static String getLastDay(String time,String hqrqbs,int ts){
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          Calendar calendar = Calendar.getInstance();
          Date date=null;
          try {
              date = sdf.parse(time);
          } catch (ParseException e) {
              e.printStackTrace();
          }
          calendar.setTime(date);
          int day=calendar.get(Calendar.DATE);
          //                      此处修改为+1则是获取后一天
          if(hqrqbs.equals("+")) {
        	  calendar.set(Calendar.DATE,day+1);
          }else {
        	  calendar.set(Calendar.DATE,day-1);
          }
          
   
          String lastDay = sdf.format(calendar.getTime());
          return lastDay;
      }
      
      /**
       * 获取失效日期
       * @param scrq 生产日期
       * @param dw 效期单位
       * @param xq 效期
       * @return
       * @throws Exception
       */
      public static Date getSxrq(String scrq,String dw,int xq)throws Exception {
      	Date date=null;
      	switch (dw) {
  		case "001"://年
  			date=addYear(parseDate(scrq), xq);
  			break;
  		case "002"://月
  			date=addMonth(parseDate(scrq), xq);
  			break;
  		case "003"://日
  			date=addDate(parseDate(scrq), xq);
  			break;
  		default:
  			break;
  		}
      	return date;
      }
      /** 
       * 在日期上增加月分
       */  
      public static Date addMonth(Date date, int n)  
      {  
          Calendar cal = Calendar.getInstance();  
          cal.setTime(date);  
          cal.add(Calendar.MONTH, n);  
          return cal.getTime();  
      }  
      
      /** 
       * 在日期上增加年份
       */  
      public static Date addYear(Date date, int n)  
      {  
          Calendar cal = Calendar.getInstance();  
          cal.setTime(date);  
          cal.add(Calendar.YEAR, n);  
          return cal.getTime();  
      }  
      
      /** 
       * 在日期上增加天数
       */  
      public static Date addDate(Date date, int n)  
      {  
          Calendar cal = Calendar.getInstance();  
          cal.setTime(date);  
          cal.add(Calendar.DATE, n);  
          return cal.getTime();  
      } 
      
      
      /**
       * 获取生产日期
       * @param sxrq 失效日期
       * @param dw 效期单位
       * @param xq 效期
       * @return
       * @throws Exception
       */
      public static Date getScrq(String sxrq,String dw,int xq)throws Exception {
      	Date date=null;
      	switch (dw) {
  		case "001"://年
  			date=addYear(parseDate(sxrq), xq);
  			break;
  		case "002"://月
  			date=addMonth(parseDate(sxrq), xq);
  			break;
  		case "003"://日
  			date=addDate(parseDate(sxrq), xq);
  			break;
  		default:
  			break;
  		}
      	return date;
      }
      /**
       * 获取指定日期指定范围前后日期
       * @param rq 指定日期（yyyy-MM-dd）
       * @param fwlx	范围类型：Calendar.YEAR 年，Calendar.MONTH 月，Calendar.DATE 天
       * @param ts	间隔范围值
       * @return
       * @throws Exception
       */
      public static String getHqZdRqQhrq(String rq,int fwlx,int ts)throws Exception {
    	  if(Def2Val.strNotNUllBoolean(rq)==false) {
    		  return "";
    	  }
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
			Calendar calendar = Calendar.getInstance(); 
			calendar.setTime(format.parse(rq)); 
			calendar.add(fwlx, ts);    //得到前一年 
			return format.format(calendar.getTime());
      }
      /**
       * 根据指定日期计算年龄
       * @param rq
       * @return
       * @throws Exception
       */
      public static int getAgeByBirth(String rq) throws Exception {
          int age = 0;
          if(Def2Val.strNotNUllBoolean(rq)==false) {
          	return age;
          }
          rq=rq.replace("/", "-");
          Date birthDay=new SimpleDateFormat("yyyy-MM-dd").parse(rq);
          Calendar cal = Calendar.getInstance();
          if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
              throw new IllegalArgumentException(
                      "The birthDay is before Now.It's unbelievable!");
          }
          int yearNow = cal.get(Calendar.YEAR);  //当前年份
          int monthNow = cal.get(Calendar.MONTH);  //当前月份
          int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
          cal.setTime(birthDay);
          int yearBirth = cal.get(Calendar.YEAR);
          int monthBirth = cal.get(Calendar.MONTH);
          int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
          age = yearNow - yearBirth;   //计算整岁数
          if (monthNow <= monthBirth) {
              if (monthNow == monthBirth) {
                  if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
              } else {
                  age--;//当前月份在生日之前，年龄减一
              }
          }
          return age;
      }
}
