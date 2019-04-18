<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/21 0021
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<head>
    <title>停车场信息管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div style="width: 100%;height: 100%;background-image: url(${pageContext.request.contextPath}/pic/index.jpg);position: absolute;background-size:100% 100% ">
    <form id="loginForm" class="form-horizontal" style="padding-left: 35%;padding-top: 10%;"
          action="${pageContext.request.contextPath}/userController/login.user" method="post" onsubmit="return checkForm()">
        <div class="form-group" style="width: 50%;text-align: center;">
            <h2 style="color:white">停车场管理系统</h2>
        </div>
        <div class="form-group" style="width: 50%;">
            <label for="username" class="col-sm-2 control-label" style="color:white;">账 号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username" name="username"
                       placeholder="请输入账号" style="width: 280px;" onblur="checkUsernameNull(this)"
                       data-toggle="popover" data-placement="right">
                <span style="color: red">${usernameError}</span>
            </div>

        </div>
        <div class="form-group" style="width: 50%;">
            <label for="password" class="col-sm-2 control-label" style="color:white;">密 码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" name="password"
                       placeholder="请输入密码" style="width: 280px;" onblur="checkPasswordNull(this)">
                <span style="color: red">${passwordError}</span>
            </div>
        </div>
        <div class="row" style="width: 70%;">
            <div class="col-sm-5">
                <button type="submit" onclick="checkForm()" class="btn btn-default" style="width: 40%;float: right">登录</button>
            </div>
            <div class="col-sm-5">
                <a href="${pageContext.request.contextPath}/register">
                    <button type="button" class="btn btn-default" style="width: 40%;float: left">注册</button>
                </a>
            </div>
        </div>
        <div class="row" style="width: 100%">
            <div class="col-sm-5">
                <a href="${pageContext.request.contextPath}/passwordReset" style="color:white;font-style: italic;float: right">忘记密码？</a>
            </div>
            <div class="col-sm-5">
            </div>
        </div>
    </form>
</div>
</body>
<%
//    request.removeAttribute("usernameError");
//    request.removeAttribute("passwordError");
%>
<script type="text/javascript">

    /*这里是提交表单前的非空校验*/
    function checkForm() {

        var username = $("input[name='username']").val();
        var password = $("input[name='password']").val();

        if (username == "" || username == null || username == undefined) {
            $("#username").next("span").text("用户名不能为空！");
            /*阻止表单提交*/
            return false;
        } else if (password == "" || password == null || password == undefined) {
            $("#password").next("span").text("密码不能为空！");
            return false;
        } else {
            // $("#loginForm").submit();//提交
            return true;
        }
    }

    function clearError(item)
    {
        $(item).next("span").text("");
    }

    function checkPasswordNull(item)
    {
        clearError(item);
        if(item.value=="")
        {
            $(item).next("span").text("密码不能为空！");
        }
    }

    function checkUsernameNull(item)
    {
        clearError(item);
        if(item.value=="")
        {
            $(item).next("span").text("用户名不能为空！");
        }
    }
</script>
</html>
