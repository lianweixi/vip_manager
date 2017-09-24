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
			<a href="${pageContext.request.contextPath}/vip_reg.jsp">新增</a>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table">
					<caption>VIP信息</caption>
					<thead>
						<tr>
							<th>名称</th>
							<th>年龄</th>
							<th>入会时间</th>
							<th>成分</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${vips}" var="vip">
							<tr>
								<td>${vip.name}</td>
								<td>${vip.age}</td>
								<td>${vip.joinTime}</td>
								<td>${vip.profession}</td>
								<td><a href="${pageContext.request.contextPath}/vip_delete.action?vipId=${vip.vipId}">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
	</div>
</div>
</body>
</html>