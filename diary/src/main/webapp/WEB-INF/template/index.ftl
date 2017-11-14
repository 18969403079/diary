<!DOCTYPE html>
<html lang="en" data-ng-app="webManager">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="{{app.description}}">
    <meta name="keywords" content="app, responsive, angular, bootstrap, dashboard, admin">
    <title>CCG(盛和环球)后台管理系统</title>
    <!-- Bootstrap styles-->
    <link rel="stylesheet" href="app/css/bootstrap.min.css">
    <!-- Application styles-->
    <link rel="stylesheet" href="app/css/app.min.css">
    <!-- Themes-->
    <link rel="stylesheet" ng-href="{{app.layout.theme}}" data-ng-if="app.layout.theme">
    <link rel="stylesheet" href="app/css/login.css">
    <link rel="stylesheet" href="vendor/ztree/metro.min.css">
    <link rel="stylesheet" href="vendor/select2/css/select2.min.css">
    <link rel="stylesheet" href="vendor/select2/css/select2-bootstrap.min.css">
    <link rel="stylesheet" href="app/vendor/zoomify/zoomify.min.css">
    <link rel="stylesheet" href="app/vendor/angulartreetable/css/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="app/vendor/angulartreetable/css/jquery.treetable.css">

</head>

<body data-ng-class="{ 'layout-fixed' : app.layout.isFixed, 'aside-collapsed' : app.layout.isCollapsed,
 'layout-boxed' : app.layout.isBoxed, 'layout-fs': app.useFullLayout, 'hidden-footer': app.hiddenFooter,
  'aside-float': app.layout.isFloat}">

<div data-ui-view="" data-autoscroll="false" class="wrapper"></div>

<script src="app/js/dist/base.min.js"></script>

<script src="app/js/dist/relies.js"></script>
<script src="app/js/dist/main.js"></script>

<script src="app/vendor/angulartreetable/js/jquery.treetable.js"></script>
<script src="app/vendor/angulartreetable/js/angular-treetable.js"></script>

</body>

</html>