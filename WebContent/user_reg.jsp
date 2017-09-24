<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css">
	<script type="text/javascript">
	function check(form) {
		if (document.forms.userForm.username.value == "") {
			alert("请输入用户名");
			document.forms.userForm.username.focus();
			return false;
		}
		if (document.forms.userForm.password.value == "") {
			alert("请输入密码");
			document.forms.userForm.password.focus();
			return false;
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="haomaTitle" id="hmtitle">
			<div class="haoma-inner" id="haoma-inner">用户注册</div>
		</div>
		<form action="${pageContext.request.contextPath}/user_add.action" method="post" name="userForm">
			<div id="formArea">
				<div class="box box_3" style="z-index: 0">
					<label class="item" for="username">用户名</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_error">
							<input type="text" class="new_txt" id="username" name="username"
								tabindex="1" style="z-index: 0" maxlength="24"
								autocomplete="off">
						</div>
					</div>
				</div>
				<div class="box box_4" style="z-index: 0">
					<label class="item" for="password">用户口令</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_error">
							<input type="password" class="new_txt" id="password" name="password"
								tabindex="4" style="z-index: 0" maxlength="24"
								autocomplete="off">
						</div>
					</div>
				</div>
				<div class="box box_5" style="z-index: 0">
					<label class="item" for="quanxian">用户权限</label>
					<select name="quanxian">
						<option value=1>启用</option>
						<option value=2>禁用</option>
					</select>
					<!-- <div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_error">
							<input type="text" class="new_txt" id="quanxian" name="quanxian"
								tabindex="5" style="z-index: 0" maxlength="24">
						</div>
					</div> -->
				</div>
				<div class="box box_7" style="z-index: 0">
					 <span class="item"></span>
					 <div class="ipt_box nick_ipt_box">
							<input type="submit" value="注册" onclick="return check(this);">
							<input type="button" value="返回" onclick="javascript:history.back(-1);">
					</div>					
				</div>
				<dir style="color: red;">
						<p>${msg}</p>
					</dir>
			</div>			
		</form>
	</div>
</body>
</html>