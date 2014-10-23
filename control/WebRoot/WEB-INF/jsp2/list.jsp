<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>顾客列表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
	<style type="text/css">
			#d2{height:30px;}
			#fields{height:110px;
					text-align: center;
			}
			#fields2{
					margin-left: 11%;
					text-align: left;
			}	
			#outleft{
				text-align:center;
			}
			body{
				font-family:"宋体";
			}
			h3{
				color:grey;
				font-family: 微软雅黑;
				font-size:15px;
			}
			a{
				color: black;
			}
			body{
				font-family: SimSun;   
			}
			td{
				padding-top:2px;
				border: 5px 10px;
				padding-right:30px;
			}
			.list_div{
				//float:left;
				width:468px;height:260px;border:#909090 1px solid;
				background:#fff;color:#333;
				filter:progid:DXImageTransform.Microsoft.Shadow(color=#909090,direction=120,strength=4); 
				moz-box-shadow: 2px 2px 10px #909090;
				webkit-box-shadow: 2px 2px 10px #909090;
				box-shadow:2px 2px 10px #909090;/*opera或ie9*/
				margin-left:20px;
				margin-top: 20px;
				text-align: left;
				background: url("../img/touxiang22.png") right 0 no-repeat;
				display:inline-block;
				
			}
			body {
				background-attachment:fixed;
				background-image: url("../img/bgs.png");
				text-algin:center;
			}
			.edit a{
				text-decoration: none;
			}
			a{
				text-decoration: none;
			}
			.form-size{ display:inline-block;}
	</style>
	<script type="text/javascript">
		function download(){
			$('#filter').show();
		}
	</script>
</head>
<body>	
	<div id=d2> </div>
	<div id=fields>
		<a href="/control/marketing_files/welcome.action"><img src="../img/fieldslogo.jpg"/></a>
		
		<div id=fields2>
		<table>
		<tr><td width="220px"><h3>本次搜索结果数据量：${num}条</h3></td><td><!-- <a href="/control/marketing_files/d${actionName}.action?page=${page+1}&day1=${day1}&day2=${day2}"><input type="button" class="button" value="下载数据 " /></a> -->
		<input type="button" class="button" value="下载数据 " onclick="download()"/><div id=filter style="display: none; float: right;"><form action="/control/marketing_files/d${actionName}.action?" style="display: inline-block; font-size: 13px; color: grey;" ><input name="isNull" value="filter" type="checkbox">过滤电话为空的用户&nbsp;&nbsp;<input type="submit" value="确定"></form></div></td></tr>
		</table>
		
	</div>
	</div>
	<div id="outleft">
		<div id= "left" style="margin-left:10%;margin-right:10%;text-align: center;overflow:auto;zoom:1;">
		
		<s:iterator value="list">
		
			<div class = "list_div" id = "list_div" style="background-color: white;display:inline-block;">
						<div style="margin-left:50px;margin-top: 30px;clear: both;">	
							<span style=" padding-top: 20px;font-size:1.7em;">
								<b>姓名:<s:property value="firstName"/><s:property value="lastName"/></b>
							</span>
						</div>	
						
						<div style="margin-top: 10px;margin-left: 50px;"><b>
								顾客编号</b>: <s:property value="id"/>
							
						</div>
						<div style="margin-left:50px;margin-top: 10px">
							<span style="padding-top: 10px;font-size: 12px;">
								<b>手机号码:</b><s:property value="phone"/>
							</span>	
						</div>	
						<div style=" margin-left:50px;margin-top: 10px">	
							<span style="padding-top: 10px;">	
								<b>Email:</b><s:property value="email"/>
							</span>	
						</div>
						<div style="margin-left:50px;margin-top: 10px">
							<span style=" padding-top: 0px; font-size: 12px; padding-right: 20px;">
								<b> 电话:</b><s:property value="telephone"/>
							 </span>
							<span  style=" padding-top: 10px; font-size: 12px;">
								<b>注册时间:</b><s:date name="dateAdded" format="yyyy-MM-dd"/>
							</span>
						</div>	
						<div style="margin-left:50px;margin-top: 10px">	
							
						</div>
						<div style="margin-left:50px;margin-top: 10px">	
							<span  style=" padding-top: 10px; font-size: 12px;">
							  	<b>家庭住址:</b>未知
							 </span> 
						</div>
					</div>	
		</s:iterator>
		<table width="100%">
						<tr>
							<td valign="middle" align="middle">
								<h3>
									<a href="/control/marketing_files/${actionName}.action?page=${page-1}&day1=${day1}&day2=${day2}">上一页</a>
									|第${page}页/共${pageNum}页|
									<a href="/control/marketing_files/${actionName}.action?page=${page+1}&day1=${day1}&day2=${day2}">下一页</a>
								</h3>
							</td>
						</tr>
						
		</table>
	</div>
	</div>
	
	<div id = "foot"></div>
</body>
</html>