<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/26
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%@include file="../include/headInclude.jsp"%>
    <script type="text/javascript">
        layui.use('table', function(){
            var table = layui.table;
            //第一个实例
            table.render({
                elem: '#demo'
                ,height: 312
                ,url: '/demo/table/user/' //数据接口
                ,page: true //开启分页
                ,cols: [[ //表头
                    {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                    ,{field: 'username', title: '用户名', width:80}
                    ,{field: 'sex', title: '性别', width:80, sort: true}
                    ,{field: 'city', title: '城市', width:80}
                    ,{field: 'sign', title: '签名', width: 177}
                    ,{field: 'experience', title: '积分', width: 80, sort: true}
                    ,{field: 'score', title: '评分', width: 80, sort: true}
                    ,{field: 'classify', title: '职业', width: 80}
                    ,{field: 'wealth', title: '财富', width: 135, sort: true}
                ]]
            });

        });
        
        function addRole() {
            parent.layer.open({ //在父窗口打开
                type: 2,
                title: '新增角色',
                closeBtn: 1, //显示关闭按钮
                anim: 2,
                area: ['750px', '450px'],
                shadeClose: false, //取消遮罩关闭
                content: '${pageContext.request.contextPath}/pages/roleAdd.jsp',
                success: function(layero, index){
                    /*var jquerySendHelloButton = $("#pId", layero.find("iframe")[0].contentWindow.document);
                    var tIdButton = $("#tId", layero.find("iframe")[0].contentWindow.document);
                    var treeCodeButton = $("#treeCode", layero.find("iframe")[0].contentWindow.document);
                    jquerySendHelloButton.attr("value", $("#tempPId").val());
                    tIdButton.attr("value", $("#tempTId").val());
                    treeCodeButton.attr("value", $("#tempTreeCode").val());*/
                    var parentObj = $(layero).find("iframe")[0].contentWindow.document.getElementById("parentId");
                    $(parentObj).val(parentId);
                }
            });
        }
    </script>
</head>
<body>
<div class="main-content">
    <div class="panel panel-headline">
        <div class="panel-body" style="height: 80%;">
            <div class="layui-row">
                <form class="layui-form" action="">
                    <div class="layui-form-item">
                        <div style="float: left">
                            <input type="text" name="title" placeholder="请输入标题" class="layui-input">
                        </div>
                        <div style="float: left;margin: 4px 28px;">
                            <button type="button" class="layui-btn layui-btn-sm">搜索</button>
                            <button type="button" class="layui-btn layui-btn-sm">重置</button>
                            <button type="button" class="layui-btn layui-btn-sm" onclick="addRole()">添加</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="layui-row">
                <table id="demo" lay-filter="test"></table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
