//判断是手机还是邮箱 是否符合规范
function judgeAccountType(loginName){
var phoneZZ= /^[A-Za-zd]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/;
var emailZZ =/^(1[34578]\d{9}|\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*|09\d{8})$/;
var taiwanPhoneZZ =/^(1[34578]\d{9}|09\d{8})$/;
var json = new Object();
json.judge = false;
 if(emailZZ.test(loginName)){
	 json.type = 1
     json.judge = true;		 
 }	

 if (phoneZZ.test(loginName)) {
	json.type = 0
	json.judge = true;
} else {
	 if(taiwanPhoneZZ.test(loginName)){
			json.type = 0
			json.judge = true;
	 }
}
 return json;
}

/**
 * 数据字典选项(由TTS中迁移过来,zhengshuang)
 * @param basedPath
 * @param data 需要传递给后台的参数，格式如：{'code' : 'XXX'}
 * @param obj 该下拉选的元素id
 */
function dataSelect(basedPath, data) {
	var dataSrc = [''];
	$.ajax({
		url: "getData",
		data:data,
		async: false,
		type:"get",
		dataType : 'json',
		success:function(d){
			for (var i = 0; i < d.length; i++) {
				dataSrc.push({id : d[i].code, text : d[i].name});
			}
		},
		error:function(){
			return null;
		}
	});
	return  dataSrc;
}

/*$('#userCenterDeatil').on('click',function(){
	location.href="jumpToUserCenterInfo";
});
$('#userCenterSecurity').on('click',function(){
	location.href="jumpToUserCenterSecurity";
});*/
