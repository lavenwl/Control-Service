package com.fieldschina.marketing.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.fieldschina.marketing.email.Email;
import com.fieldschina.marketing.email.SendMail;
import com.fieldschina.marketing.email.Server;
import com.fieldschina.marketing.entity.User;
import com.fieldschina.marketing.util.Util;
/**
 * 线程控制类
 * 
 * @author  LAVEN  E-mail:lavenwl@gmail.com
 * @company FieldsChina.IT.BI
 * @version 创建时间：2014-9-26 下午5:26:22
 */
public class ThreadService {
	private String emails = "543410506@qq.com";
    Logger log = Logger.getLogger(ThreadService.class);
	private Timer t = null;
	private boolean bb = false;
	public void setEmails(String emails){
		this.emails = emails;
	}
	public boolean changeBB(boolean b){
		bb = b;
		return bb;
	}
	public boolean getBB(){
		return bb;
	}
	private Timer getTimer(){
		if(t == null){
			t = new Timer();
		}
		return t;
	}
	public boolean cancel(){
		getTimer().cancel();
		this.t = null;
		return true;
	}
	public void Timer(Date date, long time){
			bb = true;
			Timer t = getTimer();
			TimerTask task = new TimerTask() {
				public void run() {
					boolean in = false;
					while(bb){
						System.out.println("CheckReportHandler Timer Task start��");
						MarketingFile();
						System.out.println("CheckReportHandler Timer task end��");
						in = true;
						if(bb)
							bb = !bb;
					}
					if(in)
						bb = !bb;
				}
			};
			t.scheduleAtFixedRate(task, date, time);
	}
	public void MarketingFile(){
		Map<String, String> fileNameMap = new HashMap<String, String>();
		//当月注册时间大于14天
		TimerCurrentMonthRegistrationM14Days(fileNameMap);
		//当月注册时间大于7天小于14天
		TimerCurrentMonthRegistrationM7L14Days(fileNameMap);
		//拥有2单且10天内未下单
		TimerHave2OrdersNoOrder10Days(fileNameMap);
		//拥有4单的用户数据
		TimerHave4Orders(fileNameMap);
		//发送文件到收件人
		sendCSVFile(fileNameMap);
	}
	/**
	 * 生成当前月注册时间大于14天的用户的数据的文件
	 * 
	 * @param fileNameMap
	 * @return
	 */
	public String TimerCurrentMonthRegistrationM14Days(Map<String, String> fileNameMap){
		List<User> list = null;
		list = new ArrayList<User>();
		UserService userService = new UserService();
		list = userService.getRegD14Days();
		CSVService cs = new CSVService();
		List exportData = new ArrayList<Map>();
		for(int i = 0; i < list.size(); i++){
			Map row1 = new LinkedHashMap<String, String>();
	        row1.put("1", list.get(i).getId());
	        row1.put("2", list.get(i).getEmail());
	        row1.put("3", list.get(i).getFirstName());
	        row1.put("4", list.get(i).getLastName());
	        row1.put("5", list.get(i).getTelephone());
	        row1.put("6", list.get(i).getPhone());
	        row1.put("7", list.get(i).getDateAdded());
	        exportData.add(row1);
		}
        LinkedHashMap map = new LinkedHashMap();
        map.put("1", "id");
        map.put("2", "email");
        map.put("3", "firstname");
        map.put("4", "lastname");
        map.put("5", "telephone");
        map.put("6", "phone");
        map.put("7", "date_added");
        String path = System.getProperty("user.dir") + "/FieldsCSVFiles";
        path = path.replace("bin", "webapps/control");
        System.out.println("path:" + path);
        String name = "TimerCurrentMonthRegistrationM14Days";
        name += Util.getDay() + ".csv";
        fileNameMap.put("TimerCurrentMonthRegistrationM14Days", name);
        System.out.println("filename:" + name);
		cs.createCSVFile(exportData, map, path, name);
		return "success";
	}
	/**
	 * 生成当前月注册时间大于7天小于14天的用户数据的文件
	 * 
	 * @param fileNameMap
	 * @return
	 */
	public String TimerCurrentMonthRegistrationM7L14Days(Map<String, String> fileNameMap){
		List<User> list = null;
		list = new ArrayList<User>();
		UserService userService = new UserService();
		list = userService.getRegD7L14Days();
		CSVService cs = new CSVService();
		List exportData = new ArrayList<Map>();
		for(int i = 0; i < list.size(); i++){
			Map row1 = new LinkedHashMap<String, String>();
	        row1.put("1", list.get(i).getId());
	        row1.put("2", list.get(i).getEmail());
	        row1.put("3", list.get(i).getFirstName());
	        row1.put("4", list.get(i).getLastName());
	        row1.put("5", list.get(i).getTelephone());
	        row1.put("6", list.get(i).getPhone());
	        row1.put("7", list.get(i).getDateAdded());
	        exportData.add(row1);
		}
        LinkedHashMap map = new LinkedHashMap();
        map.put("1", "id");
        map.put("2", "email");
        map.put("3", "firstname");
        map.put("4", "lastname");
        map.put("5", "telephone");
        map.put("6", "phone");
        map.put("7", "date_added");
        String path = System.getProperty("user.dir") + "/FieldsCSVFiles";
        path = path.replace("bin", "webapps/control");
        System.out.println("path:" + path);
        String name = "TimerCurrentMonthRegistrationM7L14Days";
        name += Util.getDay() + ".csv";
        fileNameMap.put("TimerCurrentMonthRegistrationM7L14Days", name);
		cs.createCSVFile(exportData, map, path, name);
		return "success";
	}
	/**
	 * 生成拥有2单且十天内未下单的用户的数据的文件
	 * 
	 * @param fileNameMap
	 * @return
	 */
	public String TimerHave2OrdersNoOrder10Days(Map<String, String> fileNameMap){
		List<User> list = null;
		list = new ArrayList<User>();
		UserService userService = new UserService();
		list = userService.getOrder2No10Days();
		CSVService cs = new CSVService();
		List exportData = new ArrayList<Map>();
		for(int i = 0; i < list.size(); i++){
			Map row1 = new LinkedHashMap<String, String>();
	        row1.put("1", list.get(i).getId());
	        row1.put("2", list.get(i).getEmail());
	        row1.put("3", list.get(i).getFirstName());
	        row1.put("4", list.get(i).getLastName());
	        row1.put("5", list.get(i).getTelephone());
	        row1.put("6", list.get(i).getPhone());
	        row1.put("7", list.get(i).getDateAdded());
	        exportData.add(row1);
		}
        LinkedHashMap map = new LinkedHashMap();
        map.put("1", "id");
        map.put("2", "email");
        map.put("3", "firstname");
        map.put("4", "lastname");
        map.put("5", "telephone");
        map.put("6", "phone");
        map.put("7", "date_added");
        String path = System.getProperty("user.dir") + "/FieldsCSVFiles";
        path = path.replace("bin", "webapps/control");
        String name = "TimerHave2OrdersNoOrder10Days";
        name += Util.getDay() + ".csv";
        fileNameMap.put("TimerHave2OrdersNoOrder10Days", name);
		cs.createCSVFile(exportData, map, path, name);
		return "success";
	}
	/**
	 * 生成存在4单的用户的数据的文件
	 * 
	 * @param fileNameMap
	 * @return
	 */
	public String TimerHave4Orders(Map<String, String> fileNameMap){
		List<User> list = null;						//存放数据集合
		list = new ArrayList<User>();
		UserService userService = new UserService();
		list = userService.get4Orders();
		CSVService cs = new CSVService();
		List exportData = new ArrayList<Map>();
		for(int i = 0; i < list.size(); i++){
			Map row1 = new LinkedHashMap<String, String>();
	        row1.put("1", list.get(i).getId());
	        row1.put("2", list.get(i).getEmail());
	        row1.put("3", list.get(i).getFirstName());
	        row1.put("4", list.get(i).getLastName());
	        row1.put("5", list.get(i).getTelephone());
	        row1.put("6", list.get(i).getPhone());
	        row1.put("7", list.get(i).getDateAdded());
	        exportData.add(row1);
		}
        LinkedHashMap map = new LinkedHashMap();
        map.put("1", "id");
        map.put("2", "email");
        map.put("3", "firstname");
        map.put("4", "lastname");
        map.put("5", "telephone");
        map.put("6", "phone");
        map.put("7", "date_added");
        String path = System.getProperty("user.dir") + "/FieldsCSVFiles";
        path = path.replace("bin", "webapps/control");
        System.out.println("path:" + path);
        String name = "TimerHave4Orders";
        name += Util.getDay() + ".csv";
        fileNameMap.put("TimerHave4Orders", name);
		cs.createCSVFile(exportData, map, path, name);
		return "success";
	}
	/**
	 * 发送csv文件到收件人
	 * 
	 * @param map
	 */
	public void sendCSVFile(Map<String, String> map){
		String receiver = emails;
		List listFile = new ArrayList();  
		String path = System.getProperty("user.dir") + "/FieldsCSVFiles";
        path = path.replace("bin", "webapps/control");
	    log.debug("path:" + path + "\n map:" + map);
	    Iterator it = map.keySet().iterator();
	    while(it.hasNext()){
	    	String name = (String) it.next();
	    	if(!name.equals(map.get(name)))
	    		listFile.add(new File(path + "/" + map.get(name)));
	    }
	    Server server=new Server("smtp.qq.com","25",Util.getProperty("senderemailaddress"),Util.getProperty("senderemailpassword")); 
	    Email email=new Email("Hello!Bye!","CSV file for WebPower",Util.getProperty("senderemailaddress"),receiver);  
	    email.setAttenchment(listFile);
	    SendMail sendemail=new SendMail();  
	    String result = sendemail.send(server,email);
	    map = Util.getCSVFileProperty();
	    log.info("发送成功");
	}
}
