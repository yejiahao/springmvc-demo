<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/header.jspf" %>
<%@ include file="/footer.jspf" %>
<body>
<div class="alert alert-success" role="alert">登录成功</div>
<div class="container">
    <form action="${pageContext.request.contextPath}/login/uploadFile" method="post" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <input type="submit" value="upload"/>
    </form>

</div>
</body>

</html>