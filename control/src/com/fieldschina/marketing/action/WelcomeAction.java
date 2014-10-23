package com.fieldschina.marketing.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.fieldschina.marketing.service.ThreadService;
import com.opensymphony.xwork2.ActionContext;
/**
 * 跳转至登陆页面的方法，同时自动启动系统默认线程，参数默认
 * 
 * @author  LAVEN  E-mail:lavenwl@gmail.com
 * @company FieldsChina.IT.BI
 * @version 创建时间：2014-9-26 下午2:17:29
 */
public class WelcomeAction {
	private String name;
	private String version;
	private boolean b = false;
	public String execute(){
		try{
			ActionContext context = ActionContext.getContext();   
		    Map application = context.getApplication();  
		    ThreadService threadService = (ThreadService) application.get("ThreadService");
		    if(threadService == null){
		        threadService = new ThreadService();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd " + "15:47:00");
				Date startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdf.format(new Date()));
				if (System.currentTimeMillis() > startTime.getTime()) {
					startTime = new Date(startTime.getTime() + 60*60*1000L);
				}
		       	threadService.Timer(startTime, 60*60*1000L);
		        application.put("ThreadService", threadService);
		    }
		    b = threadService.getBB();
		    if(version ==null){
		    	return "success1";
		    }else{
		    	if(version.equals("1")){
			    	return "success1";
			    }else if(version.equals("2")){
			    	return "success2";
			    }else{
			    	return "error";
			    }
		    }
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
}
