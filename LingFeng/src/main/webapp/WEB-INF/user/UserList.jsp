<%@page import="java.util.Map"%>
<%@page import="com.lingfeng.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>
	<head>
		<title>用户信息</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${basePath}/css/stylemain.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<%@ include file="/WEB-INF/layout/header.jsp" %>
				
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
					用户信息
					</h1>
					<table class="table">
					<tr class="table_header">
						<td>ID</td>
						<td>用户名</td>
						<td>密码</td>
						<td>修改</td>
						<td>权限</td>
						<td>对应员工</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${old_cy }" var="old">

    <tr><td>${old.key }</td><td>${old.value }</td>
    <td>${new_cy[old.key] }</td></tr>

</c:forEach>
					
					<c:forEach items="${userList}" var="u" varStatus="r">
						<tr class="row${r.count%2+1}">
							<td>${u.id}</td>
							<td>${u.login_name}</td>
							<td>${u.pwd}</td>
							<td><a href="${basePath}/user/password.do?id=${u.id}">修改</a></td>
							<td>
								<c:if test="${u.privilege%2==1}">管理员&ensp;</c:if>
								<c:if test="${u.privilege/8>=1}">财务&ensp;</c:if>
								<c:if test="${(u.privilege%8)/4>=1}">统计&ensp;</c:if>
								<c:if test="${(u.privilege%4)/2>=1}">人事&ensp;</c:if>
							</td>
							<td>${map[u.lister_id]}</td>
							<td><a href="${basePath}/user/delete.do?id=${u.id}">删除</a></td>
						</tr>
					</c:forEach>	
					<tr><td colspan="2">${pageBar}</td></tr>
					</table>
					<p>
						<input type="button" class="button" value="添加用户" onclick="location='${basePath}/user/userAdd.do'"/>
					</p>
					<p><a href="${basePath}/user/userlist.do">返回主菜单</a></p>
				</div>	
			</div>
		<%@include file="/WEB-INF/layout/footer.jsp" %>
		</div>
	</body>
</html>
