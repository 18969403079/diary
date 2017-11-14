<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理系统</title>
</head>
<!-- Bootstrap styles-->
<link rel="stylesheet" href="./resource/common/css/bootstrap.min.css">
<!-- Application styles-->
<link rel="stylesheet" href="./resource/common/css/app.min.css">
<!-- Themes-->
<link rel="stylesheet" ng-href="{{app.layout.theme}}" data-ng-if="app.layout.theme">
<link rel="stylesheet" href="./resource/login/css/login.css">
<link rel="stylesheet" href="./resource/common/css/metro.min.css">
<link rel="stylesheet" href="./resource/common/css/select2.min.css">
<link rel="stylesheet" href="./resource/common/css/select2-bootstrap.min.css">
<link rel="stylesheet" href="./resource/common/css/zoomify.min.css">
<link rel="stylesheet" href="./resource/common/css/jquery.treetable.theme.default.css">
<link rel="stylesheet" href="./resource/common/css/jquery.treetable.css">

<body>
<div data-ui-view="" data-autoscroll="false" class="wrapper"></div>
<div>

<div class="login_background">
</div>

<!---内容
================================================== -->
<form class="login_center" name="formValidate">
    <div class="login_titile">
        <font class="fot34">BigPigMan</font>&nbsp;<font class="grey">| </font>&nbsp; <font
            class="fot26">后台管理系统</font>
    </div>
    <div class="login_cotent">
        <div class="cotent_title">
            <font class="fot22">登录</font>&nbsp;&nbsp;
        </div>
        <table width="362" height="280" class="gtable" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td valign="bottom">账&nbsp;&nbsp;号：
                </td>
            </tr>
            <tr>
                <td>
                    <input id="txtUserName" name="username" ng-model="account" class="input_a" type="text"
                           required="required"
                           placeholder="请输入账号"
                           ng-enter="doLogin()">
                    <span ng-show="validateInput('username', 'required')"
                          class="text-danger">账号不能为空</span>
                </td>
            </tr>
            <tr>
                <td valign="bottom">密&nbsp;&nbsp;码：
                </td>
            </tr>
            <tr>
                <td>
                    <input id="txtPassword" ng-model="password" name="password" class="input_a" type="password"
                           required="required"
                           placeholder="请输入密码"
                           ng-enter="doLogin()">
                    <span ng-show="validateInput('password', 'required')"
                          class="text-danger">账号不能为空</span>
                </td>
            </tr>
            <tr>
                <td valign="bottom">验证码：
                </td>
            </tr>
            <tr>
                <td>
                    <input id="txtKaptcha" ng-model="txtKaptcha" class="input_a" type="text" placeholder="请输入验证码"
                           ng-enter="doLogin()"
                           style="width: 45%;"/>
                    <img ng-src="{{imgUrl}}" alt="看不清，换一张" ng-click="getPicture()" style="width: 45%;">
                </td>
            </tr>

            <tr>
                <td valign="bottom"></td>
            </tr>
            <tr>
                <td>
                    <a href="javascript:void(0);" id="btnLogin" class="btn_ok" ng-click="doLogin()">登 &nbsp;录</a>
                </td>
            </tr>
        </table>
    </div>
</form>
<!---底部
================================================== -->
<div class="login_bottom">
    Copyright ©2017, CCG(盛和环球) 版权所有
</div>

</div>

</body>
<script src="./resource/common/js/jquery.min.js"></script>
<script src="./resource/common/js/dist/base.min.js"></script>
<script src="./resource/common/js/dist/relies.js"></script>
<script src="./resource/common/js/dist/main.js"></script>
<script src="./resource/common/js/jquery.treetable.js"></script>
<script src="./resource/common/js/angular-treetable.js"></script>
</html>