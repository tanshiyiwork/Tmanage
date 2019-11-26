<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/25
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="../assets/css/bootstrap.min.css">
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
    <script src="../assets/vendor/jquery/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        function changeImage(obj) {
            $(obj).attr("src","/captcha.jpg");
        }
    </script>
</head>
<body>
<div id="wrapper">
    <div class="vertical-align-wrap">
        <div class="vertical-align-middle">
            <div class="auth-box ">
                <div class="left">
                    <div class="content">
                        <div class="header">
                            <div class="logo text-center"><img src="../assets/img/logo-dark.png" alt="Klorofil Logo"></div>
                            <p class="lead">系统登录</p>
                        </div>
                        <form class="form-auth-small" action="/login">
                            <div class="form-group">
                                <label for="username" class="control-label sr-only">账号</label>
                                <input type="text" class="form-control" name="username" id="username" placeholder="账号">
                            </div>
                            <div class="form-group">
                                <label for="password" class="control-label sr-only">密码</label>
                                <input type="password" class="form-control" name="password" id="password" placeholder="密码">
                            </div>
                            <div class="form-group">
                                <label for="captcha" class="control-label sr-only">验证码</label>
                                <input type="password" class="form-control" name="captcha" id="captcha" placeholder="验证码">
                            </div>
                            <div><span><img src="/captcha.jpg" onclick="changeImage(this)"></span></div>
                            <div class="form-group clearfix">
                                <label class="fancy-checkbox element-left">
                                    <input type="checkbox">
                                    <span>记住我</span>
                                </label>
                            </div>
                            <button type="submit" class="btn btn-primary btn-lg btn-block">登录</button>
                            <div class="bottom">
                                <span class="helper-text"><i class="fa fa-lock"></i> <a href="#">忘记密码</a></span>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="right">
                    <div class="overlay"></div>
                    <div class="content text">
                        <h1 class="heading"></h1>
                        <p></p>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
