<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="${basePath}/css/stylemain.css" />
</head>

<body>
	<div id="wrap">
		<div id="top_content">
			<%@ include file="/WEB-INF/layout/header.jsp"%>
			<div id="content">
				<p id="whereami"></p>
				<h1>修改密码</h1>
				<form action="${basePath}/user/password.do" method="post">
					<table cellpadding="0" cellspacing="0" border="0"
						class="form_table">
						<tr valign="middle" align="right" hidden="true">
							<td>ID</td>
							<td><input type="text" name="id" value="${user.id}" readonly="readonly" ></td>
						</tr>
						<tr valign="middle" align="right">
							<td>用户名</td>
							<td><input type="text"  value="${user.login_name}" name="login_name"  readonly="readonly"></td>
							<td>${login_namemsg}</td>
						</tr>
<!-- 						<tr valign="middle" align="right"> -->
<!-- 							<td>旧密码</td> -->
<!-- 							<td><input type="password" name="oldpwd"></td> -->
<%-- 							<td>${oldpwdmsg}</td> --%>
<!-- 						</tr> -->
						<tr valign="middle" align="right">
							<td>新密码</td>
							<td><input type="password" name="pwd" placeholder="${VALIDATE_PWD}"></td>
							<td>${pwdmsg}</td>
						</tr>
						<tr valign="middle" align="right">
							<td>重复新密码</td>
							<td><input type="password" name="repwd"></td>
							<td>${repwdmsg}</td>
						</tr>
						<tr valign="middle" align="left">
							<td colspan="2"><input type="submit" value="修改"></td>
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