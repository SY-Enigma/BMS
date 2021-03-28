<%--
  Created by IntelliJ IDEA.
  User: 17974
  Date: 2021/3/21
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body style="text-align: center;">
            <form name="form1" method=post>
                用&nbsp;户名：<input type="text" id="username" name="username"><br>
                密&nbsp;&nbsp;&nbsp;码：<input type="password" id="pwd" name="pwd"><br>
                再次密码：<input type="password" id="pwd_again" name="pwd_again"><br>
            <input type="button" onclick="userRegister()" value="注册"><br>
         <span id="tip_show_r"></span>
      </form>
</body>
</html>
