package com.fieldschina.marketing.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fieldschina.marketing.entity.User;
import com.fieldschina.marketing.service.CSVService;
import com.fieldschina.marketing.service.UserService;
import com.fieldschina.marketing.util.Util;
/**
 * 根据订单数量用户自定义设置
 * 
 * @author  LAVEN  E-mail:lavenwl@gmail.com
 * @company FieldsChina.IT.BI
 * @version 创建时间：2014-9-26 上午10:52:33
 */
public class OrderBiggerUserDefinedAction {
	private List<User> list;	//需要返回的结果集
	private String fileName;	//下载文件的名称
	private int page = 1;		//翻页查询的页数
	private String actionName;	//请求名
	private int day1;			//参数1
	private int day2;			//参数2
	private String isNull;		//是否过滤用户电话为空的用户
	private int num = 0;		//此次查询一共获得多少数据
	private int pageNum = 0;	//此次查询一共获得多少页数据
/**
 * 处理分页查询的方法
 * 
 * @return
 */
	public String execute(){
		try{
			actionName = "oudd";
			list = new ArrayList<User>();
			UserService userService = new UserService();
			num = userService.getOrderBiggerUserDefinedNum(day1);
			if(num != 0){
				int i = num % 15;
				if(i == 0){
					pageNum = num / 15;
				}else{
					pageNum = (num / 15) + 1;
				}
			}
			list = userService.getOrderBiggerUserDefined(day1, page, 15);
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}
/**
 * 执行下载操作的方法
 * 
 * @return
 */
	public String download(){
		try{
			list = new ArrayList<User>();
			UserService userService = new UserService();
			list = userService.getOrderBiggerUserDefined(day1);
			CSVService cs = new CSVService();
			List exportData = new ArrayList<Map>();
			if(isNull != null && isNull.equals("filter")){
				for(int i = 0; i < list.size(); i++){
					if(list.get(i).getPhone().length() > 5){
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
				}
			}else{
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
	        String name = "orderBiggerUserDefined";
	        name += Util.getDay() + ".csv";
	        fileName = name;
			cs.createCSVFile(exportData, map, path, name);
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}
	
	public String getIsNull() {
		return isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public int getDay1() {
		return day1;
	}

	public void setDay1(int day1) {
		this.day1 = day1;
	}

	public int getDay2() {
		return day2;
	}

	public void setDay2(int day2) {
		this.day2 = day2;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
}
