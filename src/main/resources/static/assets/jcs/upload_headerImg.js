var imgSize_new, handSize_new;
// 鍒濆鍖朩eb Uploader
var uploader = WebUploader.create({
    //fileSingleSizeLimit: 1024 * 1024,//瀛楄妭闄愬埗(1MB)
    fileVal: "Filedata",//name 鍚嶇О
    //fileNumLimit: 1,//鏈€澶氫笂浼犳暟閲�
    auto: true,
    // swf鏂囦欢璺緞
    swf: '/Content/fangdong/js/Uploader.swf',
    // 鏂囦欢鎺ユ敹鏈嶅姟绔€�
    server: '//imghandler.muniao.com/ImageHandler/ImgUpload_ThumbHead',
    // 閫夋嫨鏂囦欢鐨勬寜閽€傚彲閫夈€�
    // 鍐呴儴鏍规嵁褰撳墠杩愯鏄垱寤猴紝鍙兘鏄痠nput鍏冪礌锛屼篃鍙兘鏄痜lash.
    pick: '#upload_btn',
    // 鍙厑璁搁€夋嫨鏂囦欢锛屽彲閫夈€�
    accept: {
        title: 'Images',
        extensions: 'gif,jpg,jpeg,bmp,png',
        mimeTypes: 'image/*'
    }
});
// 褰撴湁鏂囦欢娣诲姞杩涙潵鐨勬椂鍊�
uploader.on('fileQueued', function (file) {
    imgSize_new = file.size;
    if ($(".file-item").length) {
        $("dele").trigger("click");
        $(".img-uploadStatus").html("璇烽噸鏂颁笂浼�");
    }
    var $li = $(
        '<div id="' + file.id + '" class="file-item thumbnail">' +
        '<img id="conpic" />' +
        '<div class="info" style="display:none;"><dele style="cursor:pointer;line-height: 15px;" title="鐐瑰嚮鍒犻櫎">鍒犻櫎</dele></div>' +
        '</div>'
        ),
        $img = $li.find('img');
    $(".header-imageBox").html($li);
    // 鍒涘缓缂╃暐鍥�
    uploader.makeThumb(file, function (error, src) {
        if (error) {
            $img.replaceWith('<span>涓嶈兘棰勮</span>');
            return;
        }
        $img.attr('src', src);
    });
    //澶勭悊鍒犻櫎
    $li.on("click", "dele", function () {
        $('#' + file.id).remove();
        uploader.removeFile(file);
    });
});

// 鏂囦欢涓婁紶杩囩▼涓垱寤鸿繘搴︽潯瀹炴椂鏄剧ず銆�
uploader.on('uploadProgress', function (file, percentage) {
    var $li = $('#' + file.id),
        $percent = $li.find('.progress span');

    // 閬垮厤閲嶅鍒涘缓
    if (!$percent.length) {
        $percent = $('<p class="progress"><span></span></p>')
            .appendTo($li)
            .find('span');
    }

    $percent.css('width', percentage * 100 + '%');
});

// 鏂囦欢涓婁紶鎴愬姛锛岀粰item娣诲姞鎴愬姛class, 鐢ㄦ牱寮忔爣璁颁笂浼犳垚鍔熴€�
uploader.on('uploadSuccess', function (file, response) {
    if (response.ret == 6 || response.ret == 8 || imgSize_new > 1048576) {
        uploader.removeFile(file);
        if (imgSize_new > 1048576)
        { alert("鍥剧墖灏哄澶ぇ锛岃閲嶆柊涓婁紶"); }
        else
        { alert(response.msg); }
        $(".img-uploadStatus").html("璇烽噸鏂颁笂浼�");
        $("#" + file.id).remove();
        $(".header-imageBox").html("<img id='conpic' src='/Content/fangdong/image/owner_placeholder.jpg' />");
        return false;
    }
    $('#' + file.id).addClass('upload-state-done');
    $('#' + file.id).find('img').attr('fullurl', response.fullurl).attr('url', response.url);
    $(".img-uploadStatus").html("宸蹭笂浼�");
});

// 鏂囦欢涓婁紶澶辫触锛岀幇瀹炰笂浼犲嚭閿欍€�
uploader.on('uploadError', function (file, reason) {
    console.log("touxiang")
    console.log(reason)
    var $li = $('#' + file.id);
    $(".img-uploadStatus").html("涓婁紶澶辫触锛岃閲嶆柊涓婁紶");
    $li.remove();
    $(".header-imageBox").html("<img id='conpic' src='/Content/fangdong/image/owner_placeholder.jpg' />");
});

// 瀹屾垚涓婁紶瀹屼簡锛屾垚鍔熸垨鑰呭け璐ワ紝鍏堝垹闄よ繘搴︽潯銆�
uploader.on('uploadComplete', function (file) {
    $('#' + file.id).find('.progress').remove();
});
//韬唤璇佹闈�
var frontSize_new = 0
var frontcard = WebUploader.create({
    //fileSingleSizeLimit: 1024 * 1024,//瀛楄妭闄愬埗(1MB)
    fileVal: "Filedata",//name 鍚嶇О
    //fileNumLimit: 1,//鏈€澶氫笂浼犳暟閲�
    auto: true,
    // swf鏂囦欢璺緞
    swf: '/Content/fangdong/js/Uploader.swf',
    // 鏂囦欢鎺ユ敹鏈嶅姟绔€�
    server: '//imghandler.muniao.com/ImageHandler/ImgUpload_ThumbHead',
    // 閫夋嫨鏂囦欢鐨勬寜閽€傚彲閫夈€�
    // 鍐呴儴鏍规嵁褰撳墠杩愯鏄垱寤猴紝鍙兘鏄痠nput鍏冪礌锛屼篃鍙兘鏄痜lash.
    pick: '#frontcard',
    // 鍙厑璁搁€夋嫨鏂囦欢锛屽彲閫夈€�
    accept: {
        title: 'Images',
        extensions: 'jpg,jpeg,png',
        mimeTypes: 'image/*'
    }
});
// 褰撴湁鏂囦欢娣诲姞杩涙潵鐨勬椂鍊�
frontcard.on('fileQueued', function (file) {
    frontSize_new = file.size;
    if ($(".cardOne").length) {
        $(".img-uploadStatus").html("璇烽噸鏂颁笂浼�");
    }
    var $li = $(
        '<div id="' + file.id + '" class="cardOne">' +
        '<img id="front" src="/Content/fangdong/image/front.png"/>' +
        '<span class="identity_text">鏇存崲</span>' +
        '</div>'
        ),
        $img = $li.find('img');
    $(".frontMain").html($li);
    // 鍒涘缓缂╃暐鍥�
    frontcard.makeThumb(file, function (error, src) {
        if (error) {
            $img.replaceWith('<span>涓嶈兘棰勮</span>');
            return;
        }
        $img.attr('src', src);
        $li.find('span').show();
        //      /*$("#upload_btn").hide();*/
    });
});

// 鏂囦欢涓婁紶杩囩▼涓垱寤鸿繘搴︽潯瀹炴椂鏄剧ず銆�
frontcard.on('uploadProgress', function (file, percentage) {
    var $li = $('#' + file.id),
        $percent = $li.find('.progress span');

    // 閬垮厤閲嶅鍒涘缓
    if (!$percent.length) {
        $percent = $('<p class="progress"><span></span></p>')
            .appendTo($li)
            .find('span');
    }

    $percent.css('width', percentage * 100 + '%');
});

// 鏂囦欢涓婁紶鎴愬姛锛岀粰item娣诲姞鎴愬姛class, 鐢ㄦ牱寮忔爣璁颁笂浼犳垚鍔熴€�
frontcard.on('uploadSuccess', function (file, response) {
    if (response.ret == 6 || response.ret == 8 || frontSize_new > 10485760) {
        frontcard.removeFile(file);
        if (frontSize_new > 10485760)
        { alert("璇烽€夋嫨灏忎簬10M鐨勭収鐗�"); }
        else if (frontSize_new < 41) {
            alert("璇烽€夋嫨澶т簬0.05M鐨勭収鐗�");
        } else { alert(response.msg); }
        $(".img-uploadStatus").html("璇烽噸鏂颁笂浼�");
        $("#" + file.id).remove();
        $(".frontMain").html("<img id='front' src='/Content/fangdong/image/front.png' />");
        return false;
    }
    $('#' + file.id).addClass('upload-state-done');
    $('#' + file.id).find('img').attr('fullurl', response.fullurl).attr('url', response.url);
    $(".img-uploadStatus").html("宸蹭笂浼�");
});

// 鏂囦欢涓婁紶澶辫触锛岀幇瀹炰笂浼犲嚭閿欍€�
frontcard.on('uploadError', function (file, reason) {
    console.log("zhengmian")
    console.log(reason)
    var $li = $('#' + file.id);
    $(".img-uploadStatus").html("涓婁紶澶辫触锛岃閲嶆柊涓婁紶");
    $li.remove();
    $(".frontMain").html("<img id='front' src='/Content/fangdong/image/front.png' />");
});

// 瀹屾垚涓婁紶瀹屼簡锛屾垚鍔熸垨鑰呭け璐ワ紝鍏堝垹闄よ繘搴︽潯銆俧rontcard
frontcard.on('uploadComplete', function (file) {
    $('#' + file.id).find('.progress').remove();
});
//韬唤璇佸弽闈�
var reverseSize_new = 0
var reversecard = WebUploader.create({
    //fileSingleSizeLimit: 1024 * 1024,//瀛楄妭闄愬埗(1MB)
    fileVal: "Filedata",//name 鍚嶇О
    //fileNumLimit: 1,//鏈€澶氫笂浼犳暟閲�
    auto: true,
    // swf鏂囦欢璺緞
    swf: '/Content/fangdong/js/Uploader.swf',
    // 鏂囦欢鎺ユ敹鏈嶅姟绔€�
    server: '//imghandler.muniao.com/ImageHandler/ImgUpload_ThumbHead',
    // 閫夋嫨鏂囦欢鐨勬寜閽€傚彲閫夈€�
    // 鍐呴儴鏍规嵁褰撳墠杩愯鏄垱寤猴紝鍙兘鏄痠nput鍏冪礌锛屼篃鍙兘鏄痜lash.
    pick: '#reversecard',
    // 鍙厑璁搁€夋嫨鏂囦欢锛屽彲閫夈€�
    accept: {
        title: 'Images',
        extensions: 'jpg,jpeg,png',
        mimeTypes: 'image/*'
    }
});
// 褰撴湁鏂囦欢娣诲姞杩涙潵鐨勬椂鍊�
reversecard.on('fileQueued', function (file) {
    reverseSize_new = file.size;
    if ($(".cardTwo").length) {
        $(".img-uploadStatus").html("璇烽噸鏂颁笂浼�");
    }
    var $li = $(
        '<div id="' + file.id + '" class="cardTwo">' +
        '<img id="reverse" src="/Content/fangdong/image/reverse.png"/>' +
        '<span class="identity_text">鏇存崲</span>' +
        '</div>'
        ),
        $img = $li.find('img');
    $(".reverseMain").html($li);
    // 鍒涘缓缂╃暐鍥�
    reversecard.makeThumb(file, function (error, src) {
        if (error) {
            $img.replaceWith('<span>涓嶈兘棰勮</span>');
            return;
        }
        $img.attr('src', src);
        $li.find('span').show();
    });
});

// 鏂囦欢涓婁紶杩囩▼涓垱寤鸿繘搴︽潯瀹炴椂鏄剧ず銆�
reversecard.on('uploadProgress', function (file, percentage) {
    var $li = $('#' + file.id),
        $percent = $li.find('.progress span');

    // 閬垮厤閲嶅鍒涘缓
    if (!$percent.length) {
        $percent = $('<p class="progress"><span></span></p>')
            .appendTo($li)
            .find('span');
    }

    $percent.css('width', percentage * 100 + '%');
});

// 鏂囦欢涓婁紶鎴愬姛锛岀粰item娣诲姞鎴愬姛class, 鐢ㄦ牱寮忔爣璁颁笂浼犳垚鍔熴€�
reversecard.on('uploadSuccess', function (file, response) {
    if (response.ret == 6 || response.ret == 8 || reverseSize_new > 10485760) {
        reversecard.removeFile(file);
        if (reverseSize_new > 10485760)
        { alert("璇烽€夋嫨灏忎簬10M鐨勭収鐗�"); }
        else if (reverseSize_new < 41) {
            alert("璇烽€夋嫨澶т簬0.05M鐨勭収鐗�");
        } else { alert(response.msg); }
        $(".img-uploadStatus").html("璇烽噸鏂颁笂浼�");
        $("#" + file.id).remove();
        $(".reverseMain").html("<img id='reverse' src='/Content/fangdong/image/reverse.png' />");
        return false;
    }
    $('#' + file.id).addClass('upload-state-done');
    $('#' + file.id).find('img').attr('fullurl', response.fullurl).attr('url', response.url);
    $(".img-uploadStatus").html("宸蹭笂浼�");
});

// 鏂囦欢涓婁紶澶辫触锛岀幇瀹炰笂浼犲嚭閿欍€�
reversecard.on('uploadError', function (file, reason) {
    console.log("fanmianmian")
    console.log(reason)
    var $li = $('#' + file.id);
    $(".img-uploadStatus").html("涓婁紶澶辫触锛岃閲嶆柊涓婁紶");
    $li.remove();
    $(".reverseMain").html("<img id='reverse' src='/Content/fangdong/image/reverse.png' />");
});

// 瀹屾垚涓婁紶瀹屼簡锛屾垚鍔熸垨鑰呭け璐ワ紝鍏堝垹闄よ繘搴︽潯銆�
reversecard.on('uploadComplete', function (file) {
    $('#' + file.id).find('.progress').remove();
});
//鎵嬫寔姝ｉ潰鐓�
var handcard = WebUploader.create({
    //fileSingleSizeLimit: 1024 * 1024,//瀛楄妭闄愬埗(1MB)
    fileVal: "Filedata",//name 鍚嶇О
    //fileNumLimit: 1,//鏈€澶氫笂浼犳暟閲�
    auto: true,
    // swf鏂囦欢璺緞
    swf: '/Content/fangdong/js/Uploader.swf',
    // 鏂囦欢鎺ユ敹鏈嶅姟绔€�
    server: '//imghandler.muniao.com/ImageHandler/ImgUpload_ThumbHead',
    // 閫夋嫨鏂囦欢鐨勬寜閽€傚彲閫夈€�
    // 鍐呴儴鏍规嵁褰撳墠杩愯鏄垱寤猴紝鍙兘鏄痠nput鍏冪礌锛屼篃鍙兘鏄痜lash.
    pick: '#handcard',
    // 鍙厑璁搁€夋嫨鏂囦欢锛屽彲閫夈€�
    accept: {
        title: 'Images',
        extensions: 'jpg,jpeg,png',
        mimeTypes: 'image/*'
    }
});
// 褰撴湁鏂囦欢娣诲姞杩涙潵鐨勬椂鍊�
handcard.on('fileQueued', function (file) {
    handSize_new = file.size;
    if ($(".cardTwo").length) {
        $(".img-uploadStatus").html("璇烽噸鏂颁笂浼�");
    }
    var $li = $(
        '<div id="' + file.id + '" class="cardthree">' +
        '<img id="hand" src="/Content/fangdong/image/hand.png"/>' +
        '<span class="identity_text">鏇存崲</span>' +
        '</div>'
        ),
        $img = $li.find('img');
    $(".handMain").html($li);
    // 鍒涘缓缂╃暐鍥�
    handcard.makeThumb(file, function (error, src) {
        if (error) {
            $img.replaceWith('<span>涓嶈兘棰勮</span>');
            return;
        }
        $img.attr('src', src);
        $li.find('span').show();
    });
});

// 鏂囦欢涓婁紶杩囩▼涓垱寤鸿繘搴︽潯瀹炴椂鏄剧ず銆�
handcard.on('uploadProgress', function (file, percentage) {
    var $li = $('#' + file.id),
        $percent = $li.find('.progress span');

    // 閬垮厤閲嶅鍒涘缓
    if (!$percent.length) {
        $percent = $('<p class="progress"><span></span></p>')
            .appendTo($li)
            .find('span');
    }

    $percent.css('width', percentage * 100 + '%');
});

// 鏂囦欢涓婁紶鎴愬姛锛岀粰item娣诲姞鎴愬姛class, 鐢ㄦ牱寮忔爣璁颁笂浼犳垚鍔熴€�
handcard.on('uploadSuccess', function (file, response) {
    if (response.ret == 6 || response.ret == 8 || handSize_new > 10485760) {
        handcard.removeFile(file);
        if (handSize_new > 10485760)
        { alert("璇烽€夋嫨灏忎簬10M鐨勭収鐗�"); }
        else if (handSize_new < 41) {
            alert("璇烽€夋嫨澶т簬0.05M鐨勭収鐗�");
        } else { alert(response.msg); }
        $(".img-uploadStatus").html("璇烽噸鏂颁笂浼�");
        $("#" + file.id).remove();
        $(".handMain").html("<img id='hand' src='/Content/fangdong/image/hand.png' />");
        return false;
    }
    $('#' + file.id).addClass('upload-state-done');
    $('#' + file.id).find('img').attr('fullurl', response.fullurl).attr('url', response.url);
    $(".img-uploadStatus").html("宸蹭笂浼�");
});

// 鏂囦欢涓婁紶澶辫触锛岀幇瀹炰笂浼犲嚭閿欍€�
handcard.on('uploadError', function (file, reason) {
    console.log("shouchimian")
    console.log(reason)
    var $li = $('#' + file.id);
    $(".img-uploadStatus").html("涓婁紶澶辫触锛岃閲嶆柊涓婁紶");
    $li.remove();
    $(".handMain").html("<img id='hand' src='/Content/fangdong/image/hand.png' />");
});

// 瀹屾垚涓婁紶瀹屼簡锛屾垚鍔熸垨鑰呭け璐ワ紝鍏堝垹闄よ繘搴︽潯銆�
handcard.on('uploadComplete', function (file) {
    $('#' + file.id).find('.progress').remove();
});