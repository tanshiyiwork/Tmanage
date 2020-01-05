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
        var globalTable = null;
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
        }
        $(function(){
            reloadTree();
        });
        function zTreeOnClick(event, treeId, treeNode) {
            var isParent = treeNode.isParent;
            reloadTableByCondition(treeNode.id,null);
        }
        function reloadTree() {
            $.fn.zTree.init($("#tree"), setting);
        }

        layui.use('table', function(){
            var table = layui.table;
            //第一个实例
            globalTable = table.render({
                elem: '#listTable'
                ,height: 390
                ,url: '/user/getUserInfoTable.do' //数据接口
                ,title:'用户信息表'
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
                    ,{field: 'username', title: '用户名', width:"15%"}
                    ,{field: 'phone', title: '手机号', width:"17%", sort: true}
                    ,{field: 'email', title: '邮箱', width:"20%"}
                    ,{field: 'sysDept.deptName', title: '部门', width: "15%",templet: function (d) {
                            if(d.sysDept == null){
                                return '';
                            }else{
                                return d.sysDept.deptName;
                            }
                        }}
                    ,{field: 'lockFlag', title: '状态', width: "10%",templet: function (d) {
                            if(d.lockFlag == '0'){
                                return "<span class='layui-badge layui-bg-blue' style='margin-top:5px;'>正常</span>";
                            }else {
                                return "<span class='layui-badge' style='margin-top:5px;'>锁定</span>";
                            }
                        }
                     }
                    ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:"15%"}
                ]]
            });

            //监听行工具事件
            table.on('tool(listTable)', function(obj){
                var data = obj.data;
                if(obj.event === 'del'){
                    delUser(data.userId);
                } else if(obj.event === 'edit'){
                    modifyUser(data.userId);
                }
            });
        });

        function reloadTableByCondition(deptId,username) {
            globalTable.reload({
                where: { //设定异步数据接口的额外参数，任意设
                    'sysDept.deptId': deptId
                    ,'username': username
                }
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        }
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
        function modifyUser(userId) {
            parent.layer.open({ //在父窗口打开
                type: 2,
                title: '编辑人员',
                closeBtn: 1, //显示关闭按钮
                anim: 2,
                area: ['750px', '430px'],
                shadeClose: false, //取消遮罩关闭
                content: '/user/toEditUser?userId='+userId
            });
        }

        function delUser(userId) {
            parent.layer.confirm('您确定要删除该用户吗?',{btn: ['确定', '取消'],title:"提示"}, function(index){
                $.ajax({
                    type: "post",
                    url: "/user/deleteUser",
                    data: {"userId":userId},
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

        function reloadTable() {
            $(".layui-laypage-btn")[0].click();
        }
        
        function searchUser() {
            var username = $("#username").val();
            if(username=='' || username == null || username == undefined){
                reloadTableByCondition(null,null);
            }else{
                reloadTableByCondition(null,username);
            }
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
        <div class="panel-body" style="height: 84%;">
            <div class="layui-row layui-col-space10">
                <div class="layui-col-md2">
                    <ul id="tree" class="ztree"></ul>
                </div>
                <div class="layui-col-md10">
                    <div class="layui-row">
                        <form class="layui-form" action="">
                            <div class="layui-form-item">
                                <div style="float: left">
                                    <input type="text" name="username" id="username" placeholder="请输入用户名" class="layui-input">
                                </div>
                                <div style="float: left;margin: 4px 28px;">
                                    <button type="button" class="layui-btn layui-btn-sm" onclick="searchUser()">搜索</button>
                                    <button type="reset" class="layui-btn layui-btn-sm">重置</button>
                                    <button type="button" class="layui-btn layui-btn-sm" onclick="addUser()">添加</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="layui-row">
                        <table id="listTable" lay-filter="listTable" width="100%"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
