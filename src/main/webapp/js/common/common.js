/**
 * Created by Ye Jiahao on 2017/06/04.
 */
function loadPage(dataLayer, url, data, isAsync) {
    $.ajax({
        method: 'GET',
        url: url,
        async: isAsync,
        dataType: 'html',
        data: data,
        success: function (result, status) {
            $('#' + dataLayer).html(result);
        },
        error: function (result, status) {
            console.error(status);
        }
    });
}

function acitveTabById(id) {
    $('.nav.navbar-nav').children().removeClass('active');
    $('#' + id).addClass('active');
}