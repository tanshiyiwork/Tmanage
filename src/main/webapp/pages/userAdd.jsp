<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/29
  Time: 18:34
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
        $(function () {
            initDeptCommboTree();
            initRoleCommboBox();
        });
        function initDeptCommboTree() {
            $("#deptTree").combotree({
                url: "/dept/getDetpTree",
                method:"post",
                id: "id",
                text: "name",
                lines: true,
                panelHeight: 'auto', //高度自适应
                panelWidth: 'auto',//宽度自适应
                onSelect:function (node) {
                    $("#deptId").val(node.id);
                },onLoadSuccess:function (node, data) {
                    var deptId = '${sysUser.sysDept.deptId}';
                    var lockFlag = '${sysUser.lockFlag}';
                    if(deptId != ''){
                        $('#deptTree').combotree('setValue',deptId);
                    }
                    if(lockFlag != ''){
                        $("#lockFlag").val(lockFlag);
                        if(lockFlag == '1'){
                            $("#lockInput").prop("checked", false);
                            layui.form.render();
                        }
                    }else{
                        $("#lockFlag").val('0');
                    }
                }

            });
        }

        function initRoleCommboBox() {
            $("#roleBox").combobox({
                url:"/role/getRoleCommbo",//获取数据
                method : "post",
                valueField: 'id',
                textField: 'text',
                multiple:true,
                panelHeight: 'auto', //高度自适应
                onChange:function(){
                    var value =  $("#roleBox").combobox('getValues');
                    $("#roleIds").val(value);
                },onLoadSuccess:function () {
                    var roleIds = '${roleIds}';
                    if(roleIds!=''){
                        var idsObj = JSON.parse(roleIds);
                        $('#roleBox').combobox('setValues', idsObj);
                    }
                }
            })
        }
        layui.use(['form'], function(){
            var form = layui.form;
            form.on('switch(oneChoose)', function (data) {
                if(data.elem.checked){//正常
                    $("#lockFlag").val("0");
                }else{//锁定
                    $("#lockFlag").val("1");
                }
                console.log(data.elem.checked); //是否被选中，true或者false
                console.log(data.value); //复选框value值，也可以通过data.elem.value得到
            });
            //监听提交
            form.on('submit(roleInfo)', function(data){
                $.ajax({
                    type: 'post',
                    dataType:'json',
                    async: true,
                    data: data.field,
                    url:"/user/saveOrUpdate.do",
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
            <input type="hidden" name="userId" value="${sysUser.userId}"/>
            <div class="layui-form-item">
                <label class="layui-form-label"><span style="color: red">*</span>用户名：</label>
                <div class="layui-input-inline">
                    <input type="text" name="username" value="${sysUser.username}" required  lay-verify="required" placeholder="请输入用户名" class="layui-input">
                </div>
                <label class="layui-form-label"><span style="color: red">*</span>邮箱：</label>
                <div class="layui-input-inline">
                    <input type="text" name="email" value="${sysUser.email}" required  lay-verify="required" placeholder="请输入邮箱" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span style="color: red">*</span>手机号：</label>
                <div class="layui-input-inline">
                    <input type="text" name="phone" value="${sysUser.phone}" required  lay-verify="required" placeholder="请输入手机号" class="layui-input">
                </div>
                <label class="layui-form-label">部门：</label>
                <div class="layui-input-inline">
                    <input class="easyui-combotree" id="deptTree" style="width:200px;">
                    <input type="hidden" name="sysDept.deptId" id="deptId" value="${sysUser.sysDept.deptId}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">角色：</label>
                <div class="layui-input-inline">
                    <input id="roleBox" class="easyui-combobox">
                    <input type="hidden" id="roleIds" name="roleIds" value="${roleIds}">
                </div>
                <label class="layui-form-label">状态：</label>
                <div class="layui-input-inline">
                    <input type="checkbox" id="lockInput" checked="" lay-skin="switch" lay-filter="oneChoose" name="open" lay-text="正常|锁定">
                    <input type="hidden" id="lockFlag" name="lockFlag">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <div style="margin-left: 25%">
                        <input class="layui-btn" type="button" lay-submit lay-filter="roleInfo" value="保存">
                        <button class="layui-btn" type="button" onclick="closeIframe()">关闭</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
