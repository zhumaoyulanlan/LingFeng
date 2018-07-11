<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<title>删除用户</title>
<link rel="stylesheet" type="text/css" href="${basePath}/css/stylemain.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<%@ include file="/WEB-INF/layout/header.jsp"%>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						<p style="color:Crimson;">是否确认删除该用户?</p>
					</h1>
					<form action="${basePath}/user/delete.do" method="post" >
		<table  cellpadding="0" cellspacing="0" border="0"
							class="form_table">
					<tr valign="middle" align="right" hidden="true">
				<td>id</td>
				<td align="left"><input value="${user.id}" name=id> </td>
			</tr>
			<tr valign="middle" align="right">
				<td>用户名:</td>
				<td align="left">${user.login_name}</td>
			</tr>
			<tr valign="middle" align="right">
				<td>密码:</td>
				<td align="left">${user.pwd}</td>
			</tr>
			<tr valign="middle" align="right">
				<td>权限:</td>
				<td align="left">		<c:if test="${user.privilege%2==1}">管理员&ensp;</c:if>
								<c:if test="${user.privilege/8>=1}">财务&ensp;</c:if>
								<c:if test="${(user.privilege%8)/4>=1}">统计&ensp;</c:if>
								<c:if test="${(user.privilege%4)/2>=1}">人事&ensp;</c:if>
								</td>
			</tr>
			<tr valign="middle" align="right">
				<td>使用者:</td>
				<td align="left">${employee.name}</td>
			</tr>
			<tr valign="middle" align="left">
				<td colspan="2"><input type="submit" value="删除"></td>
				<td><a href="${basePath}/user/userlist.do">返回</a></td>
			</tr>
		</table>
	</form>
				</div>
			</div>
			<%@include file="/WEB-INF/layout/footer.jsp"%>
		</div>
	</body>
</html>

