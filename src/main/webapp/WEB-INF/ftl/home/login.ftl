<html>
<head>
    <title> BirdSquare: Login</title>
    <link rel="stylesheet" type="text/css" href="css/header.css">
</head>
<body>
<div id="main_container">
<#include "../includes.ftl">
    <div id="main-content">
        <div id="fb-root"></div>
        <div class="fb-login-button" autologoutlink="true" data-show-faces="true" data-width="200" data-max-rows="1"></div>
        <div id="user-info"></div>
    </div>
    <script type="text/javascript" src="javascript/FBLogin.js"></script>
<#include "../footer.ftl">
</div>
</body>
</html>
