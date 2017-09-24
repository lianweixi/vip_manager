<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/buttons.css">
<script type="text/javascript">
	function check(form) {
		if (document.forms.loginForm.username.value == "") {
			alert("请输入用户名");
			document.forms.loginForm.username.focus();
			return false;
		}
		if (document.forms.loginForm.password.value == "") {
			alert("请输入密码");
			document.forms.loginForm.password.focus();
			return false;
		}
	}
</script>
<title>登录</title>
</head>
<body>
	<div class="container">
		<div class="haomaTitle" id="hmtitle">
			<div class="haoma-inner" id="haoma-inner">登录</div>
		</div>
		<form action="${pageContext.request.contextPath}/user_login.action" method="post" name="loginForm">
			<div id="formArea">
				<div class="box box_3" style="z-index: 0">
					<label class="item" for="username">用戶名</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_error">
							<input type="text" class="new_txt" id="username" name="username"
								tabindex="1" style="z-index: 0" maxlength="24"
								autocomplete="off">
						</div>
					</div>
				</div>
				<div class="box box_4" style="z-index: 0">
					<label class="item" for="password">密码</label>
					<div class="ipt_box nick_ipt_box">
						<div id="password_bg" class="bg_error">
							<input type="password" class="new_txt" id="password" name="password"
								tabindex="2" style="z-index: 0" maxlength="24"
								autocomplete="off">
						</div>
					</div>
				</div>
				<div class="box box_4" style="z-index: 0">
					 <span class="item"></span>
					 <div class="ipt_box nick_ipt_box">
							<input type="submit" value="登录" onclick="return check(this);">
					</div>
					<dir style="color: red;">
						<p>${error}</p>
					</dir>
				</div>
			</div>
		</form>
	</div>
</body>
</html>