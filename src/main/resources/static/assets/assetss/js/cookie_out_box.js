/*
 COOKIE 璁板綍
 **/
$(function(){
	if(!$.browser.mozilla){
	  //showKefu();
	}
    
});

function showKefu(){

    var newE = document.createElement("iframe"); newE.style.display = 'none';
    var cookie = getCookie('hasenter');
	delCookie('shengdu');

   // SetCookie('shengdu', Number(cookie1) + 1);
    var gd = 0;
    $(window).scroll( function() {
		var cookie1 = getCookie('shengdu');
		var cookie = getCookie('hasenter');
        if(gd >= 3 && cookie1 >= 2 && cookie !=1){
            var get = new Date();
            var fz = get.getMinutes();
            $.ajax( {
                url:'/cms/index/kefu',// 璺宠浆鍒� action
                type:'get',
                cache:false,
                async:false,
                dataType:'text',
                success:function(data) {
                  num = parseInt(data);
				   //num = 5;
                   switch(num)
                  {
                        case 0: //灏忎箶
                          newE.src ="tencent://message/?Menu=yes&amp;amp;uin=800058070&amp;amp;Service=58&amp;amp;SigT=A7F6FEA02730C988160C6C0C17F9CACBE414B8FEB82BA7E928C6F0393D0EE8B51264BFB96BCBF57513461C061B0EC4C600B8CD5211E4EA08DA2AEF0CF1CA13A7FD3F0416AF41D9002B7CDB9943E5880EB74B93AB115EB8947FD5855C312F98B5E5E58A3B10D160F677B4D392561F458D32ECA727A03710C8&amp;amp;SigU=30E5D5233A443AB2BA447ACD83010C52F121544F68971198A62A15803C151E9903AE7CE0431E1F00B8570686EF6F7239C27AE844A8775A68E3EAE8DCC5E63C663DF4F10E267C4099";
						 break;
                        case 1: //灏忕背
                            newE.src ="tencent://message/?Menu=yes&amp;amp;uin=800058070&amp;amp;Service=58&amp;amp;SigT=A7F6FEA02730C988CBEC8F14C93625152B5C1BA1CE146732DD0CCCFEFD94872FFC9E4625FA10DC8AA71F5BA5033A293A349363A4756F4B7FE841D9291D0CE69776F3817DCDB310086E2FD6BA1A8565C7D3BCCCD1F6ED3FE5C4384DE84D6262326C1F744419804A8EDCEA33D982964767B49184F786525729&amp;amp;SigU=30E5D5233A443AB2BC1F8A78A42D0EEBB6472AB1568A5F246C22593454350BA9CCFDD9C800CBA6690E88B6FBEED5D361E8244656C9DA3CA7E3944FE2888150FD4CDC4EE378E919CA";
						   break;
                       case 2: //灏忕幉
                             newE.src ="tencent://message/?Menu=yes&amp;amp;uin=800058070&amp;amp;Service=58&amp;amp;SigT=A7F6FEA02730C988529E7077B83AA5AA9EAED8E468261B7D30B040F8D66AD1DDC1F3E143A005527983973C462B357CF8FCEB7FE4E2B4528871CED3DA421A9D3F6F369F22906FF679BD1C8504EA981AC84C75829837E00D283F32EE85530988DB1BC23FB8836D5A21120B53B869843B66B405547127AB7F77&amp;amp;SigU=30E5D5233A443AB2F87AF7F6B53FC88DB09E891447E480113CE791DCA636E31187305CFAD103E4DF788BFACF19E8C6763FDD58D75B2A54C5976704CD0B9498275CB9F7D74E49C169";
							break;
                      
                       case 3://灏忕憺
						    newE.src ="tencent://message/?Menu=yes&amp;amp;uin=800058070&amp;amp;Service=58&amp;amp;SigT=A7F6FEA02730C9880D8675D0D5AEE476E9F382DE887B766316B7D08C2780FA76882BE704D07E144671F21D8D45D3405FAF34430B76FF4609D335D5EF2D6A32B5D0AB9B731D87CE15B0C22F2C98503CD5FED8BE6D5D476D23C7AAFB5EFF509797D9DF6D8AE8A55F1A209FD583C4E83B3FBB01460E7926B232&amp;amp;SigU=30E5D5233A443AB270F509CBD50229C34FB17B5E4812CEBA927815916D1C56B43C7FF3641464F5FD9179FEE6459D30CDCB93476B3208AB5F923C8D9FCABC6276BF10289F6EBE60B0";
                            break;
						 
                    }
					
					newE.src='http://wpa.b.qq.com/cgi/wpa.php?ln=2&uin=800058070&site=qq&menu=yes';
                }
            });

            var crea = document.body.appendChild(newE);
            SetCookie('hasenter',1);
		
			


        }
        gd++;
		SetCookie('shengdu', Number(cookie1) + 1);

    })


}


function SetCookie(name,value){
    var Days = 1;   //cookie 灏嗚淇濆瓨涓€骞�
    var exp  = new Date();  //鑾峰緱褰撳墠鏃堕棿  
    exp.setTime(exp.getTime() + Days*24*60*60*1000);  //鎹㈡垚姣  
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()+";path=/";
}

//璇诲彇cookies
function getCookie(name){
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
    if(arr != null){
        return unescape(arr[2]);
    }else{
        return null;
    }
}

//鍒犻櫎cookies
function delCookie(name){
    var exp = new Date();  //褰撳墠鏃堕棿  
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
} 