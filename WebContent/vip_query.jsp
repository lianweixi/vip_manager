<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VIP信息查询</title>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form action="${pageContext.request.contextPath}/vip_consume_list.action" method="get">
				<label for="name">请输入VIP姓名</label>
				<input type="text" id="name" name="name" />
				<input type="submit" value="查询">
			</form>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table">
					<caption>VIP购物信息</caption>
					<thead>
						<tr>
							<th>姓名</th>
							<th>商品名称</th>
							<th>商品价格</th>
							<th>实收金额</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${consumes}" var="consume">
							<tr>
								<td>${consume.vip.name}</td>
								<td>${consume.commodity.commodityName}</td>
								<td>${consume.commodity.price}</td>
								<td>${consume.commodity.price * consume.commodity.agio}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
	</div>
</div>
</body>
</html>