var nowDate = new Date($("#enddate").val()),   obj = {},days=$("#days").val(),end;
if (nowDate==null){
    nowDate=new Date();
}
if (null==days){
    days=0;
}else {
    days=Math.ceil( (nowDate.getTime()- new Date().getTime())/ (1000 * 60 * 60 * 24))

}
days=days<0?0:days;
var d=new Date();

    for (var i = 0; i <= days; i++) {
        var year = d.getFullYear();

        var month = d.getMonth() + 1;

        var date = d.getDate();
        var da = [year, month, date].join('-')
        if (days!=0) {
            end = [year, month, date + 1].join('-')

            obj[da] = '有客'
        }else {
            end = [year, month, date ].join('-')

        }
        d.setDate(d.getDate() + 1)

    }

console.log(end)

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
