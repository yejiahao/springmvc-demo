<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>

<%@ include file="/header.jsp" %>
<body>
<div style="position:absolute;">
    <img src="${pageContext.request.contextPath}/image/index.png" style="width: 100%">
</div>
<div class="container" style="position: relative;z-index: 1;">
    <form style="max-width: 400px;padding: 15px;margin: 150px auto"
          action="${pageContext.request.contextPath}/login/login.do" method="post">
        <h2 class="form-signin-heading">Sign in</h2>
        <div class="input-group input-group-lg">
            <span class="input-group-addon glyphicon glyphicon-envelope" aria-hidden="true"></span>
            <input type="text" name="account" id="account" class="form-control" placeholder="用户名" required autofocus>
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
        <button class="btn btn-lg btn-block" type="reset">重置</button>
    </form>
</div>

</body>
</html>