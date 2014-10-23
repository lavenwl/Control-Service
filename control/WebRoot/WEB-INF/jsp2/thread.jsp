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
			td{
				padding-top:0px;
				border: 5px 10px;
			}
			.list_div{
				//float:left;
				width:410px;height:250px;border:#909090 1px solid;
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
		<div id= "left" style="margin-left:10%;margin-right:10%;text-align: center;">
		
			<div class = "list_div" id = "list_div" style="background-color: white;display:inline-block;padding: 20px 30px;">
								<div id="content">
					<p id="whereami">
					</p>
					<div style="height:0px;"> </div>
				<!-- 	<b>
						线程控制
					</b> -->
					<div style="height:10px;"> </div>
						<table cellpadding="0" cellspacing="0" border="0" class="form_table">
							<tr>
								<td valign="middle" align="right">
									<form action="/control/marketing_files/startt.action" method="post" id="f">
										<table>
											<tr>
												<td style="font-size:12px;">
													<table cellpadding="0" cellspacing="0" border="0" class="form_table">
														<tr>
															<td valign="middle" colspan="2">
																<!-- <p>当前线程执行状态：</p> <p style="margin-left: 110px;"><span style="color:red;" id="username_msg">${b}</span></p>  -->
																<p><div><b style="padding-bottom: 13px; position: absolute;">当前线程执行状态：</b><span style="color:red;padding-left: 125px;"><s:if test="b" ><img src="../img/start6.png" style="height: 25px;"/></s:if><s:else><img src="../img/stop6.png" style="height: 25px;"/></s:else></span></div></p> 
																
															</td>
														</tr>
														<tr>
															<td valign="middle" colspan="2">
																<strong style="color:  rgb(210, 210, 210);">____________________________________________</strong>
															</td>
														</tr >
														<tr style="height: 20px;">
															<td valign="middle" colspan="2">
															</td>
															
														</tr>
														<tr style="height: 30px;">
															<td valign="middle" align="right">
																线程开始时间：
															</td>
															<td valign="middle" align="left">
																<input type="text" class="inputgri" name="start" id="username"/>
																<span style="color:red;" id="username_msg">（yyyy-mm-dd hh:mm:ss）</span>
															</td>
														</tr>
														<tr style="height: 30px;">
															<td valign="middle" align="right">
																线程间隔时间：
															</td>
															<td valign="middle" align="left">
																<input type="text" class="inputgri" name="hour" id="username"/>
																<span style="color:red;" id="username_msg">(小时)</span>
															</td>
														</tr>
														<tr style="height: 30px;">
															<td valign="middle" align="right">
																线程发送邮箱：
															</td>
															<td valign="middle" align="left">
																<input type="text" class="inputgri" name="email" id="username"/>
																<span style="color:red;" id="username_msg"></span>
															</td>
														</tr>
													</table>
												</td>
											</tr>
											<tr>
												<td valign="middle" align="middle">
													<table>
													  <tr style="width:100px">
														   <td align="center" colspan="2">
														   <input type="submit" class="button" value="启动线程" />
														   <a href="/control/marketing_files/stopp.action"> <input type="button" class="button" value="关闭线程" /></a>
														   </td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</form>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									
									<!-- <a href="/control/marketing_files/welcome.action"> <input type="submit" class="button" value="返回主页" /></a> -->
								</td>
							</tr>
						</table>
				</div>		
			</div>	
	</div>
	</div>
	
	<div id = "foot"></div>
</body>
</html>