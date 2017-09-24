<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统维护</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<a href="${pageContext.request.contextPath}/user_reg.jsp">新增</a>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<table class="table">
					<caption>系统维护</caption>
					<thead>
						<tr>
							<th>用户名</th>
							<th>用户口令</th>
							<th>用户权限</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user">
							<tr>
								<td>${user.username}</td>
								<td>${user.password}</td>
								<c:choose>
									<c:when test="${user.quanxian == 1}">
										<td><a
											href="${pageContext.request.contextPath}/user_qualify_change.action?username=${user.username}&quanxian=2">禁用</a></td>
									</c:when>
									<c:when test="${user.quanxian == 2}">
										<td><a
											href="${pageContext.request.contextPath}/user_qualify_change.action?username=${user.username}&quanxian=1">启用</a></td>
									</c:when>
									<c:otherwise></c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>