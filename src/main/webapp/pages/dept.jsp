<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../include/headInclude.jsp"%>
    <script type="text/javascript">
        function addDept(){
            layui.use('layer', function(){
                var layer = layui.layer;
                parent.layer.open({ //在父窗口打开
                    type: 2,
                    skin: 'layui-layer-rim', //样式类名
                    title: '新增部门',
                    closeBtn: 1, //显示关闭按钮
                    anim: 2,
                    area: ['750px', '430px'],
                    shadeClose: false, //取消遮罩关闭
                    content: '${pageContext.request.contextPath}/pages/deptAdd.jsp'
                });
            });
        }
    </script>
</head>
<body>
<div class="main-content">
    <div class="layui-fluid">
        <div class="layui-row" style="">
            <div class="layui-col-md10">
                <button type="button" class="layui-btn" onclick="addDept()">
                    <i class="layui-icon">&#xe608;</i> 添加部门
                </button>
            </div>
        </div>
        <div class="layui-row layui-col-space10" style="width: 100%;">
            <div class="layui-col-md10">
                <table id="demoTreeTable1"></table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
