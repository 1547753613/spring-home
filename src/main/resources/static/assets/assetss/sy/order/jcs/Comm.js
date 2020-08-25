/* 
请求Ajax 带返回值
*/
function AjaxJson(url) {
    $.ajax({
        url: url,
        type: "get",
        data: null,
        dataType: "json",
        async: false,
        success: function (data) {
            alert(data.Message);
        },
        error: function (data) {
            alert("操作异常！");
        }
    });
}
/* 
获取订单状态
*/
function orderstatus(status, isdeal, canpaydate, renttype, drawbackamount) {
    var canpaydateTimestamp = 0;
    var now_timestamp = format(new Date(), 'timestamp');
    if (canpaydate != null) {
        canpaydateTimestamp = format(new Date(canpaydate), 'timestamp');
    }
    if (renttype == 4) {
        if (status == 1) {
           return  "未付款";
        }
        else if (status == 8 && isdeal == 0) {
           return  "-";
        }
        else if (status == 2) {
           return  "已付款";
        }
        else if (status == 3) {
           return  "订单完成";
        }
        else if (status == 5 && isdeal == 0) {
           return  "退款";
        }
        else if (status == 10) {
           return  "取消订单";
        }
        else {
           return  "-";
        }
    }
    else {
        switch (status) {
            case 1:
                if (now_timestamp - canpaydateTimestamp > 2 * 60 * 60) {
                    return "未付款[已过期]";
                }
                return "未付款";
                break;
            case 2:
                return "已付款";
                break;
            case 3:
                return "订单完成";
                break;
            case 4:
                return "等待确认退款";
                break;
            case 5:
                if (isdeal == 0) {
                    return "待处理退款";
                }
                else if (isdeal == 1) {
                    return "已退款";
                }
                else if (isdeal == 2) {
                   return  "不同意退款";
                }
                else {
                    return "退款处理中";
                }
                break;
            case 8:
                if (isdeal == 0) {
                    if (now_timestamp - canpaydateTimestamp > 30 * 60) {
                        return "等待确认[已过期]";
                    } else {
                        return "等待确认<br/><br/><a href='javascript:window.location.reload();' class='aBlue'>刷新状态</a>";
                    }
                } else if (isdeal == 9) {
                    if (drawbackamount > 0) { return "预支付未确认[已退款]"; } else {
                        return "预支付未确认";
                    }
                } else {
                    if (drawbackamount > 0) { return "房东拒绝[已退款]"; } else {
                        return "房东拒绝";
                    }
                }
                return "已付款";
                break;
            case 10:
                if (drawbackamount > 0) { return "房客取消[已退款]"; } else {
                    return "房客取消";
                }
                break;
            default:
                return "未知订单状态";
                break;
        }
    }
}

/*
	format 时间格式化；
	DateObject 时间
	type 时间类型
		timestamp 时间戳
		y 年
		m 月
		d 日
		h 时
		i 分钟
		s 秒
		D 日
		M 星期
	错误将返回false ；
*/
format = function (DateObject, type) {
    type = type || "y-m-d h:i:s";
    var objecttype = Object.prototype.toString.call(DateObject).split(" ")[1].toLowerCase().replace("]", "");

    if (objecttype !== "string" && objecttype !== "date" && objecttype !== "object" && objecttype !== "number") {
        return null;
    }
    if (objecttype === "number") {
        DateObject = Math.round(DateObject);
        DateObject = new Date(DateObject * 1000);
        /*
                    if (DateObject>3000){
                        DateObject = new Date(DateObject*1000);
            //			DateObject.setTime(DateObject);
                    }
                    else if (DateObject<3000){
                        //DateObject = new Date();
                        DateObject.setUTCFullYear(DateObject, 0, 1);
            //			DateObject.setUTCHours(0, 0, 0, 0);
                    }
        /*
        */
    }
    else if (objecttype !== "date") {
        DateObject = new Date(DateObject);
    }
    //		DateObject.setUTCHours(0, 0, 0, 0);
    var date = DateObject;
    var year = (date.getFullYear()).toString(),
    _month = date.getMonth(),
    month = (_month + 1).toString(),
    day = (date.getDate()).toString(),
    _day = (date.getDay()).toString(),
    hour = (date.getHours()).toString(),
    miniter = (date.getMinutes()).toString(),
    second = (date.getSeconds()).toString(),
//	Millisecond = (date.getMilliseconds()).toString(),
     _year;
    var timestamp = Math.round(date.getTime()) / 1000;
    if (timestamp == 0) {
        return null;
    }

    var dateArray = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    month = month.length === 1 ? "0" + month : month;
    day = day.length === 1 ? "0" + day : day;
    hour = hour.length === 1 ? "0" + hour : hour;
    miniter = miniter.length === 1 ? "0" + miniter : miniter;
    second = second.length === 1 ? "0" + second : second;
    if (type == 'date') {
        return date;
    }
    if (type == 'timestamp') {
        return Math.round(timestamp);
    }
    return type.replace(/timestamp/g, Math.round(timestamp))
//		.replace(/ms/g, Millisecond)
        .replace(/y/g, year)
        .replace(/m/g, month)
        .replace(/d/g, day)
        .replace(/h/g, hour)
        .replace(/i/g, miniter)
        .replace(/s/g, second)
        .replace(/D/g, _day)
        .replace(/M/g, dateArray[_month]);
}