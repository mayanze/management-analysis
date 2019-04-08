<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>DataGrid 数据表格</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />

    <#--------------------------------------------------------------------->
    <#--js/css 库模块-->
    <#--------------------------------------------------------------------->

    <#include "../../head.ftl">

</head>
<body>

<div class="row">
    <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
        <table style="width:100%;">
            <tr>
                <td style="width:100%;">
                    <a class="mini-button" iconCls="icon-add" onclick="add()">增加</a>
                    <a class="mini-button" iconCls="icon-add" onclick="edit()">编辑</a>
                    <a class="mini-button" iconCls="icon-remove" onclick="remove()">删除</a>
                </td>
                <td style="white-space:nowrap;">
                    <input id="remark" class="mini-textbox" emptyText="请输入备注" style="width:150px;" onenter="onKeyEnter"/>
                    <a class="mini-button" onclick="search()">查询</a>
                </td>
            </tr>
        </table>
    </div>
</div>
<div id="datagrid1" class="mini-datagrid row fill" allowResize="true"
     url="/consume/findAll"  idField="id" multiSelect="true">
    <div property="columns">
        <!--<div type="indexcolumn"></div>        -->
        <div type="checkcolumn" ></div>
        <div field="dictionaryPo.name" width="120" headerAlign="center" allowSort="true">分类</div>
        <div field="money" width="120" headerAlign="center" allowSort="true">金额</div>
        <div field="createTime" width="100" headerAlign="center" dateFormat="yyyy-MM-dd HH:mm:ss" allowSort="true">创建日期</div>
        <div field="remark" width="120" headerAlign="center" allowSort="true">备注</div>
    </div>
</div>

<#--------------------------------------------------------------------->
<#--js模块-->
<#--------------------------------------------------------------------->
<script type="text/javascript" src="/static/view/page/consume/consume_list.js"></script>

</body>
</html>