<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/5
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../include/headInclude.jsp"%>
    <script type="text/javascript">
        layui.use(['form','element'], function(){
            var form = layui.form;
            //监听提交
            form.on('submit(updatePassword)', function(data){
                var newPassword1 = $("#newPassword1").val();
                var newPassword2 = $("#newPassword2").val();
                if(newPassword1 == newPassword2){
                    $.ajax({
                        type: 'post',
                        dataType:'json',
                        async: true,
                        data: data.field,
                        url:"/user/updatePassword.do",
                        beforeSend: function () {//这里是全局事件
                            showloading(true);
                        },
                        success:function(data){
                            var msg = "";
                            if(data.code == "200"){
                                msg = "修改成功！";
                            }else if(data.code == "300"){
                                msg = "原密码输入有误，请核对！";
                            }else{
                                msg = "修改失败！";
                            }
                            showloading(false);
                            layer.msg(msg,{icon:1,time:2000});
                        },error:function () {
                            showloading(false);
                            layer.msg('修改失败！',{icon:1,time:2000});
                        }
                    });
                }else{
                    layer.msg('密码输入不一致，请核对！',{icon:1,time:2000});
                }
                return false;
            });
        });
    </script>
</head>
<body>
<div class="main-content">
    <div class="layui-tab">
        <ul class="layui-tab-title">
            <li class="layui-this">个人信息</li>
            <li>修改密码</li>
            <li>修改邮箱</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <form class="layui-form" action="">
                    <div class="layui-form-item">
                        <label class="layui-form-label" style="width: 10%;">用户名：</label>
                        <div class="layui-input-block">
                            <input style="width: 30%;" type="text" name="username" class="layui-input" value="${sysUser.username}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label" style="width: 10%;">手机号：</label>
                        <div class="layui-input-block">
                            <input style="width: 30%;" type="tel" lay-verify="phone" name="phone" class="layui-input" value="${sysUser.phone}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label" style="width: 10%;">用户邮箱：</label>
                        <div class="layui-input-block">
                            <input style="width: 30%;" type="text" readonly="readonly" name="email" lay-verify="email" class="layui-input layui-disabled" value="${sysUser.email}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label" style="width: 10%;">所属部门：</label>
                        <div class="layui-input-block">
                            <input style="width: 30%;" type="text" readonly="readonly" name="sysDept.deptName" class="layui-input layui-disabled" value="${sysUser.sysDept.deptName}">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button type="submit" class="layui-btn" lay-submit="" lay-filter="userInfo">提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="layui-tab-item">
                <form class="layui-form">
                    <input type="hidden" name="userId" value="${sysUser.userId}"/>
                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 10%;"><span style="color: red">*</span>原密码：</label>
                    <div class="layui-input-block">
                        <input style="width: 30%;" type="text" name="password" lay-verify="required" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 10%;"><span style="color: red">*</span>密码：</label>
                    <div class="layui-input-block">
                        <input style="width: 30%;" type="password" id="newPassword1" lay-verify="required" name="newPassword" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 10%;"><span style="color: red">*</span>确认密码：</label>
                    <div class="layui-input-block">
                        <input style="width: 30%;" type="password" id="newPassword2" lay-verify="required" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn" lay-submit lay-filter="updatePassword">修改</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
                </form>
            </div>

            <div class="layui-tab-item">
                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 10%;"><span style="color: red">*</span>邮箱：</label>
                    <div class="layui-input-block">
                        <input style="width: 30%;" type="text" name="oldPassWord" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 10%;"><span style="color: red">*</span>验证码：</label>
                    <div class="layui-input-block">
                        <input style="width: 30%;" type="tel" lay-verify="phone" name="phone" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 10%;"><span style="color: red">*</span>密码：</label>
                    <div class="layui-input-block">
                        <input style="width: 30%;" type="text" name="email" lay-verify="email" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn" lay-submit="" lay-filter="userEmail">提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
