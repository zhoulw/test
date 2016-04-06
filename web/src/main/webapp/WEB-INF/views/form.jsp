<%--
 description:
 user: mayuan
 QQ:836119679
 date: 2016/3/27
 time: 19:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${website}/user/new">
    userName<input type="text" name="userName"><br>
    password<input type="password" name="password">
    passwordagain<input type="password" name="password2">
    ${message}
    <input type="submit" value="zhuce">
</form>
</body>
</html>
