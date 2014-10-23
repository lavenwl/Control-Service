<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
	<style>
		#d{height:80px;}	
		#d2{height:30px;}
		#fields{height:110px;}	
		#set{width:700px;
				border: 2px solid #808080;
				height:200px;
				display: inline-block;
				font-size:30px;
				color:grey;
				border-radius: 18px;
				vertical-align: middle;
				//background-color: rgba(255, 255, 255, 0.73);
		}
		body{text-align:center;
				background: url("../img/bgs.png") repeat;
		}
		
		#form{text-align:center;}
		h1{color:green;
			font-size:60px;
		}
		#in{height:100%;
			vertical-align:middle;
		}
		#ti{font-size:30px;}
	</style>	
</head>
<script type="text/javascript">
function getfocus(id){
	var textSearch = document.getElementById(id);
	if(textSearch.value=='请输入邮箱或者是手机号码'){
		textSearch.value = "";
		textSearch.style.color = 'black';
	}
}
function check_value(id){
	var textSearch2 = document.getElementById(id);
		if(textSearch2.value.trim()==""){
			textSearch2.value = "请输入邮箱或者是手机号码";
			textSearch2.style.color='gray';
		}else{
			
		}
	
	
}
function cheack_input(){
	var email_reg =/[^\u4e00-\u9fa5]/;
	var telephone_reg = /^[0-9]*$/;
	var input_value = document.getElementById("search_name");
	if(input_value.value!=null&&input_value.value.trim()!=""&&input_value.value.trim()!="请输入邮箱或者是手机号码"){
		if(email_reg.test(input_value.value)||telephone_reg.test(input_value.value)){
			return true;
		}else{
			document.getElementById("error").innerHTML="请正确输入！";
			return false;
		}
	}else{
		document.getElementById("error").innerHTML="不能为空";
		return false;
	}
}
</script>

<body>
	<div id=d2> </div>
	<div id=fields><img src="../img/fieldslogo.jpg"/></div>
	<form id=form action="Http://192.168.100.123:8080/fieldschina/show_blur_customer_servlet?version=ch&name=${name}" method="post" onsubmit="return cheack_input()">
  		<fieldset id=set>
    		<legend id=ti><strong>Customer Profile</strong></legend>
      			<p align="center">
      				<div style="height: 20px;width: auto;margin:0px auto;color: red;text-align: center;font-size: 12px;" id = "error" >${error}</div>
      				<table  id = "search_table" style="width:100%;"> 
						<tr>
							<td align="center">
								<input type = "text" name = "search_name" id = "search_name" value ="请输入邮箱或者是手机号码" style="width: 410px;height: 24px;color: gray;margin-left: -5px;" onfocus="getfocus(this.id)" onblur="check_value(this.id)">
							</td>
						</tr>	
						<tr></tr>
						<tr>
							<td align="center"> 
								<input type = "submit" value = "查询" style="width: 110px;height: 25px;" onclick="cheack_input()">
							</td>
						</tr>
					</table>
      			</p>
  		</fieldset>
	</form>
	<div id=d> </div>
	<form action="confirm.action" method="post">
  		<fieldset id=set>
    		<legend><strong>Multi-Level Marketing</strong></legend>
    			<p align="center">
    				<table  id = "search_table" style="width:100%;"> 
						<tr>
							<td>
								<select style="width: 410px;height: 26px;color: gray;margin-left: -5px;" name="actionName">
									<option disabled="disabled" selected="selected">-----请选择-----</option>
    								<option value="1">当月内注册时间大于14天的用户</option>
    								<option value="2">当月内注册时间大于7天小于14天的用户</option>
    								<option value="3">一年内下2单且近10天未下单的用户</option>
    								<option value="4">一年内下单数量大于等于4单的用户</option>
    								<option value="5">自定义</option>
									<option value="6">设置</option></option>
								</select>
							</td>
						</tr>	
						<tr></tr>
						<tr>
							<td align="center"> 
								<!--<input type = "submit" value = "浏览" style="width: 110px;height: 25px;" onclick="return cheack_input()">-->
						 		<input type = "submit" value = "确定" style="width: 110px;height: 25px;" >
							</td>
						</tr>
					</table>
    			</p>
  		</fieldset>
	</form>
	<div style="margin-top:30px;font-size: 13px;"><a href="/control/marketing_files/welcome.action?version=1">中文版</a><div style="width:30px;display:inline-block;"></div><a href="/control/marketing_files/welcome.action?version=2">ENGLISH</a></div>
</body>
</html>