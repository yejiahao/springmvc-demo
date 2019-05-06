<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/header.jspf" %>
<script>
    $(function () {
        // jquery style must add "[0]"
        ($('#mainli').find('a'))[0].click();

        getOnlineCount();
        setInterval(getOnlineCount, 60 * 1000);
    });

    function getOnlineCount() {
        $.get('${pageContext.request.contextPath}/login/getOnlineCount', function (data) {
            $('.badge').html(data);
        });
    }

    function setIframe(url, obj) {
        $('.active').removeClass('active');
        $(obj).parent().addClass('active');

        $('#j-mainContent').prop('src', '${pageContext.request.contextPath}' + url);
    }

    function changeFrameHeight() {
        $('#j-mainContent').prop('height', $(window).height());
    }

    window.onresize = function () {
        changeFrameHeight();
    }
</script>
<body style="overflow-y:hidden">
<nav class="navbar navbar-expand-md fixed-top navbar-dark bg-dark">
    <div class="container-fluid">
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav mr-auto">
                <li id="mainli" class="nav-item"><a href="#" onclick="setIframe('/loginsuccess.jsp', this)"
                                                    class="nav-link">首页</a></li>
                <li id="studentli" class="nav-item"><a href="#"
                                                       onclick="setIframe('/stud/showStudInfos', this)"
                                                       class="nav-link">学生管理</a></li>
                <li id="achievementli" class="nav-item"><a href="#" class="nav-link">成绩管理</a></li>
                <li id="courseli" class="nav-item"><a href="#" class="nav-link"
                                                      onclick="setIframe('/coursemodule.jsp', this)">课程管理</a></li>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Submit</button>
                </form>
            </ul>

            <ul class="navbar-nav mr-sm-3">
                <li class="nav-item"><a class="nav-link">当前在线人数<span
                        class="badge badge-pill badge-secondary">*</span></a></li>
                <li class="nav-item"><a href="#" class="nav-link">用户管理</a></li>
                <li class="nav-item"><a href="#" class="nav-link">系统管理</a></li>
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">${loginUser['userName']}</a>
                    <div class="dropdown-menu">
                        <a id="settingli" class="dropdown-item" href="#"
                           onclick="javascript:setIframe('/login/accountSetting', this)">
                            <i class="fa fa-cog fa-fw"></i>账号设置</a>
                        <a id="exitli" class="dropdown-item" href="${pageContext.request.contextPath}/login/logout">
                            <i class="fa fa-sign-out fa-fw"></i>退出</a>
                    </div>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<iframe frameborder="0" id="j-mainContent" onload="changeFrameHeight()"></iframe>
<%@ include file="/footer.jspf" %>
</body>
</html>