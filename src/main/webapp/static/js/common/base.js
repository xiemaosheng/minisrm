var Base = {
    ctxPath : "",
    refresh : function(n) {
        if (n == 0) {
            var iframe = $("#content-main iframe:visible");
            iframe.attr("src", iframe.attr("src"));
        } else {
            $("#content-main iframe").each(function(index, item) {
                var iframe = $(this);
                iframe.attr("src", iframe.attr("src"));
            });
        }

    },
    logout : function() {
        Tip.confirm("确认退出？", function() {
            window.location.href = Base.ctxPath + "/logout";
        });
    },
    getScrollbarWidth : function() {
        var p = document.createElement('p'), styles = {
            width : '100px',
            height : '100px',
            overflowY : 'scroll'
        }, i, scrollbarWidth;
        for (i in styles)
            p.style[i] = styles[i];
        document.body.appendChild(p);
        scrollbarWidth = p.offsetWidth - p.clientWidth;

        var pnode = p.parentNode;
        if (pnode) {
            pnode.removeChild(p);
        }
        return scrollbarWidth;
    },
    tableAdjust : function(tableId) {
        var tbody = $("#" + tableId + " tbody");
        tbody.scrollTop(1);
        if (tbody.scrollTop() > 0) {
            $("#" + tableId + " thead").css("width",
                    (tbody.width() - this.getScrollbarWidth()) + "px");
            $("#" + tableId + " thead tr th:last").css("border-right", "none");
        } else {
            $("#" + tableId + " thead").css("width", tbody.width() + "px");
            $("#" + tableId + " thead tr th:last").css("border-right", "");
        }
        tbody.scrollTop(0);
    }
}

var Favorite = {
    init : function(id) {
        var favorite = Cookies.getJSON("favorite-pages");
        if (favorite) {
            var pages = favorite["100000"];
            for (var i = 0; i < pages.length; i++) {
                $(id)
                        .append(
                                "<div class='btn-group' style='position: relative'><span class='tab-favorite-close'>×</span><a class='btn btn-white m-r' href="
                                        + pages[i].url
                                        + " onclick='menuItem();' style='position:relative'><i style='color:#F8AC59;margin-right:6px;' class='fa fa-star'></i>"
                                        + pages[i].title + "</a></div>")
            }
        }
        $(id + " .tab-favorite-close").on("click", function(e) {
            Tip.confirm("确认删除？", function() {
                $('.navbar-minimalize').trigger('click');
            });
        });
    },
    add : function() {
        var tabs = $(".page-tabs .page-tabs-content a");
        if (tabs.length == 1) {
            Tip.info("当前页无法收藏");
            return;
        }
        var title = $(".page-tabs .page-tabs-content a.active").text();
        var url = $("#content-main iframe:visible").attr("src");
        var page = {
            title : title,
            url : url
        };
        var favorite = Cookies.getJSON("favorite-pages");
        if (favorite) {
            var pages = favorite["100000"];
            var exists = false;
            for (var i = 0; i < pages.length; i++) {
                if (pages[i].url == url) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                Tip.info("当前页面已在收藏列表");
                return;
            }
            Tip.success("页面收藏成功");
            pages.push(page);
            Cookies.set("favorite-pages", {
                "100000" : pages
            });
        } else {
            if (url && title) {
                Cookies.set("favorite-pages", {
                    "100000" : [ page ]
                });
                Tip.success("页面收藏成功");
            }
        }
    }
}

var Validator = {
    init : function(formId, fields) {
        $(formId).bootstrapValidator({
            container : 'popover',
            excluded : [ ':disabled' ],
            feedbackIcons : {
                valid : 'glyphicon glyphicon-ok',
                invalid : 'glyphicon glyphicon-remove',
                validating : 'glyphicon glyphicon-refresh'
            },
            fields : fields
        });
    },
    validate : function(formId) {
        var form = $(formId);
        form.data("bootstrapValidator").resetForm();
        form.bootstrapValidator('validate');
        return form.data('bootstrapValidator').isValid();
    }
}

var Tip = {
    confirm : function(tip, ensure) {
        var player = parent.layer;
        parent.layer.confirm(tip, {
            btn : [ "确定", "取消" ]
        }, function(index) {
            ensure();
            player.close(index);
        }, function(index) {
            player.close(index);
            if ($("button[type='submit'").length > 0) {
                $("button[type='submit'").removeAttr("disabled");
            }
        });
    },
    alert : function(info, iconIndex) {
        parent.layer.msg(info, {
            icon : iconIndex
        });
    },
    info : function(info) {
        Tip.alert(info, 0);
    },
    success : function(info) {
        Tip.alert(info, 1);
    },
    error : function(info) {
        Tip.alert(info, 2);
    }
}

$(function() {
    $(".navbar-minimalize").click(function() {
        var fa = $(this).find("i");
        if (fa.hasClass("fa-arrow-left")) {
            fa.removeClass("fa-arrow-left");
            fa.addClass("fa-bars");
            $(".logo-element img").attr("src", "/static/img/logo2.png");
        } else {
            fa.addClass("fa-arrow-left");
            fa.removeClass("fa-bars");
            setTimeout(function() {
                $(".logo-element img").attr("src", "/static/img/logo1.png");
            }, 280);
        }
    });

    $(".user-info").click(function() {
        $(".profile-element").show();
    });

    $(".J_tabRefreshCur").click(function() {
        Base.refresh(0);
    });

    $(".J_tabRefreshAll").click(function() {
        Base.refresh(1);
    });
    $(".J_tabFavorite").click(function() {
        Favorite.add();
    });

    /*
     * var winUrl = window.parent.location.href; var ifrUrl =
     * window.location.href; var host = winUrl.substring(0,
     * winUrl.lastIndexOf("/")); var loginUrl = host+"/login"; if(winUrl !=
     * ifrUrl && ifrUrl.indexOf(loginUrl) != -1){ window.parent.location.href =
     * ifrUrl; }
     */
})

String.prototype.endWith = function(str) {
    if (str == null || str == "" || this.length == 0
            || str.length > this.length)
        return false;
    if (this.substring(this.length - str.length) == str)
        return true;
    else
        return false;
    return true;
}

String.prototype.startWith = function(str) {
    if (str == null || str == "" || this.length == 0
            || str.length > this.length)
        return false;
    if (this.substr(0, str.length) == str)
        return true;
    else
        return false;
    return true;
}