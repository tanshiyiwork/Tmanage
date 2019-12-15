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
    <style>
        .layui-form-label{
            width: 115px;
        }
    </style>
    <script>
        $(function () {
            $("#tree").combotree({
                url: "/dept/getDetpTree",
                id: "id",
                text: "name",
                lines: true,
                onBeforeSelect: function (node) {
                    // debugger;
                    if (!$(this).tree('isLeaf', node.target)) {
                        $(this).combo("showPanel");
                        return false;
                    }

                }

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
                        <label class="layui-form-label"><span style="color: red">*</span>机构名称：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                        </div>
                        <label class="layui-form-label"><span style="color: red">*</span>排序编号：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label"><span style="color: red">*</span>上级机构：</label>
                        <div class="layui-input-inline">
                            <input id="tree" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <div style="margin-left: 25%">
                                <button class="layui-btn" lay-submit lay-filter="formDemo">确定</button>
                                <button type="reset" class="layui-btn layui-btn-primary">取消</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
