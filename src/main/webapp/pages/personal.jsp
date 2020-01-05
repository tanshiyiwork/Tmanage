<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/5
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../include/headInclude.jsp"%>
    <script type="text/javascript">
        layui.use('element', function(){
            /*var $ = layui.jquery
                ,element = layui.element;*/ //Tab的切换功能，切换事件监听等，需要依赖element模块

            //触发事件
            /*var active = {
                tabAdd: function(){
                    //新增一个Tab项
                    element.tabAdd('demo', {
                        title: '新选项'+ (Math.random()*1000|0) //用于演示
                        ,content: '内容'+ (Math.random()*1000|0)
                        ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
                    })
                }
                ,tabDelete: function(othis){
                    //删除指定Tab项
                    element.tabDelete('demo', '44'); //删除：“商品管理”


                    othis.addClass('layui-btn-disabled');
                }
                ,tabChange: function(){
                    //切换到指定Tab项
                    element.tabChange('demo', '22'); //切换到：用户管理
                }
            };*/

            /*$('.site-demo-active').on('click', function(){
                var othis = $(this), type = othis.data('type');
                active[type] ? active[type].call(this, othis) : '';
            });*/

            //Hash地址的定位
            /*var layid = location.hash.replace(/^#test=/, '');
            element.tabChange('test', layid);

            element.on('tab(test)', function(elem){
                location.hash = 'test='+ $(this).attr('lay-id');
            });*/

        });
    </script>
</head>
<body>
<div class="main-content">
    <div class="layui-tab">
        <ul class="layui-tab-title">
            <li class="layui-this">个人信息</li>
            <li>修改密码</li>
            <li>修改邮箱</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                1. 高度默认自适应，也可以随意固宽。
                <br>2. Tab进行了响应式处理，所以无需担心数量多少。
            </div>
            <div class="layui-tab-item">内容2</div>
            <div class="layui-tab-item">内容3</div>
        </div>
    </div>
</div>
</body>
</html>
