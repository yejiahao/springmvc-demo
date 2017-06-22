<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<table class="table">
    <thead>
    <td>序号</td>
    <td>姓名</td>
    <td>学号</td>
    <td>注册时间</td>
    <td>操作</td>
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
        <td>
            <a onclick="alert('pencil')"><span class="glyphicon glyphicon-pencil"></span></a>
            <a onclick="alert('trash')"><span class="glyphicon glyphicon-trash"></span></a>
        </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div id="pageLayer" style="padding-right: 20px;">
    <nav aria-label="Page navigation" class="text-right">
        <ul class="pagination" id="pageLayerul"></ul>
    </nav>
</div>

<script>
    $(function () {
        var options = {
            currentPage: ${currentPage},
            totalPages: ${totalPages},
            numberOfPages: 5,
            onPageClicked: function (event, originalEvent, type, page) {
                var data = {
                    'sName': $('#hidden_sName').val(),
                    'sNumber': $('#hidden_sNumber').val(),
                    'sRegisterTimeBegin': $('#hidden_sRegisterTimeBegin').val(),
                    'sRegisterTimeEnd': $('#hidden_sRegisterTimeEnd').val(),
                    'page': page
                };
                $('#studentLayer').load('${pageContext.request.contextPath}/stud/showStudInfos', data, function (responseText, status, xhr) {
                    if (status == "error") {
                        alert("Error: " + xhr.status + ": " + xhr.statusText);
                    }
                });
            }
        }
        $('#pageLayerul').bootstrapPaginator(options);
    });
</script>