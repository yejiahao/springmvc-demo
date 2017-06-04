<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img alt="Brand"
                                                  src="${pageContext.request.contextPath}/image/logo.png"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li id="mainli"><a href="${pageContext.request.contextPath}/login/login.do">首页</a>
                </li>
                <li id="studentli"><a href="${pageContext.request.contextPath}/stud/showStudInfos.do">学生管理</a></li>
                <li id="courseli"><a href="#">课程管理</a></li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">用户管理</a></li>
                <li><a href="#">系统管理</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">${loginUser['userName']}<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> 账号设置</a></li>
                        <li role="separator" class="divider"></li>
                        <li id="exitli"><a href="${pageContext.request.contextPath}/login/logout.do"><span
                                class="glyphicon glyphicon-log-out" aria-hidden="true"></span> 退出</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
</body>
</html>