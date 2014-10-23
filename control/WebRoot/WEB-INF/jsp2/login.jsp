<!--
*******************************************************
* 程序名称：login.jsp
* 程序功能：用户登录首页面
* 创建日期：2010-05-31
* 更新记录：  更新人	更新日期	           更新原因/内容
*           chenxw	2010-05-31	新建
*******************************************************
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fields Data Center Logon</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/stylein.css">
<link href="<%=request.getContextPath() %>/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/login.js" charset="UTF-8"></script>
<script src="<%=request.getContextPath() %>/js/jquery-1.4.3.js" charset="utf-8"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- css文本 -->


<!-- jquery脚本 -->

<script src="<%=request.getContextPath() %>/js/jquery-1.js"></script>

</head>
<body>






	<div style="width: 1896px; margin-left: -948px;" class="login_container">
		<div class="login_logo">
			<img src="<%=request.getContextPath() %>/img/logo.png">
		</div>
		<form style="margin-left: 1198px;" class="info_enter" id="login-form" action="login.action" method="post">
		
		
			<div class="login_title"><h4>Fields Data Center</h4></div>
			<div class="login_text">
				<div class="login_icon"><img src="<%=request.getContextPath() %>/img/head.png"></div>
				<div class="login_text_in">
					<input id="login" name="name" type="text"> 
				</div>
			</div>
			<div class="login_text">
				<div class="login_icon"><img src="<%=request.getContextPath() %>/img/pw.png"></div>
				<div class="login_text_in">
					<input id="Password" name="Password" type="password"> 
				</div>
			</div>
			<div class="login_button"> 
				<input class="login" onclick="return cheack_input()" name="commit" value=" " type="submit">
				<input class="reset" name="commit" value=" " onclick="reset();" type="button">
			</div>
			<div id="error1" class="error" style="height:30px;color:red;font-size:12px;display:none;margin:0px">
				<p>用户名或密码不正确！</p>
			</div>
			<input id="SessionID" name="SessionName" value="3233EF7F9CD2FBE64E44BC38B3E73F50" type="hidden">
			<input value="" id="back" type="hidden">
			</form>
		</div>
<script>
function reset(){
	var login=document.getElementById("login");
	var password=document.getElementById("Password");
	login.value="";
	password.value="";
}


	function cheack_input(){
		var email_reg =/[^\u4e00-\u9fa5]/;
		var telephone_reg = /^[0-9]*$/;
		var input_value = document.getElementById("login");
		var input_value2 = document.getElementById("Password");
		var b = false;
		if(input_value.value!=null&&input_value.value!=""&&input_value2.value!=null&&input_value2.value!=""){
			if((email_reg.test(input_value.value)&&email_reg.test(input_value2.value))){
				if(input_value.value=="CNMKT" && input_value2.value=="fields1234"){
					b = true;
				}
				if(input_value.value=="VIPMKT" && input_value2.value=="fields1234"){
					b = true;
				}
				if(input_value.value=="WEBOPR" && input_value2.value=="fields1234"){
					b = true;
				}
				if(input_value.value=="ADMIN" && input_value2.value=="admin@123"){
					b = true;
				}
				if(input_value.value=="BICRM" && input_value2.value=="bicrm@321"){
					b = true;
				}
				if(b == false){
						$(".error").show();
						document.getElementById("error1").innerHTML="<p>用户名或密码不正确！</p>";
						return false;
					}else{
						return true;
						}
			}else{
				$(".error").show();
				document.getElementById("error1").innerHTML="<p>请正确输入！</p>";
				return false;
			}
		}else{
			$(".error").show();
			document.getElementById("error1").innerHTML="<p>不能为空!</p>";
			return false;
		}
	}



var back=document.getElementById("back").value;
if(back=="1"){ 
	$(".error").show();
}
</script>		
	 
		

<table style="display: none;" class="igtranslator-bubble"><tr><td class="igtranslator-header" colspan="4"></td></tr><tr><td colspan="4"><table class="igtranslator-content"></table></td></tr><tr class="igtranslator-footer"><td title="Save to Phrasebook" style="background-image: url(resource://jid1-dgnibwqga0sibw-at-jetpack/igtranslator/data/content_script/bookmarks.png)"></td><td title="Listen" style="background-image: url(resource://jid1-dgnibwqga0sibw-at-jetpack/igtranslator/data/content_script/voice.png)"></td><td title="Open Google Translate" style="background-image: url(resource://jid1-dgnibwqga0sibw-at-jetpack/igtranslator/data/content_script/home.png)"></td><td title="Open Settings" style="background-image: url(resource://jid1-dgnibwqga0sibw-at-jetpack/igtranslator/data/content_script/settings.png)"></td></tr></table></body></html>