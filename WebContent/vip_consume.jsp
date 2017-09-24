<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>VIP购物登记</title>
</head>
<body>
	<div class="container">
		<div class="haomaTitle" id="hmtitle">
			<div class="haoma-inner" id="haoma-inner">VIP购物登记</div>
		</div>
		<form action="${pageContext.request.contextPath}/vip_consume_add.action"
			method="post" name="vipForm">
			<div id="formArea">
				<div class="box box_3" style="z-index: 0">
					<label class="item" for="vipId">VIP</label>
					<select name="vipId">
								<c:forEach items="${vips}" var="vip">
									<option value="${vip.vipId}">${vip.name}</option>						
								</c:forEach>
							</select>
					<%-- <div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_error">
							<select name="vipId">
								<c:forEach items="${vips}" var="vip">
									<option value="${vip.vipId}">${vip.name}</option>						
								</c:forEach>
							</select>
						</div>
					</div> --%>
				</div>
				<div class="box box_4" style="z-index: 0">
					<label class="item" for="commodityId">商品</label>
					<select name="commodityId">
								<c:forEach items="${commodities}" var="commodity">
									<option value="${commodity.commodityId}">${commodity.commodityName}</option>						
								</c:forEach>
							</select>
					<%-- <div class="ipt_box nick_ipt_box">
						<div id="nick_bg" class="bg_error">
							<select name="commodityId">
								<c:forEach items="${commodities}" var="commodity">
									<option value="${commodity.commodityId}">${commodity.commodityName}</option>						
								</c:forEach>
							</select>
							<!-- <input type="text" class="new_txt" id="age" name="age"
								tabindex="4" style="z-index: 0" maxlength="24"
								autocomplete="off"> -->
						</div>
					</div> --%>
				</div>
				<div class="box box_7" style="z-index: 0">
					<span class="item"></span>
					<div class="ipt_box nick_ipt_box">
						<input type="submit" value="购物登记">
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