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
    <jsp:include page="../include/headInclude.jsp"/>
    <script>
        layui.config({
            base: '${pageContext.request.contextPath}/plugins/module/'
        }).extend({
            treeSelect: 'treeSelect/treeSelect'
        });
        layui.use(['treeSelect','form'], function () {
            var treeSelect= layui.treeSelect;
            treeSelect.render({
                // 选择器
                elem: '#tree',
                // 数据
                data: '${pageContext.request.contextPath}/dept/getDetpTree',
                // 异步加载方式：get/post，默认get
                type: 'get',
                // 占位符
                placeholder: '修改默认提示信息',
                // 是否开启搜索功能：true/false，默认false
                search: true,
                // 点击回调
                click: function(d){
                    console.log(d);
                },
                // 加载完成后的回调函数
                success: function (d) {
                    console.log(d);
//                选中节点，根据id筛选
//                treeSelect.checkNode('tree', 3);

//                获取zTree对象，可以调用zTree方法
//                var treeObj = treeSelect.zTree('tree');
//                console.log(treeObj);

//                刷新树结构
//                treeSelect.refresh();
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
                            <input type="text" id="tree" lay-filter="tree" class="layui-input">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
