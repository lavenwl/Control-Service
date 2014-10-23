<%@page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>线程控制</title>
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
						线程控制
					</h1>
						<table cellpadding="0" cellspacing="0" border="0" class="form_table">
							<tr>
								<td valign="middle" align="right">
									<form action="/control/marketing_files/startt.action" method="post" id="f">
										<table>
											<tr>
												<td>
													<table cellpadding="0" cellspacing="0" border="0" class="form_table">
														<tr>
															<td valign="middle" align="right">
																<p>当前线程执行状态：</p> 
															</td>
															<td valign="middle" align="left">
																<p><span style="color:red;" id="username_msg">${b}</span></p> 
															</td>
														</tr>
														<tr>
															<td valign="middle" align="right">
																线程开始时间：
															</td>
															<td valign="middle" align="left">
																<input type="text" class="inputgri" name="start" id="username"/>
																<span style="color:red;" id="username_msg">（格式：yyyy-mm-dd hh:mm:ss）</span>
															</td>
														</tr>
														<tr>
															<td valign="middle" align="right">
																线程间隔时间：
															</td>
															<td valign="middle" align="left">
																<input type="text" class="inputgri" name="hour" id="username"/>
																<span style="color:red;" id="username_msg">( 单位：小时)</span>
															</td>
														</tr>
														<tr>
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
														   <input type="submit" class="button" value="启动" />
														   <input type="reset" class="button" value="取消" />
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
									<a href="/control/marketing_files/stopp.action"> <input type="submit" class="button" value="关闭线程" /></a>
									<a href="/control/marketing_files/welcome.action"> <input type="submit" class="button" value="返回主页" /></a>
								</td>
							</tr>
						</table>
				</div>
			</div>
			<%@include file="../../common/foot.jsp" %>
		</div>
	</body>
</html>
