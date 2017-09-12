<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>

<%@ include file="/header.jspf" %>
<%@ include file="/footer.jspf" %>
<script src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
<body style="overflow-y:hidden">
<div style="position:absolute;">
    <img src="${pageContext.request.contextPath}/image/index.png" style="width: 100%">
</div>
<div class="container" style="position: relative;z-index: 1;">
    <form style="max-width: 400px;padding: 15px;margin: 150px auto"
          action="${pageContext.request.contextPath}/login/login" method="post">
        <h2 class="form-signin-heading">登录</h2>
        <div class="input-group input-group-lg">
            <span class="input-group-addon glyphicon glyphicon-user" aria-hidden="true"></span>
            <input type="text" name="account" id="account" class="form-control" placeholder="邮箱/账号" required autofocus>
        </div>
        <div class="input-group input-group-lg">
            <span class="input-group-addon glyphicon glyphicon-lock" aria-hidden="true"></span>
            <input type="password" name="password" id="password" class="form-control" placeholder="密码" required>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox"> 记住密码
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        <div class="checkbox">
            <a href="${pageContext.request.contextPath}/register.jsp" class="text-left">立即注册</a>
            <a href="#" class="pull-right">忘记密码？</a>
        </div>
        <span style="color:red">${errorMessage}</span>
    </form>

</div>
</body>
<script>
    $(function () {
        <% session.removeAttribute("errorMessage"); %>

        if ($.cookie('account') != null && $.cookie('password') != null) {
            $('#account').val($.cookie('account'));
            $('#password').val($.cookie('password'));
            $('input[type=checkbox]').prop('checked', true);
        }
    });

    // 根据勾选框状态操作cookies
    $('form').submit(function () {
        if ($('input[type=checkbox]').prop('checked')) {
            var account = $('#account').val();
            var password = $('#password').val();
            $.cookie('account', account, {expires: 7});
            $.cookie('password', password, {expires: 7});
        } else {
            $.cookie('account', '', {expires: -1});
            $.cookie('password', '', {expires: -1});
        }
    });
</script>
</html>