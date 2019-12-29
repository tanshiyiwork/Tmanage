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
    <script type="text/javascript">
        layui.use(['form'], function(){
            var form = layui.form;
            //监听提交
            form.on('submit(roleInfo)', function(data){
                $.ajax({
                    type: 'post',
                    dataType:'json',
                    async: true,
                    data: data.field,
                    url:"/role/saveOrUpdate.do",
                    beforeSend: function () {//这里是全局事件
                        showloading(true);
                    },
                    success:function(data){
                        var msg = "";
                        if(data.code == "200"){
                            msg = "保存成功！";
                            top.window["mainIframe"].reloadTable();
                        }else if(data.code == "300"){
                            msg = "修改成功！";
                            top.window["mainIframe"].reloadTable();
                        }else{
                            msg = "'保存失败！'";
                        }
                        //closeIframe();
                        showloading(false);
                        layer.msg(msg,{icon:1,time:2000});
                    },error:function () {
                        showloading(false);
                        layer.msg('保存失败！',{icon:1,time:2000});
                    }
                });
                return false;
            });
        });
    </script>
</head>
<body>
<div class="main-content">
    <div class="layui-fluid">
        <form class="layui-form">
            <input type="hidden" name="roleId" value="${sysRole.roleId}"/>
            <div class="layui-form-item">
                <label class="layui-form-label"><span style="color: red">*</span>角色名称：</label>
                <div class="layui-input-inline">
                    <input type="text" name="roleName" value="${sysRole.roleName}" required  lay-verify="required" placeholder="请输入角色名称" class="layui-input">
                </div>
                <label class="layui-form-label"><span style="color: red">*</span>角色标识：</label>
                <div class="layui-input-inline">
                    <input type="text" name="roleCode" value="${sysRole.roleCode}" required  lay-verify="required" placeholder="请输入角色标识" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span style="color: red">*</span>角色介绍：</label>
                <div class="layui-input-inline">
                    <input type="text" name="roleDesc" value="${sysRole.roleDesc}" required  lay-verify="required" placeholder="请输入角色介绍" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <div style="margin-left: 25%">
                        <input class="layui-btn" type="button" lay-submit lay-filter="roleInfo" value="保存">
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
