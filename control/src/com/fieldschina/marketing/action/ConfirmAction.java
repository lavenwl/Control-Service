package com.fieldschina.marketing.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.fieldschina.marketing.service.ThreadService;
import com.opensymphony.xwork2.ActionContext;
/**
 * 主界面下拉列表框内选择操作提交使用的操作判断类
 * 
 * @author  LAVEN  E-mail:lavenwl@gmail.com
 * @company FieldsChina.IT.BI
 * @version 创建时间：2014-9-26 上午9:24:04
 */
public class ConfirmAction {
	//操作的名称（1：当月内注册时间大于14天的用户；2：当月内注册时间大于7天小于14天的用户；3：一年内下2单且近10天未下单的用户；4：一年内下单数量大于等于4单的用户；5：自定义；6：设置；）
	private String actionName;
	public String execute(){
			if(actionName != null){
				return actionName;
			}else{
				return "error";
			}
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	
}
