<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/header.jspf" %>
<body>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
        <li><a href="#">Library</a></li>
        <li class="active">Data</li>
    </ol>

    <div class="panel panel-default">
        <div class="panel-heading"><h4>修改密码</h4></div>
        <div class="panel-body">
            <form id="updatePasswdForm">
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-2 text-center"><h5>原密码：</h5></div>
                        <div class="col-lg-4"><input type="password" class="form-control" name="oldPasswd"
                                                     maxlength="20"/></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-2 text-center"><h5>请输入新密码：</h5></div>
                        <div class="col-lg-4"><input type="password" class="form-control" name="newPasswd1"
                                                     maxlength="20"/></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-2 text-center"><h5>确认新密码：</h5></div>
                        <div class="col-lg-4"><input type="password" class="form-control" name="newPasswd2"
                                                     maxlength="20"/></div>
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
            </form>
        </div>
    </div>

</div>
</body>
<script>
    $('#updatePasswdForm').on('submit', function () {
        var param = new Array();
        var formData = $(this).serializeArray();
        $.each(formData, function (index, element) {
            param.push(element['value']);
        });
        $.ajax({
            url: '/login/updatePassword',
            method: 'PUT',
            data: JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            success: function (data) {
                alert(data['message']);
            }
        });
    });
</script>
</html>