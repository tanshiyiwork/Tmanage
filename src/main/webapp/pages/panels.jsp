<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/29
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panels | Klorofil - Free Bootstrap Dashboard Template</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="../assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../assets/vendor/linearicons/style.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="../assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="../assets/css/demo.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="../assets/img/favicon.png">
    <!-- Javascript -->
    <script src="../assets/vendor/jquery/jquery.min.js"></script>
    <script src="../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="../assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
    <script src="../assets/scripts/klorofil-common.js"></script>
</head>
<body>
<div class="main-content">
    <div class="container-fluid">
        <h3 class="page-title">Panels</h3>
        <div class="row">
            <div class="col-md-8">
                <!-- PANEL HEADLINE -->
                <div class="panel panel-headline">
                    <div class="panel-heading">
                        <h3 class="panel-title">Panel Headline</h3>
                        <p class="panel-subtitle">Panel to display most important information</p>
                    </div>
                    <div class="panel-body">
                        <h4>Panel Content</h4>
                        <p>Objectively network visionary methodologies via best-of-breed users. Phosfluorescently initiate go forward leadership skills before an expanded array of infomediaries. Monotonectally incubate web-enabled communities rather than process-centric.</p>
                    </div>
                </div>
                <!-- END PANEL HEADLINE -->
            </div>
            <div class="col-md-4">
                <!-- PANEL NO PADDING -->
                <div class="panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">Panel No Padding</h3>
                        <div class="right">
                            <button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
                            <button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
                        </div>
                    </div>
                    <div class="panel-body no-padding bg-primary text-center">
                        <div class="padding-top-30 padding-bottom-30">
                            <i class="fa fa-thumbs-o-up fa-5x"></i>
                            <h3>No Content Padding</h3>
                        </div>
                    </div>
                </div>
                <!-- END PANEL NO PADDING -->
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <!-- PANEL DEFAULT -->
                <div class="panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">Panel Default</h3>
                        <div class="right">
                            <button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
                            <button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
                        </div>
                    </div>
                    <div class="panel-body">
                        <p>Objectively network visionary methodologies via best-of-breed users. Phosfluorescently initiate go forward leadership skills before an expanded array of infomediaries. Monotonectally incubate web-enabled communities rather than process-centric.</p>
                    </div>
                </div>
                <!-- END PANEL DEFAULT -->
            </div>
            <div class="col-md-4">
                <!-- PANEL NO CONTROLS -->
                <div class="panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">Panel No Right Controls</h3>
                    </div>
                    <div class="panel-body">
                        <p>Objectively network visionary methodologies via best-of-breed users. Phosfluorescently initiate go forward leadership skills before an expanded array of infomediaries. Monotonectally incubate web-enabled communities rather than process-centric.</p>
                    </div>
                </div>
                <!-- END PANEL NO CONTROLS -->
            </div>
            <div class="col-md-4">
                <!-- PANEL WITH FOOTER -->
                <div class="panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">Panel With Footer</h3>
                        <div class="right">
                            <button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
                            <button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
                        </div>
                    </div>
                    <div class="panel-body">
                        <p>Objectively network visionary methodologies via best-of-breed users. Phosfluorescently initiate go forward leadership skills before an expanded array.</p>
                    </div>
                    <div class="panel-footer">
                        <h5>Panel Footer</h5>
                    </div>
                </div>
                <!-- END PANEL WITH FOOTER -->
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <!-- PANEL SCROLLING -->
                <div id="panel-scrolling-demo" class="panel">
                    <div class="panel-heading">
                        <h3 class="panel-title">Panel Scrolling</h3>
                    </div>
                    <div class="panel-body">
                        <p>Objectively network visionary methodologies via best-of-breed users. Phosfluorescently initiate go forward leadership skills before an expanded array of infomediaries. Monotonectally incubate web-enabled communities rather than process-centric.</p>
                        <p>Objectively network visionary methodologies via best-of-breed users. Phosfluorescently initiate go forward leadership skills before an expanded array of infomediaries. Monotonectally incubate web-enabled communities rather than process-centric.</p>
                        <p>Objectively network visionary methodologies via best-of-breed users. Phosfluorescently initiate go forward leadership skills before an expanded array of infomediaries. Monotonectally incubate web-enabled communities rather than process-centric.</p>
                    </div>
                </div>
                <!-- END PANEL SCROLLING -->
            </div>
        </div>
    </div>
</div>
</body>
</html>
