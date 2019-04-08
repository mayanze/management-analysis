<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>编辑面板</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />

    <#--------------------------------------------------------------------->
    <#--js/css 库模块-->
    <#--------------------------------------------------------------------->
    <#include "../../head.ftl">

    <style type="text/css">
        html, body
        {
            padding:0;
            margin:0;
            border:0;
            height:100%;
            overflow:hidden;
        }
    </style>
</head>
<body>

<form id="form1" method="post">
    <input name="id" class="mini-hidden" />
    <div style="padding-left:11px;padding-bottom:5px;">
        <table style="table-layout:fixed;">
            <tr>
                <td style="width:80px;">分类：</td>
                <td style="width:150px;">
                    <input name="type" class="mini-combobox" style="width:150px;" textField="name" valueField="code" url="/dictionary/findByParentCode?parentCode=income"/>
                </td>
                <td style="width:80px;">金额：</td>
                <td style="width:150px;">
                    <input name="money" class="mini-textbox" required="true"  emptyText="请输入金额"/>
                </td>
            </tr>
            <tr>
                <#--<td style="width:80px;">日期：</td>-->
                <#--<td style="width:150px;">-->
                    <#--<input name="date" class="mini-datepicker" required="true"  emptyText="请输入date"/>-->
                <#--</td>-->
                <td >备注：</td>
                <td colspan="3">
                    <input name="remark" class="mini-textbox" required="false" emptyText="请选择备注"/>
                </td>
            </tr>
        </table>
    </div>
    <div style="text-align:center;padding:10px;">
        <a class="mini-button" onclick="onOk" style="width:60px;margin-right:20px;">确定</a>
        <a class="mini-button" onclick="onCancel" style="width:60px;">取消</a>
    </div>
</form>

<#--------------------------------------------------------------------->
<#--js模块-->
<#--------------------------------------------------------------------->
<script type="text/javascript" src="/static/view/page/income/edit.js"></script>

</body>
</html>
