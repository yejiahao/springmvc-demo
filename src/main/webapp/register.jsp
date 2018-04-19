<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="/header.jspf" %>
<%@ include file="/footer.jspf" %>
<body>
<div class="container">
    <div class="card">
        <div class="card-header">
            <h4>注册新用户</h4>
            <button class="text-right btn">返回</button>
        </div>
        <div class="card-body">
            <form id="updatePasswdForm">
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-2 text-center"><h5>您的名字：</h5></div>
                        <div class="col-lg-4"><input type="password" class="form-control" name="oldPasswd"
                                                     maxlength="20"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-2 text-center"><h5>请输入新密码：</h5></div>
                        <div class="col-lg-4"><input type="password" class="form-control" name="newPasswd1"
                                                     maxlength="20"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-2 text-center"><h5>确认新密码：</h5></div>
                        <div class="col-lg-4"><input type="password" class="form-control" name="newPasswd2"
                                                     maxlength="20"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-2 text-center"><h5>上传头像：</h5></div>
                        <div class="col-lg-4"><input type="file" name="file"/>
                        </div>
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
</html>
