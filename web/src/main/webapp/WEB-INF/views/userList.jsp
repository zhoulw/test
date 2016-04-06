<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<body>
<table style="text-align: center;font-size: 30px">
	<tr>
		<th>序号</th>
		<th>账号</th>
		<th>密码</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${userList}" var="user" varStatus="status" >
		<tr>
			<td>${status.index+1}</td>
			<td>${user.userName}</td>
			<td>${user.password}</td>
			<td><a href="${website}user/delete?id=${user.id}">删除</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>