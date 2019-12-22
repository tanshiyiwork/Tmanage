<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../include/headInclude.jsp"%>
    <link href="../plugins/ztree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../plugins/ztree/js/jquery.ztree.core.js"></script>
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
            /*$("#tempPId").val(treeNode.id);
            $("#tempTId").val(treeNode.id);
            $("#tempTreeCode").val(treeNode.treecode);*/
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
                    {field:'createTime',title:'创建时间',width:50,sortable:true},
                    {field:'id',title:'操作',width:70,formatter:function(value,rowData,rowIndex){
                            var c ="";
                            c+="<a href='javascript:void(0);' onclick='modifyBtn(\""+ rowData.id+ "\")'>编辑</a>";
                            c+="&nbsp;|&nbsp;<a href='javascript:void(0);' onclick='delBtn(\""+ rowData.id+ "\")'>删除</a>";
                            return c;
                        }}
                ]]
            });
        }

        function modifyBtn(stId) {
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
                    content: '/table/toUpdateHeadInfo?stId='+stId,
                });
            });
        }

        function delBtn(stId) {

        }

        function addTableHead() {
            layer.open({
                type: 2,
                title: '新增节点',
                maxmin: false,
                shadeClose: false, //点击遮罩关闭层
                area : ['800px' , '520px'],
                content: './table_add.jsp',
                success: function(layero, index){
                    //注意这里的#sid是iframe页面中的一个标签id
                    var jquerySendHelloButton = $("#pId", layero.find("iframe")[0].contentWindow.document);
                    var tIdButton = $("#tId", layero.find("iframe")[0].contentWindow.document);
                    var treeCodeButton = $("#treeCode", layero.find("iframe")[0].contentWindow.document);
                    jquerySendHelloButton.attr("value", $("#tempPId").val());
                    tIdButton.attr("value", $("#tempTId").val());
                    treeCodeButton.attr("value", $("#tempTreeCode").val());
                }
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
    <div class="layui-row">
        <div class="layui-col-md3">
            <ul id="tree" class="ztree"></ul>
        </div>
        <div class="layui-col-md9">
            <div class="layui-row">
                <button type="button" class="layui-btn" onclick="addDept()">
                    <i class="layui-icon">&#xe608;</i> 添加部门
                </button>
            </div>
            <div class="layui-row">
                <table id="listTable" width="100%"></table>
            </div>
        </div>
    <%--<div class="layui-fluid">
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
    </div>--%>
    </div>
</div>
</body>
</html>
