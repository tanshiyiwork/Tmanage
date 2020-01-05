<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/5
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>403</title>
    <script type="text/javascript">
        function gotoLogin() {
            top.location.href="../login.jsp";
        }
    </script>
</head>
<body>
<div>
    <h1>认证过期,无法访问系统资源,请重新登录</h1>
    <button onclick="gotoLogin()">点击跳转登录页面</button>
</div>
</body>
</html>
