<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/header.jsp" %>
<body>
<%@ include file="/navbar.jsp" %>
<div style="margin-top: 80px;">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">学生信息</div>
        <div id="studentLayer">
            <%@include file="/WEB-INF/jsp/student/studentlisttable.jsp" %>
        </div>
    </div>

    <div id="pageLayer" style="padding-right: 20px;">
        <nav aria-label="Page navigation" style="text-align: right">
            <ul class="pagination" id="pageLayerul"></ul>
        </nav>
    </div>
</div>
</body>
</html>
<script>
    $(function () {
        var options = {
            currentPage: ${currentPage},
            totalPages: ${totalPages},
            numberOfPages: 5,
            itemTexts: function (type, page) {
                switch (type) {
                    case "first":
                        return "首页";
                    case "prev":
                        return "上页";
                    case "next":
                        return "下页";
                    case "last":
                        return "尾页";
                    case "page":
                        return page;
                }
            },
            onPageClicked: function (event, originalEvent, type, page) {
                loadPage('studentLayer', '${pageContext.request.contextPath}/stud/showStudInfos.do', page);
            }
        }
        $('#pageLayerul').bootstrapPaginator(options);

        //导航栏高亮显示对应模块
        acitveTabById('studentli');
    });
</script>
