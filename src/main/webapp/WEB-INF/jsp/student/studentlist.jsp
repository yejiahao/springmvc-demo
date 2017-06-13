<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/header.jspf" %>
<%@ include file="/footer.jspf" %>
<body>
<%@ include file="/navbar.jsp" %>
<div style="margin-top: 60px;">
    <div style="padding: 10px 1200px 10px 20px;">
        <div class="input-group input-group-sm" style="margin-bottom: 10px;">
            <span class="input-group-addon">姓名</span>
            <input type="text" class="form-control" id="sName" name="sName"/>
        </div>
        <div class="input-group input-group-sm" style="margin-bottom: 10px">
            <span class="input-group-addon">学号</span>
            <input type="text" class="form-control" id="sNumber" name="sNumber"/>
        </div>
        <div class="input-group input-group-sm" style="margin-bottom: 10px">
            <span class="input-group-addon">注册时间</span>
            <input type="text" class="form-control" id="sRegisterTime" name="sRegisterTime"/>
        </div>
        <div class="input-group input-group-sm" style="margin-bottom: 10px">
            <span class="input-group-addon">下拉选择</span>
            <select class="form-control">
                <option>1</option>
                <option>2</option>
                <option>3</option>
            </select>
        </div>
        <div class="input-group input-group-sm">
            <button class="btn btn-success" id="search">查找</button>
        </div>
    </div>
    <%--hidden layer--%>
    <div>
        <input type="hidden" id="hidden_sName"/>
        <input type="hidden" id="hidden_sNumber"/>
        <input type="hidden" id="hidden_sRegisterTime"/>
    </div>

    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">学生信息</div>
        <div id="studentLayer">
            <%@include file="/WEB-INF/jsp/student/studentlisttable.jsp" %>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $(function () {
        //导航栏高亮显示对应模块
        acitveTabById('studentli');
    });

    // Ajax to find students
    $('#search').on('click', function () {
        var sName = $('#sName').val();
        var sNumber = $('#sNumber').val();

        $('#hidden_sName').val(sName);
        $('#hidden_sNumber').val(sNumber);

        var data = {
            'sName': sName,
            'sNumber': sNumber,
            'page': 1
        };
        loadPage('studentLayer', '${pageContext.request.contextPath}/stud/showStudInfos', data, true);

    });
</script>
