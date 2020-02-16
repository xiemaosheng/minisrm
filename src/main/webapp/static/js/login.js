$(function () {
    //粒子背景特效
    $('body').particleground({
        dotColor: '#ddd',
        lineColor: '#ddd'
    });
})


/**
 * 验证码更改
 */
$(function () {
    $('#kaptchaImage').click(function () {
        $(this).attr('src', Base.ctxPath + 'kaptcha?' + Math.floor(Math.random() * 100));
    })
});

function loginBefore(obj) {
    var $submitBtn = $(obj);
    $submitBtn.val("登录中...");
    $submitBtn.prop("disabled", true);
    $submitBtn.css("cursor", "not-allowed");
}

function loginAfter(obj) {
    var $submitBtn = $(obj);
    $submitBtn.val("立即登录");
    $submitBtn.prop("disabled", false);
    $submitBtn.css("cursor", "pointer");
}

/**
 * 用户登录
 */
$(function () {
    $('.submit_btn').click(function () {
        var username = $("input[name='username']").val();
        if (username.length <= 0) {
            toastr.warning("请输入帐号");
            $("input[name='username']").attr("placeholder", "请输入帐号");
            return false;
        }
        var password = $("input[name='password']").val();
        if (password.length <= 0) {
            toastr.warning("请输入密码");
            $("input[name='password']").attr("placeholder", "请输入密码");
            return false;
        }
        var kaptchaFlag = $("input[name='kaptchaFlag']").val();
        var kaptcha = $("input[name='kaptcha']").val();
        if (kaptchaFlag && kaptcha && kaptcha.length <= 0) {
            toastr.warning("输入验证码");
            $("input[name='kaptcha']").attr("placeholder", "输入验证码");
            return false;
        }
        loginBefore(this);
        $.ajax({
            url: Base.ctxPath + '/dologin',
            type: 'post',
            dataType: 'json',
            data: {
                "username": username,
                "password": password,
                "kaptcha": kaptcha
            },
            success: function (result) {
                if (result.code == 200) {
                    window.location.href = Base.ctxPath + '/';
                } else {
                    console.info(result.message);
                    toastr.error(result.message);
                    loginAfter($('.submit_btn'));
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                var error = $.parseJSON(jqXHR.responseText);
                toastr.error(error.message);
                $("input[name='kaptcha']").val("");
                $("input[name='kaptcha']").attr("placeholder", error.message);
                $("#kaptchaImage").trigger("click");
                loginAfter($('.submit_btn'));
            }
        });
    })
});

/**
 * 回车登录实现
 */
$(document).keyup(function (event) {
    if (event.keyCode == 13) {
        $(".submit_btn").trigger("click");
    }
});