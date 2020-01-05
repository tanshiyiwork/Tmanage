<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/27
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<html>
<head>
    <title></title>
    <%@include file="../include/headInclude.jsp"%>
</head>
<body style="overflow:-moz-scrollbars-none;overflow-y:hidden">
<div id="wrapper">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="brand">
            <a href="#"><img src="../assets/img/logo-dark.png" alt="Klorofil Logo" class="img-responsive logo"></a>
        </div>
        <div class="container-fluid">
            <div class="navbar-btn">
                <button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
            </div>
            <div id="navbar-menu">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
                            <i class="lnr lnr-alarm"></i>
                            <span class="badge bg-danger">5</span>
                        </a>
                        <ul class="dropdown-menu notifications">
                            <li><a href="#" class="notification-item"><span class="dot bg-warning"></span>System space is almost full</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-danger"></span>You have 9 unfinished tasks</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-success"></span>Monthly report is available</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-warning"></span>Weekly meeting in 1 hour</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-success"></span>Your request has been approved</a></li>
                            <li><a href="#" class="more">See all notifications</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="lnr lnr-question-circle"></i> <span>Help</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Basic Use</a></li>
                            <li><a href="#">Working With Data</a></li>
                            <li><a href="#">Security</a></li>
                            <li><a href="#">Troubleshooting</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="../assets/img/user.png" class="img-circle" alt="Avatar"> <span><security:authentication property="principal.username"/></span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=basePath%>pages/personal.jsp" target="mainIframe"><i class="lnr lnr-user"></i> <span>个人中心</span></a></li>
                            <li><a href="#"><i class="lnr lnr-envelope"></i> <span>系统信息</span></a></li>
                            <li><a href="#"><i class="lnr lnr-cog"></i> <span>系统设置</span></a></li>
                            <li><a href="<%=basePath%>logout"><i class="lnr lnr-exit"></i> <span>注销</span></a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div id="sidebar-nav" class="sidebar">
        <div class="sidebar-scroll">
            <nav>
                <ul class="nav">
                    <li><a href="<%=basePath%>pages/elements.jsp" target="mainIframe" class="active"><i class="lnr lnr-home"></i> <span>主页</span></a></li>
                    <security:authorize access="hasAnyRole('SUP_ADMIN','ADMIN')">
                        <li>
                            <a href="#authManage" data-toggle="collapse" class="collapsed"><i class="lnr lnr-cog"></i> <span>权限管理</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                            <div id="authManage" class="collapse ">
                                <ul class="nav">
                                    <li><a href="<%=basePath%>pages/user.jsp" target="mainIframe" class="">用户管理</a></li>
                                    <li><a href="<%=basePath%>pages/dept.jsp" target="mainIframe" class="">部门管理</a></li>
                                    <li><a href="<%=basePath%>pages/role.jsp" target="mainIframe" class="">角色管理</a></li>
                                    <li><a href="<%=basePath%>pages/menu.jsp" target="mainIframe" class="">菜单管理</a></li>
                                </ul>
                            </div>
                        </li>
                    </security:authorize>
                    <li>
                        <a href="#systemManage" data-toggle="collapse" class="collapsed"><i class="lnr lnr-chart-bars"></i> <span>系统管理</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="systemManage" class="collapse ">
                            <ul class="nav">
                                <li><a href="<%=basePath%>pages/user.jsp" target="mainIframe" class="">字典管理</a></li>
                                <li><a href="<%=basePath%>pages/dept.jsp" target="mainIframe" class="">日志管理</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="<%=basePath%>pages/charts.jsp" target="mainIframe" class=""><i class="lnr lnr-chart-bars"></i> <span>图表</span></a></li>
                    <li><a href="<%=basePath%>pages/panels.jsp" target="mainIframe" class=""><i class="lnr lnr-file-empty"></i> <span>面板</span></a></li>
                    <li><a href="<%=basePath%>pages/notifications.jsp" target="mainIframe" class=""><i class="lnr lnr-alarm"></i> <span>通知</span></a></li>
                    <li><a href="<%=basePath%>pages/tables.jsp"  class=""><i class="lnr lnr-dice"></i> <span>Tables</span></a></li>
                    <li><a href="<%=basePath%>pages/typography.jsp" class=""><i class="lnr lnr-text-format"></i> <span>Typography</span></a></li>
                    <li><a href="<%=basePath%>pages/icons.jsp" class=""><i class="lnr lnr-linearicons"></i> <span>Icons</span></a></li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="main">
        <iframe name="mainIframe" frameborder="0" src="<%=basePath%>pages/elements.jsp" style="width: 100%;height: 100%;"></iframe>
    </div>
</div>
</body>
</html>
