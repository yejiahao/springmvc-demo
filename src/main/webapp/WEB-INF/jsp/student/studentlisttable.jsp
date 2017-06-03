<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
