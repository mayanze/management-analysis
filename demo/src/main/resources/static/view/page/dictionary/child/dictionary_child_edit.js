mini.parse();


var form = new mini.Form("form1");

function SaveData() {
    saveForm(form, {
        url: "/dictionary/save",
        callback: function (success) {
            if (success) CloseWindow("save");
            else CloseWindow();
        }
    });
}

////////////////////
//标准方法接口定义
function SetData(data) {
    if (data.action == "edit") {
        debugger
        //跨页面传递的数据对象，克隆后才可以安全使用
        data = mini.clone(data);

        $.ajax({
            url: "/dictionary/findById",
            data:{id:data.id},
            cache: false,
            success: function (text) {
                var o = mini.decode(text);
                form.setData(o);
                form.setChanged(false);
            }
        });
    }else {
        data = mini.clone(data);
        var text = '{pid: '+data.pId+'}';
        var o = mini.decode(text);
        form.setData(o);
        form.setChanged(false);
    }
}

function GetData() {
    var o = form.getData();
    return o;
}
function CloseWindow(action) {
    if (action == "close" && form.isChanged()) {
        if (confirm("数据被修改了，是否先保存？")) {
            return false;
        }
    }
    if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
    else window.close();
}
function onOk(e) {
    SaveData();
}
function onCancel(e) {
    CloseWindow("cancel");
}

let myUtil = {
    getUrlParameter: function(key){
        var reg = new RegExp("(^|&)"+key+"=([^&]*)(&|$)");
        var result = window.location.search.substr(1).match(reg);
        return result?decodeURIComponent(result[2]):null;
    }
}

    let pId = myUtil.getUrlParameter("pId");
    $("#dictionary_pId").val(pId);
