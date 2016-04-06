<%--
  Created by IntelliJ IDEA.
  User: zhoulw
  Date: 2016/4/5
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body>
<h1>注册</h1>
<p style="color: red">${message}</p>
<form action="/student/new" method="post">
    <p>学号：
    <input type="text" name="studentNumber" /></p>
    <p>密  码：
    <input type="password" name="password" /></p>
    <p>确认密 码：
    <input type="password" name="password2"/></p>
    <p>姓名：
    <input type="text" name="name" /></p>
    <p>性别：
    <input type="text" name="sex" /></p>
    <p>成绩：
    <input type="text" name="" /></p>
    <p>班级号：
    <input type="text" name="classNumber" /></p>
    <p>年级号：
    <input type="text" name="grade" /></p>
    <p>学院：
    <input type="text" name="college" /></p>
    <p>生日：
    <input type="text" name="date" /></p>

    <button type="submit">确定</button>
    <button type="reset">取消</button>
</form>
</body>
</html>