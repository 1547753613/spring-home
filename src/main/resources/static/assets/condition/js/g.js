/* search - pro  js*/
$('#txtKeyword').focus(function(){
    var key = $(this).val();
    $('#txtKeyword').css('color','#999');
    if(key==search_placeholder){
        $('#txtKeyword').val('');
    }
});
$('#txtKeyword').blur(function(){
    var key = $(this).val();
    if(key==''){
        $('#txtKeyword').val(search_placeholder);
        $('#txtKeyword').css('color','#ccc');
    }else{
        $('#txtKeyword').css('color','#999');
    }
});

$(function(){

    $("input[name='housetype']").click(function () {
       var housetype=$(this).attr('data');
       if (housetype!='所有'){
           $("#housetype").text(housetype);
       }else {
           $("#housetype").text('所有类型');

       }

    })
    
    // 鑰佷唬鐮侊紝鏆備笉鐭ラ亾鍝噷鐢�
    $(".SelectContent").click(function(){$(".Selecttext").show();$("#MddBox").hide();});
    $(".Selecttext li").mouseover(function(){
        $(".Selecttext li").removeClass("IndCur");
        $(this).addClass("IndCur");
    }).click(function(){
        $("#number_of_guests").val($(this).text());
        $(".Selecttext").hide();
    });
    
    $(".collapse-button").click(function(){
        var $ele = $(this);
        $(".search_select").slideToggle("normal", function(){
            $ele.hide();
            if($ele.hasClass("open")) {
                $(".collapse").show();
            } else{
                $(".open").show();
            }
        });
    });



    //搜索按钮
    $("#btn").click(function(){
        submitFrom();
    });

});


function setCookie(name,value,unset)
{
    var Days = 30;
    var exp = new Date();
    if(unset == -1) {
        var cookie = name + "=;path=/;domain=.zizaike.com;expires=Thu, 01 Jan 1970 00:00:00 GMT;";
    }else {
        exp.setTime(exp.getTime() + Days*24*60*60*1000);
        var cookie = name + "="+ encodeURIComponent(value) + "; path=/; domain=.zizaike.com; expires=" + exp.toGMTString();
    }
    document.cookie = cookie;
}
function getCookie(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))
        return decodeURIComponent(arr[2]);
    else
        return null;
}

// 鐢变簬涓€浜涙櫙鐐圭瓑閫昏緫娑夊強鍒板煙鍚嶅垽鏂紝鍙﹀姞涓€涓彁浜よ烦杞紝鍋氬垏鎹㈠煙鍚嶇殑鎯呮櫙
function submitLocation() {

    var domain = $("#txtDestdomain").val() + $("#baseDomain").val();
    var filter = [];
    var url = ('https:' == document.location.protocol ? 'https://' : 'http://' ) + domain+"/search/";
    var sightid = $.trim( $("#txtSightid").val());
    var cityid = $.trim($("#txtCityid").val());
    if(sightid>0){
        filter.push("i"+sightid);
    }else if(cityid>100) {
        filter.push("c"+cityid);
    }
    if(filter.length > 0) {
        url += "/" + filter.join("-");
    }
    location.href = url;
}

function submitFrom (){

    var reqid=new Array();//服务集合
    $(".service-select .ischecked").each(function (item) {
        reqid.push(parseInt($(this).attr("data")))
    })
    var city=$.trim($("#txtCity").val());//市区
    var startDate=$.trim($("#checkin").val())//入住日期
    var endDate=$.trim($("#checkout").val())//离开日期
    var days = Math.abs( new Date(startDate).getTime()- new Date(endDate).getTime())/ (1000 * 60 * 60 * 24)
    var min = $.trim($("#price-range-min").val());//价格筛选最小
    var max = $.trim($("#price-range-max").val());//价格筛选最大
    var htid=$("input[name='housetype']:checked").val();//房源类型

    /*console.log(city)
    console.log(days)
    console.log(minPrice)
    console.log(maxPrice)
    console.log(housetype)
    console.log(requireTypes)*/
    $.ajax({
        url:'/muniao/fuzzySearch',
        type:'get',
        traditional:true,
        data:{
            days,
            min,
            max,
            htid,
            reqid

        },
        success:function(data){
            if (data!=null){
                $("#search-result-ul").html("");
                var html="";
                $(".homeNum").text(data.length)
                $.each(data,function (i,item) {
                    //console.log(item.renttype)
                    html+="                            <li>\n" +
                        "                                <div class=\"item clearfix homestay_marker\" data-id=\"511626\">\n" +
                        "                                    <div class=\"home_stay clearfix\">\n" +
                        "                                        <div class=\"div_home_photo\">\n" +
                        "                                            <a href='/muniao/House/querybyid?id="+item.id+"'  style=\"color: #000000;font-size: 18px; \" target=\"_blank\" title='"+item.hname+"'  >\n" +
                        "                                                <img alt='"+item.hname+"' src='"+item.simg+"' /></a>\n" +
                        "                                        </div>\n" +
                        "                                        <div class=\"div_album\">\n" +
                        "                                            <a href='/muniao/House/querybyid?id="+item.id+"'  target=\"_blank\" title='"+item.hname+"'>\n" +
                        "                                                <img class=\"photo_album\" src='"+item.landlord.head+"'  title='"+item.landlord.nickname+"'   /></a>\n" +
                        "                                        </div>\n" +
                        "\n" +
                        "\n" +
                        "                                        <a id=\"c_511626\" class=\"be-favorite collect_icon\" href=\"javascript:void(0);\"  title=\"点击收藏这家民宿\"></a>\n" +
                        "                                    </div> <!-- end home_stay -->\n" +
                        "\n" +
                        "                                    <div class=\"clearfix room_list\">\n" +
                        "                                        <h2 class=\"user_title clearfix\">\n" +
                        "                                            <a class=\"title-link\" href='/muniao/House/querybyid?id="+item.id+"'  target=\"_blank\" title='"+item.hname+"'  >"+item.hname+"</a>\n" +
                        "\n" +
                        "                                            &nbsp;<a class=\"title-mark\" target=\"_blank\"><em title=\"速订\" class=\"S_icon\"></em></a>\n" +
                        "                                        </h2>\n" +
                        "\n" +
                        "                                        <div class=\"min-price-info\" align=\"right\" >\n" +
                        "                                            <div class=\"min-price-text\" >￥<p class=\"price-text\" >"+item.houseMany.holidays+"</p>起</div>\n" +
                        "                                        </div>\n" +
                        "                                        <div class=\"disc-price-info\" align=\"right\" >\n" +
                        "                                            <p class=\"disc-price-text\" id=\"p_original_price\">\n" +
                        "                                            </p>\n" +
                        "                                        </div>\n" +
                        "\n" +
                        "                                        <div class=\"user_address\" data-id=\"511626\">\n" +
                        "                                            <span>"+item.houseAddress.city+"</span>   <span>"+item.houseAddress.address+"</span>\n" +
                        "                                        </div>\n" +
                        "\n" +
                        "\n" +
                        "                                        <div class=\"user_more\" style=\"margin-top: 5px;\">\n" +
                        "                                            <a href=\"javascript:void(0)\" target=\"_blank\">\n" +
                        "                                                <span style=\"color: white\">暂无点评</span>\n" +
                        "                                            </a>\n" +
                        "\n" +
                        "                                        </div>\n" +
                        "\n" +
                        "                                        <div class=\"user_service\">\n" +
                        "                                <span class=\"fw-baoche fw-icon\">\n" +
                        "                                <div class=\"questionMain\">\n" +
                        "                                    <b >"+item.renttype.tname+"</b>\n" +
                        "                                    <b style=\"margin-left: 40px;\">最早入住时间:</b><span>"+item.houseRules.atcheck+"</span>\n" +
                        "\n" +
                        "                                    <b style=\"margin-left: 40px;\">最晚入住时间:</b><span>"+item.houseRules.lastcheck+"</span>\n" +
                        "\n" +
                        "                                 </div>\n" +
                        "                                 </span>\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "                                        </div> <!-- end user service -->\n" +
                        "\n" +
                        "                                        <input type=\"hidden\" value=\"0\" class=\"list_input\" id=\"list_more_input_511626\">\n" +
                        "\n" +
                        "                                    </div> <!-- end room_list -->\n" +
                        "                                </div>\n" +
                        "                            </li>\n"
                })
                $("#search-result-ul").html(html);

            }
        }
    })
}

function log_behavior(action,content){
    $.ajax({
        url:"/zzk_taiwan_ajax.php",
        data: {
            'ajax_type':"log_searchbox_behavior",
            'user_agent': navigator.userAgent,
            'application':'web',
            'action':action,
            'bid':0,
            'action_desc':content,
        },
        success:function(data){},
    });
}

function send_byvue(){
    var vueData = new Object();
    vueData['type'] = 'list';
    vueData['txtCity'] = searchBox.txtCity;
    vueData['txtSightid'] = searchBox.txtSightid;
    vueData['txtCityid'] = searchBox.txtCityid;
    vueData['txtDestdomain'] = searchBox.txtDestdomain;
    vueData['checkin_date'] = searchBox.checkin_date;
    vueData['checkout_date'] = searchBox.checkout_date;
    Vue.http.options.emulateJSON = true;
    Vue.http.post(
        '/v2/ajax', 
        vueData
    ).then(function(response){
    }, function(response){
    });
}

$( function() {
    // location
    $(".poi-choice").click(function () {
        $(".poi_list .loclist").hide();
        if($(this).parents(".click").length > 0) {
            $(".poi-title").removeClass("click");
            $(".poi_list").hide();
        }else {
            $(".poi-title").removeClass("click");
            var type = $(this).data('type');
            $(this).parent(".poi-title").addClass("click");
            $("." + type).show();
            $(".poi_list").show();
        }
    });

    $(document).on("click", ".poi-item", function(){
        choice_sight(this);
        $(".pageNum").val(0);
       //$("#btn").click();
    });

    $(document).on("click","#loc_unlimited", function() {
        if($(this).hasClass("current")) {
            return;
        }
        clear_poi();
        // $("#txtCityid").val("");
        $("#txtSightid").val("");
        $("#MddBox").hide();
        // $(".poi_list").hide();
        // $(".poi-choice").removeClass("current");
        $(".poi-item").removeClass("current");
        // var poiTitle = $(".poi-title");
        // poiTitle.removeClass("click");
        // poiTitle.each(function(e){
        //     var title = $(e).find(".origin-title").val();
        //     $(e).find(".poi-choice-title").text(title);
        // });
        $(this).addClass("current");

        $(".pageNum").val(0);
      //  $("#btn").click();
    });

    // price
    var timers;
    $( "#slider-range" ).slider({
        range: true,
        min: 0,
        max: range_max_price,
        step: 10,
        animate: 'slow',
        values: [ min_price, max_price ],
        slide: function( event, ui ) {
            $( "#price-range-min" ).val( ui.values[ 0 ] );
            $( "#price-range-max" ).val( ui.values[ 1 ] );
            var price_str = price_symbol.replace("%p", ui.value);
            $(ui.handle).find(".sidecar").text(price_str);

            // 闃叉婊戝姩澶绻佸欢鏃舵墽琛�
            if(timers != undefined) {
                clearTimeout(timers);
            }
            timers = setTimeout(function(){
                //console.log("execute search");
                $(".pageNum").val(0);
             //   $("#btn").click();
            }, 800);
        }
    }).each( function() {
        var opt = $("#slider-range").data().uiSlider.options;
        var vals = opt.max - opt.min;
        // 姣�500鏄剧ず涓€涓爣绛�
        var setp = parseInt(price_mark_str);
        // var vals = 4;
 
        var k = 0;
        for (var i = 0; i <= vals; i = i + setp) {
            var line = $("<span></span>").addClass("slider-step-line");
            var priceStr = i;
            if(priceStr == opt.max) {
                priceStr += "+";
            }
            var priceDiv = $("<label></label>").addClass("slider-step-price").html(priceStr);
            var el = $('<span></span>').addClass("slider-step").css('left', (i/vals*100) + '%');
            el.append(line).append(priceDiv);
            $( '#slider-range' ).append(el);
        }
    });
    $('.ui-slider-handle').each(function(k, e){ 
        var opt = $("#slider-range").data().uiSlider.options;
        var value =  $("#slider-range").data().uiSlider.options.values;
        var price = value[k];
        if(price == opt.max) {
            price += "+";
        }
        price_str = price_symbol.replace("%p", price);
        $(e).append('<span class="sidecar">'+ price_str +'</span>');
    });
    $("<div></div>").appendTo(".ui-slider").css({
        'height': '20px',
        'position' : 'absolute',
        'top': '-8px',
        'width':'100%',
        'cursor' : 'pointer'
    });

    $("#price-range-min").val($( "#slider-range" ).slider( "values", 0 ) );
    $("#price-range-max").val($( "#slider-range" ).slider( "values", 1 ) );

    // 澶嶉€�
    $(".choice-input").change(function(){
        if($(this).data("type") == 'clear'){
            $(".choice-input").not("#service-unlimited").removeAttr("checked");
        }else{
            $("#service-unlimited").removeAttr("checked");
        }
        var dropdown = $(this).parents(".search-dropdown");
        if(dropdown.length > 0) {
            var choiceNumber = dropdown.find(".choice-input:checked").length;
            if(choiceNumber > 0) {
                dropdown.find(".choice-number").text("路 " + choiceNumber).show();
                dropdown.addClass("dropdown-choice");
            }
            else {
                dropdown.find(".choice-number").hide();
                dropdown.removeClass("dropdown-choice");
            }
        }
        $(".pageNum").val(0);
       // $("#btn").click();

    });

    // other
    $(".other-filter").click(function(){
        var type = $(this).data("type");
        if($(this).hasClass("becheck")) {
            $(this).removeClass("becheck");
            $(this).addClass("ischecked");
        }else{
            $(this).removeClass("ischecked");
            $(this).addClass("becheck");
        }

        $(".pageNum").val(0);
     //   $("#btn").click();
    });
} );

function choice_sight(e) {
    var id = $(e).data("id");
    var type = $(e).data('type');
    var sight_name = $(e).text();
    $("#txtKeyword").val("");
    $("#txtSightid").val(id);
    clear_poi();
    $("#loc_unlimited").removeClass("current");
    $(e).addClass("current");
    var poiTitle = $("#poi-title-"+type);
    poiTitle.find(".poi-choice-title").text(sight_name);
    poiTitle.find(".poi-choice").addClass("current");
    if(type == 'scenic_spots') {
        try{
            mylat=$(e).data('lat');
            mylng=$(e).data('lng');
        }catch (err) {
            console.log(err.message);
        }
    }

}

function clear_poi() {
    $(".poi_list").hide();
    $(".poi-choice").removeClass("current");
    $("#loc_unlimited").addClass("current");
    $(".poi-item").removeClass("current");
    var poiTitle = $(".poi-title");
    poiTitle.removeClass("click");
    poiTitle.each(function(i, e){
        var title = $(e).find(".default-title").val();
        $(e).find(".poi-choice-title").text(title);
    });
    try{
        mylat=0;
        mylng=0;
    }catch (err) {
        console.log(err.message);
    }
}

function change_city(id, type) {

    clear_poi();
    $("#txtKeyword").val("");
    var asyncData = {
        queryType: type,
        id:id,
        type:'poi_info'
    };
    $.get(
        "/v2/ajax",
        asyncData,
        function(response){
            console.log(response);
            render_poi(response.data.list, response.data.current);
        }
    );
}

function render_poi(list, current) {

    if(list.length >0 ) {

        $(".poi-title").hide();
        $(".poi_list").html("");
        var $smaller = $("<div>").addClass('smaller poi-smaller');
        var $item = $("<a>").addClass("poi-item").attr("href", "javascript:void(0);");
        $.each(list, function (k, e) {
            var type = e.type;
            var $list = $("<div>").addClass(type + " loclist clearfix");
            $.each(e.list, function (i, row) {
                var item = $item.clone().attr({
                    "title": row.name, 'data-type':row.type, 'data-id':row.id, 'data-city':row.loc_id,
                    'data-lat':row.lat, 'data-lng': row.lng
                }).text(row.name);
                $list.append($smaller.clone().append(item));
            });
            $list.appendTo($(".poi_list"));
            $("#poi-title-"+type).show();
        });
        if(current.id > 0 ) {
            var htmlDom = $(".poi-item[data-id='"+current.id+"']")[0];
            choice_sight(htmlDom);
        }
        $(".dl-area").show();
    }
    else {
        $(".dl-area").hide();
    }
}
/* search City js */
$(function(){

/*    $("#txtCity").focus(function(){
    
        var srt = $(document).scrollTop();
        var wh = $(window).height();
    
        $("#MddBox").show();
        $(".Selecttext").hide();
        if($.trim($(this).val())== search_placeholder){
            $(this).val("");
        }
        var city = $("#txtCity").val();
    }).blur(function(){
        if($.trim($(this).val())==""){
            $(this).val("");
        }
    });*/

    $(".destination").hover(function () {
        $(".destination").removeClass("current-destination");
        $(this).addClass("current-destination");
        var dest_id = $(this).attr('forpoi');
        $(".hotList").hide();
        $(".hotDest-"+dest_id).show();

    });


    $("#MddBox").on("click", "label", function (){
        $('#txtKeyword').val(search_placeholder);
        var poiid = $(this).attr("forpoi");
        var sightid = $(this).attr("forsight");
        var $txtCity = $("#txtCity");
        var $txtCityId = $("#txtCityid");
        var dest_id = $(this).data('dest');
        var dest_domain = $(this).data('domain');
        var locIdPrev = $txtCityId.val();
        $txtCity.val($(this).text());
        $txtCityId.val(poiid);
        $("#txtSightid").val(sightid);
        $txtCity.blur();
        $("#txtDestId").val(dest_id);
        $("#txtDestdomain").val(dest_domain);
        $("#MddBox").hide();

        var current_dest = $("#currentDestId").val();
        // 涓€閮ㄥ垎閫昏緫浼氭牴鎹煙鍚嶅垽鏂紝鍒囨崲鐩殑鍦颁細鍋氳烦杞�
        if(dest_id != current_dest) {
            submitLocation();
            return false;
        }

        // 鍩庡競鏀瑰彉闇€瑕佸垏鎹oi淇℃伅
        if(sightid != '' && sightid != undefined){
            change_city(sightid, 'poi');
        }else if(poiid != '' && poiid != undefined) {
            change_city(poiid, 'city');
        }

        $(".pageNum").val(0);
      //  $("#btn").click();
    
    });
    
    $("#MddBox span").click(function(){$("#MddBox").hide();});
    
    $(document).bind("click",function(e){
        var target = $(e.target);
        if(target.parents(".searchCondensed").length == 0){
            $("#MddBox").hide();
        }
    });

});
var datepicker_CurrentInput;
$(function(){
    /*
	$("#checkin").change(function(){
	    
	  var temp_in = $(this).val();
	  var temp_out = $("#checkout").val();
	
	  var c_in = new Date(Date.parse(temp_in.replace(/-/g, "/")));
	  c_in.setDate(c_in.getDate() + 1);
	  var month = c_in.getMonth()+1;
	  var date = c_in.getDate();
	  if (month <10){
	    month = '0' + month;  
	  }
	  if (date <10){
	    date = '0' + date;  
	  }
	  if (temp_out == '閫€鎴挎棩鏈�'){
	    $("#checkout").val(c_in.getFullYear()+"-"+month+"-"+date);
	  }
	  else{
	    var c_out = new Date(Date.parse(temp_out.replace(/-/g, "/")));
	    if (c_in >= c_out) {
	       $("#checkout").val(c_in.getFullYear()+"-"+month+"-"+date);
	     }           
	  }  
	  
	});

	$("#checkout").change(function(){
	     
	  var temp_out = $(this).val();
	  var temp_in = $("#checkin").val();
	
	  var c_out = new Date(Date.parse(temp_out.replace(/-/g, "/")));
	  c_out.setDate(c_out.getDate() - 1);
	  var month = c_out.getMonth()+1;
	  var date = c_out.getDate() ;
	  if (month <10){
	    month = '0' + month;  
	  }
	  if (date <10){
	    date = '0' + date;  
	  }
	  if (temp_in == '鍏ヤ綇鏃ユ湡'){
	    $("#checkin").val(c_out.getFullYear()+"-"+month+"-"+date);
	  }
	  else{
	    var c_in = new Date(Date.parse(temp_in.replace(/-/g, "/")));
	    if (c_in >= c_out) {
	       $("#checkin").val(c_out.getFullYear()+"-"+month+"-"+date);
	     }           
	  }
	});
    */

   
    // 璁剧疆DatePicker 鐨勯粯璁よ缃�
//    $.datepicker.setDefaults({ showButtonPanel: true, closeText:all_time});
   
    // 缁戝畾鈥淒one鈥濇寜閽殑click浜嬩欢锛岃Е鍙戠殑鏃跺€欙紝娓呯┖鏂囨湰妗嗙殑鍊�
    $(document).on("click", ".ui-datepicker-close", function (){
        datepicker_CurrentInput.value = "";
        //鐩墠鍙兘涓€璧�
        $("#checkin").val("");
        $("#checkout").val("");
        setCookie('checkin', ' ', -1);
        setCookie('checkout', ' ', -1);
        $.post('/v2/ajax',
            {"type":"clear_date"},
            function(msg){
            //console.log(msg);
            }
        );
    });
   
    $(".OccupancyDaty").click(function(){
        var action = $(this).attr("behavior")+"_focus";
        var city = $("#txtCity").val();
        var checkin = $("#checkin").val();
        var checkout = $("#checkout").val();
        var keyword = $("#txtKeyword").val();
        var content = city+"|"+checkin+"|"+checkout+"|"+keyword;
        //log_behavior(action,content)
        $("#MddBox").hide();
        $(".Selecttext").hide();
    });

    $(".datePicker").datepicker({
        numberOfMonths: 2,
        dateFormat: "yy-mm-dd",
        yearSuffix: '',
        monthNames: [january,february,march,april,may,june,july, august,september,october,november,december],
        dayNamesMin: [su,mo,tu,we,th,fr,sa],
        showButtonPanel:true,
        closeText:all_time,
        beforeShow: customeRange,
        beforeShowDay: customeDay,
        onSelect: choseDay,
        onClose:function(){
            var action = $(this).attr("behavior")+"_blur";
            var city = $("#txtCity").val();
            var checkin = $("#checkin").val();
            var checkout = $("#checkout").val();
            var keyword = $("#txtKeyword").val();
            var content = city+"|"+checkin+"|"+checkout+"|"+keyword;
            $(this).data('datepicker').inline = false;
            choiseNum = 0;
            //log_behavior(action,content);
       }
    });

    $(".dateInput").click(function(){
        $(".datePicker").focus();
        $(".datePicker").datepicker("show");
    });

//    $("#checkout").datepicker({
//        minDate: 1,
//        dateFormat: "yy-mm-dd",
//        yearSuffix: '',
//        monthNames: [january,february,march,april,may,june,july, august,september,october,november,december],
//        dayNamesMin: [su,mo,tu,we,th,fr,sa],
//       onClose:function(){
//        var action = $(this).attr("behavior")+"_blur";
//        var city = $("#txtCity").val();
//        var checkin = $("#checkin").val();
//        var checkout = $("#checkout").val();
//        var keyword = $("#txtKeyword").val();
//        var content = city+"|"+checkin+"|"+checkout+"|"+keyword;
//        log_behavior(action,content);
//       }
//    });

}); // end ready fun

function customeRange(input) {
    var min = new Date(),
        dateMin = min,
        dateMax = new Date(min.getTime() + 365 * 24 * 60 * 60 * 1000),
        dayRange = 30;

    datepicker_CurrentInput = input;

    if (input.id === "checkin") {
        if ($("#checkout").datepicker("getDate") != null) {
            dateMax = $("#checkout").datepicker("getDate");
            dateMin = $("#checkout").datepicker("getDate");
            dateMin.setDate(dateMin.getDate() - dayRange);
            if (dateMin < min) {
                dateMin = min;
            }
        }
        else {
            dateMax = new Date; //Set this to your absolute maximum date
        }
    }
    else if (input.id === "checkout") {
        if ($("#checkin").datepicker("getDate") != null) {
            dateMin = $("#checkin").datepicker("getDate");
            var rangeMax = new Date(dateMin.getFullYear(), dateMin.getMonth(),dateMin.getDate() + dayRange);

            if(rangeMax < dateMax) {
                dateMax = rangeMax;
            }
        }
    }
    return {
        minDate: dateMin,
        maxDate: dateMax
    };
}

function customeDay(d) {
    var showctl = [true, "", ""];
    var checkin = $("#checkin").val();
    var checkout = $("#checkout").val();
    if(Date.parse(checkin) > 0 && Date.parse(checkout) > 0) {
        var thisTime = d.getTime();
        var dateStart = Date.parse(checkin);
        var dateEnd = Date.parse(checkout);
        if( dateStart - thisTime <= 8*60*60*1000
            && thisTime < dateEnd
        ) {
            showctl = [true, "dp-highlight", ""];
        }
    }
    return showctl;
}

var choiseNum = 0;
function choseDay(dateText, inst) {
    var checkin = $("#checkin").val(); //$.datepicker.parseDate($.datepicker._defaults.dateFormat, $("#checkin").val());
    var checkout = $("#checkout").val(); //$.datepicker.parseDate($.datepicker._defaults.dateFormat, $("#checkout").val());
    if(choiseNum == 0) {
        $(this).data('datepicker').inline = true;
        choiseNum = 1;
        $("#checkin").val(dateText);
        $("#checkout").val("");
    }else{
        if( Date.parse(checkin) >= Date.parse(dateText) ) {
            $("#checkin").val(dateText);
        }else{
            choiseNum = 0;
            $(this).data('datepicker').inline = false;
            $("#checkout").val(dateText);
        }
    }
}

  $(function(){

      $('#txtKeyword').bind('input propertychange', function() {
          ajax_guanlian();
      });

      //濡傛灉缁� .tr_search 缁戝畾涓€涓簨浠讹紝鑳芥墽琛屼箞锛�
      $(document).on('click', ".tr_search", function(){
          var history_s = getCookie('history_s');
          if(history_s==null){history_s='';}
          else{history_s='|'+history_s;}
          history_s = $(this).attr('word')+','+$(this).attr('type')+','+$(this).attr('url')+history_s;
          setCookie('history_s',history_s);
          location.href = $(this).attr('url');
      });

      $("body").click(function(e){
          if(e.target.id!='Search_box'&&'txtKeyword'!=e.target.id){
              $("#Search_box").hide();
          }else
          {
              ajax_guanlian();
          }
      });

      $(document).on('click', '#rm_his', function(){
          setCookie('history_s','',-1);
          //alert('娓呴櫎鎴愬姛锛�');
      });
      function ajax_guanlian(){
          var k = 0;
          var cityId = $("#txtCityid").val();
          $.getJSON("/v2/ajax", { destid:dest_id, locid:cityId,key:$('#txtKeyword').val() , multilang: "12"}, function(json){
              if(json.title==''){
                  $("#Search_box").hide();
                  return false;
              }else{
                  $("#Search_box").show();
              }
              var is_his = 0;
              var color = '#F35758';
              if(json.title == search_history ){
                  is_his = 1;
                  color = '#979797';
              }
              $("#search_table").remove();
              $(".rm_p").remove();
              $("#Search_box").append(
                  "<p class='rm_p'>"+json.title+"</P>"
              );
              $("#Search_box").append(
                  $("<table />").attr({"id":"search_table"})
              );

              $.each(json.body,function(n,value) {
                  if(value.type=='city'){
                      var typename = city_text;
                      if(is_his==1)
                      {
                          img_url='https://static.zzkcdn.com/search/guanlianicon-pc-search-history-city.png';
                      }
                      else{
                          img_url='https://static.zzkcdn.com/search/guanlianicon-pc-search-city.png';
                      }
                  }
                  if(value.type=='sight'){
                      var typename = viewpoint;
                      if(is_his==1)
                          img_url='https://static.zzkcdn.com/search/guanlianicon-pc-search-history-scenery.png';
                      else img_url='https://static.zzkcdn.com/search/guanlianicon-pc-search-scenery.png';
                  }
                  if(value.type=='business'){
                      var typename = business_district;
                      if(is_his==1)
                          var img_url='https://static.zzkcdn.com/search/guanlianicon-pc-search-history-business-district.png';
                      else var img_url='https://static.zzkcdn.com/search/guanlianicon-pc-search-business-district.png';
                  }
                  if(value.type=='homestay'){
                      var typename = homestay_text;
                      if(is_his==1)
                          img_url='https://static.zzkcdn.com/search/guanlianicon-pc-search-history-flat.png';
                      else  img_url='https://static.zzkcdn.com/search/guanlianicon-pc-search-flat.png';
                  }
                  if(value.type=='address'){var typename = address_association;var img_url='';}
                  if(img_url!=''){//琛ㄧず涓嶆槸鍦板潃鍏宠仈
                      img_url = "<td style='text-align: right;width: 15px;padding-right: 5px;'><img style='margin-top: 8px;width: 15px;height: 15px;' src='"+img_url+"' /></td>";
                      typename ="<td style='text-align: right;padding-right: 5px;color: "+color+";'>"+typename+"</td>";
                  }else{
                      typename = "<td colspan='2' style='text-align: right;font-size:12px;padding-right: 5px;color: #979797;'>"+typename+"</td>";
                  }
                  var trClass = "tr_search";
                  if(value.category == "global"){
                      trClass += " global_search";
                      k++;
                  }
                  var style = "";
                  if(k == 1) {
                      style = "style='border-top:1px dashed #ccc'";
                  }
                  $("#search_table").append(
                      "<tr class='"+trClass+"' "+ style +" word='"+value.word+"' type='"+value.type+"' url='"+value.url+"' ><td class='td_search'>"+value.word+"</td>"+typename+img_url+"</tr>"
                  );
              });
              if(is_his==1){ //鐢ㄦ潵鍒ゆ柇鏄惁鏄巻鍙茶褰�
                  $("#Search_box").append(
                      "<p class='rm_p' id='rm_his' style='border-bottom: none;border-top:1px dotted #ccc'>" + clear_history + "</P>"
                  );
              }
          });
      }
      $('#txtKeyword').focus(function(){
       var key = $(this).val();
       $('#txtKeyword').css('color','#999');
       if(key=='姘戝鍚嶇О銆佹櫙鐐广€佸晢鍦堛€佸煄甯傜瓑'){
          $('#txtKeyword').val('');
       }
    });
    $('#txtKeyword').blur(function(){
       var key = $(this).val();
       if(key==''){
         $('#txtKeyword').val('姘戝鍚嶇О銆佹櫙鐐广€佸晢鍦堛€佸煄甯傜瓑');
         $('#txtKeyword').css('color','#ccc');
       }else{
         $('#txtKeyword').css('color','#999');
       }
    });
    $('#txtKeyword').keydown(function(e){
      if(e.keyCode==13){
         //submitFrom();
      }
    });
  });

// simple js
;(function(){
	$(".language-row").click(function(){
		var lan_id = $(this).attr("for");
		var date=new Date();
        var expireDays=30;
        date.setTime(date.getTime()+expireDays*24*3600*1000);
        document.cookie="lang_id="+lan_id+"; path=/; domain=.zizaike.com; expire="+date.toGMTString();
	});
	$(".currency-row").click(function(){
		var cy_id = $(this).attr("for");
		var date=new Date();
        var expireDays=30;
        date.setTime(date.getTime()+expireDays*24*3600*1000);
        document.cookie="currency_id="+cy_id+"; path=/; domain=.zizaike.com; expire="+date.toGMTString();
	});
})($);
var map, big_map;
var marker_arr = [];
var show_item = [];
function hideTip(e) {
    var homestay = e.target.getExtData();
    var mark_id = 'map_mark_' + homestay['id'];
    $('.' + mark_id).removeClass('map_mark_select');
    $('.list_mark_num_' + homestay['id']).removeClass('list_mark_num_select');
    $('#map_tips').hide();
}

$.fn.isOnScreen = function () {

    var win = $(window);

    var viewport = {
        top: win.scrollTop(),
        left: win.scrollLeft()
    };
    viewport.right = viewport.left + win.width();
    viewport.bottom = viewport.top + win.height();

    var bounds = this.offset();
    bounds.right = bounds.left + this.outerWidth();
    bounds.bottom = bounds.top + this.outerHeight();

    return (!(viewport.right < bounds.left || viewport.left > bounds.right || viewport.bottom < bounds.top || viewport.top > bounds.bottom));

};
function scroll_refresh() {
    var old_show = show_item.slice();
    $('.homestay_marker').each(function () {
        var show = $(this).isOnScreen();
        var id = $(this).data('id');
        if (marker_arr.hasOwnProperty(id)) {
            if (show) {
                if (!($.inArray(id, show_item) >= 0) || (typeof marker_arr[id].getMap() == 'undefined')) {
                    show_item.push(id);
                    marker_arr[id].setMap(map);
                }
            } else {
                show_item = $.grep(show_item, function (value) {
                    return value != id;
                });
                marker_arr[id].setMap(null);
            }
        }
    });
    if (!($(old_show).not(show_item).length === 0 && $(show_item).not(old_show).length === 0)) {
        //console.log('refresh:' + (Date.now() / 1000));
        map.setFitView();
    }
}

function fixDiv() {
    var $cache = $('#map_container');
    if ($('#J_isFloat').is(':checked') && $(window).scrollTop() > $cache.data('origin_top')) {
        $cache.addClass('map_fixed');
    } else {
        $cache.removeClass('map_fixed');
    }
}
function showTip(e) {
    setTimeout(function () {
        var homestay = e.target.getExtData();
        e.target.setTop(true);
        $('.map_mark').removeClass('map_mark_select');
        $('.list_mark_num').removeClass('list_mark_num_select');
        var mark_id = 'map_mark_' + homestay['id'];
        var marker = $('.' + mark_id);
        marker.addClass('map_mark_select');
        $('.list_mark_num_' + homestay['id']).addClass('list_mark_num_select');
        var tpl = '<div class="left"><img class="pic" src="' + homestay_thumb[homestay['id']] + '" alt=""></div>'
            + '<div class="right"><p class="name">' + homestay['name'] + '</p>'
            + '<p class="address" title="' + homestay['address'] + '">' + homestay['address'] + '</p>'
            + '<p class="bottom">'
            + (homestay['score'] > 0 ? '<span class="score">' + homestay['score'] + '鍒�</span> / ' : '')
            + (homestay['comment_num'] > 0 ? '<span>' + homestay['comment_num'] + '鏉¤瘎浠�</span>' : '') + '</p>'
            + '</div>';

        var mark_offset = marker.offset();
        $('#map_tips').html(tpl).css({
            top: mark_offset.top - 20,
            left: mark_offset.left - 390,
            zIndex: 9999
        }).show();
    }, 500);
}

function generate_marker() {
    /*for (var i = 0, marker; i < homestay_arr.length; i++) {
        if (homestay_arr[i]['position'][0] <= 0 || homestay_arr[i]['position'][1] <= 0) {
            continue;
        }
        var content = document.createElement('div');
        content.className = 'map_mark map_mark_' + homestay_arr[i]['id'];
        content.innerHTML = '<span class="map_num">' + (i + 1) + '</span>'
            + '<div class="map_mark_inner"><span style="white-space: nowrap;" class="map_mark_name">&yen;' + homestay_min_price_arr[homestay_arr[i]['id']]
            + (homestay_arr[i]['speed_room'] ? '<span class="S_icon"></span>' : '') + '</div>';

    /!*    marker = new AMap.Marker({
            position: homestay_arr[i]['position'],
            content: content,
            extData: homestay_arr[i]
        });*!/
        marker.on('click', function (e) {
            var homestay = e.target.getExtData();
            window.location.href = '/h/' + homestay.id;
        });
        marker.on('mouseover', showTip);
        marker.on('mouseout', hideTip);
        marker_arr[homestay_arr[i]['id']] = marker;
    }*/
}
$(function () {
    if ($.inArray(dest_id, [10, 12]) >= 0) {
       /* map = new AMap.Map('map_container_box');
        AMap.plugin(['AMap.ToolBar', 'AMap.Scale', 'AMap.OverView'], function () {
            var toolBar = new AMap.ToolBar();
            toolBar.hideDirection();
            toolBar.hideRuler();
            var scale = new AMap.Scale();
            var overview = new AMap.OverView();
            map.addControl(toolBar);
            map.addControl(scale);
            map.addControl(overview);
        });*/
        generate_marker();
        //map.setFitView();

        var $container = $('#map_container');
        $container.data('origin_top', $container.offset().top);
        $(window).scroll(function () {
            fixDiv();
            setTimeout(scroll_refresh, 800);
        });
        $('#J_isFloat').change(function () {
            fixDiv();
        });
    }
    var $user_address = $('.user_address');
    $user_address.hover(function () {
        var homestay_id = $(this).data('id');
        $(this).find('.list_mark_num').addClass('list_mark_num_select');
        $('.map_mark_' + homestay_id).addClass('map_mark_select');
        if (marker_arr.hasOwnProperty(homestay_id)) {
            marker_arr[homestay_id].setTop(true);
        }
    }, function () {
        var homestay_id = $(this).data('id');
        $(this).find('.list_mark_num').removeClass('list_mark_num_select');
        $('.map_mark_' + homestay_id).removeClass('map_mark_select');
    });

    $('#map_container').mouseout(function () {
        $('#map_tips').hide();
        $('.map_mark').removeClass('map_mark_select');
        $('.list_mark_num').removeClass('list_mark_num_select');
    });
    $('#map_tips').hover(function () {
    }, function () {
        $('#map_tips').hide();
    });

    $user_address.click(function () {
        $.colorbox({
            fixed: true,
            open: true,
            iframe: true,
            width: '80%',
            height: '80%',
            href: '/search/map?id=' + $(this).data('id')
        });
    });

    fixDiv();
    scroll_refresh();
});
var map;
var markers = [];
var iconArr = [
    "https://static.zzkcdn.com/map/icon0.png",
    "https://static.zzkcdn.com/map/icon1.png",
    "https://static.zzkcdn.com/map/icon2.png",
    "https://static.zzkcdn.com/map/icon3.png",
    "https://static.zzkcdn.com/map/icon4.png",
    "https://static.zzkcdn.com/map/icon5.png",
    "https://static.zzkcdn.com/map/icon6.png",
    "https://static.zzkcdn.com/map/icon7.png",
    "https://static.zzkcdn.com/map/icon8.png",
    "https://static.zzkcdn.com/map/icon9.png",
    "https://static.zzkcdn.com/map/icon10.png",
    "https://static.zzkcdn.com/map/icon11.png",
    "https://static.zzkcdn.com/map/icon12.png",
    "https://static.zzkcdn.com/map/icon13.png",
    "https://static.zzkcdn.com/map/icon14.png",
    "https://static.zzkcdn.com/map/icon15.png",
    "https://static.zzkcdn.com/map/icon16.png",
    "https://static.zzkcdn.com/map/icon17.png",
    "https://static.zzkcdn.com/map/icon18.png",
    "https://static.zzkcdn.com/map/icon19.png",
    "https://static.zzkcdn.com/map/icon20.png",
    "https://static.zzkcdn.com/map/icon21.png",
    "https://static.zzkcdn.com/map/icon22.png",
    "https://static.zzkcdn.com/map/icon23.png",
    "https://static.zzkcdn.com/map/icon24.png"
];
var mylng = 0, mylat = 0;

$.fn.isOnScreen = function () {
    var win = $(window);
    var viewport = {
        top: win.scrollTop(),
        left: win.scrollLeft()
    };
    viewport.right = viewport.left + win.width();
    viewport.bottom = viewport.top + win.height();

    var bounds = this.offset();
    bounds.right = bounds.left + this.outerWidth();
    bounds.bottom = bounds.top + this.outerHeight();

    return (!(viewport.right < bounds.left || viewport.left > bounds.right || viewport.bottom < bounds.top || viewport.top > bounds.bottom));
};

function makeTip(numArr, top, left) {
    $('#map_tipss_box').html('');
    for (var i = 0; i < numArr.length; i++) {
        var tpl = '<div id="map_tipss" ><div class="left"><img class="pic" src="' + homestay_thumb[homestay_arr[numArr[i]].id] + '" alt=""></div>'
            + '<div class="right"><p class="name">' + homestay_arr[numArr[i]].name + '</p>'
            + '<p class="bottom">'
            + (homestay_arr[numArr[i]].score > 0 ? '<span class="score">' + homestay_arr[numArr[i]].score + pingfen + '</span> / ' : '')
            + (homestay_arr[numArr[i]].comment_num > 0 && homestay_arr[numArr[i]].comment_num < 2 ? '<span>' + homestay_arr[numArr[i]].comment_num + pingjia + '</span>' : '')
            + (homestay_arr[numArr[i]].comment_num > 1 ? '<span>' + homestay_arr[numArr[i]].comment_num + pingjias + '</span>' : '') + '</p>'
            + '<p class="myp">锟�' + homestay_min_price_arr[homestay_arr[numArr[i]]['id']] + '<a class="more"  href="https://japan.zizaike.com/h/' + homestay_arr[numArr[i]]['id'] + '">' + check + '</a></p> ' + '</div></div>';
        $('#map_tipss_box').append(tpl);
    }
    if ($('#map_tipss_box').hasClass('scroll')) {
        $('#map_tipss_box').removeClass('scroll');
    }
    var height = $('#map_tipss_box').height();
    if (parseInt(height) > 400) {
        $('#map_tipss_box').css({
            top: top + 85,
            left: left - 250,
            zIndex: 9999
        });
        $('#map_tipss_box').addClass('scroll');
    } else {
        $('#map_tipss_box').css({
            top: top + 85,
            left: left - 225,
            zIndex: 9999
        });
    }
}

function fixDiv() {
    var $cache = $('#map_container');
    if ($('#J_isFloat').is(':checked') && $(window).scrollTop() > $cache.data('origin_top')) {
        $('#map_container').addClass('map_fixed');
    } else {
        $cache.removeClass('map_fixed');
    }
}

function HouseMarker(latlng, map, args) {
    this.latLng_ = latlng; //for google map
    this.setMap(map); //for google map
    this.text_ = "<div class='detail-info'>" + args + "</div>";//鑷畾涔夊弬鏁�
    this.div_ = null;
    this.setMap(map);
}

//HouseMarker.prototype = new google.maps.OverlayView();

HouseMarker.prototype.onAdd = function () {
    var div = document.createElement('DIV');
    div.style.position = 'absolute';
    div.style.background = 'white';
    div.style.cursor = 'pointer';
    div.innerHTML = this.text_;
    div.className = 'myclass';
    this.div_ = div;
    var panes = this.getPanes();
    panes.overlayLayer.appendChild(div);
};

HouseMarker.prototype.draw = function () {
    var overlayProjection = this.getProjection();
    var latLng = overlayProjection.fromLatLngToDivPixel(this.latLng_);
    // 璁剧疆灞傜殑澶у皬 鍜� 浣嶇疆
    var div = this.div_;
    var size = new google.maps.Size(5, -42); // 淇鍧愭爣鐨勫€�;
    div.style.left = (latLng.x + size.width) + 'px';
    div.style.top = (latLng.y + size.height) + 'px';
};

HouseMarker.prototype.onRemove = function () {
    this.div_.parentNode.removeChild(this.div_);
    this.div_ = null;
};


function setVeiwPort(map, mark) {
    if((mark.length!=0)&(typeof map !='undefined')){
        var bounds = new google.maps.LatLngBounds();
        //璇诲彇鏍囨敞鐐圭殑浣嶇疆鍧愭爣锛屽姞鍏atLngBounds
        for (var i = 0; i < mark.length; i++) {
            bounds.extend(mark[i].getPosition());
        }
        //璋冩暣map锛屼娇鍏堕€傚簲LatLngBounds,瀹炵幇灞曠ず鏈€浣宠閲庣殑鍔熻兘
        map.fitBounds(bounds);
    }
}

function setMakers(map, iconArr, markers, num, homestay_arr, homestay_min_price_arr, lat, lng) {
    if(typeof map !='undefined'){
        if(homestay_arr.length==0&&lat==0&&lng==0){
            return;
        }
        var jin=4;
        if(homestay_arr.length<(num+3)){
            jin=homestay_arr.length-num+1;
        }
        for (var i = num; i < (num + jin); i++) {
            //璁剧疆maker
            if ((i == (num + (jin-1))) && lat == 0 && lng == 0) {
                return;
            }
            if ((i == (num + (jin-1))) && lat != 0 && lng != 0) {
                gmarker = new google.maps.Marker({
                    position: new google.maps.LatLng(lat, lng),
                    map: map,
                    icon: 'https://maps.gstatic.com/mapfiles/api-3/images/spotlight-poi2.png'
                });
            } else {
                gmarker = new google.maps.Marker({
                    position: new google.maps.LatLng(homestay_arr[i].position[1], homestay_arr[i].position[0]),
                    map: map,
                    icon: iconArr[i]
                });
            }
            markers.push(gmarker);
            //璁剧疆maker浜嬩欢
            if (i != (num + (jin-1))) {
                gmarker.addListener('mouseover', function (event) {
                    var numArr = [];
                    for (var j = 0; j < homestay_arr.length; j++) {
                        if ((event.latLng.lat() == homestay_arr[j].position[1]) && (event.latLng.lng().toFixed(4) == homestay_arr[j].position[0].toFixed(4))) {
                            numArr.push(j);//灏嗙浉鍚岀粡绾害鐨勬埧婧愭爣鍙锋斁杩涙潵
                        }
                    }
                    var mak = window.event.currentTarget;
                    var top = $(mak).position().top;
                    var left = $(mak).position().left;
                    makeTip(numArr, top, left);
                    $("#map_tipss_box").show();
                });
                gmarker.addListener('mouseout', function () {
                    $("#map_tipss_box").hide();
                });
                gmarker.addListener('click', function (event) {
                    numArr = [];
                    for (var j = 0; j < homestay_arr.length; j++) {
                        if ((event.latLng.lat() == homestay_arr[j].position[1]) && (event.latLng.lng().toFixed(4) == homestay_arr[j].position[0].toFixed(4))) {
                            numArr.push(j);//灏嗙浉鍚岀粡绾害鐨勬埧婧愭爣鍙锋斁杩涙潵
                        }
                    }
                    window.location.href = '/h/' + homestay_arr[numArr[0]].id;
                });

                //璁剧疆浠锋牸
                var count = 0;
                var string;
                for (k = 0; k < homestay_arr.length; k++) {
                    if ((homestay_arr[k].position[1] == homestay_arr[i].position[1]) && (homestay_arr[k].position[0] == homestay_arr[i].position[0])) {
                        count++;
                    }
                }
                if (count > 1) {
                    string = 'X' + count;
                } else {
                    string = '锟�' + homestay_min_price_arr[homestay_arr[i]['id']];
                }
                new HouseMarker(new google.maps.LatLng(homestay_arr[i].position[1], homestay_arr[i].position[0]), map, string);
            }
        }
    }
}

function mapInitialize() {
    var mapProp = {
        center: new google.maps.LatLng(homestay_arr[0].position[1], homestay_arr[0].position[0]),
        zoom: 20,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        scrollwheel: true
    };
    map = new google.maps.Map(document.getElementById("map_container_box"), mapProp);
    setMakers(map, iconArr, markers, 0, homestay_arr, homestay_min_price_arr, mylat, mylng);
    setVeiwPort(map, markers);
}

$(function () {


    $("#map_tipss_box").on('mouseenter', function () {
        $("#map_tipss_box").show();
    });
    $("#map_tipss_box").on('mouseleave', function () {
        $("#map_tipss_box").hide();
    });
    var oldArr = homestay_arr;
    if ($.inArray(dest_id, [11, 16]) >= 0) {
        var $container = $('#map_container');
        $container.data('origin_top', $container.offset().top);
        $(window).scroll(function () {
            fixDiv();
            setTimeout(scroll_refresh, 800);
        });
        $('#J_isFloat').change(function () {
            fixDiv();
        });


        var sightid = $.trim( $("#txtSightid").val());
        if(sightid!=null){
            for(i=0;i<$('.sight').length;i++){
                if( $('.sight ').eq(i).attr('data-sight')== sightid ){
                    mylng=$('.sight ').eq(i).attr('data-lng');
                    mylat=$('.sight ').eq(i).attr('data-lat');
                }
            }
            console.log(mylng+'..'+ mylat);
        }


        google.maps.event.addDomListener(window, 'load', mapInitialize);

        var height = $('.search_order').offset().top;
        var y = 0;
        window.onscroll = function (ev) {
            var x = Math.ceil((parseInt(window.scrollY) + 200 - parseInt(height)) / 330);
            if (x > 0 && (x !== y) && x < (homestay_arr.length - 1)) {
                for (i = 0; i < markers.length; i++) {
                    markers[i].setMap(null);
                }
                markers.length = 0;
                $(".detail-info").parent().remove();
                y = Math.ceil((parseInt(window.scrollY) + 200 - parseInt(height)) / 330);
                // map.setCenter(new google.maps.LatLng(homestay_arr[y - 1].position[1], homestay_arr[y - 1].position[0]));
                setMakers(map, iconArr, markers, y - 1, homestay_arr, homestay_min_price_arr, mylat, mylng);
                setVeiwPort(map, markers);
            }
        };
    }
    fixDiv();

})
;
/* search info js */
$(document).ready(function() {
    $(document).on("click", ".show_more_rooms", function(){
        var book = $(this);
        var moreRoom = $(this).parents(".list_more").find(".more_rooms");
        moreRoom.slideToggle("normal", function () {
            if (book.text().match(text_look_at)) {  //鏌ョ湅
                book.text(text_pack_up_room);//鏀惰捣鎴块棿
            } else {
                book.text(text_look_at_all_the_room);//鏌ョ湅鍏ㄩ儴鎴块棿
            }
        });
        return true;
    });

    $("#searchList .left .list_more a").mousemove(function () {
        $(this).addClass("nogourl");
    }).mouseout(function () {
        $(this).removeClass("nogourl");
    });

    $(".sort-item").click(function(){
        var type = $(this).data("type")
        var id = $(this).attr("data-id");
        if($(this).hasClass("list_sort") && type != "price") {
            return;
        }

        $(".sort-id").val(id);
        if(type == 'price') {
            if(id == 2) {
                $(this).attr("data-id", 3);
                $("#price-order").removeClass("pic-rotate");
            }else{
                $(this).addClass("pic-rotate");
                $(this).attr("data-id", 2);
            }
        }else{
            $("#price-order").removeClass("pic-rotate");
            $("#price-order").attr("data-id", 2);
        }

        $(".sort-item").removeClass('list_sort');
        $(this).addClass("list_sort");

        $(".pageNum").val(0);
     //   $("#btn").click();

    });

    $(document).on("click", ".paging", function(){
        if(
            $(this).hasClass("current")
            || $(this).hasClass("invalid-paging-right")
            || $(this).hasClass("invalid-paging-left")
        ) {
            return;
        }
        var type = $(this).data("type");
        var id;

        if(type == 'prev') {
            id = parseInt($("input.pageNum").val()) - 1;
        }else if(type == 'next') {
            id = parseInt($("input.pageNum").val()) + 1;
        }else {
            id = $(this).data("id");
        }
        $("input.pageNum").val(id);
        $('body, html').animate({scrollTop:$('#searchList').position().top}, 'slow');

      //  $("#btn").click();
    });

});

function collect(v, hid, no) {
    var type = v;
    var uid = '';
    if (uid == '') {
        //alert('璇锋偍鐧诲綍');
        return false;
    }
    var sss = hid;
    $.post("/mycollect.php", {type: type, uid: uid, hid: hid}, function (msg) {
        if (msg == 0) {
            sss = '#c_' + sss;
            alert('Favorited');
            $(sss).css('background-image', "url('https://pages.zizaike.com/a/new_search/images_2/red_aixing.png')");
        } else {
            sss = '#c_' + sss;
            alert('Unfavorite');
            $(sss).css('background-image', "url('https://pages.zizaike.com/a/new_search/images_2/grey_aixing.png')");
            return false;
        }
    });
}

/*
function _win_href(n) {
    var _href = $(".more_div_" + n).find(".room_pic").find("a").attr("href");
    window.open("Const_Host_Domain"+_href);
}
*/
function analysis_click(name) {
    var img= new Image();
    img.src="https://api.zizaike.com/analysis/web/search?ad_name=" + name;
    return false;
}