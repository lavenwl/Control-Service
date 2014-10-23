<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
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
	if(textSearch.value=='Please enter the E-mail or Phone number'){
		textSearch.value = "";
		textSearch.style.color = 'black';
	}
}
function check_value(id){
	var textSearch2 = document.getElementById(id);
		if(textSearch2.value.trim()==""){
			textSearch2.value = "Please enter the E-mail or Phone number";
			textSearch2.style.color='gray';
		}else{
			
		}
	
	
}
function cheack_input(){
	var email_reg =/[^\u4e00-\u9fa5]/;
	var telephone_reg = /^[0-9]*$/;
	var input_value = document.getElementById("search_name");
	if(input_value.value!=null&&input_value.value!=""&&input_value.value!="Please enter the E-mail or Phone number"){
		if(email_reg.test(input_value.value)||telephone_reg.test(input_value.value)){
			return true;
		}else{
			document.getElementById("error").innerHTML="Input the wrong data format？";
			return false;
		}
	}else{
		document.getElementById("error").innerHTML="Can not empty";
		return false;
	}
}
</script>

<body>
	<div id=d2> </div>
	<div id=fields><img src="../img/fieldslogo.jpg"/></div>
	<form id=form action="Http://192.168.100.123:8080/fieldschina/show_blur_customer_servlet?version=en&name=${name }" method="post">
  		<fieldset id=set>
    		<legend id=ti><strong>Customer Profile</strong></legend>
      			<p align="center">
      				<div style="height: 20px;width: auto;margin:0px auto;color: red;text-align: center;font-size: 12px;" id = "error" >${error}</div>
      				<table  id = "search_table" style="width:100%;"> 
						<tr>
							<td align="center">
								<input type = "text" name = "search_name" id = "search_name" value = "Please enter the E-mail or Phone number" style="width: 410px;height: 24px;color: gray;margin-left: -5px;" onfocus="getfocus(this.id)" onblur="check_value(this.id)">
							</td>
						</tr>	
						<tr></tr>
						<tr>
							<td align="center"> 
								<input type = "submit" value = "Search" style="width: 110px;height: 25px;" onclick="return cheack_input()">
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
									<option disabled="disabled" selected="selected">-----select-----</option>
    								<option value="1">Registration time larger than 14 days in month</option>
    								<option value="2">Registration time more than 7 days less than 14 days in month</option>
    								<option value="3">A year with two orders and nearly 10 days did not have orders</option>
    								<option value="4">A year with more than four orders</option>
    								<option value="5">User defined</option>
									<option value="6">Set Thread</option></option>
								</select>
							</td>
						</tr>	
						<tr></tr>
						<tr>
							<td align="center"> 
								<!--<input type = "submit" value = "浏览" style="width: 110px;height: 25px;" onclick="return cheack_input()">-->
						 		<input type = "submit" value = "OK" style="width: 110px;height: 25px;">
							</td>
						</tr>
					</table>
    			</p>
  		</fieldset>
	</form>
	<div style="margin-top:30px;font-size: 13px;"><a href="/control/marketing_files/welcome.action?version=1">中文版</a><div style="width:30px;display:inline-block;"></div><a href="/control/marketing_files/welcome.action?version=2">ENGLISH</a></div>
</body>
</html>