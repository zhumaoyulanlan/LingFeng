<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
		<title>员工信息</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${basePath}/css/stylemain.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<%@ include file="/WEB-INF/layout/header.jsp" %>
<!-- 				 employee_id;      -->
<!--  job_number;       -->
<!-- name;              -->
<!--  state;            -->
<!--  gender;           -->
<!--  age;              -->
<!-- id_card_no;        -->
<!--  department_id;    -->
<!-- department_name;   -->
<!-- post;              -->
<!-- phone;             -->
<!-- phone_other;       -->
<!-- native_place;      -->
<!-- address;           -->
<!-- politics_status;   -->
<!-- remark;            -->
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
					用户信息
					</h1>
					<table class="table" id="table">
					<tr class="table_header">
						<td>ID</td>
						<td>用户名</td>
						<td>密码</td>
						<td>修改</td>
						<td>权限</td>
						<td>对应员工</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${modelList}" var="e" varStatus="r" >
						<tr class="row${r.count%2+1}">
							<td>${e.employee_id}</td>
							<td>${e.job_number}</td>
							<td>${e.name}</td>
							<td>${e.state}</td>
							<td>${e.gender}</td>
							<td>${e.id_card_no}</td>
							<td>${e.department_id}</td>
							<td>${e.department_name}</td>
							<td>${e.post}</td>
							<td>${e.phone}</td>
							<td>${e.phone_other}</td>
							<td>${e.native_place}</td>
							<td>${e.address}</td>
							<td>${e.politics_status}</td>
							<td>${e.native_place}</td>
							<td>${e.remark}</td>
						</tr>
						</c:forEach>
					<tr><td colspan="2">${pageBar}</td></tr>
					</table>
					<p>
						<input type="button" class="button" value="添加员工" onclick="location='${basePath}/user/userAdd.do'"/>
					</p>
					<p><a href="${basePath}/user/userlist.do">返回主菜单</a></p>
				</div>	
			</div>
		<%@include file="/WEB-INF/layout/footer.jsp" %>
		</div>
	</body>
	<script type="text/javascript" src="${basePath}/js/jquery-2.1.1.js"></script>
	<script type="text/javascript">

// 		$(document).ready(function() {

// 			var tr = $("<tr></tr>");
// 			var td = append("<td></td>").text("11");
// 			tr.append(td);
// 			$("#table").append(tr);

// 		});
	</script>
	
</html>