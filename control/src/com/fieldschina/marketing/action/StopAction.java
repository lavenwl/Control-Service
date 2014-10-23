package com.fieldschina.marketing.action;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import com.fieldschina.marketing.service.ThreadService;
import com.fieldschina.marketing.util.Util;
import com.opensymphony.xwork2.ActionContext;
/**
 * 停止线程
 * 
 * @author  LAVEN  E-mail:lavenwl@gmail.com
 * @company FieldsChina.IT.BI
 * @version 创建时间：2014-9-26 下午2:04:51
 */
public class StopAction {
	private boolean b = false;
	public String execute() throws ParseException{
		try{
			ActionContext context = ActionContext.getContext();   
		    Map application = context.getApplication();  
		    ThreadService threadService = (ThreadService) application.get("ThreadService");
		    if(threadService == null){
		    	threadService = new ThreadService();
			    application.put("ThreadService", threadService);
		    }else{
		    	threadService.changeBB(false);
		    }
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

}
