<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/10
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../include/headInclude.jsp"%>
    <script>
        $(function () {
            $('#tree').combotree({
                url: <%=path%>+"dept/getDetpTree",
                required: true
            });
        });
    </script>
</head>
<body>
<div class="main-content">
    <div class="layui-fluid">
        <div class="layui-row" style="">
            <div class="layui-col-md10">
                <form class="layui-form" action="">
                    <div class="layui-form-item">
                        <label class="layui-form-label">输入框</label>
                        <div class="layui-input-block">
                            <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">密码框</label>
                        <div class="layui-input-inline">
                            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">测试</label>
                        <div class="layui-input-block">
                            <input id="tree" class="layui-input">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
