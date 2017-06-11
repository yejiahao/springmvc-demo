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
        <c:choose>
            <c:when test="${status.index % 4 == 0}">
                <tr class="success">
            </c:when>
            <c:when test="${status.index % 4 == 1}">
                <tr class="danger">
            </c:when>
            <c:when test="${status.index % 4 == 2}">
                <tr class="warning">
            </c:when>
            <c:when test="${status.index % 4 == 3}">
                <tr class="info">
            </c:when>
        </c:choose>
        <td>${status.index+1}</td>
        <td>${student.sName}</td>
        <td>${student.sNumber}</td>
        <td><fmt:formatDate value="${student.sRegisterTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
