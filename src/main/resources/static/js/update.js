$(document).ready(function () {

    $("#form1").submit(function () {
        var $title = $("#title").val();
        var $createdate = $("#createdate").val();
        
        if ($title == null || $title == "") {
            alert("文档名称不能为空！");
            return false;
        } else if ($createdate == null || $createdate == "") {
            alert("上传时间不能为空！");
            return false;
        } 
        return true;
    })

});





