/**
 * Created by Ye Jiahao on 2017/06/04.
 */
function loadPage(dataLayer, url, page) {
    $.ajax({
        method: 'GET',
        url: url,
        dataType: 'html',
        data: {
            'page': page
        },
        success: function (result, status) {
            $('#' + dataLayer).html(result);
        }
    });
}

function acitveTabById(id) {
    $('.nav.navbar-nav').children().removeClass('active');
    $('#' + id).addClass('active');
}