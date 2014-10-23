package com.fieldschina.marketing.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import com.fieldschina.marketing.config.Config;
/**
 * Util工具类
 * 
 * @author  LAVEN  E-mail:lavenwl@gmail.com
 * @company FieldsChina.IT.BI
 * @version 创建时间：2014-9-26 下午3:39:06
 */
public class Util {
	private static Logger log = Logger.getLogger(Util.class);
	//记录执行时间的快捷记录开始时间
	private static Map<String, Long> begin = new HashMap<String, Long>();
	/**
	 * 测试主方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		getBegainTimeFromFolder();
		System.out.println(getSomeDaysAgo(6));
//		getFilesList();
//		System.out.println(getDay());
//		System.out.println(getYesterday());
//		System.out.println(getTime());
//		String test = "teststring";
//		System.out.println(test.substring(0, 4));
	}
	/**
	 * 得到当前时间固定格式（"yyyy-MM-dd HH:mm:ss"）的字符串
	 * 
	 * @return
	 */
	public static String getTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	/**
	 * 得到当前日期固定格式（"yyyy-MM-dd"）的字符串
	 * 
	 * @return
	 */
	public static String getDay(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	/**
	 * 得到当前时间固定格式（"yyyy-MM-dd HH:mm:ss"）的字符串
	 * 
	 * @return
	 */
	public static String getDayTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	/**
	 * 得到昨日日期固定格式（"yyyy-MM-dd"）的字符串
	 * 
	 * @return
	 */
	public static String getYesterday(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date(new Date().getTime()-24*60*60*1000));
	}
	/**
	 * 得到当前月份的一号的时间
	 * 
	 * @return
	 */
	public static String getMonth(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-01");
		return sdf.format(new Date());
	}
	/**
	 * 得到上一个月份的一号的时间
	 * 
	 * @return
	 */
	public static String getLastMonth(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-01");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		return sdf.format(c.getTime());
	}
	/**
	 * 得到上一个月份的一号的时间
	 * 
	 * @return
	 */
	public static String getLastMonth(String begainTime){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-01");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf2.parse(begainTime));
		} catch (ParseException e) {
			log.error(Util.getTrace(e));
		}
		c.add(Calendar.MONTH, -1);
		return sdf.format(c.getTime());
	}
	/**
	 * 得到上一个月份的一号的时间
	 * 
	 * @return
	 */
	public static String getNextMonth(String begainTime){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-01");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf2.parse(begainTime));
		} catch (ParseException e) {
			log.error(Util.getTrace(e));
		}
		c.add(Calendar.MONTH, 1);
		return sdf.format(c.getTime());
	}
	/**
	 * 比较两个字符串时间的大小
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static int compareDateString(String time1, String time2){
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar t1 = Calendar.getInstance();
		Calendar t2 = Calendar.getInstance();
		try {
			t1.setTime(sdf2.parse(time1));
			t2.setTime(sdf2.parse(time2));
		} catch (ParseException e) {
			log.error(Util.getTrace(e));
		}
		int t = t1.compareTo(t2);
		return t;
	}
	/**
	 * 得到七天前的字符串形式的时间
	 * 
	 * @return
	 */
	public static String get7DaysAgo(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -7);
		return sdf.format(c.getTime());
	}
	/**
	 * 获取14天前的时间
	 * 
	 * @return
	 */
	public static String get14DaysAgo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -14);
		return sdf.format(c.getTime());
	}
	/**
	 * 获取配置文件属性
	 * 
	 * @param property
	 * @return
	 */
	public static String getProperty(String property){
		return Config.getInstance().getProperty(property);
	}
	/**
	 * 获取配置文件的时间属性
	 * 
	 * @param property
	 * @return
	 */
	public static long getTimeProperty(String property){
		return Long.valueOf(Config.getInstance().getProperty(property))*60*1000;
		
	}
	/**
	 * 将字符串格式的时间转化成date类型的数据
	 * 
	 * @param s
	 * @return
	 * @throws ParseException
	 */
	public static Date paraseStringToTime(String s) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		System.out.println("时间格式："  + s);
		date = sdf.parse(s);
		java.sql.Date sdate = new java.sql.Date(date.getTime());
		return sdate;
	}
	/**
	 * 获取配置文件中的csv文件相关的参数
	 * 
	 * @return
	 */
	public static Map<String, String> getCSVFileProperty() {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<?> propNames = Config.getInstance().propertyNames();
		while (propNames.hasMoreElements()) {
			String name = (String) propNames.nextElement();
			if (name.startsWith("csv.")) {
				map.put(getProperty(name), getProperty(name));
			} // end if (name.endsWith(".url"))
		} // end while (propNames.hasMoreElements())
		return map;
	}
	/**
	 * 将exception转化成流的形式写入到文件中
	 * 
	 * @param t
	 * @return
	 */
	public static String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }
	/**
	 * 得到固定几天前的字符串格式的时间
	 * 
	 * @param day1
	 * @return
	 */
	public static String getSomeDaysAgo(int day1) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -day1);
		return sdf.format(c.getTime());
	}

}
