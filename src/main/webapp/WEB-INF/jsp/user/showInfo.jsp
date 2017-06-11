<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>

<%@ include file="/header.jspf" %>
<%@ include file="/footer.jspf" %>

<body>
<div id="single_layer">
    <span>当前用户</span>
    <table align="center" border="4" bordercolor="GREEN">
        <thead>
        <tr>
            <td width="150px">用户编号</td>
            <td width="150px">用户姓名</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${userInfo['uNumber']}</td>
            <td>${userInfo['uName']}</td>
        </tr>
        </tbody>
    </table>
</div>

<hr/>

<div id="allUser_layer">
    <span>所有用户</span><br/>
    <input type="button" id="allUser_btn" value="显示用户信息"/>
    <table align="center" border="4" bordercolor="RED" id="allUser_table">
        <thead>
        <tr>
            <td width="150px">用户编号</td>
            <td width="150px">用户姓名</td>
            <td width="150px">用户注册时间</td>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
    <span>系统当前时间 <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
</div>
</body>

<script type="text/javascript">
    $(function () {
        console.log("This is showInfo.jsp.");
    });

    $('#allUser_btn').on('click', function () {
        $.ajax({
            method: 'GET',
            url: '${pageContext.request.contextPath}/user/showInfos',
            data: null,
            dataType: 'json',
            success: function (data, status) {
                $(data).each(function (i, userInfo) {
                    $('#allUser_table tbody').append('<tr><td>' + userInfo.uNumber + '</td><td>' + userInfo.uName +
                        '</td><td>' + userInfo.uRegisterTime + '</td></tr>');
                });
            }
        });
        $('#allUser_btn').hide();
    });
</script>

</html>