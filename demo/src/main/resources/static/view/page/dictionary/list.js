mini.parse();

var grid = mini.get("datagrid1");
grid.load();

var menu = new ColumnsMenu(grid);

/**
 * 新增
 */
function add() {
    mini.open({
        targetWindow: window,
        url: "/page/dictionary/edit",
        title: "新增员工", width: 600, height: 400,
        onload: function () {
            var iframe = this.getIFrameEl();
            var data = { action: "new" };
            iframe.contentWindow.SetData(data);
        },
        ondestroy: function (action) {
            grid.reload();
        }
    });
}

/**
 * 编辑
 */
function edit() {
    var row = grid.getSelected();
    if (row) {
        mini.open({
            url: "/page/dictionary/edit",
            title: "编辑", width: 600, height: 400,
            onload: function () {
                var iframe = this.getIFrameEl();
                var data = { action: "edit", id: row.id };
                iframe.contentWindow.SetData(data);

            },
            ondestroy: function (action) {
                //var iframe = this.getIFrameEl();
                grid.reload();
            }
        });

    } else {
        alert("请选中一条记录");
    }

}

/**
 * 删除
 */
function remove() {
    var rows = grid.getSelecteds();
    if (rows.length > 0) {
        if (confirm("确定删除选中记录？")) {
            var ids = [];
            for (var i = 0, l = rows.length; i < l; i++) {
                var r = rows[i];
                ids.push(r.id);
            }
            var id = ids.join(',');
            grid.loading("操作中，请稍后......");
            $.ajax({
                url: "/dictionary/deleteById",
                data:{id:id},
                success: function (text) {
                    grid.reload();
                },
                error: function () {
                }
            });
        }
    } else {
        alert("请选中一条记录");
    }
}

/**
 * 子阶
 */
function child() {
    var row = grid.getSelected();
    if(row){
        var pid = row.id;
        location.href = "/page/dictionary/child/list?pid="+pid;
    }else {
        alert("请选中一条记录");
    }
}

function search() {
    var name = mini.get("name").getValue();
    var pId = 0;
    grid.load({ name: name,pId: pId });
}
function onKeyEnter(e) {
    search();
}

$(function(){
    var height = window.screen.availHeight - 150;
    $("#datagrid1").height(height);

})