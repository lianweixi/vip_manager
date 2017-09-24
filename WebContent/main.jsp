<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lian.entity.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
<title>全唐诗搜索</title>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<img alt="140x140" src="${pageContext.request.contextPath}/img/logo.png" />
		</div>
	</div>
	<div class="row clearfix" style="margin-top: 20px; ">
		<div class="col-md-3 column">
			<a href="${pageContext.request.contextPath}/commodity_reg.jsp" target="main_iframe">商品信息录入</a></br>
			<a href="${pageContext.request.contextPath}/commodity_get.action" target="main_iframe">商品信息查询</a></br>
			<a href="${pageContext.request.contextPath}/vip_get.action" target="main_iframe">VIP信息管理</a></br>
			<a href="${pageContext.request.contextPath}/vip_consume.action" target="main_iframe">VIP购物登记</a></br>
			<a href="${pageContext.request.contextPath}/vip_query.jsp" target="main_iframe">VIP信息查询</a></br>
			<% 
				User user = (User)session.getAttribute("user");
				if (user.getQuanxian() == 0) {
					out.println("<a href=\"${pageContext.request.contextPath}/user_get.action\" target=\"main_iframe\">系统维护</a></br>");
				}
			%>
			<a href="${pageContext.request.contextPath}/user_logout.action">退出</a></br>
		</div>
		<div class="col-md-9 column">
			<iframe frameborder="1" name="main_iframe" src="${pageContext.request.contextPath}/welcome.jsp" width="100%" height="500px"></iframe>		
		</div>
	</div>
</div>
</body>
</html>