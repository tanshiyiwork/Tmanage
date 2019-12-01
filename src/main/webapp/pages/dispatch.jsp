<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/2
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="../assets/vendor/jquery/jquery.min.js"></script>
    <script src="../assets/scripts/getToken.js"></script>
    <script>
        var token=$.getUrlParam("token");
        alert(token);
        if(token == "" || token ==null){
            window.location="toLogin";
        }else{
            $.ajax({
                type : 'post',
                url : '/loginSuccess',
                /*contentType : 'application/json;charset=UTF-8',*/
                dataType : 'text',
                beforeSend: function(request) {
                    request.setRequestHeader("Authorization","Bearer "+token);
                }/*,
                success : function(data,textStatus,jqXHR){
                    alert("response:"+data);
                },
                error: function (err) {
                    alert("ajax错误码:" + err.status);
                }*/
            });
        }
    </script>
</head>
<body>
<%--<form action="" method="post">
</form>--%>
</body>
</html>
