<%--
 description:
 user: mayuan
 QQ:836119679
 date: 2016/3/27
 time: 10:51
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>message</title>
</head>
<body>
调用的方法是：${message}<br>
<c:if test="${key!=''&&key!=NULL}">
接受到的参数是：${key}<br>
</c:if>
</body>
</html>
