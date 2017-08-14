<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<table class="table">
    <thead>
    <td>序号</td>
    <td>姓名</td>
    <td>学号</td>
    <td>注册时间</td>
    <td>所属专业</td>
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
        <td>${student.professional}</td>
        <td>
            <a data-id="${student.sId}" data-name="${student.sName}" data-number="${student.sNumber}"
               data-toggle="modal" href="#infoModal">
                <span class="glyphicon glyphicon-pencil"></span>
            </a>
            <sapn style="margin:15px"></sapn>
            <a data-id="${student.sId}" data-name="${student.sName}" data-number="${student.sNumber}"
               class="deleteLink">
                <span class="glyphicon glyphicon-trash"></span>
            </a>
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

<!-- Modal -->
<div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal" aria-label="Close">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                </button>
                <h4 class="modal-title" id="myModalLabel">修改信息</h4>
            </div>
            <div class="modal-body" style="padding: 40px">
                <input type="hidden" value=""/>
                <label></label>
                <div class="input-group input-group-lg modal-input">
                    <span class="input-group-addon">省份</span>
                    <select class="form-control" id="provinceSel">
                        <option value='0'>请选择</option>
                    </select>
                </div>
                <div class="input-group input-group-lg modal-input">
                    <span class="input-group-addon">城市</span>
                    <select class="form-control" id="citySel">
                        <option value='0'>请选择</option>
                    </select>
                </div>
                <div class="input-group input-group-lg modal-input">
                    <span class="input-group-addon">地区</span>
                    <select class="form-control" id="areaSel">
                        <option value='0'>请选择</option>
                    </select>
                </div>
            </div>
            <div class="modal-footer" style="text-align: center">
                <button type="button" class="btn btn-lg btn-primary" id="saveInfo">保存信息</button>
            </div>
        </div>
    </div>
</div>

<script>
    $('#infoModal').on('show.bs.modal', function (event) {
        var target = $(event.relatedTarget);
        var sId = target.data('id');
        var sName = target.data('name');
        var sNumber = target.data('number');
        $(this).find('.modal-body input[type="hidden"]').val(sId);
        $(this).find('.modal-body label').text(sName + ' | ' + sNumber);
        $.ajax({
            url: '${pageContext.request.contextPath}/stud/getLocation',
            method: 'GET',
            data: {
                'sId': sId
            },
            dataType: 'json',
            success: function (data) {
                $('#provinceSel').val(data.provincePostCode || 0);
                $('#provinceSel').change();
                $('#citySel').val(data.cityPostCode || 0);
                $('#citySel').change();
                $('#areaSel').val(data.areaPostCode || 0);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("加载信息失败： " + errorThrown);
                return false;
            }
        });
    });

    $('#saveInfo').on('click', function () {
        var sId = $('.modal-body input[type="hidden"]').val();
        var provincePostCode = $('#provinceSel').val();
        var provinceName = $('#provinceSel').find('option:selected').text();
        var cityPostCode = $('#citySel').val();
        var cityName = $('#citySel').find('option:selected').text();
        var areaPostCode = $('#areaSel').val();
        var areaName = $('#areaSel').find('option:selected').text();
        if (provincePostCode == '0' || cityPostCode == '0' || areaPostCode == '0') {
            alert("请选择省份/城市/地区");
            return false;
        }
        $.ajax({
            url: '${pageContext.request.contextPath}/stud/updateLocation',
            method: 'POST',
            data: {
                'sId': sId,
                'provincePostCode': provincePostCode,
                'provinceName': provinceName,
                'cityPostCode': cityPostCode,
                'cityName': cityName,
                'areaPostCode': areaPostCode,
                'areaName': areaName
            },
            dataType: 'json',
            success: function (data) {
                if (data) {
                    $('.close').click();
                } else {
                    alert("保存信息失败");
                    return false;
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("保存信息失败： " + errorThrown);
                return false;
            }
        });

    });

    $('.deleteLink').on('click', function () {
        var data = $(this).data();
        var message = '确定要删除<span class="label label-danger">' + data['name'] + ' | ' + data['number'] + '</span>？';
        confirm(deteleItem, $(this), message);
    })

    function deteleItem($ele) {
        var sId = $ele.data()['id'],
            errMsg = "删除失败，请联系管理员";
        $.ajax({
            url: '${pageContext.request.contextPath}/stud/delStud?sId=' + sId,
            method: 'DELETE',
            success: function (isSuccess) {
                if (isSuccess) {
                    $ele.parent().parent().remove();
                } else {
                    alert(errMsg);
                    return false;
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errMsg + "[" + errorThrown + "]");
                return false;
            }
        });
    }

    $(function () {
        $.ajax({
            url: '${pageContext.request.contextPath}/location/getProvinces',
            method: 'GET',
            contentType: 'application/json;charset=UTF-8',
            data: null,
            success: function (data) {
                initSel('#provinceSel', data);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
                window.location.href = '${pageContext.request.contextPath}/login.jsp';
            },
            dataType: 'json'
        });
    });

    $('#provinceSel').change(function () {
        $.ajax({
            url: '${pageContext.request.contextPath}/location/getCitiesByProvince',
            method: 'GET',
            async: false,
            contentType: 'application/json;charset=UTF-8',
            data: {
                'provincePostCode': $('#provinceSel').val(),
                'provinceName': $('#provinceSel').find('option:selected').text()
            },
            success: function (data) {
                clearSel('#citySel');
                clearSel('#areaSel');
                initSel('#citySel', data);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
                window.location.href = '${pageContext.request.contextPath}/login.jsp';
            },
            dataType: 'json'
        });
    });

    $('#citySel').change(function () {
        $.ajax({
            url: '${pageContext.request.contextPath}/location/getAreasByCity',
            method: 'GET',
            async: false,
            contentType: 'application/json;charset=UTF-8',
            data: {
                'provincePostCode': $('#provinceSel').val(),
                'provinceName': $('#provinceSel').find('option:selected').text(),
                'cityPostCode': $('#citySel').val(),
                'cityName': $('#citySel').find('option:selected').text()
            },
            success: function (data) {
                clearSel('#areaSel');
                initSel('#areaSel', data);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
                window.location.href = '${pageContext.request.contextPath}/login.jsp';
            },
            dataType: 'json'
        });
    });

    function clearSel(selId) {
        $(selId).empty();
        $(selId).append("<option value='0'>请选择</option>");
    }

    function initSel(selId, data) {
        for (var index = 0; index < data.length; index++) {
            var obj = data[index];
            $(selId).append("<option value='" + obj.postcode + "'>" + obj.name + "</option>")
        }
    }

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
                    'grade': $('#hidden_grade').val(),
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