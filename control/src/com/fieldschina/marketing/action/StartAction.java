package com.fieldschina.marketing.action;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import com.fieldschina.marketing.service.ThreadService;
import com.fieldschina.marketing.util.Util;
import com.opensymphony.xwork2.ActionContext;
/**
 * 启动线程的方法
 * 
 * @author  LAVEN  E-mail:lavenwl@gmail.com
 * @company FieldsChina.IT.BI
 * @version 创建时间：2014-9-26 下午1:59:55
 */
public class StartAction {
	private String start;	//新的启动线程的开始时间
	private int hour;		//新的启动线程的间隔时间
	private String email;	//新成启动线程的邮件发送地址
	private boolean b = true ;	//线程启动状态
	/**
	 * 启动新的线程，如果已经存在此线程，则停止并删除此线程，再创建新的线程
	 * 
	 * @return
	 * @throws ParseException
	 */
	public String execute() throws ParseException{
		try{
			ActionContext context = ActionContext.getContext();   
		    Map application = context.getApplication();  
		    ThreadService threadService = (ThreadService) application.get("ThreadService");
		    threadService.cancel();
		    application.remove("ThreadService");
		    threadService = new ThreadService();
		    application.put("ThreadService", threadService);
		    threadService.setEmails(getEmail());
		    threadService.Timer(Util.paraseStringToTime(getStart()), getHour()*60*60*1000);
		    b = threadService.getBB();
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}
	
	public boolean isB() {
		return b;
	}
	public void setB(boolean b) {
		this.b = b;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
