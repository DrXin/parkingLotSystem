<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/27 0027
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
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
<body style="height: 100%;width:100%;background-image: url(${pageContext.request.contextPath}/pic/register.jpg);
        background-position: 100%,100%;background-repeat: no-repeat;overflow: hidden">
<div class="row">
    <div class="col-sm-8">
    </div>
    <div class="col-sm-3">
        <form id="registerForm" role="form" action="${pageContext.request.contextPath}/userController/register.user" method="post">
            <div class="form-group">
                <h2 style="font-weight: bold">注册：</h2>
            </div>
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名" onblur="checkUsernameRepeated(this)">
                <span id="username_error" style="color: red"></span>
            </div>
            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="repeat" name="repeat" placeholder="再输入一遍密码" onblur="checkPasswordSame(this)">
                <span id="password_error" style="color: red"></span>
            </div>
            <div class="form-group">
                <label for="idCardNum" style="color: snow">身份证号码</label>
                <input type="text" class="form-control" id="idCardNum" name="idCardNum" placeholder="请输入身份证号码" onblur="checkIdCardNum(this)">
                <span id="idCardNum_error" style="color: red"></span>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-default" style="float: right">注册</button>
            </div>
        </form>
    </div>
    <div class="col-sm-1"></div>
</div>
</body>
<script type="text/javascript">
    //检查username是否已经被使用
    function checkUsernameRepeated(item) {

        $("#username_error").text("");

        var username = item.value;
        $.ajax({
            type:"get",
            url: "${pageContext.request.contextPath}/userController/checkUserName.username",
            data: {
                "username":username
            },
            dataType:"json",
            success:function (result) {
                if (result.code == 100){
                    $("#username_error").text(result.errorMsg);
                }
            }

        })
    }

    //检查两次密码输入是否一样
    function checkPasswordSame(item) {

        $("#password_error").text("");

        var p1 = $("#password")[0].value;
        var p2 = item.value;
        if(p1 != p2){
            $("#password_error").text("两次密码输入不同！请重新输入");
        }
    }

    //检查是否已登记身份信息
    function checkIdCardNum(item) {
        $("#idCardNum_error").text("");

        var num = item.value;
        $.ajax({
            type:"get",
            url: "${pageContext.request.contextPath}/userController/checkIdCardNum.idCardNum",
            data: {
                "idCardNum":num
            },
            dataType:"json",
            success:function (result) {
                if (result.code == 100){
                    $("#idCardNum_error").text(result.errorMsg);
                }
            }
        })
    }
</script>
</html>
