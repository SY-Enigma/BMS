<%--
  Created by IntelliJ IDEA.
  User: 17974
  Date: 2021/4/20
  Time: 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>留言板</title>
    <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<form class="layui-form" action="">


    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">发表留言</label>
        <div class="layui-input-block" >
            <textarea placeholder="请输入留言内容" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" >
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">发表</button>
        </div>
    </div>
</form>
<table class="layui-hide" id="test"></table>

<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
<script>
    layui.use(['layedit','table'], function(){
        var layedit = layui.layedit;
        var table = layui.table;

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //创建动态表格
        table.render({
            elem: '#test'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'card_id', width:80, title: '用户ID', sort: true}
                ,{field:'detail', width:80, title: '内容'}
                ,{field:'public_date', width:80, title: '日期', sort: true}

            ]]
        });

    });
</script>
</body>
</html>