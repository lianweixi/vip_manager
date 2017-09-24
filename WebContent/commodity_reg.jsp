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
		if (document.forms.commodityForm.commodityName.value == "") {
			alert("请输入商品名称");
			document.forms.commodityForm.commodityName.focus();
			return false;
		}
		if (document.forms.commodityForm.price.value == "") {
			alert("请输入商品价格");
			document.forms.commodityForm.price.focus();
			return false;
		} else if (isNaN(document.forms.commodityForm.price.value)) {
			alert("价格应为数字");
			document.forms.commodityForm.price.focus();
			return false;
		}
		if (document.forms.commodityForm.agio.value == "") {
			alert("请输入商品折扣");
			document.forms.commodityForm.agio.focus();
			return false;
		} else if (isNaN(document.forms.commodityForm.agio.value)) {
			alert("商品折扣应为数字");
			document.forms.commodityForm.agio.focus();
			return false;
		}
	}
</script>
<title>商品信息录入</title>
</head>
<body>
<div class="container">
		<div class="haomaTitle" id="hmtitle">
			<div class="haoma-inner" id="haoma-inner">商品信息录入</div>
		</div>
		<form action="${pageContext.request.contextPath}/commodity_add.action" method="post" name="commodityForm">
			<div id="formArea">
				<div class="box box_3" style="z-index: 0">
					<label class="item" for="commodityName">商品名称</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_error">
							<input type="text" class="new_txt" id="commodityName" name="commodityName"
								tabindex="1" style="z-index: 0" maxlength="24"
								autocomplete="off">
						</div>
					</div>
				</div>
				<div class="box box_4" style="z-index: 0">
					<label class="item" for="price">商品价格</label>
					<div class="ipt_box nick_ipt_box">
						<div id="password_bg" class="bg_error">
							<input type="text" class="new_txt" id="price" name="price"
								tabindex="2" style="z-index: 0" maxlength="24"
								autocomplete="off">
						</div>
					</div>
				</div>
				<div class="box box_5" style="z-index: 0">
					<label class="item" for="agio">商品折扣</label>
					<div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_error">
							<input type="text" class="new_txt" id="agio" name="agio"
								tabindex="3" style="z-index: 0" maxlength="24"
								autocomplete="off">
						</div>
					</div>
				</div>
				<div class="box box_6" style="z-index: 0">
					 <span class="item"></span>
					 <div class="ipt_box nick_ipt_box">
							<input type="submit" value="录入" onclick="return check(this);">
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