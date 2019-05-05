<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/header.jspf" %>
<body>
<div class="container">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Home</a></li>
        <li class="breadcrumb-item"><a href="#">Library</a></li>
        <li class="breadcrumb-item active">Data</li>
    </ol>

    <div class="card">
        <div class="card-header">
            <h4>修改密码</h4>
        </div>
        <div class="card-body">
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
    $('#updatePasswdForm').on('submit', function (event) {
        event.preventDefault();
        var param = new Array();
        var formData = $(this).serializeArray();
        $.each(formData, function (index, element) {
            param.push(element['value']);
        });
        $.ajax({
            url: '${pageContext['request']['contextPath']}/login/updatePassword',
            method: 'PUT',
            data: JSON.stringify(param),
            contentType: 'application/json;charset=UTF-8',
            success: function (result) {
                var obj = JSON.parse(result);
                alert(obj['message']);
            }
        });
    });
</script>
</html>