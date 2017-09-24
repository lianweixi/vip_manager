<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form action="${pageContext.request.contextPath}/commodity_get_by_name.action" method="get">
					<label for="commodityName">商品名称</label> 
					<input type="text" id="commodityName" name="commodityName" />
					<input type="submit" value="确定">
				</form>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<table class="table">
					<caption>商品信息</caption>
					<thead>
						<tr>
							<th>商品名称</th>
							<th>商品价格</th>
							<th>商品折扣</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${commodities}" var="commodity">
							<tr>
								<td>${commodity.commodityName}</td>
								<td>${commodity.price}</td>
								<td>${commodity.agio}</td>
								<td><a href="${pageContext.request.contextPath}/commodity_delete.action?commodityId=${commodity.commodityId}">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>