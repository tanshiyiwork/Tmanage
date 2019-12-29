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
                ,height: 390
                ,url: '/role/getRoleInfoTable.do' //数据接口
                ,title:'角色数据表'
                ,event:true//开启隔行背景
                ,skin: 'line'
                ,parseData:function (result) {
                    return {
                        "code":result.code,//解析接口状态
                        "msg":result.message,//解析提示文本
                        "count":result.total,//解析数据长度
                        "data":result.rows//解析数据列表
                    }
                },request:{
                    pageName:"page"//页码参数名称，默认page
                    ,limitName:"pageSize"//每页数据量的参数名，默认limit
                }
                ,page: true //开启分页
                ,cols: [[ //表头
                    {field: 'id', title: '序号',type:"numbers",width:"8%", sort: true, fixed: 'left'}
                    ,{field: 'roleName', title: '角色名称', width:"15%"}
                    ,{field: 'roleCode', title: '角色标识', width:"22%", sort: true}
                    ,{field: 'roleDesc', title: '角色描述', width:"20%"}
                    ,{field: 'createTime', title: '创建时间', width: "20%",templet:function (row) {
                            return layui.util.toDateString(row.createTime);
                        }}
                    ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:"15%"}
                ]]
            });

            //监听行工具事件
            table.on('tool(test)', function(obj){
                var data = obj.data;
                console.log(obj)
                if(obj.event === 'del'){
                    delRole(data.roleId);
                } else if(obj.event === 'edit'){
                    modifyRole(data.roleId);
                }
            });
        });

        function modifyRole(roleId) {
            parent.layer.open({ //在父窗口打开
                type: 2,
                skin: 'layui-layer-rim', //样式类名
                title: '编辑部门',
                closeBtn: 1, //显示关闭按钮
                anim: 2,
                area: ['750px', '430px'],
                shadeClose: false, //取消遮罩关闭
                content: '/role/toEditRole?roleId='+roleId
            });
        }

        function delRole(roleId) {
            parent.layer.confirm('您确定要删除该角色信息吗?',{btn: ['确定', '取消'],title:"提示"}, function(index){
                $.ajax({
                    type: "post",
                    url: "/role/deleteRoleInfo",
                    data: {"roleId":roleId},
                    dataType: "json",
                    async:false,
                    success:function(data) {
                        if(data.code == "200"){
                            layer.msg('删除成功', {icon: 1,time:2000});
                        }else{
                            layer.msg('删除失败', {icon: 2,time:2000});
                        }
                        reloadTable();
                    }
                });
                parent.layer.close(index);
            });
        }

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
                    var parentObj = $(layero).find("iframe")[0].contentWindow.document.getElementById("parentId");
                    $(parentObj).val(parentId);
                }
            });
        }

        function reloadTable() {
            $(".layui-laypage-btn")[0].click();
        }
    </script>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
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
