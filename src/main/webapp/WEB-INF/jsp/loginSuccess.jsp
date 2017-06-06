<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>

<%@ include file="/header.jsp" %>
<body>
<div class="alert alert-success" role="alert">登录成功</div>
<div class="container">
    <form action="${pageContext.request.contextPath}/login/uploadFile" method="post" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <input type="submit" value="upload"/>
    </form>

    <a id="logout" href="${pageContext.request.contextPath}/login/logout">退出登录</a>

    <form action="###">
        <label for="province">省份： </label>
        <div class="form-group">
            <select class="form-control" id="provinceSel">
                <option value="0">请选择</option>
            </select>
        </div>
        <label for="city">城市： </label>
        <div class="form-group">
            <select class="form-control" id="citySel">
                <option value="0">请选择</option>
            </select>
        </div>
        <label for="area">地区： </label>
        <div class="form-group">
            <select class="form-control" id="areaSel">
                <option value="0">请选择</option>
            </select>
        </div>
        <button type="submit" id="btnSubmit" class="btn btn-default">提交</button>
    </form>

</div>
</body>

<script type="text/javascript">
    $(function () {
        $.ajax({
            url: '${pageContext.request.contextPath}/province/getProvinces',
            method: 'GET',
            data: null,
            success: function (data) {
                console.log(data);
                for (var index = 0; index < data.length; index++) {
                    var obj = data[index];
                    $('#provinceSel').append("<option value='" + obj.postcode + "'>" + obj.name + "</option>")
                }
            },
            error: function () {
                console.log(errorThrown);
                window.location.href = '${pageContext.request.contextPath}/login.jsp';
            },
            dataType: 'json'
        });
    });

    $('#provinceSel').change(function () {
        $.ajax({
            url: '${pageContext.request.contextPath}/province/getCitiesByProvince',
            method: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(
                {
                    provincePostCode: $('#provinceSel').val(),
                    provinceName: $('#provinceSel').find('option:selected').text()
                }
            ),
            success: function (data) {
                clearSel('#citySel');
                clearSel('#areaSel');
                console.log(data);
                for (var index = 0; index < data.length; index++) {
                    var obj = data[index];
                    $('#citySel').append("<option value='" + obj.postcode + "'>" + obj.name + "</option>")
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(errorThrown);
                window.location.href = '${pageContext.request.contextPath}/login.jsp';
            },
            dataType: 'json'
        });
    });

    $('#citySel').change(function () {
        $.ajax({
            url: '${pageContext.request.contextPath}/province/getAreasByCity',
            method: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify(
                {
                    provincePostCode: $('#provinceSel').val(),
                    provinceName: $('#provinceSel').find('option:selected').text(),
                    cityPostCode: $('#citySel').val(),
                    cityName: $('#citySel').find('option:selected').text()
                }
            ),
            success: function (data) {
                clearSel('#areaSel');
                console.log(data);
                for (var index = 0; index < data.length; index++) {
                    var obj = data[index];
                    $('#areaSel').append("<option value='" + obj.postcode + "'>" + obj.name + "</option>")
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                console.log(errorThrown);
                window.location.href = '${pageContext.request.contextPath}/login.jsp';
            },
            dataType: 'json'
        });
    });

    function clearSel(selId) {
        $(selId).empty();
        $(selId).append("<option value='0'>请选择</option>");
    }
</script>
</html>