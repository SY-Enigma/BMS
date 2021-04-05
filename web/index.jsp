<%--
  Created by IntelliJ IDEA.
  User: 17974
  Date: 2021/3/2
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>图书管理系统</title>
    <link rel="stylesheet" href="./layui/css/layui.css" media="all">
    <style>
        html, body {
            width: 100%;
            height: 100%;

        }

        .login {
            position: relative;
            width: 100%;
            height: 100%;
        }

        .login-layout {
            position: absolute;
            width: 350px;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            background: rgba(0, 150, 136, 0.1);
            padding: 100px 80px 80px 50px;
        }

        .logo {
            font-size: 30px;
            width: 100%;
            text-align: center;
            margin-bottom: 10px;
        }

    </style>
</head>
<body>

<%@include file="alert.jsp" %>

<div class="login" align="center">
    <div class="login-layout">
        <form class="layui-form" method="post"
              action="/login">
            <div class="layui-form-item">
                <label class="layui-form-label logo">
                    图书馆
                </label>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"
                       style="text-align: center">用户名
                </label>
                <div class="layui-input-block">
                    <input type="text" name="username"
                           placeholder="请输入"
                           autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label" style="text-align:
                center">密码</label>
                <div class="layui-input-block">
                    <input type="password" name="password"
                           placeholder="请输入"
                           autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-input-block">
                <input type="radio" name="role" value="0"
                       title="管理员">
                <input type="radio" name="role" value="1"
                       title="用户" checked>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <div class="layui-btn-group">
                        <button class="layui-btn" style="margin-left: 10px" lay-submit lay-filter="formDemo">立即登录
                        </button>

                    </div>
                </div>
            </div>
            <div style="float: left">
                <button class="layui-btn layui-btn-primary" ><a href="register.jsp">新用户注册</a>
                </button>
            </div>
            <div style="float: right">
                <button class="layui-btn layui-btn-primary" ><a href="ForgetPassword.jsp">忘记密码？</a>
                </button>
            </div>
            <!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
        </form>
    </div>
</div>

<script src="/layui/layui.js"></script>
<script>
    layui.use('form', function () {
        var form = layui.form;


        //各种基于事件的操作，下面会有进一步介绍
    });
</script>
</body>
</html>