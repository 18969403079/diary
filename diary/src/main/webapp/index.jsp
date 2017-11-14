<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="icon" href="<%=path%>/images/favicon.ico" type="image/x-icon"/>
    <link href="<%=path%>/assets/css/boot>/css/style.css"/>
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="<%=path%>/assets/css/ace-ie.min.css"/>
    <![endif]-->
    <script src="<%=path%>/assets/js/ace-extra.min.js"></script>
    <!--[if lt IE 9]>
    <script src="<%=path%>/assets/js/html5shiv.js"></script>
    <script src="<%=path%>/assets/js/respond.min.js"></script>
    <![endif]-->
    <script src="<%=path%>/resource/js/jquery.min.js"></script>
    <script src="<%=path%>/resource/assets/layer/layer.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=path%>/js/utils.js"></script>
    <script>
        function loadTopWindow() {
            if (window.top != null && window.top.document.URL != document.URL) {
                window.top.location = document.URL; //这样就可以让登陆窗口显示在整个窗口了
            }
        }
        function keyLogin() {
            if (event.keyCode == 13)  //回车键的键值为13
                $("#loginSumbit").click(); //调用登录按钮的登录事件
        }
        function mobileweiXinLogin() {
            window.location.href = cxtPath + "/mobile/wxlogin.jhtml";
        }
    </script>
    <title>云融客管理系统登录</title>
</head>
<a id="check_page" class="computer"
   style="background: #fff;border-color:#fff;"></a>
<body class="login-layout Reg_log_style" onload="loadTopWindow()" onkeydown="keyLogin();">
    <a href="<%=path%>/login/test.do">导出表格</a>
</body>
</html>
<script type="text/javascript" src="<%=path%>/js/jquery.md5.js"></script>
<script type="text/javascript" src="<%=path%>/js/des.js"></script>
<script type="text/javascript" src="<%=path%>/js/bus/login.js"></script>
<script>
    $(function () {
        $("#wxLogin").click(function () {
            var index = layer.open({
                type: 2,
                title: '微信扫一扫登录',
                shadeClose: true,
                shade: [0.3, '#393D49'],
                maxmin: false,
                area: ["420px", "60%"],
                content: '${site}'
            });
        })
    });
</script>
</html>