<%@ page pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE>
<html>
	<head>
		<title>添加用户</title>
	
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
						添加用户
					</h1>
					<form action="userAdd.do" method="post" >
		<table  cellpadding="0" cellspacing="0" border="0"
							class="form_table">
			<tr valign="middle" align="right">
				<td>用户名</td>
				<td><input type="text" name="login_name" placeholder="${VALIDATE_LOGINNAME}"></td>
				<td>${login_nameMsg}</td>
			</tr>
			<tr valign="middle" align="right" >
				<td>密码</td>
				<td><input type="password" name="pwd" placeholder="${VALIDATE_PWD}"></td>
				<td>${pwdMsg}</td>
			</tr>
			<tr valign="middle" align="right">
				<td>重复密码</td>
				<td><input type="password" name="repwd"></td>
				<td>${pwdMsg}</td>
			</tr>
			<tr valign="middle" align="right">
				<td>权限</td>
				<td><input type="checkbox" value="1" name="privilege">管理员<input
					type="checkbox" value="2" name="privilege">人事<input type="checkbox"
					value="4" name="privilege">统计<input type="checkbox" value="8" name="privilege">财务</td>
			</tr>
			<tr valign="middle" align="right">
				<td>对应员工</td>
				<td><select name="lister_id" id="lister_id">
					<option value=0>无</option>
				</select></td>
			</tr>
			<tr valign="middle" align="left">
				<td colspan="2"><input type="submit" value="添加"></td>
				<td><a href="${basePath}/user/userlist.do">返回</a></td>
			</tr>
		</table>
	</form>
				</div>
			</div>
			<%@include file="/WEB-INF/layout/footer.jsp"%>
		</div>
	</body>
	<script type="text/javascript" src="${basePath}/js/jquery-2.1.1.js"></script>
	<script>

	
		$(document).ready(
				function() {
					$.post("${basePath}/dictionary/getEmployee.ajax", {
			
					}, function(data, status) {
						for(var e in data){
							var option="<option value='"+e+"'>" + data[e] + "</option>";
							$("#lister_id").append($(option));
						}
					});
		})
	</script>
</html>







