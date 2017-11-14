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
    <link href="<%=path%>/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="<%=path%>/assets/css/font-awesome.min.css"/>
    <!--[if IE 7]>
    <link rel="stylesheet" href="<%=path%>/assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->
    <link rel="stylesheet" href="<%=path%>/resource/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="<%=path%>/resource/assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="<%=path%>/resource/assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="<%=path%>/css/style.css"/>
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
<div class="logintop">
    <span>欢迎登录云融客管理系统</span>
</div>
<div class="loginbody">
    <div class="login-container">
        <div class="center">
            <img src=""/>
        </div>
        <div class="space-6"></div>
        <div class="position-relative">
            <div id="login-box" class="login-box widget-box no-border visible">
                <div class="widget-body">
                    <div class="widget-main">
                        <h4 class="header blue lighter bigger">
                            <i class="icon-coffee green"></i>
                            云融客管理系统 登录
                        </h4>

                        <div class="login_icon"><img src="<%=path%>/images/login.png"/></div>

                        <form id="loginFrom">
                            <fieldset>
                                <ul>
                                    <li style="padding-right: 0;" class="frame_style form_error">
                                        <label style=" background: url(/drp-web-boss/images/account_tab.png) no-repeat 7px center;
                                        background-size: 22px; float: left; width: 40px;  margin-top: 2px;height: 37px;  border-right: 1px solid #ddd;"
                                               class="user_icon"></label>
                                        <select id="accountType" onchange="changeAccountType(this);">
                                            <option value="-1">——请选择账户类型——</option>
                                            <option value="1">个人云融客</option>
                                            <option value="2">商超云融客</option>
                                        </select>
                                    </li>
                                    <li class="frame_style form_error"><label class="user_icon"></label><input
                                            placeholder="手机号/会员ID/云融生活用户ID" name="username" type="text" id="username"/>
                                    </li>
                                    <li class="frame_style form_error"><label class="password_icon"></label><input
                                            placeholder="输入密码" name="password" type="password" id="password"/></li>
                                    <li class="frame_style form_error"><label class="Codes_icon"></label><input
                                            placeholder="输入验证码" name="validateCode" type="text" id="validateCode"
                                            style="width:120px;"/>
                                        <div class="Codes_region">
                                            <img id="imageCode" alt="" src="" style="cursor: pointer;" title="点我更换验证码"/>
                                        </div>
                                    </li>

                                </ul>
                                <div class="" id="rememberMeDiv">
                                    <input type="checkbox" name="rememberMe" value="Y" id="rememberMe"/>保持登录<br>
                                </div>
                                <div class="clearfix" style="text-align: center;width: 96%; margin: 0 auto;">
                                    <button type="button" class="width-35 btn btn-sm btn-primary" id="loginSumbit">
                                        <i class="icon-key"></i>
                                        登录
                                    </button>
                                </div>
                                <div class="space-4"></div>
                            </fieldset>
                        </form>
                        <%--微信登录--%>
                        <%--<div align="center" class="social-login" id="mobilewx">--%>
                        <%--<a href="javaScript:void(0);" id="mobilewxLogin" onclick="mobileweiXinLogin();" data-type="qq" class="login_way_weixin"></a>--%>
                        <%--</div>--%>
                        <%--<div align="center" class="weixin-login-title" id="pcwx">--%>
                        <%--<a href="javaScript:void(0);" id="wxLogin" data-type="qq" class="login_way_weixin">微信登录</a>--%>
                        <%--</div>--%>
                    </div>
                    <div class="toolbar clearfix">
                    </div>
                </div><!-- /widget-body -->
            </div><!-- /login-box -->
        </div><!-- /position-relative -->
    </div>
</div>
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