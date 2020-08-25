//
$(document).ready(function () {
    //
    function ArrayforEach(list, callback) {
        for (var i = 0; i < list.length; i++) {
            if (typeof callback === 'function') {
                callback.call(list, list[i], i);
            }
        }
    }
    var index = [
        { "class": ".write-messageBox .close-dialogRegister", "event": "click", "category": "鎴夸笢绠″寮圭獥-鍏抽棴", "action": "鐐瑰嚮" },
        { "class": ".usercon .userL li a:contains(涓汉淇℃伅)", "event": "click", "category": "鐢ㄦ埛涓績椤�-涓汉淇℃伅", "action": "鐐瑰嚮" },
        { "class": ".usercon .userL li a:contains(璁㈠崟绠＄悊)", "event": "click", "category": "鐢ㄦ埛涓績椤�-璁㈠崟绠＄悊", "action": "鐐瑰嚮" },
        { "class": ".usercon .userL li a:contains(鎴戠殑鏀惰棌)", "event": "click", "category": "鐢ㄦ埛涓績椤�-鎴戠殑鏀惰棌", "action": "鐐瑰嚮" },
        { "class": ".usercon .userL li a:contains(鎴戠殑浼氬憳)", "event": "click", "category": "鐢ㄦ埛涓績椤�-鎴戠殑浼氬憳", "action": "鐐瑰嚮" },
        { "class": ".usercon .userL li a:contains(鎴戠殑浼樻儬鍒�)", "event": "click", "category": "鐢ㄦ埛涓績椤�-鎴戠殑浼樻儬鍒�", "action": "鐐瑰嚮" },
        { "class": ".usercon .userL li a:contains(鎴戠殑绉熷竵)", "event": "click", "category": "鐢ㄦ埛涓績椤�-鎴戠殑绉熷竵", "action": "鐐瑰嚮" },
        { "class": ".usercon .userL li a:contains(瀵嗙爜淇敼)", "event": "click", "category": "鐢ㄦ埛涓績椤�-瀵嗙爜淇敼", "action": "鐐瑰嚮" },
        { "class": ".usercon .userL li a:contains(鏀舵鏂瑰紡)", "event": "click", "category": "鐢ㄦ埛涓績椤�-鏀舵鏂瑰紡", "action": "鐐瑰嚮" },
        { "class": ".usercon .userL li a:contains(娑堟伅鎻愰啋)", "event": "click", "category": "鐢ㄦ埛涓績椤�-娑堟伅鎻愰啋", "action": "鐐瑰嚮" },
        { "class": ".usercon .userL li a:contains(鎴挎簮绠＄悊)", "event": "click", "category": "鎴夸笢璇︽儏椤�-鎴夸笢鎴挎簮", "action": "鐐瑰嚮" },
        { "class": "#roomcontent .ubgimg", "event": "click", "category": "鎴夸笢璇︽儏椤�-鐐瑰嚮鎴挎簮", "action": "鐐瑰嚮" },
        { "class": ".czc_000000058", "event": "click", "category": "鎴夸笢璇︽儏椤�-鎴夸笢璇勪环", "action": "鐐瑰嚮" }
    ];
    ArrayforEach(index, function (x, i) {
        //
        $("body").delegate(x["class"], x["event"], function () {
            _czc.push(锘縖"_trackEvent", x["category"], x["action"], x["label"] || "", x["value"] || 0, x["nodeid"] || 0]);
        });
    });
});