<%@page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>营销系统数据导出主界面</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
		<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
		<script type="text/javascript" src="../js/login.js"></script>
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<%@include file="../../common/head.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						主界面
					</h1>
						<table cellpadding="0" cellspacing="0" border="0" class="form_table" width="90%">
							<tr>
								<td valign="middle" align="middle">
									<table>
									  	<tr style="width:100px">
										   <td align="center" colspan="2">
										   <a href="/control/marketing_files/create_new.action"><input type="button" class="button" value="创建新的导出规则 " /></a>
										   </td>
										</tr>
										<tr style="width:100px">
										   <td align="center" colspan="2">
										   <p>··································································</p>
										   </td>
										</tr>
										<tr>
											<td valign="top" align="middle">
												<table>
												  <tr style="width:100px">
													   <td  align="center" colspan="2">
													   	   <a href="/control/marketing_files/thread_control.action"><input type="button" class="button" value="线程控制 " /></a>
													   </td>
													</tr>
												</table>
											</td>
											<td valign="bottom" align="middle">
												<table>
												  <tr style="width:100px">
													   <td align="center" colspan="2">
													  		<p>线程执行情况：<span style="color:red;" id="username_msg">${b}</span></p> 
													   </td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
								<td valign="middle" align="middle">
									<table>
									  <tr style="width:100px">
										   <td align="left" colspan="2">
										    <a href="/control/marketing_files/rd14.action"><span style="color:green; font-size:14px" id="username_msg">1.当月内注册时间大于14天的用户</span></a>
										   </td>
										</tr>
										<tr style="width:100px">
										   <td align="left" colspan="2">
										    <a href="/control/marketing_files/rd7x14.action"><span style="color:green; font-size:14px" id="username_msg">2.当月内注册时间大于7天小于14天的用户</span></a>
										   </td>
										</tr>
										<tr style="width:100px">
										   <td align="left" colspan="2">
										    <a href="/control/marketing_files/dd2qswd.action"><span style="color:green; font-size:14px" id="username_msg">3.一年内下2单且近10天未下单的用户</span></a>
										   </td>
										</tr>
										<tr style="width:100px">
										   <td align="left" colspan="2">
										    <a href="/control/marketing_files/dddd4d.action"><span style="color:green; font-size:14px" id="username_msg">4.一年内下单数量大于等于4单的用户</span></a>
										   </td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
				</div>
			</div>
			<%@include file="../../common/foot.jsp" %>
		</div>
	</body>
</html>
