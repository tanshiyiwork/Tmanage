<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/29
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notifications | Klorofil - Free Bootstrap Dashboard Template</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="../assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../assets/vendor/linearicons/style.css">
    <link rel="stylesheet" href="../assets/vendor/toastr/toastr.min.css">
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
    <script src="../assets/vendor/toastr/toastr.min.js"></script>
    <script src="../assets/scripts/klorofil-common.js"></script>
</head>
<body>
<div class="main-content">
    <div class="container-fluid">
        <h3 class="page-title">Notifications</h3>
        <div id="toastr-demo" class="panel">
            <div class="panel-body">
                <!-- CONTEXTUAL -->
                <h4>Context</h4>
                <p class="demo-button">
                    <button type="button" class="btn btn-primary btn-toastr" data-context="info" data-message="This is general theme info" data-position="top-right">General Info</button>
                    <button type="button" class="btn btn-success btn-toastr" data-context="success" data-message="This is success info" data-position="top-right">Success Info</button>
                    <button type="button" class="btn btn-warning btn-toastr" data-context="warning" data-message="This is warning info" data-position="top-right">Warning Info</button>
                    <button type="button" class="btn btn-danger btn-toastr" data-context="error" data-message="This is error info" data-position="top-right">Error Info</button>
                </p>
                <!-- END CONTEXTUAL -->
                <br>
                <!-- POSITION -->
                <h4>Position</h4>
                <p class="demo-button">
                    <button type="button" class="btn btn-default btn-toastr" data-context="info" data-message="Hi, I'm here" data-position="bottom-right">Bottom Right</button>
                    <button type="button" class="btn btn-default btn-toastr" data-context="info" data-message="Hi, I'm here" data-position="bottom-left">Bottom Left</button>
                    <button type="button" class="btn btn-default btn-toastr" data-context="info" data-message="Hi, I'm here" data-position="top-left">Top Left</button>
                    <button type="button" class="btn btn-default btn-toastr" data-context="info" data-message="Hi, I'm here" data-position="top-right">Top Right</button>
                    <button type="button" class="btn btn-default btn-toastr" data-context="info" data-message="Hi, I'm here" data-position="top-full-width">Top Full Width</button>
                    <button type="button" class="btn btn-default btn-toastr" data-context="info" data-message="Hi, I'm here" data-position="bottom-full-width">Bottom Full Width</button>
                    <button type="button" class="btn btn-default btn-toastr" data-context="info" data-message="Hi, I'm here" data-position="top-center">Top Center</button>
                    <button type="button" class="btn btn-default btn-toastr" data-context="info" data-message="Hi, I'm here" data-position="bottom-center">Bottom Center</button>
                </p>
                <!-- END POSITION -->
                <br>
                <!-- CALLBACK -->
                <h4>Callback</h4>
                <p class="demo-button">
                    <button type="button" class="btn btn-default btn-toastr-callback" id="toastr-callback1" data-context="info" data-message="onShown and onHidden callback demo">onShown and onHidden</button>
                    <button type="button" class="btn btn-default btn-toastr-callback" id="toastr-callback2" data-context="info" data-message="Please click me">onclick</button>
                    <button type="button" class="btn btn-default btn-toastr-callback" id="toastr-callback3" data-context="info" data-message="Please click close button">onCloseClick</button>
                </p>
                <!-- END CALLBACK -->
            </div>
        </div>
    </div>
</div>
</body>
</html>
