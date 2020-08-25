// JavaScript Document
BS=window.BS||{}

BS.Article={};
BS.Article.dingstatus=false;
BS.Article.updateNum=function(obj,id,field)
{
	
	if(BS.Article.dingstatus)
	 {
		 BS.Common.hint("<img src='/Public/Home/images/hinted.png'/>");
		 return;
	 }
	//alert(id);
	$.ajax(
	  {
		url: "/peixun/index/ajax_updatenum",
		type: "POST", 		
		data:{id:id,field:field}, 
		dataType: "html", 
		success: function(result){
			if(field!='shownum')
			{
				var num=$(obj).find("span").text();
				var rnum=parseInt(num)+1;
				$(obj).find("span").text(rnum);
				BS.Article.dingstatus=true;
				$(".thanks").show();
				$(".thanks").fadeOut(1800);
			}
		}
	})	

}
BS.Article.fontSize=function(size,target)
{
	$(target).find("*").css("font-size",size);
}
BS.Article.readAll=function(obj,id)
{
	$.ajax(
	  {
		url: "/peixun/index/ajax_getcontent",
		type: "POST", 		
		data:{id:id}, 
		dataType: "json", 
		success: function(result){
			
			 $("#cont_"+id).show();
			 $("#cm_dd_"+id).show();
			 $("#cont_"+id).find(".list_content").html(result['content']);
			 //$(obj).attr("onclick","BS.Article.hideContent(this,"+id+")");
			 $(obj).attr("onclick","BS.Article.hideContent(this,"+id+")");
			 $(obj).text("鏀惰捣");
			 
			 if(result['islogin']==1)
			   $("#cm_bm_"+id).html("<a href='/user'>"+result['nickname']+"</a>");
			 else
			     $("#cm_bm_"+id).html("璇�<a href=\"javascript:;\" onclick=\"checkLogin("+id+")\">鐧诲綍</a>鍚庤瘎璁�");
		}
	})	
}
BS.Article.hideContent=function(obj,id)
{
	 $("#cont_"+id).hide();
	 $("#cm_dd_"+id).hide();
	 $(obj).text("蹇€熼槄璇�");
	 $(obj).attr("onclick","BS.Article.readAll(this,"+id+")");; 
}
BS.Article.sendComment=function(id,content)
{
 
	$.ajax(
	  {
		url: "/peixun/index/ajax_sendcomment",
		type: "POST", 		
		data:{id:id,content:content}, 
		dataType: "html", 
		success: function(result){
		    if(result=='ok')
			{
				$("#cm_content_"+id).val("");
				BS.Common.hint("<img src='/Public/Home/images/commentdone.png'/>");
			}
			else
			{
				BS.Common.hint("<img src='/Public/Home/images/commentno.png'/>");
			}
		}
	})	
   //	alert("鍙戣〃鎴愬姛");
}
BS.Article.addCommDiv=function(obj,replyid,dockid,sway)
{
	$("#replay_comment").remove();
	
	var divclass="pop_box";
	if(sway==1)
	{
		divclass="pop_box_s";
	}
	 var cov='<div class="'+divclass+'" id="replay_comment">'+"<input type='hidden' name='replyid' value='"+replyid+"' />"+"<input type='hidden' name='dockid' value='"+dockid+"' />"+'<s></s><textarea name="comment"></textarea><div class="box_btn"><a href="javascript:;" onclick="sendComment(this)">鍙戣〃璇勮</a></div></div>';
	
	$(cov).insertAfter($(obj).parent());
	
	
}

BS.Member={};

BS.Member.loadCss=function(url)
{

        var link = document.createElement( "link" );
        link.type = "text/css";
        link.rel = "stylesheet";
        link.href = url;
        document.getElementsByTagName( "head" )[0].appendChild( link );
}

BS.Member.getCity=function(obj,target)
{
	var pid=0;
	if(obj)   
	   pid=$(obj).find("option:selected").val(); 
	$.ajax(
	  {
		url: "/Member/ajax_getcity", 
		type: "POST", 		
		data:{pid:pid}, 
		dataType: "json", 
		success: function(result){
			var content="<option value='0'>璇烽€夋嫨...</option>";
			for(key in result)
			{
				content+="<option value='"+result[key]['id']+"'>"+result[key]['city']+"</option>";
			}
			$(target).html(content);
		}
	})	
}

BS.Member.checkLogin=function(islogin,func)
{

    var login_url = "/user/login/do_login";
    $.post(login_url,{},function(data){
        var obj_data = eval('('+data+')');
        if(obj_data.status==1){
			func();
        }else{
			BS.Member.lateFunc=func;
            BS.Member.loadCss('/cms/public/css/pop-layer.css');
			BS.Member.ajaxLogin();
        }
    });
}

BS.Member.ajaxLogin=function(a)
{



    if($(".login-reg-layer").length<1||a)
    {
		$(".login-reg-layer").remove();
		BS.Member.loadCss('/cms/public/css/pop-layer.css');
        BS.Member.ShowCover();


        var loginele = $('<div class="login-reg-layer" style="z-index: 999999999"><div class="layer-block"><div class="layer-close" onclick="BS.Member.closeLogin()"></div><div class="layer-tit">娆㈣繋鐧诲綍鎬濋€擟MS瀹樼綉</div>'+
		'<div class="shortcut-link">杩樻病鏈夋€濋€旂綉绔欒处鍙凤紵<a href="javascript:;" onclick="BS.Member.ajaxGoreg()" class="login_direct">椹笂娉ㄥ唽</a></div>'+
		'<div class="user-msg-block"><div style="color: red" id="error"></div><ul><li><input type="text" class="msg-text w296 username" name="account" id="account" placeholder="璇疯緭鍏ユ墜鏈�/閭/鐢ㄦ埛鍚�" /></li>' +
			'<li><input type="password" class="msg-text w296 password" name="pwd" id="pwd" placeholder="璇疯緭鍏ュ瘑鐮�" /></li><li><input type="text" class="msg-text w166 code" name="code" id="code" placeholder="楠岃瘉鐮�" /><img class="pic-yzm" style="cursor: pointer"  title="鐐瑰嚮鎴戞洿鎹㈤獙璇佺爜" src="/user/captcha?math='+Math.random()+'" onClick="this.src=this.src+\'?math=\'+ Math.random()" /></li>' +
			'<li><input type="button" class="finish-btn" onclick="BS.Member.ajaxGoLogin()" value="鐧诲綍"></li></ul></div><div class="shortcut-link">蹇樿瀵嗙爜锛�<a href="/user/findpass/step1" target="_blank">鎵惧洖瀵嗙爜</a></div></div></div>');

        $("body").append(loginele);
        var s_top=$(window).scrollTop()+140;
        var s_left=($(window).width()-430)/2;
        loginele.css('left',s_left);
        loginele.css('top',s_top);
        loginele.css('z-index',9999999999);
        loginele.css('position','absolute');

        $(window).scroll(function(e) {
            var s_top=s_top;
            var s_left=s_left;
            loginele.css('left',s_left);
            loginele.css('top',s_top);
        });


    }
}
var allowsend = 1; //鏄惁鍏佽鍙戦€侀獙璇佺爜
var is_can_submit = 1;//鏄惁鍏佽鎻愪氦
function code_timeout(v) {
	if (v > 0) {
		$('.sendcode').html('閲嶅彂楠岃瘉鐮�(' + (--v) + ')');
		setTimeout(function () {
			code_timeout(v)
		}, 1000);
	}
	else {
		$('.sendcode').html('閲嶅彂楠岃瘉鐮�');
		allowsend = 1;
	}
}

//鍙戦€侀獙璇佸槢
BS.Member.send_check_code = function(){
	if(allowsend==0)
	{ return false;}
	var mobile = $("#mobile").val();
	if (!/^0?1[3|4|5|7|8][0-9]\d{8}$/.test(mobile)) {
		layer.alert('鎵嬫満鍙风爜鏍煎紡涓嶆纭�,璇峰～鍐欐纭殑鎵嬫満鍙风爜',{icon: 2,title:'淇℃伅鎻愮ず',btn:['纭']});
		return false;
	}
	var url =  '/user/findpass/ajax_sendmsgcode?phone=' + mobile;
	$.getJSON(url, function (data) {
		if (data.Success == 1) {
			layer.msg('楠岃瘉鐮佸彂閫佹垚鍔�', {icon: 1,time: 1000});
			code_timeout(60);
			allowsend = 0;
		} else {
			layer.msg("楠岃瘉鐮佸彂閫佸け璐�," + data.Message, {icon: 2,time: 1000});
		}
	}, 'json');
}

//娉ㄥ唽椤甸潰
BS.Member.ajaxGoreg=function()
{
		$(".login-reg-layer").remove();
		var loginele = $('<div class="login-reg-layer"><div class="layer-block">' +
			'<div class="layer-close" onclick="BS.Member.closeLogin()"></div><div class="layer-tit">娉ㄥ唽鎬濋€擟MS甯愬彿</div>'+
			'<div class="shortcut-link">宸叉湁鎬濋€旂綉绔欒处鍙凤紵<a href="javascript:;" onclick="BS.Member.ajaxLogin(1)" class="login_direct">鐩存帴鐧婚檰</a></div>'+
			'<div class="user-msg-block"><div style="color: red" id="error"></div>' +
			'<ul><li><input type="text" class="msg-text w296 username" name="mobile" id="mobile" placeholder="璇疯緭鍏ユ墜鏈�" /></li>' +
			'<li><input type="password" class="msg-text w296 password" name="pwd_reg" id="pwd_reg" placeholder="璇疯緭鍏ュ瘑鐮�" /></li>' +
			'<li><input type="text" class="msg-text w166 code" name="checkcode" id="checkcode" placeholder="鍔ㄦ€侀獙璇佺爜" />' +
			'<span class="send sendcode" onclick="BS.Member.send_check_code()">鍙戦€侀獙璇佺爜</span>'+
			'</li>' +
			'<li><input type="button" class="finish-btn" onclick="BS.Member.ajaxGodoreg()" value="鎻愪氦"></li></ul>' +
			'</div></div></div>');

		$("body").append(loginele);
		var s_top=$(window).scrollTop()+140;
		var s_left=($(window).width()-430)/2;
		loginele.css('left',s_left);
		loginele.css('top',s_top);
		loginele.css('z-index',999999999);
		loginele.css('position','absolute');

		$(window).scroll(function(e) {
			var s_top=s_top;
			var s_left=s_left;
			loginele.css('left',s_left);
			loginele.css('top',s_top);
		});





};
BS.Member.closeLogin=function()
{
    $(".login-reg-layer").remove();
    BS.Member.closeCover();
    layer.closeAll();
}


BS.Member.ajaxGodoreg=function()
{
	var mobile=$(".login-reg-layer").find('#mobile').val();
	var password=$(".login-reg-layer").find('#pwd_reg').val();
	var checkcode=$(".login-reg-layer").find('#checkcode').val();
	//鎵嬫満鏍煎紡
	if (!/^0?1[3|4|5|7|8][0-9]\d{8}$/.test(mobile)) {
        $(".login-reg-layer").find("#error").text("鎵嬫満鍙风爜鏍煎紡涓嶆纭�,璇峰～鍐欐纭殑鎵嬫満鍙风爜!");
		//layer.alert('',{icon: 2,title:'淇℃伅鎻愮ず',btn:['纭']});
		return false;
	}
	//鎵嬫満閲嶅楠岃瘉
	$.ajax({
		type: 'post',
		dataType: 'json',
		url: '/user/login/do_judgePhone',
		data: {phone: mobile},
		async:false,
		success:function(json){
			if(json.status==0)
			{
                $(".login-reg-layer").find("#error").text("璇ユ墜鏈哄凡琚敞鍐�!");
				//layer.alert('璇ユ墜鏈哄凡琚敞鍐�',{icon: 2,title:'淇℃伅鎻愮ず',btn:['纭']});
				is_can_submit = 0 ;
			}
			else
			{
				is_can_submit = 1;
			}
		}
	});
	if(is_can_submit!=1)
	{
		return false;
	}

	//瀵嗙爜
	if(password.length<8)
	{
        $(".login-reg-layer").find("#error").text("瀵嗙爜涓嶈兘灏忎簬8浣�!");
		//layer.alert('瀵嗙爜涓嶈兘灏忎簬8浣�',{icon: 2,title:'淇℃伅鎻愮ず',btn:['纭']});
		return false;
	}
	//楠岃瘉鐮�
	if(checkcode.length<4){
        $(".login-reg-layer").find("#error").text("璇峰～鍐欐纭殑楠岃瘉鐮�!");
		//layer.alert('璇峰～鍐欐纭殑楠岃瘉鐮�',{icon: 2,title:'淇℃伅鎻愮ず',btn:['纭']});
		return false;
	}
	$.ajax(
		{
			url: "/user/login/do_ajax_doreg",
			type: "POST",
			data:{mobile:mobile,password:password,checkcode:checkcode},
			dataType: "json",
			success: function(result){
				console.debug(result);
				if(result['status']=='1')
				{
					console.debug('adasdd');
					BS.Member.userinfo=result['userinfo'];
					BS.Member.haslogin=true;
					$(".login-reg-layer").remove();
					BS.Common.hint('<img src="/Public/Home/images/log_success.png"/>');
					window.setTimeout(BS.Member.lateFunc,1000);
					BS.Member.closeCover();
				}
				else if(result['status']=='2')
				{
					$(".login-reg-layer").find("#error").text("楠岃瘉鐮侀敊璇�!");
					$(".login-reg-layer").find("#code").val('');
				}
				else if(result['status']=='3')
				{
					$(".login-reg-layer").find("#error").text("鎵嬫満鍙锋垨瀵嗙爜涓嶆弧瓒虫潯浠�!");
					$(".login-reg-layer").find("#code").val('');
				}
			}
		})

}
BS.Member.ajaxGoLogin=function()
{
    var username=$(".login-reg-layer").find('.username').val();
    var password=$(".login-reg-layer").find('.password').val();
    var code=$(".login-reg-layer").find('.code').val();

    if(!username||!password||!code){
        $("#error").text("鐢ㄦ埛鍚嶃€佸瘑鐮佹垨楠岃瘉鐮佷笉鑳戒负绌�!");
        return;
    }

    $.ajax(
        {
            url: "/user/login/do_ajaxlogin",
            type: "POST",
            data:{account:username,password:password,code:code},
            dataType: "json",
            success: function(result){
                if(result['status']=='1')
                {
                    BS.Member.userinfo=result['userinfo'];
                    BS.Member.haslogin=true;
                    //$(".top_operate p:eq(0)").html(result['topbar']);
                    //$(".atc_top_login span:eq(0)").html(result['topbar']);
                    $(".login-reg-layer").remove();
                    BS.Common.hint('<img src="/Public/Home/images/log_success.png"/>');
                    window.setTimeout(BS.Member.lateFunc,1000);

                    BS.Member.closeCover();
                }
                else if(result['status']=='2')
                {
                    $(".login-reg-layer").find("#error").text("楠岃瘉鐮侀敊璇�!");
                    $(".login-reg-layer").find("#code").val('');
					$('.pic-yzm').trigger('click')
                }
                else
                {
                    $(".login-reg-layer").find("#error").text("鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒!");
                    $(".login-reg-layer").find(".username,.password").val('');
					$('.pic-yzm').trigger('click')
					$(".login-reg-layer").find("#code").val('');
                }
            }
        })

}
BS.Member.ShowCover=function() 
{

	$('.wrappers').show();
		   	       

         
}

BS.Member.closeCover=function() {

	$('.wrappers').hide();

 }


BS.Common={};
BS.Common.hint=function(content)
{
	 
	   var ytop=$(window).height()/2+$(window).scrollTop();
	   var show=$("<div id='archint' style='position:absolute;width:100%;z-index:2000;top:"+ytop+"px;text-align:center'>"+content+"</div>");
	   show.children().css("display","inline").css("margin","auto");
	   $("body").append(show);
	   window.setTimeout(function(){
		    $("#archint").fadeOut(500,function(){$(this).remove();});
		   },1000);
	
}
BS.Common.togTextarea=function(obj,content)
{
	var ct=$.trim($(obj).val());
	if(ct==content)
	{
		$(obj).val("");
		$(obj).css("color","#333");
	}
	
}