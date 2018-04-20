/**
 * Created by Ye Jiahao on 2017/06/04.
 */
function acitveTabById(id) {
    $('.nav.navbar-nav').children().removeClass('active');
    $('#' + id).addClass('active');
}

function confirm(func, $ele) {
    if ($('#myConfirm').length > 0) {
        $('#myConfirm').remove();
    }

    var message = '确定要删除<span class="badge badge-danger">' + $ele.data()['name'] + ' | ' + $ele.data()['number'] + '</span>？';

    var html = '<div class="modal fade" id="myConfirm" tabindex="-1" role="dialog" aria-labelledby="myConfirmLabel">'
        + '<div class="modal-dialog modal-sm" role="document"><div class="modal-content"><div class="modal-header">'
        + '<h4 class="modal-title" style="font-size:14px;" id="myConfirmLabel">确认</h4>'
        + '<button class="close" data-dismiss="modal" aria-label="Close"><i class="fa fa-remove fa-lg"></i></button></div>'
        + '<div class="modal-body text-center" style="font-size:16px;">' + message + '</div>'
        + '<div class="modal-footer">'
        + '<button class="btn btn-sm btn-info" data-dismiss="modal">取消</button>'
        + '<button class="btn btn-sm btn-danger" id="confirmOK">确定</button>'
        + '</div></div></div></div>';

    $('body').append(html);
    $('#myConfirm').modal('show');

    $('#confirmOK').on('click', function () {
        func($ele);
        $('#myConfirm').modal('hide');
    })
}

function modalAlert(message) {
    if ($('#myAlert').length > 0) {
        $('#myAlert').remove();
    }

    var html = '<div class="modal fade" id="myAlert" tabindex="-1" role="dialog" aria-labelledby="myAlertLabel">'
        + '<div class="modal-dialog modal-sm" role="document"><div class="modal-content">'
        + '<div class="modal-body text-center" style="font-size:16px;">' + message + '</div>'
        + '<div class="modal-footer">'
        + '<button class="btn btn-sm btn-primary" id="alertOK">确定</button>'
        + '</div></div></div></div>';

    $('body').append(html);
    $('#myAlert').modal('show');

    $('#alertOK').on('click', function () {
        $('#myAlert').modal('hide');
    })
}

$(function () {
    $('.datetimepicker').datetimepicker({
        format: 'yyyy-mm-dd',
        language: 'zh-CN',
        minView: 'month'
    });
});