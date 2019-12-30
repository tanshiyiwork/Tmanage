<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/29
  Time: 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../include/headInclude.jsp"%>
    <link href="../plugins/ztree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../plugins/ztree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript">
        var setting = {
            async: {
                enable: true,
                url:"/dept/getDetpZtree"
            },
            view: {
                dblClickExpand: false,
                selectedMulti: false,
                showLine: true,
                showIcon: true
            },
            check: {
                enable: true,
                chkStyle: "checkbox",
                chkboxType: { "Y": "s", "N": "s" }
            },
            data: {
                simpleData: {
                    enable: true,
                    dKey: "id",
                    pIdKey: "pid",
                    rootPId: 0
                }
            },
            callback: {
                onClick: zTreeOnClick,
                onAsyncSuccess:zTreeOnAsyncSuccess
            },
        };
        //ztree异步加载完毕展开所有节点
        function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
            var treeObj = $.fn.zTree.getZTreeObj("tree");
            treeObj.expandAll(true);
        };
        $(function(){
            reloadTree();
        });
        function zTreeOnClick(event, treeId, treeNode) {

        };
        function reloadTree() {
            $.fn.zTree.init($("#tree"), setting);
        }

        layui.use('table', function(){
            var table = layui.table;
            //第一个实例
            table.render({
                elem: '#listTable'
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
        function addUser() {
            parent.layer.open({ //在父窗口打开
                type: 2,
                title: '新增用户',
                closeBtn: 1, //显示关闭按钮
                anim: 2,
                area: ['750px', '450px'],
                shadeClose: false, //取消遮罩关闭
                content: '${pageContext.request.contextPath}/pages/userAdd.jsp',
                success: function(layero, index){
                    /*var parentObj = $(layero).find("iframe")[0].contentWindow.document.getElementById("parentId");
                    $(parentObj).val(parentId);*/
                }
            });
        }
    </script>
</head>
<body>
<div class="main-content">
    <div class="panel panel-headline">
        <div class="panel-body" style="height: 80%;">
            <div class="layui-row layui-col-space10">
                <div class="layui-col-md2">
                    <ul id="tree" class="ztree"></ul>
                </div>
                <div class="layui-col-md10">
                    <div class="layui-row">
                        <form class="layui-form" action="">
                            <div class="layui-form-item">
                                <div style="float: left">
                                    <input type="text" name="title" placeholder="请输入标题" class="layui-input">
                                </div>
                                <div style="float: left;margin: 4px 28px;">
                                    <button type="button" class="layui-btn layui-btn-sm">搜索</button>
                                    <button type="button" class="layui-btn layui-btn-sm">重置</button>
                                    <button type="button" class="layui-btn layui-btn-sm" onclick="addUser()">添加</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="layui-row">
                        <table id="listTable" width="100%"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
