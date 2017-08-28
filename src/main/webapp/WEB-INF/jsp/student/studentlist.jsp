<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/header.jspf" %>
<%@ include file="/footer.jspf" %>
<body>
<%@ include file="/navbar.jsp" %>
<div class="container">
    <div style="margin-top: 60px;">
        <div style="padding: 10px 75% 10px 1%;">
            <div class="input-group input-group-sm modal-input">
                <span class="input-group-addon">姓名</span>
                <input type="text" class="form-control" id="sName" name="sName"/>
            </div>
            <div class="input-group input-group-sm modal-input">
                <span class="input-group-addon">学号</span>
                <input type="text" class="form-control" id="sNumber" name="sNumber"
                       onkeyup="this.value=this.value.replace(/\D/g,'')" maxlength="9"/>
            </div>
            <div class="input-group input-group-sm modal-input">
                <span class="input-group-addon">注册日期</span>
                <input type="text" class="form-control datetimepicker" id="sRegisterTimeBegin"
                       name="sRegisterTimeBegin"/>
                <span class="input-group-addon">到</span>
                <input type="text" class="form-control datetimepicker" id="sRegisterTimeEnd" name="sRegisterTimeEnd"/>
            </div>

            <div class="input-group input-group-sm modal-input">
                <span class="input-group-addon">所属年级</span>
                <select class="form-control" id="grade" name="grade">
                    <option value="0">全部</option>
                    <option value="1">一年级</option>
                    <option value="2">二年级</option>
                    <option value="3">三年级</option>
                    <option value="4">四年级</option>
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
            <input type="hidden" id="hidden_sRegisterTimeBegin"/>
            <input type="hidden" id="hidden_sRegisterTimeEnd"/>
            <input type="hidden" id="hidden_grade"/>
        </div>

        <div class="panel panel-default">
            <div class="panel-heading">
                <span style="font-size: 20px;">学生信息</span>
                <div style="float: right;">
                    <button class="btn btn-info" id="create">添加学生</button>
                    <button class="btn btn-warning" id="export">批量导出</button>
                </div>
            </div>
            <div id="studentLayer"></div>
        </div>
    </div>
</div>
<script>
    $(function () {
        //导航栏高亮显示对应模块
        acitveTabById('studentli');

        $('#search').click();
    });

    // Ajax to find students
    $('#search').on('click', function () {
        var sName = $('#sName').val();
        var sNumber = $('#sNumber').val();
        var sRegisterTimeBegin = $('#sRegisterTimeBegin').val();
        var sRegisterTimeEnd = $('#sRegisterTimeEnd').val();
        var grade = $('#grade').val();

        $('#hidden_sName').val(sName);
        $('#hidden_sNumber').val(sNumber);
        $('#hidden_sRegisterTimeBegin').val(sRegisterTimeBegin);
        $('#hidden_sRegisterTimeEnd').val(sRegisterTimeEnd);
        $('#hidden_grade').val(grade);

        var data = {
            'sName': sName,
            'sNumber': sNumber,
            'sRegisterTimeBegin': sRegisterTimeBegin,
            'sRegisterTimeEnd': sRegisterTimeEnd,
            'grade': grade,
            'page': 1
        };

        $('#studentLayer').load('${pageContext.request.contextPath}/stud/showStudInfos', data, function (responseText, status, xhr) {
            if (status == "error") {
                alert("Error: " + xhr.status + ": " + xhr.statusText);
            }
        });

    });
</script>
</body>
</html>
