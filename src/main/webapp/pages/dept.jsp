<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../include/headInclude.jsp"%>
    <link href="../plugins/ztree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../plugins/ztree/js/jquery.ztree.core.js"></script>
    <script type="text/javascript">
        function addDept(){
            var parentId = $("#tempParentId").val();
            if(parentId == "" || parentId == undefined){
                layer.msg('请先选择组织树节点！');
            }else{
                parent.layer.open({ //在父窗口打开
                    type: 2,
                    skin: 'layui-layer-rim', //样式类名
                    title: '新增部门',
                    closeBtn: 1, //显示关闭按钮
                    anim: 2,
                    area: ['750px', '430px'],
                    shadeClose: false, //取消遮罩关闭
                    content: '${pageContext.request.contextPath}/pages/deptAdd.jsp',
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
        }
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
            $("#tempParentId").val(treeNode.id);
            initTable(treeNode.id);
        };

        function initTable(tid){
            $('#listTable').datagrid({
                url:'/dept/getDeptInfoTable',//地址
                queryParams: {
                    tid: tid
                },
                rownumbers:true,//序号 默认falese
                singleSelect:true,//单选 默认falese
                nowrap:false,//单行显示 默认true
                fitColumns:true,//宽度自适应 默认falese -- 此状态下，width大小为相对比例，但总长不可超过最小宽度
                pagination:true,//底部分页 默认falese
                pageSize:10,//单页条数 默认10
                columns:[[
                    {field:'deptCode',title:'部门编号',width:50,sortable:true},
                    {field:'deptName',title:'部门名称',width:80,sortable:true},
                    {field:'level',title:'层级',width:70,sortable:true},
                    {field:'sort',title:'排序',width:50,sortable:true},
                    {field:'createTime',title:'创建时间',width:50,sortable:true,formatter:function (value,row,index) {
                            var timestamp = new Date(value);
                            return timestamp.toLocaleString();
                    }},
                    {field:'id',title:'操作',width:70,formatter:function(value,rowData,rowIndex){
                            var c ="";
                            c+="<a href='javascript:void(0);' onclick='modifyBtn(\""+ rowData.deptId+ "\")'>编辑</a>";
                            c+="&nbsp;|&nbsp;<a href='javascript:void(0);' onclick='delBtn(\""+ rowData.deptId+ "\")'>删除</a>";
                            return c;
                        }}
                ]]
            });
        }

        function modifyBtn(deptId) {
            parent.layer.open({ //在父窗口打开
                type: 2,
                skin: 'layui-layer-rim', //样式类名
                title: '编辑部门',
                closeBtn: 1, //显示关闭按钮
                anim: 2,
                area: ['750px', '430px'],
                shadeClose: false, //取消遮罩关闭
                content: '/dept/toEditDept?deptId='+deptId
            });
        }

        function delBtn(deptId) {
            parent.layer.confirm('您确定要删除该部门信息吗?',{btn: ['确定', '取消'],title:"提示"}, function(index){
                $.ajax({
                    type: "post",
                    url: "/dept/deleteDeptInfo",
                    data: {"deptId":deptId},
                    dataType: "json",
                    async:false,
                    success:function(data) {
                        if(data.code == "200"){
                            layer.msg('删除成功', {icon: 1});
                        }else{
                            layer.msg('删除失败', {icon: 2});
                        }
                        reloadTable();
                        reloadTree();
                    }
                });
                parent.layer.close(index);
            });
        }

        function reloadTable() {
            $('#listTable').datagrid('reload');
        }

        function reloadTree() {
            $.fn.zTree.init($("#tree"), setting);
        }
    </script>
</head>
<body>
<div class="main-content">
    <div class="layui-row layui-col-space10">
        <div class="layui-col-md3">
            <div class="panel panel-headline">
                <div class="panel-body" style="height: 80%;">
                    <ul id="tree" class="ztree"></ul>
                </div>
            </div>
        </div>

        <div class="layui-col-md9">
            <div class="panel panel-headline">
                <div class="panel-body" style="height: 80%;">
                    <div class="layui-row">
                        <input type="hidden" id="tempParentId"/>
                        <button type="button" class="layui-btn" onclick="addDept()">
                            <i class="layui-icon">&#xe608;</i> 添加部门
                        </button>
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
