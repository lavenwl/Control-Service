<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>查询出来顾客列表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
	<style type="text/css">
			#d2{height:30px;}
			#fields{height:110px;
					text-align: center;
			}	
			#outleft{
				text-align:center;
			}
			body{
				font-family:"宋体";
			}
			a{
				color: black;
			}
			body{
				font-family: SimSun;   
			}
			input[type="text"] {
   			 	border: 1px solid #101010;
				border-style: hidden hidden solid;
			}
			td{
				padding-top:2px;
				border: 5px 10px;
				padding-right:30px;
			}
			.list_div{
				float:left;
				width:408px;height:220px;border:#909090 1px solid;
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
</head>
<body>	
	<div id=d2> </div>
	<div id=fields><a href="/control/marketing_files/welcome.action"><img src="../img/fieldslogo.jpg"/></a></div>
	<div id="outleft">
		<div id= "left" style="margin-left:10%;margin-right:10%;text-align: center;overflow:auto;zoom:1;">
		
			<div class = "list_div" id = "list_div" style="background-color: white;display:inline-block;padding: 20px 30px;">
				<form action="/control/marketing_files/rud.action" method="post" id="f">
										<table cellpadding="0" cellspacing="0" border="0" class="form_table" width="100%">
											<tr>
												<td valign="middle" align="left">
													<p><b>过滤注册时间:</b></p>
												</td>
											</tr>
											<tr>
												<td valign="left" style="font-size:13px;">
													当  月  注  册  用  户  大  于 <input type="text" name="day1" id="username" style="width: 30px;"/> 天 ,</br>且  小  于 
													<input type="text" name="day2" id="pwd" style="width: 30px;"/> 天  的  用  户 。
												</td>
												<td align="right" colspan="2">
												  <!--  	<input type="submit" class="button" value=" 查询 " />--> 
												   <!--	<input type="reset" class="button" value=" 重置 " />--> 
											   </td>
											</tr>
											<tr style="height: 80px;"></tr>
											<tr>
												<td td align="right" colspan="3">
    												<button type="submit" style="width: 102px; height: 27px; border: 0px none; background: url(../img/cxbt.jpg) repeat scroll left top transparent;" onmouseover="this.style.backgroundPosition='left -27px'" onmouseout="this.style.backgroundPosition='left top'" value="查询"></button>
    												<button type="reset" style="width: 102px; height: 27px; border: 0px none; background: url(../img/czbt.jpg) repeat scroll left top transparent;" onmouseover="this.style.backgroundPosition='left -27px'" onmouseout="this.style.backgroundPosition='left top'" value="重置表单"></button>
												</td>
											</tr>
										</table>
									</form>		
			</div>	
			<div class = "list_div" id = "list_div" style="background-color: white;display:inline-block;padding: 20px 30px;">
					<form action="/control/marketing_files/oud.action" method="post" id="f">
										<table cellpadding="0" cellspacing="0" border="0" class="form_table" width="100%">
											<tr>
												<td valign="middle" align="left">
													<p><b>过滤订单数量:</b></p>
												</td>
											</tr>
											<tr>
												<td valign="left" style="font-size:13px;">
													一  年  下  单  等  于 
													<input type="text" name="day1" id="username" style="width: 30px;"/> 单 ,</br> 且 
													<input type="text" name="day2" id="pwd" style="width: 30px;"/> 天  内  未  下  单  的  用  户 。
												</td>
												<td align="right" colspan="2">
											   <!--  	<input type="submit" class="button" value=" 查询 " />--> 
												   <!--	<input type="reset" class="button" value=" 重置 " />--> 
											   
											   </td>
											</tr>
											<tr style="height: 80px;"></tr>
											<tr>
												<td td align="right" colspan="3">
    												<button type="submit" style="width: 102px; height: 27px; border: 0px none; background: url(../img/cxbt.jpg) repeat scroll left top transparent;" onmouseover="this.style.backgroundPosition='left -27px'" onmouseout="this.style.backgroundPosition='left top'" value="查询"></button>
    												<button type="reset" style="width: 102px; height: 27px; border: 0px none; background: url(../img/czbt.jpg) repeat scroll left top transparent;" onmouseover="this.style.backgroundPosition='left -27px'" onmouseout="this.style.backgroundPosition='left top'" value="重置表单"></button>
												</td>
											</tr>
										</table>
									</form>		
			</div>
			<div class = "list_div" id = "list_div" style="background-color: white;display:inline-block;padding: 20px 30px;">
				<form action="/control/marketing_files/oudd.action" method="post" id="f">
										<table cellpadding="0" cellspacing="0" border="0" class="form_table" width="100%">
											<tr>
												<td valign="middle" align="left">
													<p><b>过滤订单数量:</b></p>
												</td>
											</tr>
											<tr>
												<td valign="left" style="font-size:13px;">
													一  年  下  单  等  于 
													<input type="text" name="day1" id="username" style="width: 30px;"/> 单  的  用  户 。</br>&nbsp;<input type="text" style="width: 30px;border-style: hidden hidden hidden;"/>
												</td>
												<td align="right" colspan="2">
													  <!--  	<input type="submit" class="button" value=" 查询 " />--> 
												   <!--	<input type="reset" class="button" value=" 重置 " />--> 
											   </td>
											</tr>
											<tr style="height: 80px;"></tr>
											<tr>
												<td td align="right" colspan="3">
    												<button type="submit" style="width: 102px; height: 27px; border: 0px none; background: url(../img/cxbt.jpg) repeat scroll left top transparent;" onmouseover="this.style.backgroundPosition='left -27px'" onmouseout="this.style.backgroundPosition='left top'" value="查询"></button>
    												<button type="reset" style="width: 102px; height: 27px; border: 0px none; background: url(../img/czbt.jpg) repeat scroll left top transparent;" onmouseover="this.style.backgroundPosition='left -27px'" onmouseout="this.style.backgroundPosition='left top'" value="重置表单"></button>
												</td>
											</tr>
										</table>
									</form>		
			</div>
		<table width="100%">
						<tr height="20px">
							<td valign="middle" align="right">
								
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right">
								<!-- <a href="/control/marketing_files/welcome.action"><input type="button" class="button" value="返回主页 " /></a> -->
							</td>
						</tr>
		</table>
	</div>
	</div>
	
	<div id = "foot"></div>
</body>
</html>