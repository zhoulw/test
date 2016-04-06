<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- **********************************************************************************
*Description: 登录页
*author:      mayuan
*date:        2015.8.25
************************************************************************************************* -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>学生管理系统--登录页</title>
    <link rel="stylesheet" type="text/css" href='<c:url value="/css/common/common.css"></c:url>'>
    <link rel="stylesheet" type="text/css" href='<c:url value="/css/base/reset.css"></c:url>'>
    <script type="text/javascript" src='<c:url value="/js/site-config.js"></c:url>'></script>
    <link rel="stylesheet" type="text/css" href='<c:url value="/css/login_invert.css"></c:url>'>
</head>
<body>
<div class="header">
    <a class="header_log">学生管理系统</a>
</div>
<div class="continer continer_login">
    <h1>学生管理系统</h1>
    <div class="login">
        <form action="${website}login" method="post">
        <div class="login_peo">
            <span></span>
            <input type="text" name="userName" value="" />
        </div>
        <hr/>
        <div class="login_pass">
            <span></span>
             <input type="password" name="password" value=""/>
        </div>
            <input type="submit" class="login_icon" href="" value="login"/>
        </form>
    </div>
    <div class="login_invert"></div>
</div>
</body>
</html>