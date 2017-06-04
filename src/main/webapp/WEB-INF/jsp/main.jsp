<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="/header.jsp" %>
<%
    DateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    request.setAttribute("now", dt.format(new Date()));%>
<body>
<%@ include file="/navbar.jsp" %>
<div style="margin-top: 80px">
    <c:if test="${loginUser['gender'] == 1}">
        <%request.setAttribute("color", "dodgerblue");%>
    </c:if>
    <c:if test="${loginUser['gender'] == 0}">
        <%request.setAttribute("color", "hotpink");%>
    </c:if>

    <h2 style="text-align: center"><span style="color: ${color}">${loginUser['userName']}</span>, 欢迎来到系统网站</h2>
    <br>
    <h3 style="text-align: center">登录时间： ${now}</h3>

</div>
</body>
<script>
    $(function () {
        acitveTabById('mainli');
    });
</script>
</html>
