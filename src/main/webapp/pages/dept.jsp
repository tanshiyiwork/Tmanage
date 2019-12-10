<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../include/headInclude.jsp"/>
    <!-- 表格操作列 -->
    <script type="text/html" id="demoTreeTableBar1">
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">修改</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>

    <!-- 表格状态列 -->
    <script type="text/html" id="demoTreeTableState1">
        <input type="checkbox" lay-filter="ckState" value="{{d.id}}" lay-skin="switch"
               lay-text="正常|锁定" {{d.state==0?'checked':''}}/>
    </script>

    <script type="text/javascript">
        layui.config({
            base: '../plugins/module/'
        }).extend({
            treeTable: 'treeTable/treeTable'
        }).use(['layer', 'util', 'treeTable'], function () {
            var $ = layui.jquery;
            var layer = layui.layer;
            var util = layui.util;
            var treeTable = layui.treeTable;
            var data = [{
                id: "1",
                name: "xxx",
                state: 0,
                createTime: "2019/11/18 10:44:00",
                children: [{
                    id: "1_1",
                    name: "xxx",
                    state: 0,
                    createTime: "2019/11/18 10:44:00",
                    children: [{
                        id: "1_1_1",
                        name: "xxx",
                        state: 0,
                        createTime: "2019/11/18 10:44:00",
                        children: []
                    }, {
                        id: "1_1_2",
                        name: "xxx",
                        state: 0,
                        createTime: "2019/11/18 10:44:00",
                        children: []
                    }, {
                        id: "1_1_3",
                        name: "xxx",
                        state: 0,
                        createTime: "2019/11/18 10:44:00",
                        children: []
                    }]
                }, {
                    id: "1_2",
                    name: "xxx",
                    state: 0,
                    createTime: "2019/11/18 10:44:00",
                    children: [{
                        id: "1_2_1",
                        name: "xxx",
                        state: 0,
                        createTime: "2019/11/18 10:44:00",
                        children: []
                    }, {
                        id: "1_2_2",
                        name: "xxx",
                        state: 0,
                        createTime: "2019/11/18 10:44:00",
                        children: []
                    }, {
                        id: "1_2_3",
                        name: "xxx",
                        state: 0,
                        createTime: "2019/11/18 10:44:00",
                        children: []
                    }]
                }, {
                    id: "1_3",
                    name: "xxx",
                    state: 0,
                    createTime: "2019/11/18 10:44:00",
                    children: []
                }]
            }, {
                id: "2",
                name: "xxx",
                state: 0,
                createTime: "2019/11/18 10:44:00",
                children: [{
                    id: "2_1",
                    name: "xxx",
                    state: 0,
                    createTime: "2019/11/18 10:44:00",
                    children: [{
                        id: "2_1_1",
                        name: "xxx",
                        state: 0,
                        createTime: "2019/11/18 10:44:00",
                        children: []
                    }, {
                        id: "2_1_2",
                        name: "xxx",
                        state: 0,
                        createTime: "2019/11/18 10:44:00",
                        children: []
                    }, {
                        id: "2_1_3",
                        name: "xxx",
                        state: 0,
                        createTime: "2019/11/18 10:44:00",
                        children: []
                    }]
                }, {
                    id: "2_2",
                    name: "xxx",
                    state: 0,
                    createTime: "2019/11/18 10:44:00",
                    children: []
                }, {
                    id: "2_3",
                    name: "xxx",
                    state: 0,
                    createTime: "2019/11/18 10:44:00",
                    children: []
                }]
            }, {
                id: "3",
                name: "xxx",
                state: 0,
                createTime: "2019/11/18 10:44:00",
                children: [{
                    id: "3_1",
                    name: "xxx",
                    state: 0,
                    createTime: "2019/11/18 10:44:00",
                    children: []
                }, {
                    id: "3_2",
                    name: "xxx",
                    state: 0,
                    createTime: "2019/11/18 10:44:00",
                    children: []
                }, {
                    id: "3_3",
                    name: "xxx",
                    state: 0,
                    createTime: "2019/11/18 10:44:00",
                    children: []
                }]
            }, {
                id: "4",
                name: "xxx",
                state: 0,
                createTime: "2019/11/18 10:44:00",
                children: []
            }, {
                id: "5",
                name: "xxx",
                state: 0,
                createTime: "2019/11/18 10:44:00",
                children: []
            }];

            // 渲染表格
            var insTb = treeTable.render({
                elem: '#demoTreeTable1',
                data: data,
                tree: {
                    iconIndex: 2
                },
                cols: [
                    {type: 'numbers'},
                    {type: 'checkbox'},
                    {field: 'id', title: 'ID'},
                    {field: 'name', title: 'name', width: 160},
                    {field: 'createTime', title: '创建时间', templet: function (d) {
                            return util.toDateString(d.createTime);
                        }, width: 180
                    },
                    {templet: '#demoTreeTableState1', title: '状态', width: 100},
                    {align: 'center', toolbar: '#demoTreeTableBar1', title: '操作', width: 120}
                ],
                style: 'margin-top:0;'
            });

            treeTable.on('tool(demoTreeTable1)', function (obj) {
                var event = obj.event;
                if (event == 'del') {
                    layer.msg('点击了删除', {icon: 1});
                } else if (event == 'edit') {
                    layer.msg('点击了修改', {icon: 1});
                }
            });

            // 全部展开
            $('#btnExpandAll').click(function () {
                insTb.expandAll();
            });

            // 全部折叠
            $('#btnFoldAll').click(function () {
                insTb.foldAll();
            });

            $('#btnExpand').click(function () {
                insTb.expand('2');
            });

            $('#btnFold').click(function () {
                insTb.fold('2');
            });

            $('#btnChecked').click(function () {
                insTb.expand('1_1_2');
                insTb.setChecked(['1_1_2']);
            });

            $('#btnSearch').click(function () {
                var keywords = $('#edtSearch').val();
                if (keywords) {
                    insTb.filterData(keywords);
                } else {
                    insTb.clearFilter();
                }
            });

            $('#btnClearSearch').click(function () {
                insTb.clearFilter();
            });

            $(document).on('mouseenter', '*[lay-tips]', function () {
                layer.tips($(this).attr('lay-tips'), this, {tips: [1, '#FF5722'], time: -1});
            }).on('mouseleave', '*[lay-tips]', function () {
                layer.closeAll('tips');
            });

            setTimeout(function () {
                $('body').children('.page-loading').hide();
                $('body').removeClass('page-no-scroll');
            }, 150);

        });

        function addDept(){
            layui.use('layer', function(){
                var layer = layui.layer;
                parent.layer.open({ //在父窗口打开
                    type: 2,
                    skin: 'layui-layer-rim', //样式类名
                    title: '新增部门',
                    closeBtn: 1, //显示关闭按钮
                    anim: 2,
                    area: ['893px', '500px'],
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
