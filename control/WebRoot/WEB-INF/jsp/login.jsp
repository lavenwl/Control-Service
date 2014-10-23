<%@page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>login</title>
		<link rel="stylesheet" type="text/css" href="../../css/style.css" />
		<script type="text/javascript" src="../../js/jquery-1.4.3.js"></script>
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
						登录
					</h1>
					<form action="login.action" method="post" id="f">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="userName" id="username"/>
									<span style="color:red;" id="username_msg"></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" id="pwd"/>
									<span style="color:red;" id="pwd_msg"></span>
								</td>
							</tr>
							
						</table>
						<table>
						  <tr style="width:100px">
							   <td align="center" colspan="2">
							   <input type="submit" class="button" value="确认 &raquo;" />
							   <input type="reset" class="button" value="重置 &raquo;" />
							   </td>
							</tr>
						</table>
						<p>
							&nbsp;还不是我们的会员?&nbsp;<a href="regist.jsp">赶快加入</a>
						</p>
					</form>
				</div>
			</div>
			<%@include file="../../common/foot.jsp" %>
		</div>
	</body>
</html>
