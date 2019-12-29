<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/27
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title></title>
    <jsp:include page="../include/headInclude.jsp"/>
    <script>
        $(function() {
            // headline charts
            data = {
                labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
                series: [
                    [23, 29, 24, 40, 25, 24, 35],
                    [14, 25, 18, 34, 29, 38, 44],
                ]
            };

            options = {
                height: 300,
                showArea: true,
                showLine: false,
                showPoint: false,
                fullWidth: true,
                axisX: {
                    showGrid: false
                },
                lineSmooth: false,
            };

            new Chartist.Line('#headline-chart', data, options);


            // visits trend charts
            data = {
                labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                series: [{
                    name: 'series-real',
                    data: [200, 380, 350, 320, 410, 450, 570, 400, 555, 620, 750, 900],
                }, {
                    name: 'series-projection',
                    data: [240, 350, 360, 380, 400, 450, 480, 523, 555, 600, 700, 800],
                }]
            };

            options = {
                fullWidth: true,
                lineSmooth: false,
                height: "270px",
                low: 0,
                high: 'auto',
                series: {
                    'series-projection': {
                        showArea: true,
                        showPoint: false,
                        showLine: false
                    },
                },
                axisX: {
                    showGrid: false,

                },
                axisY: {
                    showGrid: false,
                    onlyInteger: true,
                    offset: 0,
                },
                chartPadding: {
                    left: 20,
                    right: 20
                }
            };

            new Chartist.Line('#visits-trends-chart', data, options);


            // visits chart
            data = {
                labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
                series: [
                    [6384, 6342, 5437, 2764, 3958, 5068, 7654]
                ]
            };

            options = {
                height: 300,
                axisX: {
                    showGrid: false
                },
            };

            new Chartist.Bar('#visits-chart', data, options);


            // real-time pie chart
            var sysLoad = $('#system-load').easyPieChart({
                size: 130,
                barColor: function(percent) {
                    return "rgb(" + Math.round(200 * percent / 100) + ", " + Math.round(200 * (1.1 - percent / 100)) + ", 0)";
                },
                trackColor: 'rgba(245, 245, 245, 0.8)',
                scaleColor: false,
                lineWidth: 5,
                lineCap: "square",
                animate: 800
            });

            var updateInterval = 3000; // in milliseconds

            setInterval(function() {
                var randomVal;
                randomVal = getRandomInt(0, 100);

                sysLoad.data('easyPieChart').update(randomVal);
                sysLoad.find('.percent').text(randomVal);
            }, updateInterval);

            function getRandomInt(min, max) {
                return Math.floor(Math.random() * (max - min + 1)) + min;
            }

        });
    </script>
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
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="../assets/img/user.png" class="img-circle" alt="Avatar"> <span>Samuel</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><i class="lnr lnr-user"></i> <span>My Profile</span></a></li>
                            <li><a href="#"><i class="lnr lnr-envelope"></i> <span>Message</span></a></li>
                            <li><a href="#"><i class="lnr lnr-cog"></i> <span>Settings</span></a></li>
                            <li><a href="${pageContext.request.contextPath}/logout"><i class="lnr lnr-exit"></i> <span>注销</span></a></li>
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
                    <li><a href="${pageContext.request.contextPath}/pages/elements.jsp" target="mainIframe" class="active"><i class="lnr lnr-home"></i> <span>主页</span></a></li>
                    <li>
                        <a href="#authManage" data-toggle="collapse" class="collapsed"><i class="lnr lnr-cog"></i> <span>权限管理</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="authManage" class="collapse ">
                            <ul class="nav">
                                <li><a href="${pageContext.request.contextPath}/pages/user.jsp" target="mainIframe" class="">用户管理</a></li>
                                <li><a href="${pageContext.request.contextPath}/pages/dept.jsp" target="mainIframe" class="">部门管理</a></li>
                                <li><a href="${pageContext.request.contextPath}/pages/role.jsp" target="mainIframe" class="">角色管理</a></li>
                                <li><a href="${pageContext.request.contextPath}/pages/menu.jsp" target="mainIframe" class="">菜单管理</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#systemManage" data-toggle="collapse" class="collapsed"><i class="lnr lnr-chart-bars"></i> <span>系统管理</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="systemManage" class="collapse ">
                            <ul class="nav">
                                <li><a href="${pageContext.request.contextPath}/pages/user.jsp" target="mainIframe" class="">字典管理</a></li>
                                <li><a href="${pageContext.request.contextPath}/pages/dept.jsp" target="mainIframe" class="">日志管理</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/pages/charts.jsp" target="mainIframe" class=""><i class="lnr lnr-chart-bars"></i> <span>图表</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/pages/panels.jsp" target="mainIframe" class=""><i class="lnr lnr-file-empty"></i> <span>面板</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/pages/notifications.jsp" target="mainIframe" class=""><i class="lnr lnr-alarm"></i> <span>通知</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/pages/tables.jsp"  class=""><i class="lnr lnr-dice"></i> <span>Tables</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/pages/typography.jsp" class=""><i class="lnr lnr-text-format"></i> <span>Typography</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/pages/icons.jsp" class=""><i class="lnr lnr-linearicons"></i> <span>Icons</span></a></li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="main">
        <iframe name="mainIframe" frameborder="0" src="${pageContext.request.contextPath}/pages/elements.jsp" style="width: 100%;height: 100%;"></iframe>
    </div>
</div>
</body>
</html>
