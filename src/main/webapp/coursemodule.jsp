<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/header.jspf" %>
<body>
<div class="container" style="margin-top: 4rem;">
    <div class="card-columns" id="courseLayer"/>
</div>

<script>
    let formatTime = function (time) {
        let date = new Date();
        date.setTime(time);
        return date.toLocaleDateString();
    };

    let appendCourse = function (course) {
        let html = '<div class="card bg-light">'
            + '<div class="card-header text-center">' + course.nameZhCN + '</div>'
            + '<div class="card-body" style="height: 10rem;overflow:auto;">'
            + '<p class="card-text" style="text-indent: 2rem;">' + course.description + '</p>'
            + '</div>'
            + '<div class="card-footer">'
            + '<small class="text-muted">Last updated ' + formatTime(course.updateTime) + '</small>'
            + '</div>'
            + '</div>'
        $('#courseLayer').append(html);
    };

    $(function () {
        $.ajax({
            type: 'GET',
            url: '${pageContext['request']['contextPath']}/course/listCourseItem',
            dataType: 'json',
            success: function (result) {
                // SUCCESS_CODE
                if (result.code === 100) {
                    $(result.data.items).each(function (index, course) {
                        appendCourse(course);
                    });
                }
            },
            error: function (xhr) {
            }
        });
    })
</script>
</body>
</html>
