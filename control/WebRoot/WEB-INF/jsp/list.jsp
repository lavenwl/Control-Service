<%@page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>过滤数据展示</title>
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
						过滤数据展示
					</h1>
					<h3>本次搜索结果数据量：${num}</h3>
					<table border="0">
						<tr>
							<th>User ID</th>
							<th>Email</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Phone</th>
							<th>Telephone</th>
							<th>Date Added</th>
						</tr>
						<s:iterator value="list">
							<tr>
								<td><s:property value="id"/></td>
								<td><s:property value="email"/></td>
								<td><s:property value="firstName"/></td>
								<td><s:property value="lastName"/></td>
								<td><s:property value="phone"/></td>
								<td><s:property value="telephone"/></td>
								<td><s:date name="dateAdded" format="yyyy-MM-dd"/></td>
							</tr>
						</s:iterator>
						
					</table>
					<table width="80%">
						<tr>
							<td valign="middle" align="middle">
								<h3>
									<a href="/control/marketing_files/${actionName}.action?page=${page-1}&day1=${day1}&day2=${day2}">上一页</a>
									|第${page}页/共${pageNum}页|
									<a href="/control/marketing_files/${actionName}.action?page=${page+1}&day1=${day1}&day2=${day2}">下一页</a>
								</h3>
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right">
								<a href="/control/marketing_files/welcome.action"><input type="button" class="button" value="返回主页 " /></a>
								<a href="/control/marketing_files/d${actionName}.action?page=${page+1}&day1=${day1}&day2=${day2}"><input type="button" class="button" value="下载数据 " /></a>
							</td>
						</tr>
					</table>
					
				</div>
			</div>
			<%@include file="../../common/foot.jsp" %>
		</div>
	</body>
</html>
