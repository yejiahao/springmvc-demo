<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/header.jspf" %>
<%@ include file="/footer.jspf" %>

<body>
<%@ include file="/navbar.jsp" %>
<div style="margin-top: 80px">
    <c:if test="${loginUser['gender'] == 1}">
        <%request.setAttribute("color", "dodgerblue");%>
    </c:if>
    <c:if test="${loginUser['gender'] == 0}">
        <%request.setAttribute("color", "hotpink");%>
    </c:if>

    <h2 class="text-center"><span style="color: ${color}">${loginUser['userName']}</span>, 欢迎来到系统网站</h2>
    <br>
    <h3 class="text-center">登录时间：
        <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/>
    </h3>

</div>
</body>
<script>
    $(function () {
        acitveTabById('mainli');
    });
</script>
</html>
