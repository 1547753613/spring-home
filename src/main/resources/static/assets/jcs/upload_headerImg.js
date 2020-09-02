var imgSize_new, handSize_new;
// 初始化Web Uploader
var uploader = WebUploader.create({
    //fileSingleSizeLimit: 1024 * 1024,//字节限制(1MB)
    fileVal: "Filedata",//name 名称
    //fileNumLimit: 1,//最多上传数量
    auto: true,
    // swf文件路径
    swf: '/Content/fangdong/js/Uploader.swf',
    // 文件接收服务端。
    server: '//imghandler.muniao.com/ImageHandler/ImgUpload_ThumbHead',
    // 选择文件的按钮。可选。
    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
    pick: '#upload_btn',
    // 只允许选择文件，可选。
    accept: {
        title: 'Images',
        extensions: 'gif,jpg,jpeg,bmp,png',
        mimeTypes: 'image/*'
    }
});
// 当有文件添加进来的时候
uploader.on('fileQueued', function (file) {
    imgSize_new = file.size;
    if ($(".file-item").length) {
        $("dele").trigger("click");
        $(".img-uploadStatus").html("请重新上传");
    }
    var $li = $(
        '<div id="' + file.id + '" class="file-item thumbnail">' +
        '<img id="conpic" />' +
        '<div class="info" style="display:none;"><dele style="cursor:pointer;line-height: 15px;" title="点击删除">删除</dele></div>' +
        '</div>'
        ),
        $img = $li.find('img');
    $(".header-imageBox").html($li);
    // 创建缩略图
    uploader.makeThumb(file, function (error, src) {
        if (error) {
            $img.replaceWith('<span>不能预览</span>');
            return;
        }
        $img.attr('src', src);
    });
    //处理删除
    $li.on("click", "dele", function () {
        $('#' + file.id).remove();
        uploader.removeFile(file);
    });
});

// 文件上传过程中创建进度条实时显示。
uploader.on('uploadProgress', function (file, percentage) {
    var $li = $('#' + file.id),
        $percent = $li.find('.progress span');

    // 避免重复创建
    if (!$percent.length) {
        $percent = $('<p class="progress"><span></span></p>')
            .appendTo($li)
            .find('span');
    }

    $percent.css('width', percentage * 100 + '%');
});

// 文件上传成功，给item添加成功class, 用样式标记上传成功。
uploader.on('uploadSuccess', function (file, response) {
    if (response.ret == 6 || response.ret == 8 || imgSize_new > 1048576) {
        uploader.removeFile(file);
        if (imgSize_new > 1048576)
        { alert("图片尺寸太大，请重新上传"); }
        else
        { alert(response.msg); }
        $(".img-uploadStatus").html("请重新上传");
        $("#" + file.id).remove();
        $(".header-imageBox").html("<img id='conpic' src='/Content/fangdong/image/owner_placeholder.jpg' />");
        return false;
    }
    $('#' + file.id).addClass('upload-state-done');
    $('#' + file.id).find('img').attr('fullurl', response.fullurl).attr('url', response.url);
    $(".img-uploadStatus").html("已上传");
});

// 文件上传失败，现实上传出错。
uploader.on('uploadError', function (file, reason) {
    console.log("touxiang")
    console.log(reason)
    var $li = $('#' + file.id);
    $(".img-uploadStatus").html("上传失败，请重新上传");
    $li.remove();
    $(".header-imageBox").html("<img id='conpic' src='/Content/fangdong/image/owner_placeholder.jpg' />");
});

// 完成上传完了，成功或者失败，先删除进度条。
uploader.on('uploadComplete', function (file) {
    $('#' + file.id).find('.progress').remove();
});
//身份证正面
var frontSize_new = 0
var frontcard = WebUploader.create({
    //fileSingleSizeLimit: 1024 * 1024,//字节限制(1MB)
    fileVal: "Filedata",//name 名称
    //fileNumLimit: 1,//最多上传数量
    auto: true,
    // swf文件路径
    swf: '/Content/fangdong/js/Uploader.swf',
    // 文件接收服务端。
    server: '//imghandler.muniao.com/ImageHandler/ImgUpload_ThumbHead',
    // 选择文件的按钮。可选。
    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
    pick: '#frontcard',
    // 只允许选择文件，可选。
    accept: {
        title: 'Images',
        extensions: 'jpg,jpeg,png',
        mimeTypes: 'image/*'
    }
});
// 当有文件添加进来的时候
frontcard.on('fileQueued', function (file) {
    frontSize_new = file.size;
    if ($(".cardOne").length) {
        $(".img-uploadStatus").html("请重新上传");
    }
    var $li = $(
        '<div id="' + file.id + '" class="cardOne">' +
        '<img id="front" src="/Content/fangdong/image/front.png"/>' +
        '<span class="identity_text">更换</span>' +
        '</div>'
        ),
        $img = $li.find('img');
    $(".frontMain").html($li);
    // 创建缩略图
    frontcard.makeThumb(file, function (error, src) {
        if (error) {
            $img.replaceWith('<span>不能预览</span>');
            return;
        }
        $img.attr('src', src);
        $li.find('span').show();
        //      /*$("#upload_btn").hide();*/
    });
});

// 文件上传过程中创建进度条实时显示。
frontcard.on('uploadProgress', function (file, percentage) {
    var $li = $('#' + file.id),
        $percent = $li.find('.progress span');

    // 避免重复创建
    if (!$percent.length) {
        $percent = $('<p class="progress"><span></span></p>')
            .appendTo($li)
            .find('span');
    }

    $percent.css('width', percentage * 100 + '%');
});

// 文件上传成功，给item添加成功class, 用样式标记上传成功。
frontcard.on('uploadSuccess', function (file, response) {
    if (response.ret == 6 || response.ret == 8 || frontSize_new > 10485760) {
        frontcard.removeFile(file);
        if (frontSize_new > 10485760)
        { alert("请选择小于10M的照片"); }
        else if (frontSize_new < 41) {
            alert("请选择大于0.05M的照片");
        } else { alert(response.msg); }
        $(".img-uploadStatus").html("请重新上传");
        $("#" + file.id).remove();
        $(".frontMain").html("<img id='front' src='/Content/fangdong/image/front.png' />");
        return false;
    }
    $('#' + file.id).addClass('upload-state-done');
    $('#' + file.id).find('img').attr('fullurl', response.fullurl).attr('url', response.url);
    $(".img-uploadStatus").html("已上传");
});

// 文件上传失败，现实上传出错。
frontcard.on('uploadError', function (file, reason) {
    console.log("zhengmian")
    console.log(reason)
    var $li = $('#' + file.id);
    $(".img-uploadStatus").html("上传失败，请重新上传");
    $li.remove();
    $(".frontMain").html("<img id='front' src='/Content/fangdong/image/front.png' />");
});

// 完成上传完了，成功或者失败，先删除进度条。frontcard
frontcard.on('uploadComplete', function (file) {
    $('#' + file.id).find('.progress').remove();
});
//身份证反面
var reverseSize_new = 0
var reversecard = WebUploader.create({
    //fileSingleSizeLimit: 1024 * 1024,//字节限制(1MB)
    fileVal: "Filedata",//name 名称
    //fileNumLimit: 1,//最多上传数量
    auto: true,
    // swf文件路径
    swf: '/Content/fangdong/js/Uploader.swf',
    // 文件接收服务端。
    server: '//imghandler.muniao.com/ImageHandler/ImgUpload_ThumbHead',
    // 选择文件的按钮。可选。
    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
    pick: '#reversecard',
    // 只允许选择文件，可选。
    accept: {
        title: 'Images',
        extensions: 'jpg,jpeg,png',
        mimeTypes: 'image/*'
    }
});
// 当有文件添加进来的时候
reversecard.on('fileQueued', function (file) {
    reverseSize_new = file.size;
    if ($(".cardTwo").length) {
        $(".img-uploadStatus").html("请重新上传");
    }
    var $li = $(
        '<div id="' + file.id + '" class="cardTwo">' +
        '<img id="reverse" src="/Content/fangdong/image/reverse.png"/>' +
        '<span class="identity_text">更换</span>' +
        '</div>'
        ),
        $img = $li.find('img');
    $(".reverseMain").html($li);
    // 创建缩略图
    reversecard.makeThumb(file, function (error, src) {
        if (error) {
            $img.replaceWith('<span>不能预览</span>');
            return;
        }
        $img.attr('src', src);
        $li.find('span').show();
    });
});

// 文件上传过程中创建进度条实时显示。
reversecard.on('uploadProgress', function (file, percentage) {
    var $li = $('#' + file.id),
        $percent = $li.find('.progress span');

    // 避免重复创建
    if (!$percent.length) {
        $percent = $('<p class="progress"><span></span></p>')
            .appendTo($li)
            .find('span');
    }

    $percent.css('width', percentage * 100 + '%');
});

// 文件上传成功，给item添加成功class, 用样式标记上传成功。
reversecard.on('uploadSuccess', function (file, response) {
    if (response.ret == 6 || response.ret == 8 || reverseSize_new > 10485760) {
        reversecard.removeFile(file);
        if (reverseSize_new > 10485760)
        { alert("请选择小于10M的照片"); }
        else if (reverseSize_new < 41) {
            alert("请选择大于0.05M的照片");
        } else { alert(response.msg); }
        $(".img-uploadStatus").html("请重新上传");
        $("#" + file.id).remove();
        $(".reverseMain").html("<img id='reverse' src='/Content/fangdong/image/reverse.png' />");
        return false;
    }
    $('#' + file.id).addClass('upload-state-done');
    $('#' + file.id).find('img').attr('fullurl', response.fullurl).attr('url', response.url);
    $(".img-uploadStatus").html("已上传");
});

// 文件上传失败，现实上传出错。
reversecard.on('uploadError', function (file, reason) {
    console.log("fanmianmian")
    console.log(reason)
    var $li = $('#' + file.id);
    $(".img-uploadStatus").html("上传失败，请重新上传");
    $li.remove();
    $(".reverseMain").html("<img id='reverse' src='/Content/fangdong/image/reverse.png' />");
});

// 完成上传完了，成功或者失败，先删除进度条。
reversecard.on('uploadComplete', function (file) {
    $('#' + file.id).find('.progress').remove();
});
//手持正面照
var handcard = WebUploader.create({
    //fileSingleSizeLimit: 1024 * 1024,//字节限制(1MB)
    fileVal: "Filedata",//name 名称
    //fileNumLimit: 1,//最多上传数量
    auto: true,
    // swf文件路径
    swf: '/Content/fangdong/js/Uploader.swf',
    // 文件接收服务端。
    server: '//imghandler.muniao.com/ImageHandler/ImgUpload_ThumbHead',
    // 选择文件的按钮。可选。
    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
    pick: '#handcard',
    // 只允许选择文件，可选。
    accept: {
        title: 'Images',
        extensions: 'jpg,jpeg,png',
        mimeTypes: 'image/*'
    }
});
// 当有文件添加进来的时候
handcard.on('fileQueued', function (file) {
    handSize_new = file.size;
    if ($(".cardTwo").length) {
        $(".img-uploadStatus").html("请重新上传");
    }
    var $li = $(
        '<div id="' + file.id + '" class="cardthree">' +
        '<img id="hand" src="/Content/fangdong/image/hand.png"/>' +
        '<span class="identity_text">更换</span>' +
        '</div>'
        ),
        $img = $li.find('img');
    $(".handMain").html($li);
    // 创建缩略图
    handcard.makeThumb(file, function (error, src) {
        if (error) {
            $img.replaceWith('<span>不能预览</span>');
            return;
        }
        $img.attr('src', src);
        $li.find('span').show();
    });
});

// 文件上传过程中创建进度条实时显示。
handcard.on('uploadProgress', function (file, percentage) {
    var $li = $('#' + file.id),
        $percent = $li.find('.progress span');

    // 避免重复创建
    if (!$percent.length) {
        $percent = $('<p class="progress"><span></span></p>')
            .appendTo($li)
            .find('span');
    }

    $percent.css('width', percentage * 100 + '%');
});

// 文件上传成功，给item添加成功class, 用样式标记上传成功。
handcard.on('uploadSuccess', function (file, response) {
    if (response.ret == 6 || response.ret == 8 || handSize_new > 10485760) {
        handcard.removeFile(file);
        if (handSize_new > 10485760)
        { alert("请选择小于10M的照片"); }
        else if (handSize_new < 41) {
            alert("请选择大于0.05M的照片");
        } else { alert(response.msg); }
        $(".img-uploadStatus").html("请重新上传");
        $("#" + file.id).remove();
        $(".handMain").html("<img id='hand' src='/Content/fangdong/image/hand.png' />");
        return false;
    }
    $('#' + file.id).addClass('upload-state-done');
    $('#' + file.id).find('img').attr('fullurl', response.fullurl).attr('url', response.url);
    $(".img-uploadStatus").html("已上传");
});

// 文件上传失败，现实上传出错。
handcard.on('uploadError', function (file, reason) {
    console.log("shouchimian")
    console.log(reason)
    var $li = $('#' + file.id);
    $(".img-uploadStatus").html("上传失败，请重新上传");
    $li.remove();
    $(".handMain").html("<img id='hand' src='/Content/fangdong/image/hand.png' />");
});

// 完成上传完了，成功或者失败，先删除进度条。
handcard.on('uploadComplete', function (file) {
    $('#' + file.id).find('.progress').remove();
});