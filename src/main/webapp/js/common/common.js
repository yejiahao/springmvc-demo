/**
 * Created by Ye Jiahao on 2017/06/04.
 */
function acitveTabById(id) {
    $('.nav.navbar-nav').children().removeClass('active');
    $('#' + id).addClass('active');
}

$(function () {
    $('.datetimepicker').datetimepicker({
        format: 'yyyy-mm-dd',
        language: 'zh-CN',
        minView: 'month'
    });
});