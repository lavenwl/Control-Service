package com.fieldschina.marketing.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	 /**
	  * 得到下载文件的名字
	  * @return
	  */
	 public String getDownloadFileName() {
	    String fileName=ServletActionContext.getRequest().getParameter("fileName");
	    String downloadFileName = fileName;
	    try {
	     downloadFileName = new String(downloadFileName.getBytes(), "ISO8859-1");
	    } catch (Exception e) {
	     e.printStackTrace();
	    }
	    return downloadFileName;
	 }

	 /**
	  * 读取文件并发送文件执行下载操作
	  * @return
	  */
	 public InputStream getInputStream() {
	    String name=this.getDownloadFileName();
	    String path = "/FieldsCSVFiles/";
	    String realPath=path + name;
	    InputStream in=ServletActionContext.getServletContext().getResourceAsStream(realPath);
	    if(null==in){
	     System.out.println("Can not find a java.io.InputStream with the name [inputStream] in the invocation stack. Check the <param name=\"inputName\"> tag specified for this action");  
	    }
	    return ServletActionContext.getServletContext().getResourceAsStream(realPath);
	 }
	 public String execute(){
		 return "success";
	 }
}
