<%--
  Created by IntelliJ IDEA.
  User: 17974
  Date: 2021/4/18
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>设置我的资料</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
</head>
<body>
<jsp:useBean id="admin" class="cn.edu.niit.domain.Admin" scope="session"/>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">设置我的资料</div>
                <div class="layui-card-body" pad15>
                    <div class="layui-row">
                        <div class="layui-col-md2"
                             style="display: flex;justify-content: flex-end;">
                            <img class="layui-header"
                                 src="<jsp:getProperty name="admin" property="header"/>"/>
                        </div>
                        <div class="layui-col-md10">
                            <div class="layui-form" lay-filter="">
                                <div class="layui-form-item">
                                    <label class="layui-form-label">管理员名</label>
                                    <div class="layui-input-inline">
                                        <input type="text"
                                               name="username"
                                               value="<jsp:getProperty name="admin" property="username"/>"
                                               readonly
                                               class="layui-input">
                                    </div>
                                    <div class="layui-form-mid layui-word-aux">
                                        不可修改,用于后台登录名
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">昵称</label>
                                    <div class="layui-input-inline">
                                        <input type="text"
                                               name="nickname"
                                               value="<jsp:getProperty name="admin" property="reader"/>"
                                               lay-verify="nickname"
                                               autocomplete="off"
                                               placeholder="请输入昵称"
                                               class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">性别</label>
                                    <div class="layui-input-block">
                                        <input type="radio" name="sex"
                                               value="男"
                                               title="男"
                                                <%=admin.isSex() ? "checked" : ""%>/>
                                        <input type="radio" name="sex"
                                               value="女"
                                               title="女" <%=admin.isSex() ? "" : "checked"%>/>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">头像</label>
                                    <div class="layui-input-inline">
                                        <input name="avatar"
                                               lay-verify="required"
                                               id="LAY_avatarSrc"
                                               placeholder="图片地址"
                                               value="<jsp:getProperty name="admin" property="header"/>"
                                               class="layui-input">
                                    </div>
                                    <div class="layui-input-inline layui-btn-container"
                                         style="width: auto;">
                                        <button type="button"
                                                class="layui-btn layui-btn-primary"
                                                id="LAY_avatarUpload">
                                            <i class="layui-icon">&#xe67c;</i>上传图片
                                        </button>
                                        <button class="layui-btn layui-btn-primary"
                                                layadmin-event="avartatPreview">
                                            查看图片
                                        </button>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">手机</label>
                                    <div class="layui-input-inline">
                                        <input type="text"
                                               name="cellphone"
                                               value="<jsp:getProperty name="admin" property="cellPhone"/>"
                                               lay-verify="phone"
                                               autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <div class="layui-input-block">
                                        <button class="layui-btn"
                                                lay-submit
                                                lay-filter="setmyinfo">
                                            确认修改
                                        </button>
                                        <button type="reset"
                                                class="layui-btn layui-btn-primary">
                                            重新填写
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
