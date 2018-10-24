//公共js
function pagination(op){
    var options = $.extend({}, {
        url     :   "",
        async   :   true
    }, op);

    var page = 0;//第几页
    var totalPages = 0;//共多少页
    var param = new Object();//查询表格所需参数

    /**
     * 表格查询
     */
    function findAll(param , sizeIsChanged) {

        $.ajax({
            method  :   "POST",
            async   :   options.async,
            url     :   options.url,
            data    :   param
        }).done(function(result) {
            var html = "";
            $(result.content).each(function (index) {
                var offset = result.pageable.offset;
                html +=
                    '<tr>\n' +
                    '    <th scope="row">' + (offset + index + 1) + '</th>\n' +
                    '    <td>' + this.money + '</td>\n' +
                    '    <td>' + $.format.date(this.date, "yyyy-MM-dd") + '</td>\n' +
                    '    <td>' + this.remark + '</td>\n' +
                    '</tr>'
            });
            $("tbody").html(html);

            $("#totalElements").text("共" + result.totalElements + "条");
            totalPages = result.totalPages;
        }).fail(function( jqXHR, textStatus ) {
            alert( "Request failed: " + textStatus );
        });


        $.post("/log/findAll" , param , function (result) {
            var html = "";
            $(result.content).each(function (index) {
                var offset = result.pageable.offset;
                html +=
                    '<tr>\n' +
                    '    <th scope="row">' + (offset + index + 1) + '</th>\n' +
                    '    <td>' + this.money + '</td>\n' +
                    '    <td>' + $.format.date(this.date, "yyyy-MM-dd") + '</td>\n' +
                    '    <td>' + this.remark + '</td>\n' +
                    '</tr>'
            });
            $("tbody").html(html);

            $("#totalElements").text("共" + result.totalElements + "条");
            totalPages = result.totalPages;

        })
    }

    /**
     * 触发表格查询
     */
    var size = $("#size option:selected").val();
    param["size"] = size;
    findAll(param , true);

    /**
     *每页条数改变后触发查询
     */
    $("#size").change(function () {
        var size = $("#size option:selected").val();
        param["size"] = size;
        findAll(param , true);
    })
    /**
     * 分页点击函数
     */
    $(".pagination li").click(function () {
        var pageEl = $(this).attr("id");
        switch (pageEl){
            case "First":
                page = 0;
                break;
            case "Previous":
                page = page > 0 ? page - 1 : 0;
                break;
            case "Next":
                page = page < totalPages-1 ? page + 1 : totalPages - 1;
                break;
            default :
                page = totalPages - 1;
                break;
        }
        param["page"] = page;
        findAll(param);
    })

    /**
     *输入页数框，鼠标离开事件
     */
    $("#page").on("keyup",function () {
        page = $(this).val();
        if(page > totalPages){
            $(this).val(totalPages)
            page = totalPages;
        }
        param["page"] = page - 1;
        findAll(param);
    })
}