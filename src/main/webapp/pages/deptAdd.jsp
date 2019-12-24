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
    <%@include file="../include/headInclude.jsp"%>
    <link href="../plugins/ztree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="../plugins/ztree/js/jquery.ztree.core.js"></script>
    <style>
        .layui-form-label{
            width: 115px;
        }
    </style>
    <script>
        function showloading(t) {
            if (t) {//如果是true则显示loading
                console.log(t);
                //1。
                loading = layer.load(1, {
                    shade: [0.1, '#fff'] //0.1透明度的白色背景
                });
                //1.end
                //2.带文字的
                var loadingIndex = layer.load(2, { //icon支持传入0-2
                    shade: [0.5, 'gray'], //0.5透明度的灰色背景
                    content: '加载中...',
                    success: function (layero) {
                        layero.find('.layui-layer-content').css({
                            'padding-top': '39px',
                            'width': '60px'
                        });
                    }
                });
                //2 end
            }else{//如果是false则关闭loading
                console.log("关闭loading层:" + t);
                layer.closeAll('loading');
            }
        }
        function saveTableInfo() {
            $('#deptInfo').form('submit',{
                url:"/dept/saveOrUpdate.do",
                onSubmit:function(){
                    showloading(true);
                },
                success:function(data) {
                    showloading(false);
                    var obj = eval('(' + data + ')');
                    if(obj.code == "200"){
                        layer.alert('保存成功！');
                        window.parent.reloadTree();
                        closeCurFrame();
                    }else{
                        layer.alert('保存失败！');
                    }
                    window.parent.reloadTable();
                }
            });
            /*if($("#headInfo").form('validate')){
                $('#headInfo').form({
                    url:"/table/saveOrUpdate.do",
                    onSubmit: function(){
                        loading("正在保存");
                    },
                    success:function(data){
                        alert(data)
                    }
                });
            }*/
        }

        function closeCurFrame() {
            //关闭layer弹出层
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
        }
        $(function () {
            /*$("#tree").combotree({
                url: "/dept/getDetpTree",
                id: "id",
                text: "name",
                lines: true,
                onSelect: function (node) {
                    var parentId = node.id;
                    $("#parentId").val(parentId);
                }
            });*/
        });
        layui.use(['form'], function(){
            var form = layui.form;
            //监听提交
            form.on('submit(deptInfo)', function(data){
                alert(data.field);
                $.ajax({
                    type: 'post',
                    dataType:'json',
                    async: false,
                    data: data.field,
                    url:"/dept/saveOrUpdate.do",
                    success:function(data){
                        if(data.code == "200"){
                            closeIframe();
                        }else{
                            layer.msg('保存失败！');
                        }
                    },error:function () {
                        layer.msg('保存失败！');
                    }
                });
                return false;
                /*layer.alert(JSON.stringify(data.field), {
                    title: '最终的提交信息'
                });
                return false;*/
            });
        });

        //关闭当前弹出层
        function closeIframe() {
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        }
    </script>
</head>
<body>
<div class="main-content">
    <div class="layui-fluid">
        <div class="layui-row" style="">
            <div class="layui-col-md10">
                <form class="layui-form">
                    <div class="layui-form-item">
                        <label class="layui-form-label"><span style="color: red">*</span>机构名称：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="deptName" required  lay-verify="required" placeholder="请输入部门名称" class="layui-input">
                        </div>
                        <label class="layui-form-label"><span style="color: red">*</span>机构编码：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="deptCode" required  lay-verify="required" placeholder="请输入部门编号" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label"><span style="color: red">*</span>模块编号：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="moudleId" required  lay-verify="required" placeholder="请输入模块编号" class="layui-input">
                        </div>
                        <label class="layui-form-label"><span style="color: red">*</span>排序编号：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="sort" required  lay-verify="required|number" placeholder="请输入排序编号" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label"><span style="color: red">*</span>机构层级：</label>
                        <div class="layui-input-inline">
                            <input type="text" name="level" required  lay-verify="required|number" placeholder="请输入机构层级" class="layui-input">
                        </div>
                    </div>
                    <%--<div class="layui-form-item">
                        <label class="layui-form-label"><span style="color: red">*</span>上级机构：</label>
                        <div class="layui-input-inline">
                            <input id="tree" class="layui-input" required lay-verify="required">
                            <input type="hidden" name="parentId" id="parentId"/>
                        </div>
                    </div>--%>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <div style="margin-left: 25%">
                                <input class="layui-btn" type="button" lay-submit lay-filter="deptInfo" value="保存">
                                <button type="reset" class="layui-btn">重置</button>
                                <button class="layui-btn" type="button" onclick="closeIframe()">关闭</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
