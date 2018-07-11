/* 配置 */
var UC_PATH_ = "http://uc.tmooc.cn"; // 用户中心API接口前缀 例如 :http://xxx.com/[包名]
var TTS_MYTTS_URL = "http://tts.tmooc.cn"; // TTS 线上
//var TTS_MYTTS_URL = "http://tts9.tmooc.com"; // TTS 测试环境

//登录成功回调方法 队列；使用方法： window.loginSuccessCallback.add(fn);
window.loginSuccessCallback = $.Callbacks();
//退出成功回调方法 队列；使用方法： window.logoutSuccessCallback.add(fn);
window.logoutSuccessCallback = $.Callbacks();

// 全局ajax设置

$.ajaxSetup({
    headers: {
        'X-Requested-With': 'XMLHttpRequest'
    },
    xhrFields: {
        withCredentials: true
    }
});

/* 公共方法 */
/* tab标签 demo-test @lianglei */
$.fn.cusTab = function(opt) {
    var tabs_ = this.find('[data-module="tab"]');
    tabs_.on('click', function() {
        if($(this).hasClass('active')) {
            return false;
        }
        tabs_.removeClass('active');
        $(this).addClass('active');
        var target_ = $('#' + $(this).data('target'));
        target_.addClass('active');
        target_.siblings('.tab-item').removeClass('active');
        if($.type(opt) == 'object' && $.type(opt.callback) == 'function') {
            opt.callback(tabs_, target_);
        }

    });
};
// 获取指定 cookie
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if(arr = document.cookie.match(reg)) {
        return unescape(arr[2]);
    } else {
        return '';
    }
}
// 获取hash
function get_hash(strName) {
    var strHref = window.location.hash;
    var intPos = strHref.indexOf('#');
    var strRight = strHref.substr(intPos + 1);
    var arrTmp = strRight.split('&');
    for(var i = 0; i < arrTmp.length; i++) {
        var arrTemp = arrTmp[i].split('=');
        if(arrTemp[0].toUpperCase() == strName.toUpperCase() && arrTemp[1]) {
            if(i === arrTmp.length - 1) {
                var sIndex = arrTemp[1].indexOf('#');
                if(sIndex !== -1) {
                    arrTemp[1] = arrTemp[1].substring(0, sIndex);
                }
            }
            return arrTemp[1];
        }
    }
    return '';
}
// 写入hash
function set_hash(str) {
    if(str && typeof(str) == "string") {
        window.location.hash = '#' + str;
    }
}

/*自定义下拉选*/
function cusmot_select_fun(obj, callback) {
    var cus_sel_box = (typeof(obj) == 'string') ? $('#' + obj) : obj,
        cus_sel_list = cus_sel_box.find('ul.custom_sel_list'),
        cus_sel_val = cus_sel_box.find('input.custom_sel_val'),
        cus_sel_text = cus_sel_box.find('.custom_sel_text');
    cus_sel_val.val('');
    cus_sel_list.on('click.cusselect', 'li.option', function() {
        cus_sel_text.text($(this).text());
        cus_sel_val.val($(this).attr('ord_id'));
        if(callback && typeof(callback) == 'function') {
            callback($(this).attr('ord_id'), cus_sel_box);
        }
    });
    cus_sel_box.on('click', function() {
        if(cus_sel_list.is(':hidden')) {
            $(document).one('mousedown.order', function(e) {
                var sel_cur_box = $(e.target).closest(cus_sel_box);
                if(sel_cur_box.length > 0) {
                    return;
                }
                cus_sel_list.hide();
            });
            cus_sel_list.show();
        } else {
            $(document).off('mousedown.order');
            cus_sel_list.hide();
        }
    });
}
/*关闭弹窗*/
$(document).on('click', '.js-closewin-btn', function() {
    $.colorbox && $.colorbox.close();
});
$("#js_loginout").click(function() {
    logout_fn();
    return false;
});

function logout_fn() { //退出登录
    $.get(UC_PATH_ + '/user/exitLogin', function(res) {
        if(res.code == 1) {
            if(window.IS_UC_PAGE_) { //个人中心退出登录 返回到登录首页
                location.href = UC_PATH_ + '/login/jumpTologin';
                getUserLoginStatus();
            } else {
                getUserLoginStatus(); //更新tobbar状态
                window.logoutSuccessCallback.fire(res);
            }
        } else {
            layer.msg(res.msg);
        }
    });
    return false;
}

/*验证类型*/
function checkType(str, type, obj, form) {
    switch(type) {
        case 'required':
            /*必填*/
            return(str != '');
        case 'mail':
            return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(str);
        case 'phone':
            /*手机号验证,支持台湾*/
            return /^((?!1{11})1\d{10}|09\d{8})$/.test(str);
        case 'mail_phone':
            return /^(\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*|(?!1{11})1\d{10}|09\d{8})$/.test(str);
        case 'code':
            return(function() {
                var num = obj.attr('cuslength') || 1;
                var str_ = '^[0-9]{' + num + '}$';
                var reg = new RegExp(str_);
                return reg.test(str);
            })();
        case 'code_en':
            return(function() {
                var num = obj.attr('cuslength') || 1;
                var str_ = '^[0-9a-zA-Z]{' + num + '}$';
                var reg = new RegExp(str_);
                return reg.test(str);
            })();
        case 'chinese':
            return /^[\u4E00-\u9FA5]+$/.test(str);
        case 'ch_and_en':
            /*姓名验证*/
            return /^[a-zA-Z\u4E00-\u9FA5]+$/.test(str);
        case 'nickname':
            return(function() {
                var num = obj.attr('cuslength') || '4,12';
                var str_ = '^[[0-9a-zA-Z_\u4E00-\u9FA5]{' + num + '}$';
                var reg = new RegExp(str_);
                return reg.test(str);
            })();
            //return /^[0-9a-zA-Z_\u4E00-\u9FA5]{4,12}$/.test(str);
        case 'qq':
            /*QQ*/
            return /^[0-9]{5,11}$/.test(str);
        case 'pwd':
            return /^[0-9a-zA-Z_]{6,18}$/.test(str);
        case 'equalTo':
            return(function() {
                var tar = obj.attr('equalTo');
                return(str === $.trim(form.find('#' + tar).val()));
            })();
        case 'specialchars':
            return !/[\-\_\,\!\|\~\`\(\)\#\$\%\^\&\*\{\}\:\;\"\<\>\?]/g.test(str);
        default:
            return true;
    }
}

function validateForm(form_id, opt) {
    var form_ = $('#' + form_id);
    if(!form_.length) {
        return false;
    }
    var fnObj = $.extend(true, {
        checkform: function(obj, val, type) {
            if(type == 'select' || type == 'radio_checkbox') {
                obj.off('change.cusrule').on('change.cusrule', function() {
                    fnObj.errtips($(this), this.value, $(this).attr('cusrule'));
                });
            } else {
                obj.off('blur.cusrule').on('blur.cusrule', function() {
                    fnObj.errtips($(this), this.value, $(this).attr('cusrule'));
                });
            }
            return this.errtips(obj, val, type);
        },
        form: function() {
            var param = true;
            form_.find('input[cusrule], select[cusrule], textarea[cusrule], div[cusrule]').each(function(i, n) {
                var obj = $(n);
                var cur = fnObj.checkform(obj, this.value, obj.attr('cusrule'));
                param = (param && cur);
            });
            return param;
        },
        errtips: function(obj, val, type) {
            var res = checkType(val, type, obj, form_);
            !res ? obj.closest('.form-inp-area').addClass('error') : obj.closest('.form-inp-area').removeClass('error');
            return res;
        }
    }, opt);

    return fnObj;
}
/*登录弹框-xxw*/
$('#login_xxw').click(function() {
    if(window.IS_UC_PAGE_) { //用户中心页面登录
        location.href = UC_PATH_ + '/login/jumpTologin';
    } else {
        toLoginWinFn();
    }
    return false;
});

/* 登陆弹窗方法 */
function toLoginWinFn() {
    $.colorbox({
        speed: 0,
        inline: true,
        overlayClose: false,
        close: false,
        href: "#login_boxxxw",
        onOpen: function() {
            $('#js_login_form').find('.error').removeClass('error');
            $('.js-md-180417-login-cj').find('.js-log-type:first').show()
                .siblings('.js-log-type').hide();
            $('#js_account_pm, #js_password, #js_imgcode').val('');
            $('#js_submit_login').data('isclick', false).html('登录');
        }
    });
    refreshValidateImg(); //刷新验证码
}

/*顶部导航下拉菜单-lty*/
$('#js_init_dropmenu').mouseenter(function() {
    $(this).find('.drop-menu-list').stop().slideDown(250);
}).mouseleave(function() {
    $(this).find('.drop-menu-list').stop().slideUp(250);
})
/*在线报名 start*/
$(function() {
    /*if($('.md2018041201lty').length != 0) {
        js_init_sign();
    }*/
    $("#js_sign_up").on('mouseenter', function() {
        $.colorbox({
            speed: 0,
            inline: true,
            overlayClose: false,
            close: false,
            href: "#sign_uplty",
            onOpen: function() {
                reset_form();
            },
            onComplete: function() {
                js_init_sign();
            }
        });
    });
    /*重置表单-lty*/
    function reset_form() {
        var obj_ = $("#sign-formlty");
        obj_[0].reset();
        obj_.find('.custom_sel_text').html('请选择');
        obj_.find('.custom_sel_val').val('');
        obj_.find('.form-inp-area').removeClass('error');
    }
    //返回顶部 -lty
    $('#js_comback').click(function() {
        $('body,html').animate({
            scrollTop: 0
        }, 500);
    });
    /*在线报名-lty*/
    function js_init_sign() {
        if($("#sign_uplty").data('is_jsinited')) {
            return false;
        }
        $("#sign_uplty").data('is_jsinited', true);
        /*动态统计textarea的字数-lty*/
        function limitLength(obj, num) {
            var val_input = obj.val(),
                val_length = val_input.length;
            $("#js_total_lty").text(num - Number(val_length));
            if(val_length > num) {
                obj.val(val_input.substring(0, num + 1));
                $("#js_total_lty").text('0');
            } else {
                return;
            }
        }
        $("#remark").keyup(function() {
            limitLength($(this), 255);
        });
        /*构造下拉列表-lty*/
        function js_struc_data(d) {
            var html_ = "";
            $.each(d, function(i) {
                html_ += '<li class="option" ord_id="' + d[i].id + '">' + d[i].name + '</li>';
            })
            return html_;
        };

        /*初始化学科下拉项-lty*/
        $.ajax({
            type: "post",
            url: UC_PATH_ + "/tmoocCategory/queryTop",
            dataType: "json",
            data: {},
            success: function(d) {
                if(d.list != "") {
                    $("#js_subject").find('.custom_sel_list').html(js_struc_data(d));
                }
            }
        });
        cusmot_select_fun($("#js_course"), function(id, par_obj) {
            par_obj.find('.custom_sel_val').trigger('blur.cusrule'); //每次选择后重新触发验证
        });
        cusmot_select_fun($("#js_subject"), function(id, par_obj) {
            par_obj.find('.custom_sel_val').trigger('blur.cusrule'); //每次选择后重新触发验证
            $("#js_course").find('.custom_sel_text').html('请选择');
            $("#js_course").find('.custom_sel_val').val('');
            var pid;
            //  获取当前课程的id
            var pid = $("#subject").val();
            $.ajax({
                type: "post",
                url: UC_PATH_ + "/tmoocCategory/query",
                dataType: "json",
                data: {
                    parentId: pid
                },
                success: function(d) {
                    if(d.list != "") {
                        $("#js_course").find('.custom_sel_list').html(js_struc_data(d));
                    }
                }
            });
        });

        /*初始化城市下拉选-lty*/
        $.ajax({
            type: "post",
            url: UC_PATH_ + "/applicationForm/findProvince",
            dataType: "json",
            data: {},
            success: function(d) {
                if(d.list != '') {
                    $("#js_province").find('.custom_sel_list').html(js_struc_data(d.list));
                }
            }

        });
        cusmot_select_fun($("#js_city"), function(id, par_obj) {
            par_obj.find('.custom_sel_val').trigger('blur.cusrule'); //每次选择后重新触发验证
        });
        cusmot_select_fun($("#js_province"), function(id, par_obj) {
            par_obj.find('.custom_sel_val').trigger('blur.cusrule'); //每次选择后重新触发验证
            $("#js_city").find('.custom_sel_text').html('请选择');
            $("#js_city").find('.custom_sel_val').val('');
            // 获取当前选择课程的id
            var pid = $.trim($('#province').val());
            $.ajax({
                type: "post",
                url: UC_PATH_ + "/applicationForm/findCityInProvince",
                dataType: "json",
                data: {
                    provinceId: pid
                },
                success: function(d) {
                    $("#js_city").find('.custom_sel_list').html(js_struc_data(d.list));

                }
            });
        });

        function save() {
            var telephone = $.trim($('#telephone').val());
            var qq = $.trim($('#qq').val());
            var name = $.trim($('#name').val());
            var cityId = $.trim($("#city").val());
            var cityName = $.trim($('#js_city .custom_sel_text').text());
            var categoryId = $.trim($("#course").val());
            var categoryName = $.trim($('#js_course .custom_sel_text').text());
            var remark = $.trim($('#remark').val());
            var that_ = $("#js_sign_btn");
            that_.prop("disabled", true);
            $.ajax({
                type: "post",
                url: UC_PATH_ + "/applicationForm/save",
                dataType: "json",
                data: {
                    telephone: telephone,
                    qq: qq,
                    name: name,
                    cityId: cityId,
                    cityName: cityName,
                    categoryId: categoryId,
                    categoryName: categoryName,
                    remark: remark
                },
                success: function(d) {
                    if(d.code == '1') {
                        layer.msg('亲爱的用户，您已经申请成功！');
                        $.colorbox.close();
                    }
                    that_.prop("disabled", false);
                },
                error: function() {
                    that_.prop("disabled", false);
                }
            });
        }
        /*在线报名验证-lty*/
        $("#js_sign_btn").click(function() {
            if(validateForm('sign-formlty').form()) {
                save();
            };
        });
    }

});

/*在线报名 end*/

/*获取传参*/
function requestParam(strName) {
    var strHref = location.search;
    var intPos = strHref.indexOf('?');
    if(intPos === -1) {
        return '';
    }
    var strRight = strHref.substr(intPos + 1);
    var arrTmp = strRight.split('&');
    for(var i = 0; i < arrTmp.length; i++) {
        var arrTemp = arrTmp[i].split('=');
        if(arrTemp[0].toUpperCase() == strName.toUpperCase()) {
            if(i === arrTmp.length - 1) {
                var sIndex = arrTemp[1].indexOf('#');
                if(sIndex !== -1) {
                    arrTemp[1] = arrTemp[1].substring(0, sIndex);
                }
            }
            return arrTemp[1];
        }
    }
    return '';
}

/* ccj */

// 图片验证码
function refreshValidateImg(ele) {
    $('#' + (ele || 'js_validate_img')).attr("src", UC_PATH_ + "/validateCode?t=" + Math.random());
}
// 发送短信、邮箱验证码
function sendValidateCode(opt) {
    if($.type(opt) != 'object' || !opt.obj.length) {
        return false;
    }
    var $obj = opt.obj;
    if(!$obj.data('issend')) {
        var second = opt.time || 59;
        var s_time = setInterval(function() {
            if(second <= 1) {
                $obj.prop('disabled', false).data('issend', false).text(opt.txt || '获取动态码');
                clearInterval(s_time);
                return false;
            } else {
                $obj.text('（' + second-- + 's）');
            }
        }, 1000);

        $.post(opt.url, opt.data, function(res) {
            if(res.code != 1) {
                $obj.prop('disabled', false).data('issend', false).text(opt.txt || '获取动态码');
                clearInterval(s_time);
                layer.msg(res.msg);
            }
            opt.callback && opt.callback(res);
        });
        $obj.prop('disabled', true).data('issend', true);
    }
}
// 初始化登录
function initLoginFn() {
    // refreshValidateImg();

    $('.js-validate-img').click(function() {
        refreshValidateImg();
    });
    // 登录类型切换
    $('.js-md-180417-login-cj').on('click', '.js-log-type-cut', function() {
        var p_ = $(this).closest('.js-log-type');
        p_.hide().siblings('.js-log-type').show();

        var sib_ = p_.siblings('.js-log-type');
        if(sib_.data('logtype') == 3) {
            var state;
            if(window.IS_UC_PAGE_) {
                state = window.IS_UC_PAGE_;
            } else {
                var local = location.href;
                state = encodeURIComponent(encodeURIComponent(local));
            }

            new WxLogin({
                self_redirect: false,
                id: "js_wx_code_log",
                appid: "wx3478ef3576df5109",
                scope: "snsapi_login",
                redirect_uri: encodeURIComponent("http://www.tmooc.cn/touc" + "/login/wxLogin"),
                state: state,
                style: "black",
                href: ""
            });
        }
        setTimeout(function() {
            $.colorbox && $.colorbox.resize();
        }, 10);
    });
    /**
     * @author zhumaoyu
     * @returns
     */
//    $('#js_submit_login').click(function() {
//    	var login_name= $.trim($('#login_name').val();
//    	var 
//    	
//    	if(true){
//    		$.post(UC_PATH_ + "/login/loginTimes", {
//              login_name: login_name,
//              			pwd:pwd
//          }, function(res) {
//            
//                      }
//    	}
//    	
//    }
    
    
//    // 提交表单-登录
//    $('#js_submit_login').click(function() {
//        if(validateForm('js_login_form').form()) {
//            var t_ = $(this);
//            var loginNmae = $.trim($('#js_account_pm').val());
//            var password = $.trim($('#js_password').val());
//            var imgcode = $.trim($('#js_imgcode').val());
//            var log_type; // 0 手机，1 邮箱
//
//            var flag_ = true;
//
//            // 用户名类型判断
////            if(checkType(loginNmae, 'mail')) {
////                log_type = 1;
////            } else if(checkType(loginNmae, 'phone')) {
////                log_type = 0;
////            }
//
//            if(!t_.data('isclick')) {
//                t_.data('isclick', true).html('登录中...');
//                // 登录次数
//                $.post(UC_PATH_ + "/login/loginTimes", {
//                    login_Name: loginNmae
//                    //accountType: log_type
//                }, function(res) {
//                    if(res.code == 1) {
//                        if(res.obj >= 3) {
//                            if(!$('#js_validate_img_area').is(':visible')) {
//                                $('#js_validate_img_area').show().find('#js_imgcode').attr('cusrule', 'code_en').attr('cuslength', 4);
//                                $.colorbox.resize();
//                                flag_ = false;
//                                refreshValidateImg();
//                            }
//                            t_.data('isclick', false).html('登录');
//                        }
//                        if(flag_) {
//                            // 登录接口
//                            $.post( "login.do", {
//                                loginName: loginNmae,
//                                password: MD5(password),
//                                imgCode: imgcode,
//                                accountType: log_type
//                            }, function(res) {
//                                // TODO 
//                                // TTS 用户要有提示信息
//                                if(res.code == 1 || res.code == 2) {
//                                    if(window.IS_UC_PAGE_) { //用户中心页面登录，跳转到个人中心首页
//                                        location.href = UC_PATH_ + "/userCenter/toUserCenterPage";
//                                        return false;
//                                    } else { //门户网站 关闭弹窗
//                                        layer.msg('登录成功');
//                                        getUserLoginStatus(); //更新tobbar状态
//                                        window.loginSuccessCallback.fire(res); //登录成功回调
//                                    }
//                                    if(res.code == 2) {
//                                        /*TTS用户验证提醒*/
//                                        $.colorbox({
//                                            speed: 0,
//                                            inline: true,
//                                            overlayClose: false,
//                                            close: false,
//                                            href: "#js_yz_video"
//                                        });
//                                    } else {
//                                        $.colorbox && $.colorbox.close();
//                                    }
//                                } else if(res.code == -8009) {
//                                    // 未激活
//                                    $('#js_account_pm').before('<a href="http://uc.tmooc.cn/login/jumpToActiveMailobx" style="position: absolute;top: -17px;font-size: 12px;">该账号未激活，<span style="color:red">点击去激活</span></a>');
//                                } else if(res.code == -9001) {
//                                    // 禁用
//                                    layer.msg(res.msg);
//                                } else {
//                                    layer.msg(res.msg);
//                                    refreshValidateImg();
//                                }
//                                t_.data('isclick', false).html('登录');
//
//                            });
//                        }
//                    } else {
//                        t_.data('isclick', false).html('登录');
//                        layer.msg(res.msg);
//                    }
//                });
//            }
//
//        }
//    });
    $('#js_password, #js_imgcode').keypress(function(e) {
        if(e.keyCode === 13) {
            $('#js_submit_login').trigger('click');
        }
    });
}


// 注册初始化
function initRegisterFn() {
    refreshValidateImg();
    $('.js-validate-img').click(function() {
        var $img = $(this).closest('.form-inp-area').find('img');
        refreshValidateImg($img.attr('id'));
    });
    // 切换tab
    $('#md_2018040401_ll').cusTab({
        callback: function(tabs_, target_) {
            if(target_.attr('id') == 'md_2018040401_ll_tab2') {
                refreshValidateImg('js_validate_img_m');
            } else {
                refreshValidateImg();
            }
        }
    });
    // 注册 方法
    function register(obj, type, loginName, password, nickName, validateCode) {
        if(!obj.data('issend')) {
            $.post(UC_PATH_ + "/user/registerAccount", {
                loginName: loginName,
                password: MD5(password),
                nickName: nickName,
                validateCode: validateCode,
                accountType: type
            }, function(res) {
                if(res.code != 1) {
                    obj.data('issend', false);
                    refreshValidateImg((type == 1 && 'js_validate_img_m'));
                    layer.msg(res.msg);
                } else {
                    if(window.IS_UC_PAGE_) { //用户中心页面登录，跳转到个人中心首页
                        layer.msg('注册成功,3s后跳转登录页');
                        setTimeout(function() {
                            location.href = UC_PATH_ + '/login/jumpTologin';
                        }, 3000);
                    } else {
                        $.colorbox && $.colorbox.close();
                        getUserLoginStatus(); //更新tobbar状态
                    }
                }
                window.registerSuccessCallback && window.registerSuccessCallback(res);
            });
            obj.data('issend', true);
        }
    }
    // 手机 动态验证码
    $('#js_DynamicCodePhone').click(function() {
        var t_ = $(this);
        var reg_account = $.trim($('#js_account_phone').val());
        var img_code = $.trim($('#js_imgcode_phone').val());

        var v_account = validateForm('js_reg_phone_form').checkform($('#js_account_phone'), reg_account, 'phone');
        var v_imgCode = validateForm('js_reg_phone_form').checkform($('#js_imgcode_phone'), img_code, 'code_en');

        if(v_account && v_imgCode) {
            sendValidateCode({
                obj: t_,
                url: UC_PATH_ + "/user/sendPhoneCode",
                data: {
                    phone: reg_account,
                    imgCode: img_code
                }
            });
        }
    });
    // 邮箱 动态验证码
    $('#js_DynamicCodeEmail').click(function() {
        var t_ = $(this);
        var reg_account = $.trim($('#js_account_mail').val());
        var img_code = $.trim($('#js_imgcode_mail').val());

        var v_account = validateForm('js_reg_mail_form').checkform($('#js_account_mail'), reg_account, 'mail');
        var v_imgCode = validateForm('js_reg_mail_form').checkform($('#js_imgcode_mail'), img_code, 'code_en');

        if(v_account && v_imgCode) {
            sendValidateCode({
                obj: t_,
                url: UC_PATH_ + "/user/sendEmail",
                data: {
                    email: reg_account,
                    imgCode: img_code
                }
            });
        }
    });
    // 手机 注册
    $('#js_submit_reg_phone').click(function() {
        if(!$('#js_form_user_regyx').is(':checked')){
            layer.msg('请阅读并勾选同意用户注册协议！');
            return false;
        }
        if(validateForm('js_reg_phone_form').form()) {
            var account = $.trim($('#js_account_phone').val());
            var pwd = $.trim($('#js_pwd_phone2').val());
            var img_code = $.trim($('#js_imgcode_phone').val());
            var dy_code = $.trim($('#js_dy_code_phone').val());

            register($(this), 0, account, pwd, '', dy_code);
        }
    });
    // 邮箱 注册
    $('#js_submit_reg_mail').click(function() {
        if(!$('#js_form_user_regyx').is(':checked')){
            layer.msg('请阅读并勾选同意用户注册协议！');
            return false;
        }
        if(validateForm('js_reg_mail_form').form()) {
            var account = $.trim($('#js_account_mail').val());
            var name = $.trim($('#js_name_mail').val());
            var pwd = $.trim($('#js_pwd_mail2').val());
            var img_code = $.trim($('#js_imgcode_mail').val());
            var dy_code = $.trim($('#js_dy_code_mail').val());

            register($(this), 1, account, pwd, name, dy_code);
        }
    });
    $('#js_dy_code_phone').keypress(function(e) {
        if(e.keyCode === 13) {
            $('#js_submit_reg_phone').trigger('click');
        }
    });
    $('#js_dy_code_mail').keypress(function(e) {
        if(e.keyCode === 13) {
            $('#js_submit_reg_mail').trigger('click');
        }
    });
}

// 下拉菜单-云笔记
$('#js_go_ynote').click(function(event) {
    window.open("http://inote.tmooc.cn" + "/login/loginnow?sessionId=" + getCookie("TMOOC-SESSION"));
    return false;
});

function getUserLoginStatus() { //获取用户的登录状态
    var login_stateObj = $('#login_statelty');
    if(login_stateObj.length == 0) {
        return false;
    }
    $.getJSON(UC_PATH_ + '/userValidate/getUserInfo', function(d) {
        if(d && d.code == '1') { //登录状态
            login_stateObj.find('.logined').show();
            login_stateObj.find('.no-login').hide();
            $("#tobbar_username").text(d.obj.nickName).attr('href', UC_PATH_ + "/userCenter/toUserCenterPage")
                .attr('target', function() {
                    if(window.IS_UC_PAGE_) { //用户中心页面
                        return '_self';
                    }
                    return '_blank';
                });
            if(d.obj.pictureUrl) {
                $("#tobbar_userimg").attr('src', d.obj.pictureUrl);
            } else {
                $("#tobbar_userimg").attr('src', "http://cdn.tmooc.cn/tmooc-web/css/img/user-head.jpg");
            }
            $("#tobbar_userimg").parent('a').attr('href', UC_PATH_ + "/userCenter/toUserCenterPage")
                .attr('target', function() {
                    if(window.IS_UC_PAGE_) { //用户中心页面
                        return '_self';
                    }
                    return '_blank';
                });
            // 判断 tts 用户
            if(d.obj.userChannel && d.obj.userChannel == '10061007') {
                login_stateObj.find('#js_isshow_tts').show();
            }
        } else {
            login_stateObj.find('.logined').hide();
            login_stateObj.find('.no-login').show();
            $("#tobbar_username").text('');
            $("#tobbar_userimg").attr('src', "http://cdn.tmooc.cn/tmooc-web/css/img/user-head.jpg");
        }
    });
}

function check_old_sp_user() { //判断是否 历史付费用户
    var flag_ = false;
    $.getJSON(UC_PATH_ + '/userCenter/getUserBuy', function(d) {
        if(d && d.code == '1' && d.obj.status == '0') { //未激活用户
            layer.confirm('兑换会员<br/><a href="#" target="_blank">@#$</a>', {
                btn: ['已同意并确认兑付', '取消']
            }, function(index) {
                if(!flag_){
                    flag_ = true;
                    $.getJSON(UC_PATH_ + '/userCenter/updateUserBuy', function(dd) {
                        if(dd && dd.code =='1'){ //激活兑换成功
                            layer.msg('兑付成功！');
                            layer.close(index);
                        }else{
                            layer.msg('兑付失败！请联系客服！');
                        }
                        flag_ = false;
                    });
                }
            });
        }
    });
}

function openPayStatusFn() { //打开支付状态弹窗
    $.colorbox({
        speed: 0,
        inline: true,
        overlayClose: false,
        close: false,
        href: "#md_2018040423_ll"
    });
}

function checkTtsUser() {
    $.ajax({
        type: "post",
        url: UC_PATH_ + "/user/checkTtsUser",
        dataType: "json",
        async: false,
        success: function(data) {
            if(data.code == -8001) {
                // 未登录，跳转登录页
                layer.msg('请先登录，3秒后自动跳转到登录页！', {}, function() {
                    window.location.href = UC_PATH_ + '/login/jumpTologin';
                });
            } else if(data.code == 1) {
                // 是TTS用户，进入TTS
                var w = window.open();
                w.location = TTS_MYTTS_URL + "/user/myTTS?sessionId=" + encodeURI(data.obj) + "&date=" + (encodeURI(new Date()));
            } else {
                // 统一跳转到着陆页
                window.location.href = 'http://www.tmooc.cn/ttspages/online-class/web/TMOOC/index.shtml';
            }
        }
    });
    return false;
}

/* ccj */

/* lty */
/*导航列表对应页面点亮*/
$(function() {
    var url_ = window.location.pathname.replace('index.shtml', '');
    $.each($("#js_slide_nav a"), function() {
        var href_ = $(this).attr("href");
        if(href_) {
            href_ = /www.tmooc.cn(\/(\w+?\/)?)?/.exec(href_);
            if(href_ && href_[1] && href_[1] == url_) {
                $(this).parent().addClass('active');
                return false;
            }
        }
    });
});

/* lty */
