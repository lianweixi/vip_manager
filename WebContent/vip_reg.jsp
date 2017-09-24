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
		if (document.forms.vipForm.name.value == "") {
			alert("请输入姓名");
			document.forms.vipForm.name.focus();
			return false;
		}
		if (document.forms.vipForm.age.value == "") {
			alert("请输入年龄");
			document.forms.vipForm.age.focus();
			return false;
		} else if (isNaN(document.forms.vipForm.age.value)) {
			alert("年龄应为数字");
			document.forms.vipForm.age.focus();
			return false;
		}
		if (document.forms.vipForm.profession.value == "") {
			alert("请输入地址");
			document.forms.vipForm.profession.focus();
			return false;
		}
	}
</script>
<title>VIP注册</title>
</head>
<body>
	<div class="container">
		<div class="haomaTitle" id="hmtitle">
			<div class="haoma-inner" id="haoma-inner">VIP注册</div>
		</div>
		<form action="${pageContext.request.contextPath}/vip_add.action" method="post" name="vipForm">
			<div id="formArea">
				<div class="box box_3" style="z-index: 0">
					<label class="item" for="name">姓名</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_error">
							<input type="text" class="new_txt" id="name" name="name"
								tabindex="1" style="z-index: 0" maxlength="24"
								autocomplete="off">
						</div>
					</div>
				</div>
				<div class="box box_4" style="z-index: 0">
					<label class="item" for="age">年龄</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_error">
							<input type="text" class="new_txt" id="age" name="age"
								tabindex="4" style="z-index: 0" maxlength="24"
								autocomplete="off">
						</div>
					</div>
				</div>
				<div class="box box_5" style="z-index: 0">
					<label class="item" for="joinTime">入会日期</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_error">
							<input type="date" class="new_txt" id="joinTime" name="joinTime"
								tabindex="5" style="z-index: 0" maxlength="24">
						</div>
					</div>
				</div>
				<div class="box box_6" style="z-index: 0">
					<label class="item" for="profession">成分</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_error">
							<input type="text" class="new_txt" id="profession" name="profession"
								tabindex="6" style="z-index: 0" maxlength="24"
								autocomplete="off">
						</div>
					</div>
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