<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/15 0015
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>停车场信息管理系统（管理员）</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <!-- Bootstrap -->
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/calender.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/calender.css">

    <!--表格样式-->
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/table.js"></script>--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootbox/bootbox.min.js"></script>
    <!--图标样式-->
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.0/css/all.min.css'>
    <!--表单样式-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css">
</head>
<body style="background-color: #D3D3D3">
<nav class="navbar navbar-default" role="navigation" style="margin-bottom: 0px">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="" style="color: black">停车场信息管理系统（管理员）</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.request.contextPath}/userController/signOut?logout=true"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
</nav>
<div class="row" style="width: 100%;">
    <div class="col-md-9">
        <div class="box">
            <div class="export">
                <button id="addDriver_btn" type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#driverAddingModal">
                <img src="${pageContext.request.contextPath}/pic/add.png"/>
                <span>添加</span>
                </button>
                <div class="modal fade" id="driverAddingModal">
                    <div class="modal-dialog modal-lg modal_position">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <form id="admin_driverForm" action="${pageContext.request.contextPath}/driverController/register.driver" method="post" class="basic-grey">
                                    <h1>添加新用户
                                    </h1>

                                    <label>
                                        <span>姓名 :</span>
                                        <input id="driverName" type="text" name="driverName" placeholder="请输入姓名" />
                                    </label>

                                    <label>
                                        <span>性别 :</span><select name="gender">
                                        <option value="male">男</option>
                                        <option value="female">女</option>
                                    </select>
                                    </label>

                                    <label>
                                        <span>手机号码 :</span>
                                        <input id="phone" type="text" name="phone" placeholder="请输入手机号码" />
                                    </label>

                                    <label>
                                        <span>身份证号码 :</span>
                                        <input id="idCardNum" type="text" name="idCardNum" placeholder="请输入身份证号码"/>
                                    </label>

                                    <label>
                                        <span>所在地 :</span>
                                        <input id="address" type="text" name="address" placeholder="请输入所在地,如：广州"/>
                                    </label>

                                    <label>
                                        <span>&nbsp;</span>
                                        <button id="driverAdding_btn" type="submit" class="btn btn-default">确定</button>
                                    </label>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="adm_carsModal">
                    <div class="modal-dialog modal-lg modal_position">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">车辆信息</h4>
                            </div>
                            <div class="modal-body">
                                <table id="admin_cars_tb" class="table">
                                    <thead>
                                    <tr>
                                        <th>车牌号码</th>
                                        <th>汽车品牌</th>
                                        <th>汽车颜色</th>
                                        <th>收费方案</th>
                                    </tr>
                                    </thead>
                                    <tbody id="admin_carsTBody">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="adm_timesModal">
                    <div class="modal-dialog modal-lg modal_position">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">停车记录</h4>
                            </div>
                            <div class="modal-body">
                                <table id="admin_times_tb" class="table">
                                    <thead>
                                    <tr>
                                        <th>车牌号码</th><th>开始时间</th><th>结束时间</th><th>总时长(h)</th>
                                    </tr>
                                    </thead>
                                    <tbody id="admin_timesTBody">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="adm_tokensModal">
                    <div class="modal-dialog modal-lg modal_position">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">卡券</h4>
                            </div>
                            <div class="modal-body">
                                <table id="admin_tokens_tb" class="table">
                                    <thead>
                                    <tr>
                                        <th>卡号</th><th>车牌号码</th><th>办理时间</th><th>到期时间</th>
                                    </tr>
                                    </thead>
                                    <tbody id="admin_tokensTBody">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="adm_fareModal">
                    <div class="modal-dialog modal-lg modal_position">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">停车费用（普通计费）</h4>
                            </div>
                            <div class="modal-body">
                                <table id="admin_fares_tb" class="table">
                                    <thead>
                                    <tr>
                                        <th>车牌号码</th>
                                        <th>开始时间</th>
                                        <th>结束时间</th>
                                        <th>总时长(h)</th>
                                        <th>费用</th>
                                    </tr>
                                    </thead>
                                    <tbody id="admin_faresTBody">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <table id="admin_driversTable" role="table" class='table table-bordered'>
                <thead>
                <tr>
                    <th>driverId</th><th>车主姓名</th><th>性别</th><th>手机号码</th><th>身份证号码</th><th>所在地</th><th>车辆信息</th><th>停车记录</th><th>停车费用</th><th>卡券</th><th>操作</th>
                </tr>
                </thead>
                <tbody id='admin_drivers_body'></tbody>
            </table>
        </div>
    </div>
    <div class="col-md-3">
        <div class="calendar">
            <div class="header">
                <a data-action="prev-month" href="javascript:void(0)" title="Previous Month"><i></i></a>
                <div class="text" data-render="month-year"></div>
                <a data-action="next-month" href="javascript:void(0)" title="Next Month"><i></i></a>
            </div>
            <div class="months" data-flow="left">
                <div class="month month-a">
                    <div class="render render-a"></div>
                </div>
                <div class="month month-b">
                    <div class="render render-b"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    var faresShown = false;
    var carsMsgShown = false;
    var parkingTimeShown = false;
    var tokensShown = false;

    $.ajax({
        type: 'get',
        url: '${pageContext.request.contextPath}/driverController/showDrivers',
        dataType: 'json',
        success: function (result) {
            if(result != null){
                for(var i = 0; i < result.length; i++){
                    var driver = result[i];
                    var tr = "<tr><th>"+driver.driverId+"</th><th>"+driver.driverName+"</th>\n" +
                        "<th>"+driver.gender+"</th><th>"+driver.phone+"</th>\n" +
                        "<th>"+driver.idCardNum+"</th><th>"+driver.address+"</th>\n" +
                        "<th><i data-toggle=\"modal\" data-target=\"#adm_carsModal\" onclick=\"adm_showCars(this)\" class=\"fa fa-car\"> </i></th>" +
                        "<th><i data-toggle=\"modal\" data-target=\"#adm_timesModal\" onclick=\"adm_showTimes(this)\" class=\"fa fa-clock\"> </i></th>\n" +
                        "<th><i data-toggle=\"modal\" data-target=\"#adm_fareModal\" onclick=\"adm_showFare(this)\" class=\"fa fa-university\"> </i></th>" +
                        "<th><i data-toggle=\"modal\" data-target=\"#adm_tokensModal\" onclick=\"adm_showTokens(this)\" class=\"fa fa-credit-card\"> </i></th>"+
                        "<th><a onclick='deleteDriver(this)' class=\"del\">删除</a></th></tr>";
                    $("#admin_drivers_body").append(tr);
                }
            }
        }
    });

    $("#driverAdding_btn").click(function () {
        // $("#admin_driverForm").on("submit",function (e) {
        //     var e = e;
        // });
        $("#driverAddingModal").modal("hide");

    });

    function deleteDriver(item) {
        var driverId = $(item).parents('tr').children()[0].innerHTML;
        $.ajax({
            type: 'get',
            url: '${pageContext.request.contextPath}/driverController/deleteDriver',
            data:{
                "driverId":driverId
            }
        });
        $(item).parents('tr').remove();
    }

    function adm_showCars(item) {
        var driverId = $(item).parents('tr').children()[0].innerHTML;
        if(!carsMsgShown){
            carsMsgShown = true;

            $.ajax({
                type: 'get',
                url: '${pageContext.request.contextPath}/carController/findCarsByDriverId.driverId',
                data: {
                    "driverId": driverId
                },
                dataType: 'json',
                success: function (result) {
                    if(result != null){

                        for (var i = 0; i < result.length; i++) {
                            var car = result[i];
                            var tr = "<tr id='"+car.carId+"'><th>"+car.licenseNum+"</th><th>"+car.brand+"</th><th>"+car.color+"</th></tr>";
                            $("#admin_carsTBody").append(tr);

                            if(car.formulaId == 1){
                                var th = "<th id='f1'>普通计费</th>";
                                $("#"+car.carId).append(th);
                            }else if(car.formulaId == 2){
                                var th = "<th id='f2'>月卡</th>";
                                $("#"+car.carId).append(th);
                            }else if(car.formulaId == 3){
                                var th = "<th id='f3'>年卡</th>";
                                $("#"+car.carId).append(th);
                            }else {
                                var th = "<th id='f4'>---</th>";
                                $("#"+car.carId).append(th);
                            }
                        }
                    }
                }
            })
        }
    }

    function adm_showTimes(item) {
        if (!parkingTimeShown){
            parkingTimeShown = true;
            var driverId = $(item).parents('tr').children()[0].innerHTML;

            $.ajax({
                type: 'get',
                url: '${pageContext.request.contextPath}/parkingTimeController/showTimes.driverId',
                data: {
                    "driverId": driverId
                },
                dataType: 'json',
                success: function (result) {
                    if(result != null){

                        for (var i = 0; i < result.length; i++) {
                            var time = result[i];

                            var begin = new Date(time.beginTime);
                            var b = begin.getFullYear()+"-"+(begin.getMonth()+1)+"-"+begin.getDate()+" "+begin.getHours()+":"+begin.getMinutes()+":"+begin.getSeconds();

                            var end = new Date(time.endTime);
                            var e = end.getFullYear()+"-"+(end.getMonth()+1)+"-"+end.getDate()+" "+end.getHours()+":"+end.getMinutes()+":"+end.getSeconds();
                            var tr = "<tr id='"+time.timeId+"'><th>"+time.licenseNum+"</th><th>"+b+"</th><th>"+e+"</th><th>"+time.totalTime+"</th></tr>";
                            $("#admin_timesTBody").append(tr);
                        }
                    }
                }
            })
        }
    }

    function adm_showTokens(item) {
        if(!tokensShown){
            var driverId = $(item).parents('tr').children()[0].innerHTML;
            $.ajax({
                type: 'get',
                url: '${pageContext.request.contextPath}/tokenController/showTokens.driverId',
                data: {
                    "driverId":driverId
                },
                dataType: 'json',
                success: function (result) {
                    tokensShown = true;
                    for (var i = 0;i < result.length;i++){
                        var token = result[i];
                        var begin = new Date(token.beginTime);
                        var b = begin.getFullYear()+"-"+(begin.getMonth()+1)+"-"+begin.getDate();
                        var end = new Date(token.endTime);
                        var e = end.getFullYear()+"-"+(end.getMonth()+1)+"-"+end.getDate();
                        var tr = "<tr><th>"+token.tokenNum+"</th><th>"+token.licenseNum+"</th><th>"+b+"</th><th>"+e+"</th></tr>";
                        $("#admin_tokensTBody").append(tr);
                    }
                }
            })
        }
    }

    function adm_showFare(item) {
        if (!faresShown){
            faresShown = true;
            var driverId = $(item).parents('tr').children()[0].innerHTML;

            $.ajax({
                type: 'get',
                url: '${pageContext.request.contextPath}/fareController/showFares',
                data: {
                    "driverId": driverId
                },
                dataType: 'json',
                success: function (result) {
                    if(result != null){

                        for (var i = 0; i < result.length; i++) {
                            var fare = result[i];

                            var begin = new Date(fare.beginTime);
                            var b = begin.getFullYear()+"-"+(begin.getMonth()+1)+"-"+begin.getDate()+" "+begin.getHours()+":"+begin.getMinutes()+":"+begin.getSeconds();

                            var end = new Date(fare.endTime);
                            var e = end.getFullYear()+"-"+(end.getMonth()+1)+"-"+end.getDate()+" "+end.getHours()+":"+end.getMinutes()+":"+end.getSeconds();
                            var tr = "<tr id='"+fare.fareId+"'><th>"+fare.licenseNum+"</th><th>"+b+"</th><th>"+e+"</th><th>"+fare.totalTime+"</th><th>"+fare.total+"</th></tr>";
                            $("#admin_faresTBody").append(tr);
                        }
                    }
                }
            })
        }
    }
</script>
</html>
