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
						错误，请<a href="/control/marketing_files/welcome.action">返回</a>重试！
					</h1>
				</div>
			</div>
			<%@include file="../../common/foot.jsp" %>
		</div>
	</body>
</html>
