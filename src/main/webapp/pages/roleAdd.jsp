<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/26
  Time: 22:27
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
</head>
<body>
<div class="main-content">
    <div class="layui-fluid">
        <form class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label"><span style="color: red">*</span>机构名称：</label>
                <div class="layui-input-inline">
                    <input type="text" name="deptName" value="${sysDept.deptName}" required  lay-verify="required" placeholder="请输入部门名称" class="layui-input">
                </div>
                <label class="layui-form-label"><span style="color: red">*</span>机构编码：</label>
                <div class="layui-input-inline">
                    <input type="text" name="deptCode" value="${sysDept.deptCode}" required  lay-verify="required" placeholder="请输入部门编号" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span style="color: red">*</span>模块编号：</label>
                <div class="layui-input-inline">
                    <input type="text" name="moudleId" value="${sysDept.moudleId}" required  lay-verify="required" placeholder="请输入模块编号" class="layui-input">
                </div>
                <label class="layui-form-label"><span style="color: red">*</span>排序编号：</label>
                <div class="layui-input-inline">
                    <input type="text" name="sort" value="${sysDept.sort}" required  lay-verify="required|number" placeholder="请输入排序编号" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span style="color: red">*</span>机构层级：</label>
                <div class="layui-input-inline">
                    <input type="text" name="level" value="${sysDept.level}" required  lay-verify="required|number" placeholder="请输入机构层级" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <div style="margin-left: 25%">
                        <input class="layui-btn" type="button" lay-submit lay-filter="deptInfo" value="保存">
                        <button type="reset" class="layui-btn">重置</button>
                        <button class="layui-btn" type="button" onclick="closeIframe()">关闭</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
