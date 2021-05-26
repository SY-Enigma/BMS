<%--
  Created by IntelliJ IDEA.
  User: 17974
  Date: 2021/5/26
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>

    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
</head>

<body>
<div class="layui-container" style="margin-top: 20px">
    <div class="layui-row">
        <form class="layui-form" action="">
            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-block">
                    <input type="text" name="title" required  lay-verify="required" placeholder="请输入书名"
                           autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-block">
                    <input type="password" name="pwd" required  lay-verify="required" placeholder="请输入书名"
                           autocomplete="off" class="layui-input">
                </div>
            </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">再次密码</label>
                    <div class="layui-input-block">
                        <input type="password" name="pwd" required  lay-verify="required" placeholder="请输入书名"
                               autocomplete="off" class="layui-input">
                    </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">昵称</label>
                <div class="layui-input-inline">
                    <input type="text" name="author" required lay-verify="required"
                           placeholder="请输入作者" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">头像</label>
                <div class="layui-input-block">
                    <input type="text" name="position" required  lay-verify="required"
                           placeholder="请输入类别"
                           autocomplete="off" class="layui-input">
                </div>
            </div>


            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">描述</label>
                <div class="layui-input-block">
                    <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="addBook" >添加图书</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(addUser)', function(obj){
            $.post("/addUser",obj.field,function (d) {
                console.log("添加成功",d);
                if (d.code !=200){
                    layer.msg(d.msg);
                }else {
                    var  index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                }
            })
        });
    });
</script>
</body>
</html>
