<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/header.jspf" %>
<%@ include file="/footer.jspf" %>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8 order-md-1">
            <h4 class="mb-3">注册新用户</h4>
            <form id="registerForm">
                <div class="mb-3">
                    <label for="account">登录账号</label>
                    <input type="text" id="account" name="account" class="form-control" value="" required>
                    <div class="invalid-feedback">登录账号不能为空</div>
                </div>
                <div class="mb-3">
                    <label for="userName">真实姓名</label>
                    <input type="text" id="userName" name="userName" class="form-control" value="" required>
                    <div class="invalid-feedback">真实姓名不能为空</div>
                </div>
                <div class="mb-3">
                    <label for="password">登录密码</label>
                    <input type="password" id="password" name="password" class="form-control" value="" maxlength="20"
                           placeholder="长度6~20位" required>
                </div>
                <div class="mb-3">
                    <label for="passwdConfirm">确认密码</label>
                    <input type="password" id="passwdConfirm" name="passwdConfirm" class="form-control" value=""
                           maxlength="20" placeholder="长度6~20位" required>
                </div>
                <div class="mb-3">
                    <label>性别</label>
                    <div class="row">
                        <div class="custom-control custom-radio col-md-1 offset-md-1 mb-3">
                            <input type="radio" id="male" name="gender" class="custom-control-input" value="1" checked
                                   required>
                            <label class="custom-control-label" for="male">男</label>
                        </div>
                        <div class="custom-control custom-radio col-md-1 mb-3">
                            <input type="radio" id="female" name="gender" class="custom-control-input" value="0"
                                   required>
                            <label class="custom-control-label" for="female">女</label>
                        </div>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="role">用户角色</label>
                    <select id="role" name="role" class="custom-select d-block w-50" required>
                        <option value="1">学生</option>
                        <option value="2">教师</option>
                        <option value="3">管理员</option>
                    </select>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="emailAccount">邮箱账号</label>
                        <input type="text" id="emailAccount" name="emailAccount" class="form-control" value="">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="emailDomain">邮箱域名</label>
                        <div class="input-group">
                            <div class="input-group-append">
                                <span class="input-group-text">@</span>
                            </div>
                            <input type="text" id="emailDomain" name="emailDomain" class="form-control" value="">
                        </div>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="portrait">上传头像</label>
                    <div class="custom-file">
                        <input type="file" id="portrait" name="portrait" class="custom-file-input">
                        <label class="custom-file-label" for="portrait">选择文件</label>
                    </div>
                </div>
                <div class="mb-5">
                    <hr>
                    <button type="submit" id="submitRegister" class="btn btn-lg btn-primary btn-block">提交注册信息</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>

<script>
    $('#registerForm').on('submit', function (event) {
        event.preventDefault();
        var data = $('#registerForm').serialize();
        console.log(data);

        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/login/register',
            data: data,
            success: function (result) {
                var obj = JSON.parse(result);
                alert(obj['message']);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(errorThrown);
            }
        });
    });
</script>
</html>
