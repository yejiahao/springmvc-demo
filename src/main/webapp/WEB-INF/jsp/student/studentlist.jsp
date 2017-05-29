<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/header.jsp" %>
<body>
<%@ include file="/navbar.jsp" %>
<div style="margin-top: 80px;">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">学生信息</div>

        <!-- Table -->
        <table class="table">
            <thead>
            <td>序号</td>
            <td>姓名</td>
            <td>学号</td>
            <td>注册时间</td>
            </thead>
            <tbody>
            <c:forEach var="student" items="${studentList}" varStatus="status">
                <tr>
                    <td>${status.index+1}</td>
                    <td>${student.sName}</td>
                    <td>${student.sNumber}</td>
                    <td><fmt:formatDate value="${student.sRegisterTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
<script>
    $(function () {
        acitveTabById('studentli');
    });
</script>
</html>