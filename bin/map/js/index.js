
$(function(){
	$('#go_index').animate({
		width: '235px',
		height: '80px',
		opacity: 1
	});
	
	$('#go_index').animate({
		width: '235px',
		height: '53px'
	},200,function(){
		$('#go_index').css('-webkit-transform','rotateY(360deg)');
		$('#go_index').css('-moz-transform','rotateY(360deg)');
		$('#go_index').css('-o-transform','rotateY(360deg)');
		$('#go_index').css('-ms-transform','rotateY(360deg)');
		$('#go_index').css('-transform','rotateY(360deg)');
	});
})
 function shows(){
	$('#index_view').show();
	$('body').css("background-image","url(http://jahwapingan.oss-cn-shanghai.aliyuncs.com/1/default/ssdh/index.jpg)"); 
	$('#go_index').hide();
}


function addGuest(){
	$("#error_msg").text('您好，您的信息尚未完善，请完整填写您的信息再提交!');
	if(getQueryParam().channel == '渠道选择'){
		$("#error_msg").modal("show");
		//$("#error_msg").text('[您好，您的信息尚未完善,请完整填写您的信息再提交!]请完成渠道选择！');
		setTimeout(function(){$("#error_msg").modal("hide")},3000);
		return;
	}else if(getQueryParam().name == ''){
		$("#error_msg").modal("show");
		//$("#error_msg").text('[您好，您的信息尚未完善,请完整填写您的信息再提交!]请输入姓名！');
		setTimeout(function(){$("#error_msg").modal("hide")},3000);
		return;
	}else if(!(/^1(3|4|5|7|8)\d{9}$/.test(getQueryParam().mobilePhone))){
		$("#error_msg").modal("show");
		//$("#error_msg").text('[您好，您的信息尚未完善,请完整填写您的信息再提交!]请输入正确的手机号码！');
		setTimeout(function(){$("#error_msg").modal("hide")},3000);
		return;
	}else if($("#city").val() == ''){
		$("#error_msg").modal("show");
		//$("#error_msg").text('[您好，您的信息尚未完善,请完整填写您的信息再提交!]请选择省份城市信息！');
		setTimeout(function(){$("#error_msg").modal("hide")},3000);
		return;
	}else if($("#address").val() == ''){
		$("#error_msg").modal("show");
		//$("#error_msg").text('[您好，您的信息尚未完善,请完整填写您的信息再提交!]请输入详细地址！');
		setTimeout(function(){$("#error_msg").modal("hide")},3000);
		return;
	}
	$.ajax({
		url : '../guest/addGuest.do',
		type : 'POST',
		data :getQueryParam(),
		dataType : 'json',
//		data : 'userCode=' + name + '&password=' + password,		
		success : function(data) {
			if(data.isAdd == true){
				$("#is_show").hide();
				$("#is_success").show();
			}else{
				$("#error_msg").modal("show");
				$("#error_msg").text(data.result);
				setTimeout(function(){$("#error_msg").modal("hide")},3000);
			}
		},
		error : function() {
			$("#error_msg").modal("show");
			$("#error_msg").text('[信息提交失败]未知错误！！！');
			setTimeout(function(){$("#error_msg").modal("hide")},3000);
			return;
		}
	});
}

function getQueryParam(){
	var queryJSON = {}
	queryJSON.name = $('#name').val();
	queryJSON.mobilePhone = $('#mobilePhone').val();
	queryJSON.address = $('#city').val()+' '+ $('#address').val();
	queryJSON.mobilePhone = $('#mobilePhone').val();
	queryJSON.channel= $('#channel span').text();
	return queryJSON;
}