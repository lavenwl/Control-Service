package com.fieldschina.marketing.action;

import java.util.Date;
import java.util.Map;

import com.fieldschina.marketing.service.ThreadService;
import com.opensymphony.xwork2.ActionContext;
/**
 * 跳转至线程控制页面
 * 
 * @author  LAVEN  E-mail:lavenwl@gmail.com
 * @company FieldsChina.IT.BI
 * @version 创建时间：2014-9-26 下午2:08:46
 */
public class ThreadControlAction {
	private boolean b;
	public String execute(){
		try{
			b = false;
			ActionContext context = ActionContext.getContext();   
		    Map application = context.getApplication();  
		    ThreadService threadService = (ThreadService) application.get("ThreadService");
		    if(threadService == null){
		    	b = false;
		    	return "success";
		    }
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
}
