<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false" %>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/vendor/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/vendor/linearicons/style.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/vendor/chartist/css/chartist-custom.css">
<!-- EASYUI -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>plugins/easyui-1.7.0/themes/bootstrap/easyui.css">
<!-- MAIN CSS -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/css/main.css">
<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/css/demo.css">
<!-- ICONS -->
<link rel="apple-touch-icon" type="image/png" sizes="76x76" href="<%=basePath%>assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96" href="<%=basePath%>assets/img/favicon.png">
<!-- LAYUI -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>plugins/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>plugins/layui/css/modules/layer/default/layer.css">
<!-- Javascript -->
<script type="text/javascript" src="<%=basePath%>assets/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/vendor/chartist/js/chartist.min.js"></script>
<script type="text/javascript" src="<%=basePath%>assets/scripts/klorofil-common.js"></script>

<script type="text/javascript" src="<%=basePath%>plugins/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>plugins/layui/lay/modules/layer.js"></script>

<script type="text/javascript" src="<%=basePath%>plugins/easyui-1.7.0/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>plugins/easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>