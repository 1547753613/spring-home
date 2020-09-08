var nowDate = new Date($("#enddate").val()),   obj = {},days=$("#days").val(),end;
if (nowDate==null){
    nowDate=new Date();
}
if (null==days){
    days=1;
}

for (var i=1;i<=days;i++){

    nowDate.setDate(nowDate.getDate()+1)
    var year = nowDate.getFullYear();

    var month = nowDate.getMonth()+1;

    var date = nowDate.getDate();
    var da=[year,month,date].join('-')
    end=[year,month,date+1].join('-')
    obj[da]='有客'

}


laydate.render({
    elem: '#startenddate',
    range: true,
    min: end,
    mark:obj,
    done: function(value, date, endDate){
        var price = $(".day_l span").text();
        if (date.date!=endDate.date){
            $("#start").val($.trim(value.substr(0,10)))
            $("#end").val($.trim(value.substr(12,20)))

            //alert(date)
           // console.log(date)
           // $("#start").val(new Date(date.year, date.month, date.date, date.hours, date.minutes, date.seconds));
           // $("#end").val(new Date(endDate.year, endDate.month, endDate.date, endDate.hours, endDate.minutes, endDate.seconds));
            $("#day").val(endDate.date - date.date)
            $("#many").val(price)
            $("#day_yuding").text("立即预订(" + (endDate.date - date.date) + "晚" + price * (endDate.date - date.date) + "元)")

        }else {
            $("#day_yuding").text("立即预订");

        }
}
});