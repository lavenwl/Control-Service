package com.fieldschina.marketing.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.fieldschina.marketing.service.ThreadService;
import com.opensymphony.xwork2.ActionContext;
/**
 * 登陆跳转使用，现在的登陆判断内置页面内部，后面要在这里添加
 * 
 * @author  LAVEN  E-mail:lavenwl@gmail.com
 * @company FieldsChina.IT.BI
 * @version 创建时间：2014-9-26 上午10:50:15
 */
public class LoginAction {
	private String name;
	private boolean b = false;
	public String execute(){
		try{
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
