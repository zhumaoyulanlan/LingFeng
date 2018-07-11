<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0036)http://uc.tmooc.cn/login/jumpTologin -->
<html class="height-100">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<title>登录</title>
<link rel="stylesheet" href="${basePath}/css/iconfont.css">
<link rel="stylesheet" href="${basePath}/css/style.css">
<script src="js/jquery-2.1.1.js"></script>
<style>
.height-100 {
	height: 100%;
}

body.height-100 {
	padding-bottom: 240px;
	min-height: 971px;
	position: relative;
}

.page-footer.bd-con-lty {
	height: 240px;
	position: absolute;
	bottom: 0;
	width: 100%;
}
</style>
<link rel="stylesheet" href="/css/layer.css" id="layuicss-layer">
</head>
<body class="bgcolor-f6f5fa height-100">
	<div class="page-header">

		<script>
window.IS_UC_PAGE_ = true; //用户中心页面标识
</script>

		<div class="md2018033001lty">
			<div class="container">
				<div class="tmooc-logo pull-left">
					<a href="http://www.tmooc.cn/"> <img class="default-logo"
						src="img/tmooc-logo.png"> <img class="blue-logo"
						src="img/tmooc-logo2.png">
					</a>
				</div>

				<div class="login-area pull-right " id="login_statelty">
					<!--未登录状态-->
					<ul class="no-login clearfix">
						<li><a id="register_xxw"
							href="#">注册</a></li>
						<li class="line">|</li>
						<li><a id="login_xxw"
							href="#">登录</a></li>
					</ul>
			
				</div>
		
			</div>
		</div>
		<!--       <div style="height: 70px; background: #00A4FF;">这里是页头占位</div> -->
	</div>
	<div class="page-con" style="padding: 70px 0 30px;">
		<form autocomplete="off" action="login.do" method="post" >
			<div class="md-2018040402-ll js-md-180417-login-cj"
				style="margin: 0 auto;">
				<div class="js-log-type" data-logtype="0">
					<div class="tit">登录</div>
					<div id="js_login_form" class="form-ele-box">
						<div class="form-item clearfix">
							<div class="form-inp-area">
								<input id="js_account_pm" class="form-input" value="" name="login_name"
									type="text" cusrule="mail_phone" placeholder="邮箱或手机号">
								<span class="form-tips">邮箱或手机号格式错误</span>
							</div>
						</div>
						<div class="form-item clearfix">
							<div class="form-inp-area">
								<input id="js_password" class="form-input" value="" name="pwd"
									type="password" cusrule="pwd" placeholder="密码"> <span
									class="form-tips">包含数字、字母、下划线的6-18位</span>
							</div>
						</div>
						<div id="js_validate_img_area" class="form-item clearfix"
							style="display: none;">
							<div class="form-inp-area">
								<input id="js_imgcode" class="form-input pull-left" value=""
									type="text" placeholder="验证码"
									style="width: 80px; margin-right: 15px;"> <img
									id="js_validate_img" class="pull-left code-img js-validate-img"
									src="http://uc.tmooc.cn/login/jumpTologin" height="40px"
									width="80px" style="cursor: pointer; margin-right: 15px;">
								<div class="form-inlineblock pull-left code-btn js-validate-img">
									<span class="verflag" style="cursor: pointer;">看不清楚？换一张</span>
									<i class="verflag"></i>
								</div>
								<span class="form-tips">验证码错误</span>
							</div>
						</div>
						<div class="form-item clearfix">
							<button id="js_submit_login"
								class="form-btn form-btn-blue width-100" type="submit">登录</button>
						</div>
						<div class="form-item clearfix" style="font-size: 12px;">
							<div class="form-checkbox pull-left" style="display: none;">
								<label><input type="checkbox" checked="checked"><span>下次自动登录</span></label>
							</div>
							<div class="pull-right color-aaa" style="padding-top: 2px;">
								<a href="http://uc.tmooc.cn/login/jumpToUserFindPassword"
									class="color-aaa">忘记密码</a>&nbsp;|&nbsp;<a
									href="http://uc.tmooc.cn/login/jumpToRegister"
									class="color-aaa">注册</a>
							</div>
						</div>
						<!--                             <div class="other-loginbox"> -->
						<!--                                 <p class="c-tit color-aaa text-center">对不起,不支持第三方账号登录</p> -->
						<!--                                 <div class="c-btns"> -->
						<!--                                     <div class="c-fbtn"> -->
						<!--                                         <a class="c-btn js-log-type-cut"><i class="cusfont cusfont-wechat"></i></a> -->
						<!--                                     </div> -->
						<!--                                 </div> -->
						<!--                             </div> -->
					</div>
				</div>
				<!-- 微信 -->
				<!--                     <div class="js-log-type" data-logtype="3" style="display: none;"> -->
				<!--                         <div id="js_wx_code_log" class="text-center"></div> -->
				<!--                         <div class="other-loginbox"> -->
				<!--                             <div class="c-btns"> -->
				<!--                                 <div class="c-fbtn js-log-type-cut">返回账号登录</div> -->
				<!--                             </div> -->
				<!--                         </div> -->
				<!--                     </div> -->
			</div>
		</form>
	</div>
	<div class="page-footer bd-con-lty">

		<div class="container">
			<div class="md2018040301lty clearfix">
				<div class="bt-fr clearfix pull-right">
					<div class="b-info text-right pull-left">
						<p>文明 和谐 友爱</p>
						<p></p>
					</div>
					<div class="ewm-b pull-left">
						<img src="/img/erweima.jpg" width="75" height="75" alt="">
					</div>
				</div>
				<div class="bt-lf clearfix pull-left">
					<ul class="links clearfix">
						<li><a href="http://www.tmooc.cn/aboutus/index.shtml">关于我</a></li>
						<li>|</li>
						<li><a href="http://www.tmooc.cn/join/index.shtml">应聘信息</a></li>
						<li>|</li>
						<li><a href="http://www.tmooc.cn/contactus/index.shtml">联系我们</a></li>
						<li>|</li>
						<li><a href="http://www.tmooc.cn/business/index.shtml">暂无商务合作</a></li>
						<!--<li>|</li>
                <li><script src="https://s13.cnzz.com/z_stat.php?id=1273669604&web_id=1273669604" language="JavaScript"></script></li>-->
					</ul>
					<p class="copyright">Copyright © zhuamoyu.com</p>
				</div>
				<div class="bt-line"></div>
			</div>
		</div>


		<script src="js/layer.js"></script>
		<script src="js/jquery.colorbox-min.js"></script>
		<script src="js/app.js"></script>

		<script type="text/javascript">
    $(function(){
        getUserLoginStatus(); //获取用户登录状态信息
        /*点击搜索按钮*/
        $('#js_control_search').click(function(){
            var k_ = $.trim($('#js_search_inp').val());

            if(window.SEARCHPAGE_){
                if(k_){
                    $('.js-key-word').eq(0).text(k_);

                    resetSearch(1);

                    flag_ = true;

                    getClasslset(getSearchobj({searchCore:k_}));

                }
                layer.msg('请输入搜索内容');
                return;
            }else {
                location.href='http://www.tmooc.cn/search/index.shtml#searchCore='+encodeURI(encodeURI(k_));//+'categoryId='+($(".js-lv-xxw span.curx").data('id') || "0");
            }
            $('#js_search_inp').val('');
        });
        $('#js_search_inp').keypress(function(e){
            if(e.keyCode===13){
                $('#js_control_search').trigger('click');
            }
        });
    });
</script>
	</div>
	<script
		src="http://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin.js"></script>
	<script src="./js/main.js"></script>
	<script src="./js/jsmd5.js"></script>
	<script src="./js/jquery-cookie.js"></script>
	<script type="text/javascript">
            initLoginFn();     
        </script>


	<div id="cboxOverlay" style="display: none;"></div>
	<div id="colorbox" class="" role="dialog" tabindex="-1"
		style="display: none;">
		<div id="cboxWrapper">
			<div>
				<div id="cboxTopLeft" style="float: left;"></div>
				<div id="cboxTopCenter" style="float: left;"></div>
				<div id="cboxTopRight" style="float: left;"></div>
			</div>
			<div style="clear: left;">
				<div id="cboxMiddleLeft" style="float: left;"></div>
				<div id="cboxContent" style="float: left;">
					<div id="cboxTitle" style="float: left;"></div>
					<div id="cboxCurrent" style="float: left;"></div>
					<button type="button" id="cboxPrevious"></button>
					<button type="button" id="cboxNext"></button>
					<button type="button" id="cboxSlideshow"></button>
					<div id="cboxLoadingOverlay" style="float: left;"></div>
					<div id="cboxLoadingGraphic" style="float: left;"></div>
				</div>
				<div id="cboxMiddleRight" style="float: left;"></div>
			</div>
			<div style="clear: left;">
				<div id="cboxBottomLeft" style="float: left;"></div>
				<div id="cboxBottomCenter" style="float: left;"></div>
				<div id="cboxBottomRight" style="float: left;"></div>
			</div>
		</div>
		<div
			style="position: absolute; width: 9999px; visibility: hidden; display: none; max-width: none;"></div>
	</div>
</body>
</html>