<%@page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>创建新的导出规则</title>
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
						创建新的导出规则
					</h1>
					<table width="90%">
						<tr>
							<td>
								<table cellpadding="0" cellspacing="0" border="0" class="form_table" width="90%">
							<tr>
								<td valign="middle" align="left">
									<form action="/control/marketing_files/rud.action" method="post" id="f">
										<table cellpadding="0" cellspacing="0" border="0" class="form_table" width="90%">
											<tr>
												<td valign="middle" align="left">
													<p><b>过滤注册时间:</b></p>
												</td>
											</tr>
											<tr>
												<td valign="left">
													当月注册用户大于<input type="text" name="day1" id="username" style="width: 30px;"/>天,且小于
													<input type="text" name="day2" id="pwd" style="width: 30px;"/>天的用户
												</td>
												<td align="right" colspan="2">
												   	<input type="submit" class="button" value=" 查询 " />
												   	<input type="reset" class="button" value=" 重置 " />
											   </td>
											</tr>
										</table>
									</form>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="left">
									<form action="/control/marketing_files/oud.action" method="post" id="f">
										<table cellpadding="0" cellspacing="0" border="0" class="form_table" width="90%">
											<tr>
												<td valign="middle" align="left">
													<p><b>过滤订单数量:</b></p>
												</td>
											</tr>
											<tr>
												<td valign="left">
													一年下单等于
													<input type="text" name="day1" id="username" style="width: 30px;"/>单,且
													<input type="text" name="day2" id="pwd" style="width: 30px;"/>天内未下单的用户
												</td>
												<td align="right" colspan="2">
											   <input type="submit" class="button" value=" 查询 " />
											   <input type="reset" class="button" value=" 重置 " />
											   </td>
											</tr>
										</table>
									</form>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="left">
									<form action="/control/marketing_files/oudd.action" method="post" id="f">
										<table cellpadding="0" cellspacing="0" border="0" class="form_table" width="90%">
											<tr>
												<td valign="left">
													一年下单等于
													<input type="text" name="day1" id="username" style="width: 30px;"/>单的用户
												</td>
												<td align="right" colspan="2">
													   <input type="submit" class="button" value=" 查询 " />
													   <input type="reset" class="button" value=" 重置 " />
											   </td>
											</tr>
										</table>
									</form>
								</td>
							</tr>
						</table>
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right">
								<table width="100%">
									<tr width="80%">
										<td valign="middle" align="right">
											<a href="/control/marketing_files/welcome.action"><input type="button" class="button" value="返回主页" /></a>
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
